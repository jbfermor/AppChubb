package com.chubb.gesformad.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.chubb.gesformad.app.models.entity.Campagna;
import com.chubb.gesformad.app.models.entity.EstadoCampagna;
import com.chubb.gesformad.app.models.entity.Cliente;
import com.chubb.gesformad.app.models.services.IClienteService;

@Controller
public class CampagnaController {

	@Autowired
	private IClienteService clienteService;

	@GetMapping("/campagnaConsulta")
	public String campagnaConsulta(Model model) {
		model.addAttribute("campagnas", clienteService.findAllCampagnas());
		return "campagnaConsulta";
	}

	@GetMapping("/campagnaNueva")
	public String campagnaNueva(Model model) {
		model.addAttribute("clientes", clienteService.findAllClientes());
		model.addAttribute("estados", clienteService.findAllEstados());
		Campagna campagna = new Campagna();
		model.addAttribute("campagna", campagna);
		return "campagnaNueva";
	}
	
	@PostMapping ("/campagnaNueva") public String campagnaCrea (Campagna campagna, Model model) {
		clienteService.saveCampagna(campagna);
		model.addAttribute("campagna", campagna); 
		return "redirect:/campagnaConsulta"; 
	 }
	
	@GetMapping("/campagnaNueva/{idCampagna}")
	public String CampagnaEdita (@PathVariable("idCampagna") Long idCampagna, Model model) {
		model.addAttribute("clientes", clienteService.findAllClientes());
		model.addAttribute("estados", clienteService.findAllEstados());
		Campagna campagna = null;
		if (idCampagna > 0) {
			campagna = clienteService.findOneCampagna(idCampagna); 
			}
		else { 
			return "redirect:/campagnaConsulta"; 
			}
		model.addAttribute("campagna", campagna);
		return "campagnaNueva"; 
		}
	

	
	@GetMapping("/eliminarCampagna/{idCampagna}")
	public String campagnaElimina(@PathVariable("idCampagna") Long idCampagna, Model model){
	 clienteService.deleteCampagna(idCampagna);
	 return "redirect:/campagnaConsulta"; 
	 }
	
	//PROVEEDOR
	@GetMapping("/campagnaNuevaCliente/{idCliente}")
	public String campagnaNuevaCliente(@PathVariable(value = "idCliente") Long idCliente, Model model) {
		
		Cliente cliente = clienteService.findOneCliente(idCliente);
			if (cliente == null) {
				return "redirect:/clienteVer/" + idCliente;
			}
		Campagna campagna = new Campagna();
		campagna.setCliente(cliente);
		model.addAttribute("campagna", campagna);
		model.addAttribute("clientes", clienteService.findAllClientes());
		model.addAttribute("estados", clienteService.findAllEstados());
		return "campagnaNuevaCliente";
	}

	@PostMapping ("/campagnaNuevaCliente") public String campagnaCreaEnCliente (Campagna campagna, Model model) {
		clienteService.saveCampagna(campagna);
		model.addAttribute("campagna", campagna); 
		long id = campagna.getCliente().getIdCliente();
		return "redirect:/clienteVer/" + id;
	 }
		
	@GetMapping("/campagnaEditaCliente/{idCampagna}/{idCliente}")
	public String campagnaClienteEditar (@PathVariable("idCampagna") Long idCampagna, @PathVariable("idCliente") Long idCliente, Model model) {
			
			Cliente cliente = null;
			
			if (idCliente > 0 ) {
				cliente = clienteService.findOneCliente(idCliente);
			}
			else {
				return "redirect:/verCliente/{idCliente}";
			}
			
			Campagna campagna = null;
			
			if (idCampagna > 0) {
				campagna = clienteService.findOneCampagna(idCampagna);
				campagna.setCliente(cliente);
			}
			else { 
				return "redirect:/verCliente/{idCliente}";
				}
			model.addAttribute("clientes", clienteService.findAllClientes());
			model.addAttribute("estados", clienteService.findAllEstados());
			model.addAttribute("campagna", campagna);
			return "campagnaNuevaCliente";	
		}
	
	@GetMapping("/eliminarCampagnaCliente/{idCampagna}")
	public String campagnaClienteEliminar (@PathVariable("idCampagna") Long idCampagna, Model model) {
		Campagna campagna = clienteService.findOneCampagna(idCampagna);
		long id = campagna.getCliente().getIdCliente();
		clienteService.deleteCampagna(idCampagna);
		return "redirect:/clienteVer/" + id;
	}

}
