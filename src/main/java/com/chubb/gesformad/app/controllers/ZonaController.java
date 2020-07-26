package com.chubb.gesformad.app.controllers;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.chubb.gesformad.app.models.entity.Cliente;
import com.chubb.gesformad.app.models.entity.Zona;
import com.chubb.gesformad.app.models.services.IClienteService;

@Controller
public class ZonaController {
	
	@Autowired
	private IClienteService clienteService;

	@GetMapping("/zonaConsulta")
	public String zonaConsulta (Model model) {
		model.addAttribute("listazonas", clienteService.findAllZonas());
		return "/zonaConsulta";
	}
	
	@GetMapping("/zonaConsulta/{idCliente}")
	public String zonaConsultaCliente(@PathVariable(value = "idCliente") Long idCliente, Model model) {
		
		List <Zona> listaZonas =  clienteService.findAllZonas();
		List <Zona> listaZonaCliente = new ArrayList<Zona>();
			for(Zona i : listaZonas) {
				if (idCliente == i.getCliente().getIdCliente()) {
					listaZonaCliente.add(i);
				}
			}
		model.addAttribute("listaZonaCliente", listaZonaCliente);
		return "/clienteVer";
	}
	
	@GetMapping("/zonaNueva")
	public String zonaNueva (Model model) {
		Zona zona = new Zona();
		model.addAttribute("clientes", clienteService.findAllClientes());
		model.addAttribute("zona", zona);
		return "/zonaNueva";
	}
	
	@PostMapping("/zonaNueva")
	public String zonaCrear (Zona zona, Model model) {
		clienteService.saveZona(zona);
		model.addAttribute("zona", zona);
		return "redirect:/zonaConsulta";
	}
	
	@GetMapping("/zonaNueva/{idZona}")
	public String zonaEditar (@PathVariable("idZona") Long idZona, Model model) {
		
		Zona zona = null;
		
		if (idZona > 0) {
			zona = clienteService.findOneZona(idZona);
		}
		else { 
			return "redirect:/zonaConsulta";
			}
		
		model.addAttribute("zona", zona);
		return "/zonaNueva";	
	}
	

	@GetMapping("/eliminarZona/{idZona}")
	public String zonaEliminar (@PathVariable("idZona") Long idZona, Model model) {
		clienteService.deleteZona(idZona);
		return "redirect:/zonaConsulta";
	}
	
	
	//PROVEEDOR
	@GetMapping("/zonaNuevaCliente/{idCliente}")
	public String zonaNuevaCliente(@PathVariable(value = "idCliente") Long idCliente, Model model) {
		
		Cliente cliente = clienteService.findOneCliente(idCliente);
		model.addAttribute("zonas", clienteService.findAllZonas());
			if (cliente == null) {
				return "redirect:/clienteVer/{idCliente}";
			}
		Zona zona = new Zona();
		zona.setCliente(cliente);
		model.addAttribute("zona", zona);
		model.addAttribute("titulo", cliente.getNombreCliente());
		return "/zonaNuevaCliente";
	}

	@PostMapping ("/zonaNuevaCliente")
	public String zonaCreaEnCliente (Zona zona, Model model) {
		clienteService.saveZona(zona);
		model.addAttribute("zona", zona); 	
		long id = zona.getCliente().getIdCliente();
		return "redirect:/clienteVer/" + id;
	 }
	
	@GetMapping("/zonaNuevaCliente/{idZona}/{idCliente}")
	public String zonaClienteEditar (@PathVariable("idZona") Long idZona, @PathVariable("idCliente") Long idCliente, Model model) {
		
		Cliente cliente = null;
		
		if (idCliente > 0 ) {
			cliente = clienteService.findOneCliente(idCliente);
		}
		else {
			return "redirect:/clienteVer/{idCliente}";
		}
		
		Zona zona = null;
		
		if (idZona > 0) {
			zona = clienteService.findOneZona(idZona);
			zona.setCliente(cliente);
		}
		else { 
			return "redirect:/clienteVer/{idCliente}";
			}
		
		model.addAttribute("zona", zona);
		return "/zonaNuevaCliente";	
	}
	
	@GetMapping("/eliminarZonaCliente/{idZona}")
	public String zonaClienteEliminar (@PathVariable("idZona") Long idZona, Model model) {
		Zona zona = clienteService.findOneZona(idZona);
		long id = zona.getCliente().getIdCliente();
		clienteService.deleteZona(idZona);
		return "redirect:/clienteVer/" + id;
	}
	
	
}
