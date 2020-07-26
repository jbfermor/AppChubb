package com.chubb.gesformad.app.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.chubb.gesformad.app.models.entity.Campagna;
import com.chubb.gesformad.app.models.entity.Formacion;
import com.chubb.gesformad.app.models.entity.Formador;
import com.chubb.gesformad.app.models.entity.Franquicia;
import com.chubb.gesformad.app.models.entity.Cliente;
import com.chubb.gesformad.app.models.entity.Rol;
import com.chubb.gesformad.app.models.entity.Tienda;
import com.chubb.gesformad.app.models.entity.Zona;
import com.chubb.gesformad.app.models.services.IFormadorService;

@Controller
public class FormadorController {
	
	@Autowired
	IFormadorService formadorService;
		
	@GetMapping("/formadorConsulta")
	public String formadorConsulta (Model model) {
		List <Cliente> clientes = formadorService.findAllClientes();
		List <Formador> formadores = formadorService.findAllFormadores();
		model.addAttribute("clientes", clientes);
		model.addAttribute("formadores", formadores);
		return "/formadorConsulta";
	}
	
	
	//CONFIGURACION INICIAL
	
	@GetMapping("/formadorInicial")
	public String nuevoFormadorInicial (Model model) {
		Formador formador = new Formador();
		Rol rol = formadorService.findOneRol((long)2);
		formador.setRol(rol);
		model.addAttribute("formador", formador);
		return "/formadorInicial";
	}
	
	@PostMapping("/formadorInicial")
	public String creaFormdorInicial (Formador formador, Model model) {
		formadorService.saveFormador(formador);
		model.addAttribute("formador", formador);
		return "redirect:/index";
	}
	
	
	//FIN CONFIGURACION INICIAL
	
	@GetMapping("/formadorNuevo")
	public String nuevoFormador (Model model) {
		Formador formador = new Formador();
		Rol rol = formadorService.findOneRol((long)2);
		formador.setRol(rol);
		model.addAttribute("formador", formador);
		return "/formadorNuevo";
	}
	
	@PostMapping("/formadorNuevo")
	public String creaFormador (Formador formador, Model model) {
		formadorService.saveFormador(formador);
		model.addAttribute("formador", formador);
		return "redirect:/index";
	}
	
	@GetMapping("/formadorNuevo/{idFormador}")
	public String editaFormador (@PathVariable("idFormador") Long idFormador, Model model) {
		Formador formador = null;
		if (idFormador != null) {
			formador = formadorService.findOneFormador(idFormador);
		}
		else{
			return "redirect:/index";
		}
		model.addAttribute("formador", formador);
		return "/formadorNuevo";
	}
	
	@GetMapping("/formadorEliminar/{idFormador}")
	public String eliminaFormador (@PathVariable("idFormador") Long idFormador, Model model) {
		formadorService.deleteFormador(idFormador);
		return "redirect:/index";
	}
	
	//PROVEEDOR
	
	
	
	//VER
	
