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
import com.chubb.gesformad.app.models.entity.Proveedor;
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
		List <Proveedor> proveedores = formadorService.findAllProveedores();
		List <Formador> formadores = formadorService.findAllFormadores();
		model.addAttribute("proveedores", proveedores);
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
		
		Proveedor proveedor = new Proveedor();
		Zona zona = new Zona();


		
		//LISTA DE PROVEEDORES
		List <Proveedor> listaProveedores = formadorService.findAllProveedores();
		List <Proveedor> listaProveedoresId = new ArrayList<Proveedor>();
		for (Proveedor i:listaProveedores) {
			for (Formador j: i.getFormadores()) {
				if (j.getIdFormador() == idFormador) {
					listaProveedoresId.add(i);
				}
			}
		}
		model.addAttribute("proveedores", listaProveedores);
		model.addAttribute("proveedoresId", listaProveedoresId);
		
		
		//LISTA DE ZONAS
		List <Zona> listaZonasId = new ArrayList <Zona>();
		List <Zona> listaZonasProv = new ArrayList <Zona>();
		
		for (Proveedor i : listaProveedoresId) {
			listaZonasProv = i.getZonas();
			for (Zona j : listaZonasProv) {
				listaZonasId.add(j);
			}
		}
		
		
		model.addAttribute("zonasId", listaZonasId);
		/*
		//LISTA DE CAMPAÑAS
		List <Campagna> listaCampagnas = proveedorService.findAllCampagnas();
		List <Campagna> listaCampagnasId = new ArrayList<Campagna>();
		for (Campagna i:listaCampagnas) {
			if (i.getProveedor().getIdProveedor() == idProveedor) {
				listaCampagnasId.add(i);
			}
		}
		model.addAttribute("campagnasId", listaCampagnasId);
		
		//LISTA DE FRANQUICIAS
		List <Franquicia> listaFranquicias = proveedorService.findAllFranquicias();
		List <Franquicia> listaFranquiciasId = new ArrayList<Franquicia>();
		for (Franquicia i:listaFranquicias) {
			if (i.getProveedor().getIdProveedor() == idProveedor) {
				listaFranquiciasId.add(i);
			}
		}
		model.addAttribute("franquiciasId", listaFranquiciasId);
		
		//LISTA DE TIENDAS
		List <Tienda> listaTiendas = proveedorService.findAllTiendas();
		List <Tienda> listaTiendasId = new ArrayList<Tienda>();
		for (Tienda i:listaTiendas) {
			if (i.getProveedor().getIdProveedor() == idProveedor) {
				listaTiendasId.add(i);
			}
		}
		model.addAttribute("tiendasId", listaTiendasId);
		
		//LISTA DE FORMADORES
		List <Formador> listaFormadores = proveedorService.findAllFormadores();
		List <Formador> listaFormadoresId = new ArrayList<Formador>();
		for (Formador i:listaFormadores) {
			for (Proveedor j:i.getProveedores())
				if (j.getIdProveedor() == idProveedor) {
					listaFormadoresId.add(i);
			}
		}
		model.addAttribute("formadoresId", listaFormadoresId);
		
		//LISTA DE FORMACIONES
		List <Formacion> listaFormaciones = proveedorService.findAllFormaciones();
		List <Formacion> listaFormacionesId = new ArrayList<Formacion>();
		for (Formacion i:listaFormaciones) {
			if (i.getProveedor().getIdProveedor() == idProveedor) {
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
		
		
		model.addAttribute("proveedor", proveedor);
		model.addAttribute("zona", zona);
		model.addAttribute("formador", formador);
		
		return "/formadorVer";
		
	}

	@PostMapping("/formadorVer/{idFormador}")
	public String formadorGuardaAsignacionProveedor (@PathVariable("idFormador") Long idFormador, Proveedor proveedor, Model model) {		
		Formador formador = null;
		
			if (idFormador != null) {
				 formador = formadorService.findOneFormador(idFormador);
			}
			else{
				return "redirect:/index";
			}
				Long id = proveedor.getIdProveedor();
				Proveedor proveedorListo = formadorService.findOneProveedor(id);
				if (formador.getProveedores().contains(proveedorListo) == false) {
					formador.getProveedores().add(proveedorListo);
					formadorService.saveFormador(formador);
				}
		model.addAttribute("formador", formador);
		return "redirect:/formadorVer/" + idFormador;
	}
	
	//ELIMINAR PROVEEDOR DE LA LISTA EN FORMADORES
	@GetMapping("/formadorEliminarProveedor/{idFormador}/{idProveedor}")
	public String eliminarProveedor(@PathVariable("idFormador") Long idFormador, @PathVariable("idProveedor") Long idProveedor, Model model) {
		Proveedor proveedor = formadorService.findOneProveedor(idProveedor);
		Formador formador = formadorService.findOneFormador(idFormador);
		Proveedor provX = null;
		for (Proveedor i : formador.getProveedores()) {
			if (proveedor.getIdProveedor() == i.getIdProveedor()){
				provX = i;
			}
		}
		
		formador.getProveedores().remove(provX);
		formadorService.saveFormador(formador);
		return "redirect:/formadorVer/" + idFormador;			
	}
	

}
