package com.chubb.gesformad.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.chubb.gesformad.app.models.entity.Franquicia;
import com.chubb.gesformad.app.models.entity.Cliente;
import com.chubb.gesformad.app.models.services.IClienteService;

@Controller
public class FranquiciaController {

	@Autowired
	private IClienteService clienteService;

	@GetMapping("/franquiciaConsulta")
	public String franquiciaConsulta(Model model) {
		model.addAttribute("franquicias", clienteService.findAllFranquicias());
		Cliente cliente = new Cliente((long) 1, "Orange");
		clienteService.saveCliente(cliente);
		return "franquiciaConsulta";
	}

	@GetMapping("/franquiciaNueva")
	public String franquiciaNueva(Model model) {
		model.addAttribute("clientees", clienteService.findAllClientees());
		Franquicia franquicia = new Franquicia();
		model.addAttribute("franquicia", franquicia);
		return "/franquiciaNueva";
	}
	
	@PostMapping ("/franquiciaNueva") public String franquiciaCrea (Franquicia franquicia, Model model) {
		clienteService.saveFranquicia(franquicia);
		model.addAttribute("franquicia", franquicia); 
		return "redirect:/franquiciaConsulta"; 
	 }
	
	@GetMapping("/franquiciaNueva/{idFranquicia}")
	public String franquiciaEdita (@PathVariable("idFranquicia") Long idFranquicia, Model model) {
		model.addAttribute("clientees", clienteService.findAllClientees());
		Franquicia franquicia = null;
		if (idFranquicia > 0) {
			franquicia = clienteService.findOneFranquicia(idFranquicia); 
			}
		else { 
			return "redirect:/franquiciaConsulta"; 
			}
		model.addAttribute("franquicia", franquicia);
		return "/franquiciaNueva"; 
		}
	
	@GetMapping("/eliminarFranquicia/{idFranquicia}")
	public String franquiciaElimina(@PathVariable("idFranquicia") Long idFranquicia, Model model)
	{
	 clienteService.deleteFranquicia(idFranquicia);
	 return "redirect:/franquiciaConsulta"; 
	 }
	
	
	//PROVEEDOR
	
	@GetMapping("/franquiciaNuevaCliente/{idCliente}")
	public String franquiciaNuevaCliente(@PathVariable(value = "idCliente") Long idCliente, Model model) {
		Cliente cliente = clienteService.findOneCliente(idCliente);
			if (cliente == null) {
				return "redirect:/clienteVer/" + idCliente;
			}
		Franquicia franquicia = new Franquicia();
		franquicia.setCliente(cliente);
		model.addAttribute("franquicia", franquicia);
		model.addAttribute("clientees", clienteService.findAllClientees());
		return "/franquiciaNuevaCliente";
	}


	@PostMapping ("/franquiciaNuevaCliente") public String franquiciaCreaEnCliente (Franquicia franquicia, Model model) {
		clienteService.saveFranquicia(franquicia);
		model.addAttribute("franquicia", franquicia); 
		long idCliente = franquicia.getCliente().getIdCliente();
		return "redirect:/clienteVer/" + idCliente; 
	 }
	
	@GetMapping("/franquiciaEditaCliente/{idFranquicia}/{idCliente}")
	public String franquiciaClienteEditar (@PathVariable("idFranquicia") Long idFranquicia, @PathVariable("idCliente") Long idCliente, Model model) {
			
			Cliente cliente = null;
			
			if (idCliente > 0 ) {
				cliente = clienteService.findOneCliente(idCliente);
			}
			else {
				return "redirect:/verCliente/{idCliente}";
			}
			
			Franquicia franquicia = null;
			
			if (idFranquicia > 0) {
				franquicia = clienteService.findOneFranquicia(idFranquicia);
				franquicia.setCliente(cliente);
			}
			else { 
				return "redirect:/verCliente/{idCliente}";
				}
			model.addAttribute("clientees", clienteService.findAllClientees());
			model.addAttribute("franquicia", franquicia);
			return "/franquiciaNuevaCliente";	
		}
	
	@GetMapping("/eliminarFranquiciaCliente/{idFranquicia}")
	public String franquiciaClienteEliminar (@PathVariable("idFranquicia") Long idFranquicia, Model model) {
		Franquicia franquicia = clienteService.findOneFranquicia(idFranquicia);
		long id = franquicia.getCliente().getIdCliente();
		clienteService.deleteFranquicia(idFranquicia);
		return "redirect:/clienteVer/" + id;
	}
	

}
