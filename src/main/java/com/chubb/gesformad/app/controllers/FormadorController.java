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
import com.chubb.gesformad.app.models.entity.Formador;
import com.chubb.gesformad.app.models.entity.Provincia;
import com.chubb.gesformad.app.models.entity.Campagna;
import com.chubb.gesformad.app.models.entity.Cliente;
import com.chubb.gesformad.app.models.entity.Rol;
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
		model.addAttribute("provincias", formadorService.findAllProvincias());
		model.addAttribute("formador", formador);
		return "formadorInicial";
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
		model.addAttribute("provincias", formadorService.findAllProvincias());
		model.addAttribute("formador", formador);
		return "formadorNuevo";
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
	
	
	//VER
	
	@GetMapping("/formadorVer/{idFormador}")
	public String verFormador (@PathVariable("idFormador") Long idFormador, Model model) {
		
		//ASIGNACIONES
		
		Cliente cliente = new Cliente();
		Zona zona = new Zona();
		Formacion formacion = new Formacion();

		
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
		List <Zona> listaZonasCli = new ArrayList <Zona>();
		
		
		for (Cliente i : listaClientesId) {
			listaZonasCli = i.getZonas();
			for (Zona j : listaZonasCli) {
				listaZonasId.add(j);
			}
		}
		
			//ZONAS ASIGNADAS
		List <Zona> listaZonasSelec = new ArrayList <Zona>();
		for (Zona k : listaZonasId) {
			for(Formador l : k.getFormadores()) {
				if (l.getIdFormador() == idFormador) {
					listaZonasSelec.add(k);
				}
			}
		}
		
		model.addAttribute("zona", zona);
		model.addAttribute("zonasAsignadas", listaZonasSelec);				
		model.addAttribute("zonasId", listaZonasId);
		
			//ZONAS ASIGNADAS 
		//LISTA DE ZONAS
	
		//LISTA DE FORMACIONES
		List <Formacion> listaFormacionesId = new ArrayList <Formacion>();
		List <Campagna> listaCampagnas = new ArrayList <Campagna>();
		List <Formacion> listaFormacionesCli = new ArrayList <Formacion>();
		
		for (Cliente i : listaClientesId) {
			listaCampagnas = i.getCampagnas();
			for (Campagna j : listaCampagnas) {
				listaFormacionesCli = j.getFormaciones();
					for (Formacion k : listaFormacionesCli) {
						listaFormacionesId.add(k);
					}
			}
		}
			//FORMACIONES ASIGNADAS

				List <Formacion> listaFormacionesSelec = new ArrayList <Formacion>();
				for (Formacion l : listaFormacionesId) {
					for (Formador m : l.getFormadores()) {
						if(m.getIdFormador() == idFormador) {
							listaFormacionesSelec.add(l);
						}
					}
				}

				model.addAttribute("formacion", formacion);
				model.addAttribute("formacionesAsignadas", listaFormacionesSelec);
				model.addAttribute("formacionesId", listaFormacionesId);
			//FORMACIONES ASIGNADAS
				
		//LISTA DE FORMACIONES
		

		
		//RESTO
		
		Formador formador = null;
		if (idFormador > 0) {
			formador = formadorService.findOneFormador(idFormador);
		}
		else {
			return "redirect:/formadorVer/" + idFormador;	
		}
		
		model.addAttribute("provincias", formadorService.findAllProvincias());
		model.addAttribute("cliente", cliente);
		model.addAttribute("zona", zona);
		model.addAttribute("formacion", formacion);
		model.addAttribute("formador", formador);
		
		return "/formadorVer";
		
	}

	@PostMapping("/asignaClienteFormador/{idFormador}")
	public String formadorGuardaAsignacionCliente (@PathVariable("idFormador") Long idFormador, Cliente cliente, Model model) {		
		Formador formador = null;
		
			if (idFormador != null) {
				 formador = formadorService.findOneFormador(idFormador);
			}
			else{
				return "redirect:/index";
			}
				//asignación cliente
				Long idCl = cliente.getIdCliente();
				Cliente clienteListo = formadorService.findOneCliente(idCl);
				if (formador.getClientes().contains(clienteListo) == false) {
					formador.getClientes().add(clienteListo);
					formadorService.saveFormador(formador);
				}
				
		model.addAttribute("formador", formador);
		return "redirect:/formadorVer/" + idFormador;
	
	}
	
	@PostMapping("/asignaZonaFormador/{idFormador}")
	public String formadorGuardaAsignacionZona (@PathVariable("idFormador") Long idFormador, Zona zona, Model model) {		
		Formador formador = null;
		
			if (idFormador != null) {
				 formador = formadorService.findOneFormador(idFormador);
			}
			else{
				return "redirect:/index";
			}
				//asignación zona
				Long idZn = zona.getIdZona();
				Zona zonaLista = formadorService.findOneZona(idZn);
				if (formador.getZonas().contains(zonaLista) == false) {
					formador.getZonas().add(zonaLista);
					formadorService.saveFormador(formador);
				}
				
		model.addAttribute("formador", formador);
		return "redirect:/formadorVer/" + idFormador;
	}
	
	@PostMapping("/asignaFormacionFormador/{idFormador}")
	public String formadorGuardaAsignacionFormacion (@PathVariable("idFormador") Long idFormador, Formacion formacion, Model model) {		
		
		Formador formador = null;
			if (idFormador != null) {
				 formador = formadorService.findOneFormador(idFormador);
			}
			else{
				return "redirect:/index";
			}
				//asignación formacion
			
			Long idFmc = formacion.getIdFormacion();
			Formacion formacionLista = formadorService.findOneFormacion(idFmc);
			if (formador.getFormaciones().contains(formacionLista) == false) {
				formador.getFormaciones().add(formacionLista);
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
	
	//ELIMINAR ZONA DE LA LISTA EN FORMADORES
		@GetMapping("/formadorEliminarZona/{idFormador}/{idZona}")
		public String eliminarZona(@PathVariable("idFormador") Long idFormador, @PathVariable("idZona") Long idZona, Model model) {
			Zona zona = formadorService.findOneZona(idZona);
			Formador formador = formadorService.findOneFormador(idFormador);
			Zona provX = null;
			for (Zona i : formador.getZonas()) {
				if (zona.getIdZona() == i.getIdZona()){
					provX = i;
				}
			}
			
			formador.getZonas().remove(provX);
			formadorService.saveFormador(formador);
			return "redirect:/formadorVer/" + idFormador;			
		}
		
		//ELIMINAR FORMACION DE LA LISTA EN FORMADORES
		@GetMapping("/formadorEliminarFormacion/{idFormador}/{idFormacion}")
		public String eliminarFormacion(@PathVariable("idFormador") Long idFormador, @PathVariable("idFormacion") Long idFormacion, Model model) {
			Formacion formacion = formadorService.findOneFormacion(idFormacion);
			Formador formador = formadorService.findOneFormador(idFormador);
			Formacion provX = null;
			for (Formacion i : formador.getFormaciones()) {
				if (formacion.getIdFormacion() == i.getIdFormacion()){
					provX = i;
				}
			}
			
			formador.getFormaciones().remove(provX);
			formadorService.saveFormador(formador);
			return "redirect:/formadorVer/" + idFormador;			
		}
	

}
