package com.chubb.gesformad.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.chubb.gesformad.app.models.entity.Incidencia;
import com.chubb.gesformad.app.models.services.ITiendaService;

@Controller
public class IncidenciaController {

		@Autowired
		private ITiendaService tiendaService;
		
		@GetMapping ("/incidenciaConsulta")
		public String incidenciaConsulta (Model model) {
			Incidencia tCerrada = new Incidencia((long) 1, "Cerrada");
			Incidencia tAfluencia = new Incidencia((long) 2, "Exceso afluencia");
			Incidencia tEntrada = new Incidencia((long) 3, "Entrada denegada");
			tiendaService.saveIncidencia(tCerrada);
			tiendaService.saveIncidencia(tAfluencia);
			tiendaService.saveIncidencia(tEntrada);
			model.addAttribute("incidencias",tiendaService.findAllIncidencias());
			return "incidenciaConsulta";
		}
		
		@GetMapping ("/incidenciaNueva")
		public String incidenciaNuevo (Model model) {
			Incidencia incidencia = new Incidencia();
			model.addAttribute("incidencia", incidencia);
			return "incidenciaNueva";
		}
		
		@PostMapping ("/incidenciaNueva")
		public String creaIncidencia (Incidencia incidencia, Model model) {
			tiendaService.saveIncidencia(incidencia);
			model.addAttribute("incidencia", incidencia);
			return "redirect:/incidenciaConsulta";		
		}

		@GetMapping("incidenciaNueva/{idIncidencia}")
		public String editaIncidencia (@PathVariable("idIncidencia") Long idIncidencia, Model model) {
			
			Incidencia incidencia = null;
			if (idIncidencia > 0) {
				incidencia = tiendaService.findOneIncidencia(idIncidencia);
			}
			else {
				return "redirect:/incidenciaConsulta";	
			}
			model.addAttribute("incidencia", incidencia);
			return "incidenciaNueva";
		}
		
		@GetMapping("/eliminarincidencia/{idIncidencia}")
		public String eliminarIncidencia(@PathVariable("idIncidencia")Long idIncidencia, Model model) {
			tiendaService.deleteIncidencia(idIncidencia);
			return "redirect:/incidenciaConsulta";			
		}
	
}