	@GetMapping("/formadorVer/{idFormador}")
	public String verFormador (@PathVariable("idFormador") Long idFormador, Model model) {
		
		//ASIGNACIONES
		
		Cliente cliente = new Cliente();
		Zona zona = new Zona();


		
		//LISTA DE PROVEEDORES
		List <Cliente> listaClientes = formadorService.findAllClientes();
		List <Cliente> listaClientesId = new ArrayList<Cliente>();
		for (Cliente i:listaClientes) {
			for (Formador j: i.getFormadores()) {
				if (j.getIdFormador() == idFormador) {
					listaClientesId.add(i);
				}
			}
		}
		model.addAttribute("clientes", listaClientes);
		model.addAttribute("clientesId", listaClientesId);
		
		
		//LISTA DE ZONAS
		List <Zona> listaZonasId = new ArrayList <Zona>();
		List <Zona> listaZonasProv = new ArrayList <Zona>();
		
		for (Cliente i : listaClientesId) {
			listaZonasProv = i.getZonas();
			for (Zona j : listaZonasProv) {
				listaZonasId.add(j);
			}
		}
		
		
		model.addAttribute("zonasId", listaZonasId);
		/*
		//LISTA DE CAMPAÑAS
		List <Campagna> listaCampagnas = clienteService.findAllCampagnas();
		List <Campagna> listaCampagnasId = new ArrayList<Campagna>();
		for (Campagna i:listaCampagnas) {
			if (i.getCliente().getIdCliente() == idCliente) {
				listaCampagnasId.add(i);
			}
		}
		model.addAttribute("campagnasId", listaCampagnasId);
		
		//LISTA DE FRANQUICIAS
		List <Franquicia> listaFranquicias = clienteService.findAllFranquicias();
		List <Franquicia> listaFranquiciasId = new ArrayList<Franquicia>();
		for (Franquicia i:listaFranquicias) {
			if (i.getCliente().getIdCliente() == idCliente) {
				listaFranquiciasId.add(i);
			}
		}
		model.addAttribute("franquiciasId", listaFranquiciasId);
		
		//LISTA DE TIENDAS
		List <Tienda> listaTiendas = clienteService.findAllTiendas();
		List <Tienda> listaTiendasId = new ArrayList<Tienda>();
		for (Tienda i:listaTiendas) {
			if (i.getCliente().getIdCliente() == idCliente) {
				listaTiendasId.add(i);
			}
		}
		model.addAttribute("tiendasId", listaTiendasId);
		
		//LISTA DE FORMADORES
		List <Formador> listaFormadores = clienteService.findAllFormadores();
		List <Formador> listaFormadoresId = new ArrayList<Formador>();
		for (Formador i:listaFormadores) {
			for (Cliente j:i.getClientes())
				if (j.getIdCliente() == idCliente) {
					listaFormadoresId.add(i);
			}
		}
		model.addAttribute("formadoresId", listaFormadoresId);
		
		//LISTA DE FORMACIONES
		List <Formacion> listaFormaciones = clienteService.findAllFormaciones();
		List <Formacion> listaFormacionesId = new ArrayList<Formacion>();
		for (Formacion i:listaFormaciones) {
			if (i.getCliente().getIdCliente() == idCliente) {
				listaFormacionesId.add(i);
			}
		}
		model.addAttribute("formacionesId", listaFormacionesId);
		*/
		
		//RESTO
		
		Formador formador = null;
		if (idFormador > 0) {
			formador = formadorService.findOneFormador(idFormador);
		}
		else {
			return "redirect:/formadorVer/" + idFormador;	
		}
		
		
		model.addAttribute("cliente", cliente);
		model.addAttribute("zona", zona);
		model.addAttribute("formador", formador);
		
		return "/formadorVer";
		
	}

	@PostMapping("/formadorVer/{idFormador}")
	public String formadorGuardaAsignacionCliente (@PathVariable("idFormador") Long idFormador, Cliente cliente, Model model) {		
		Formador formador = null;
		
			if (idFormador != null) {
				 formador = formadorService.findOneFormador(idFormador);
			}
			else{
				return "redirect:/index";
			}
				Long id = cliente.getIdCliente();
				Cliente clienteListo = formadorService.findOneCliente(id);
				if (formador.getClientes().contains(clienteListo) == false) {
					formador.getClientes().add(clienteListo);
					formadorService.saveFormador(formador);
				}
		model.addAttribute("formador", formador);
		return "redirect:/formadorVer/" + idFormador;
	}
	
	//ELIMINAR PROVEEDOR DE LA LISTA EN FORMADORES
	@GetMapping("/formadorEliminarCliente/{idFormador}/{idCliente}")
	public String eliminarCliente(@PathVariable("idFormador") Long idFormador, @PathVariable("idCliente") Long idCliente, Model model) {
		Cliente cliente = formadorService.findOneCliente(idCliente);
		Formador formador = formadorService.findOneFormador(idFormador);
		Cliente provX = null;
		for (Cliente i : formador.getClientes()) {
			if (cliente.getIdCliente() == i.getIdCliente()){
				provX = i;
			}
		}
		
		formador.getClientes().remove(provX);
		formadorService.saveFormador(formador);
		return "redirect:/formadorVer/" + idFormador;			
	}
	

}
