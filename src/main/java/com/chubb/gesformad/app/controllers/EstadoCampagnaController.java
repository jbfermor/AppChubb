package com.chubb.gesformad.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.chubb.gesformad.app.models.entity.EstadoCampagna;
import com.chubb.gesformad.app.models.services.IClienteService;

@Controller
public class EstadoCampagnaController {

		@Autowired
		private IClienteService clienteService;
		
		@GetMapping ("/estadoCampagnaConsulta")
		public String estadoCampagnaConsulta (Model model) {
			model.addAttribute("estadosCampagnas",clienteService.findAllEstados());
			return "estadoCampagnaConsulta";
		}
		
		@GetMapping ("/estadoCampagnaNuevo")
		public String estadoCampagnaNuevo (Model model) {
			EstadoCampagna estadoCampagna = new EstadoCampagna();
			model.addAttribute("estadoCampagna", estadoCampagna);
			return "estadoCampagnaNuevo";
		}
		
		@PostMapping ("/estadoCampagnaNuevo")
		public String creaEstadoCampagna (EstadoCampagna estadoCampagna, Model model) {
			clienteService.saveEstado(estadoCampagna);
			model.addAttribute("estadoCampagna", estadoCampagna);
			return "redirect:/estadoCampagnaConsulta";		
		}

		@GetMapping("estadoCampagnaNuevo/{idEstadoCampagna}")
		public String editaEstadoCampagna (@PathVariable("idEstadoCampagna") Long idEstadoCampagna, Model model) {
			
			EstadoCampagna estadoCampagna = null;
			if (idEstadoCampagna > 0) {
				estadoCampagna = clienteService.findOneEstadoCampagna(idEstadoCampagna);
			}
			else {
				return "redirect:/estadoCampagnaConsulta";	
			}
			model.addAttribute("estadoCampagna", estadoCampagna);
			return "estadoCampagnaNuevo";
		}
		
		@GetMapping("/eliminarEstadoCampagna/{idEstadoCampagna}")
		public String eliminarCampagna(@PathVariable("idEstadoCampagna")Long idEstadoCampagna, Model model) {
			clienteService.deleteEstadoCampagna(idEstadoCampagna);
			return "redirect:/estadoCampagnaConsulta";			
		}
	
}
