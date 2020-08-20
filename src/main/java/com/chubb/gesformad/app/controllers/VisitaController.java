package com.chubb.gesformad.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.*;

import com.chubb.gesformad.app.models.entity.Cliente;
import com.chubb.gesformad.app.models.entity.Formacion;
import com.chubb.gesformad.app.models.entity.Formador;
import com.chubb.gesformad.app.models.entity.Provincia;
import com.chubb.gesformad.app.models.entity.Tienda;
import com.chubb.gesformad.app.models.entity.Visita;
import com.chubb.gesformad.app.models.entity.Zona;
import com.chubb.gesformad.app.models.services.IClienteService;

@Controller
public class VisitaController {
	
	@Autowired
	private IClienteService clienteService;
	
	@GetMapping ("/visitaConsulta")
	public String visitaConsulta (Model model) {
		model.addAttribute("visitas", clienteService.findAllVisitas());
		return "visitaConsulta";
	}
	
	@GetMapping ("/visitaNuevaCliente/{idCliente}")
	public String visitaNuevaCliente (@PathVariable("idCliente") Long idCliente, Model model) {
		
		Cliente clienteListo = clienteService.findOneCliente(idCliente);
		Visita visita = new Visita();
		List <Visita> listaVisitasCliente = new ArrayList <Visita>();
		
		listaVisitasCliente = clienteListo.getVisitas();
		
		//formadores
		List <Formador> listaFormadoresCliente = clienteListo.getFormadores();
		
		//formaciones
		List <Formacion> listaFormacionesCliente = clienteListo.getFormaciones();
		
		//tiendas
		List <Tienda> listaTiendasCliente = clienteListo.getTiendas();
		
		//zonas
		List <Zona> zonasTiendaVisita = new ArrayList <Zona>();
		for(Tienda i : listaTiendasCliente) {
			if (zonasTiendaVisita.contains(i.getZona()) == false) {
				zonasTiendaVisita.add(i.getZona());
			}
		}
		
		//provincias
		List <Provincia> provinciasTiendaVisita = new ArrayList <Provincia>();
		for(Tienda i : listaTiendasCliente) {
			if (provinciasTiendaVisita.contains(i.getProvincia()) == false) {
				provinciasTiendaVisita.add(i.getProvincia());
			}
		}
		
		model.addAttribute("formadores", listaFormadoresCliente);
		model.addAttribute("formaciones", listaFormacionesCliente);
		model.addAttribute("zonas", zonasTiendaVisita);
		model.addAttribute("provincias", provinciasTiendaVisita);
		model.addAttribute("tiendas", listaTiendasCliente);
		model.addAttribute("visitas", listaVisitasCliente);
		model.addAttribute("visita", visita);
		return "visitaNuevaCliente";
	}
	
	@PostMapping ("/visitaNuevaCliente/{idCliente}")
	public String creaVisitaCliente (@PathVariable("idCliente") Long idCliente, Visita visita, Model model) {
		return "redirect:/clienteVer/" + idCliente;
	}
	
}
