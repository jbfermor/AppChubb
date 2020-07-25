package com.chubb.gesformad.app.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.chubb.gesformad.app.models.entity.Formacion;
import com.chubb.gesformad.app.models.entity.Cliente;
import com.chubb.gesformad.app.models.entity.Campagna;
import com.chubb.gesformad.app.models.services.IClienteService;

@Controller
public class FormacionController {
	
	@Autowired
	private IClienteService clienteService;
	
	@GetMapping("/formacionConsulta")
	public String consultaFormacion(Model model) {
		model.addAttribute("formaciones", clienteService.findAllFormaciones());
		return "/formacionConsulta";
	}
	
	@GetMapping("/formacionNueva")
	public String nuevaFormacion (Model model) {
		Formacion formacion = new Formacion();
		model.addAttribute("campagnas", clienteService.findAllCampagnas());
		model.addAttribute("formacion", formacion);
		return "/formacionNueva";
	}
	
	@PostMapping("/formacionNueva")
	public String creaFormacion (Formacion formacion, Model model) {

		clienteService.saveFormacion(formacion);
		model.addAttribute("formacion", formacion);
		return "redirect:/formacionConsulta";
	}
	
	@GetMapping("/formacionNueva/{idFormacion}")
	public String editaFormacion (@PathVariable("idFormacion") Long idFormacion, Model model) {
		Formacion formacion = null;
			if (idFormacion > 0) {
				formacion = clienteService.findOneFormacion(idFormacion);
			}
			else {return "redirect:/formacionConsulta";}
		model.addAttribute("campagnas", clienteService.findAllCampagnas());	
		model.addAttribute("formacion", formacion);
		return "/formacionNueva";
	}
	
	@GetMapping ("/eliminaFormacion/{idFormacion}")
	public String deleteFormacion (@PathVariable("idFormacion") Long idFormacion, Model model) {
		clienteService.deleteFormacion(idFormacion);
		return "redirect:/formacionConsulta";
	}
	
	
	//DESDE PROVEEDOR
	@GetMapping("/formacionNuevaCliente/{idCliente}")
	public String nuevaFormacionCliente (@PathVariable("idCliente") Long idCliente, Model model) {
		
		Cliente cliente = null;
		if (idCliente > 0) {
			cliente = clienteService.findOneCliente(idCliente);
		}
		else {
			return "redirect:/clienteVer/" + idCliente;
		}
		
		List <Campagna> listaCampagna = clienteService.findAllCampagnas();
		List <Campagna> listaCampagnasId = new ArrayList<Campagna>();
		
		for (Campagna i : listaCampagna) {
			if (i.getCliente().getIdCliente() == idCliente) {
				listaCampagnasId.add(i);
			}
		}
		
		Formacion formacion = new Formacion();
		
		model.addAttribute("cliente", cliente);
		model.addAttribute("campagnas", listaCampagnasId);
		model.addAttribute("formacion", formacion);
		return "/formacionNuevaCliente";
	}
	
	@PostMapping("/formacionNuevaCliente/{idCliente}")
	public String creaFormacionCliente (@PathVariable("idCliente") Long idCliente, Formacion formacion, Model model) {
		Cliente cliente = null;
		if (idCliente > 0) {
			cliente = clienteService.findOneCliente(idCliente);
		}
		else {
			return "redirect:/clienteVer/" + idCliente;
		}
		formacion.setCliente(cliente);
		clienteService.saveFormacion(formacion);
		model.addAttribute("formacion", formacion);
		return "redirect:/clienteVer/" + idCliente;
	}
	
	@GetMapping("/formacionNuevaCliente/{idFormacion}/{idCliente}")
	public String editaFormacionCliente (@PathVariable("idFormacion") Long idFormacion, @PathVariable("idCliente") Long idCliente, Model model) {
		
		Formacion formacion = null;
			if (idFormacion > 0) {
				formacion = clienteService.findOneFormacion(idFormacion);
			}
			else {return "redirect:/clienteVer/" + idCliente;}
			
		Cliente cliente = null;
			if (idCliente > 0) {
				cliente = clienteService.findOneCliente(idCliente);
			}
			else {
				return "redirect:/clienteVer/" + idCliente;
			}
			
		model.addAttribute("cliente", cliente);
		model.addAttribute("campagnas", clienteService.findAllCampagnas());	
		model.addAttribute("formacion", formacion);
		return "/formacionNuevaCliente";
	}
	
	@GetMapping ("/eliminaFormacion/{idFormacion}/{idCliente}")
	public String deleteFormacion (@PathVariable("idFormacion") Long idFormacion, @PathVariable("idCliente") Long idCliente, Model model) {
		clienteService.deleteFormacion(idFormacion);
		return "redirect:/clienteVer/" + idCliente;
	}
	
}
