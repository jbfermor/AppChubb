package com.chubb.gesformad.app.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.chubb.gesformad.app.models.entity.Franquicia;
import com.chubb.gesformad.app.models.entity.Cliente;
import com.chubb.gesformad.app.models.entity.Tienda;
import com.chubb.gesformad.app.models.entity.Zona;
import com.chubb.gesformad.app.models.services.IClienteService;

@Controller
public class TiendaController {
	
	@Autowired
	private IClienteService clienteService;
	
	@GetMapping("/tiendaConsulta")
	public String consultaTienda (Model model) {
		model.addAttribute("tiendas", clienteService.findAllTiendas());
		return "/tiendaConsulta";
	}
	
	
	//DESDE CLIENTE
	
	@GetMapping("/tiendaNuevaCliente/{idCliente}")
	public String nuevaTiendaCliente(@PathVariable("idCliente") Long idCliente, Model model) {
		
		Cliente cliente = null;
		if (idCliente > 0) {
			cliente = clienteService.findOneCliente(idCliente);
		}
		else {
			return "redirect:/tiendaConsulta";
		}
		
		Tienda tienda = new Tienda();
		tienda.setCliente(cliente);
		
		List <Franquicia> listaFranquiciasP = new ArrayList <Franquicia>();
		List <Franquicia> franquiciasP = new ArrayList <Franquicia>();
		franquiciasP = clienteService.findAllFranquicias();
		for(Franquicia i : franquiciasP) {
			if(i.getCliente().getIdCliente() == idCliente) {
				listaFranquiciasP.add(i);
			}
		}
			
		List <Zona> listaZonasP = new ArrayList <Zona>();
		List <Zona> zonasP = new ArrayList <Zona>();
		zonasP = clienteService.findAllZonas();
		for(Zona i : zonasP) {
			if(i.getCliente().getIdCliente() == idCliente) {
				listaZonasP.add(i);
			}
		}
		
		model.addAttribute("provincias", clienteService.findAllProvincias());
		model.addAttribute("listaFranquiciasP", listaFranquiciasP);
		model.addAttribute("listaZonasP", listaZonasP);
		model.addAttribute("tienda", tienda);
		return "tiendaNuevaCliente"; 
	}
	
	
	@PostMapping("/tiendaNuevaCliente")
	public String creaTienda (Tienda tienda, Model model) {
		clienteService.saveTienda(tienda);
		model.addAttribute("tienda", tienda);
		Long id = tienda.getCliente().getIdCliente();
		return "redirect:/clienteVer/" + id;
	}
	
	
	@GetMapping ("/eliminarTiendaCliente/{idCliente}/{idTienda}")
	public String eliminarTienda (@PathVariable("idCliente") Long idCliente, @PathVariable("idTienda") Long idTienda, Model model) {
		clienteService.deleteTienda(idTienda);
		return "redirect:/verCliente/" + idCliente;
	}
	
	
	//DESDE FRANQUICIAS
	
	
	@GetMapping("/tiendaNuevaFranquicia/{idFranquicia}")
	public String nuevaTiendaFranquicia (@PathVariable("idFranquicia") Long idFranquicia, Model model) {
		
		Franquicia franquicia = clienteService.findOneFranquicia(idFranquicia);
			if(franquicia == null) {
				return "redirect:/tiendaConsulta";
			}
		Tienda tienda = new Tienda();
		tienda.setFranquicia(franquicia);
		Cliente cliente = franquicia.getCliente();
		tienda.setCliente(cliente);
		
		model.addAttribute("provincias", clienteService.findAllProvincias());
		model.addAttribute("zonas", clienteService.findAllZonas());
		model.addAttribute("tienda", tienda);
		model.addAttribute("nombreFranquicia", tienda.getFranquicia().getNombreFranquicia());
		
		return "tiendaNuevaFranquicia";
	}
	
	@PostMapping ("/tiendaNuevaFranquicia")
	public String creaTiendaFranquicia (Tienda tienda, Model model) {
		clienteService.saveTienda(tienda);
		model.addAttribute("tienda", tienda);
		return "redirect:/franquiciaConsulta";
	}
	

	@GetMapping("/tiendaVer/{idTienda}")
	public String verTienda (@PathVariable("idTienda") Long idTienda, Model model) {
		Tienda tienda = clienteService.findOneTienda(idTienda);
		model.addAttribute("tienda", tienda);
		return "/tiendaVer";
	}
	
	
	
}
