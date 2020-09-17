package com.chubb.gesformad.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

import com.chubb.gesformad.app.models.entity.Cliente;
import com.chubb.gesformad.app.models.entity.Formacion;
import com.chubb.gesformad.app.models.entity.FormacionElegida;
import com.chubb.gesformad.app.models.entity.Formador;
import com.chubb.gesformad.app.models.entity.Localidad;
import com.chubb.gesformad.app.models.entity.LocalidadElegida;
import com.chubb.gesformad.app.models.entity.ProvinciaElegida;
import com.chubb.gesformad.app.models.entity.Tienda;
import com.chubb.gesformad.app.models.entity.TiendaElegida;
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
	
	@RequestMapping(value = "/cargaLocalVisita", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody List <LocalidadElegida> localidades (@RequestBody ProvinciaElegida provinciaElegida) {
		List <Localidad> todoLocalidades = clienteService.findAllLocalidades();
		List <LocalidadElegida> localidades = new ArrayList <LocalidadElegida>();
		for (Localidad i : todoLocalidades) {
			if(i.getProvincia().getIdProvincia() == provinciaElegida.getIdProvincia()) {
				localidades.add(new LocalidadElegida(i.getIdLocalidad(),i.getNombreLocalidad()));
			}
		}
		return localidades;
	}
	
	@RequestMapping(value = "/cargaTienda", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody List <TiendaElegida> tiendas (@RequestBody LocalidadElegida localidadElegida) {
		List <Tienda> todoTiendas = clienteService.findAllTiendas();
		List <TiendaElegida> tiendas = new ArrayList <TiendaElegida>();
		for (Tienda i : todoTiendas) {
			if(i.getLocalidad().getIdLocalidad() == localidadElegida.getIdLocalidad()) {
				tiendas.add(new TiendaElegida(i.getIdTienda(),i.getNombreTienda()));
			}
		}
		return tiendas;
	}
	
	@RequestMapping(value = "/cargaFormacion", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List <FormacionElegida> formaciones (@PathVariable("idCliente") Long idCliente){
		List <Formacion> listaFormaciones = clienteService.findAllFormaciones();
		List <FormacionElegida> formaciones = new ArrayList <FormacionElegida>();
		for (Formacion i : listaFormaciones) {
			if(i.getCliente().getIdCliente() == idCliente) {
				formaciones.add(new FormacionElegida(i.getIdFormacion(),i.getNombreFormacion()));
			}
		}		
		return formaciones;
	}
	
	@GetMapping ("/visitaNuevaCliente/{idCliente}")
	public String visitaNuevaCliente (@PathVariable("idCliente") Long idCliente, Model model) {
		
		Cliente clienteListo = clienteService.findOneCliente(idCliente);
		Visita visita = new Visita();
		List <Visita> listaVisitasCliente = clienteListo.getVisitas();
		
		//formadores
		List <Formador> listaFormadoresCliente = clienteListo.getFormadores();
		
		//formaciones
		List <Formacion> listaFormacionesCliente = clienteListo.getFormaciones();
		List <Formacion> sumaFormaciones = new ArrayList <Formacion>();
		
		//tiendas
		List <Tienda> listaTiendasCliente = clienteListo.getTiendas();
		
		//zonas
		List <Zona> zonasTiendaVisita = new ArrayList <Zona>();
		for(Tienda i : listaTiendasCliente) {
			if (zonasTiendaVisita.contains(i.getZona()) == false) {
				zonasTiendaVisita.add(i.getZona());
			}
		}
		
		model.addAttribute("formadores", listaFormadoresCliente);
		model.addAttribute("formaciones", listaFormacionesCliente);
		model.addAttribute("sumaFormaciones", sumaFormaciones);
		model.addAttribute("zonas", zonasTiendaVisita);
		model.addAttribute("provincias", clienteService.findAllProvincias());
		model.addAttribute("visitas", listaVisitasCliente);
		model.addAttribute("visita", visita);
		return "visitaNuevaCliente";
	}
	
	@PostMapping ("/visitaNuevaCliente")
	public String creaVisitaCliente (Visita visita, Model model) {
		System.out.println();
		clienteService.saveVisita(visita);
		model.addAttribute("visita", visita);
		Long idCliente = visita.getCliente().getIdCliente();
		return "redirect:/clienteVer/" + idCliente;
	}
	
}
