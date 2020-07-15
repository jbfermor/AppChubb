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
import com.chubb.gesformad.app.models.entity.Proveedor;
import com.chubb.gesformad.app.models.entity.Campagna;
import com.chubb.gesformad.app.models.services.IProveedorService;

@Controller
public class FormacionController {
	
	@Autowired
	private IProveedorService proveedorService;
	
	@GetMapping("/formacionConsulta")
	public String consultaFormacion(Model model) {
		model.addAttribute("formaciones", proveedorService.findAllFormaciones());
		return "/formacionConsulta";
	}
	
	@GetMapping("/formacionNueva")
	public String nuevaFormacion (Model model) {
		Formacion formacion = new Formacion();
		model.addAttribute("campagnas", proveedorService.findAllCampagnas());
		model.addAttribute("formacion", formacion);
		return "/formacionNueva";
	}
	
	@GetMapping("/formacionNuevaProveedor/{idProveedor}")
	public String nuevaFormacion (@PathVariable("idProveedor") Long idProveedor, Model model) {
		Proveedor proveedor = null;
		if (idProveedor > 0) {
			proveedorService.findOneProveedor(idProveedor);
		}
		else {
			return "redirect:/proveedorVer/" + idProveedor;
		}
		Formacion formacion = new Formacion();
		
		List <Campagna> listaCampagna = proveedorService.findAllCampagnas();
		List <Campagna> listaCampagnasId = new ArrayList<Campagna>();
		
		for (Campagna i : listaCampagna) {
			if (i.getProveedor().getIdProveedor() == idProveedor) {
				listaCampagnasId.add(i);
			}
		}
		model.addAttribute("proveedor", proveedor);
		model.addAttribute("campagnas", listaCampagnasId);
		model.addAttribute("formacion", formacion);
		return "/formacionNueva";
	}
	
	@PostMapping("/formacionNueva")
	public String creaFormacion (Formacion formacion, Model model) {
		proveedorService.saveFormacion(formacion);
		model.addAttribute("formacion", formacion);
	return "redirect:/formacionConsulta";
	}
	
	@GetMapping("/formacionNueva/{idFormacion}")
	public String editaFormacion (@PathVariable("idFormacion") Long idFormacion, Model model) {
		Formacion formacion = null;
			if (idFormacion > 0) {
				formacion = proveedorService.findOneFormacion(idFormacion);
			}
			else {return "redirect:/formacionConsulta";}
		model.addAttribute("campagnas", proveedorService.findAllCampagnas());	
		model.addAttribute("formacion", formacion);
		return "/formacionNueva";
	}
	
	@GetMapping ("/eliminaFormacion/{idFormacion}")
	public String deleteFormacion (@PathVariable("idFormacion") Long idFormacion, Model model) {
		proveedorService.deleteFormacion(idFormacion);
		return "redirect:/formacionConsulta";
	}
	
}
