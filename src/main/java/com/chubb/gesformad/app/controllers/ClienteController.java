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
import com.chubb.gesformad.app.models.entity.EstadoCampagna;
import com.chubb.gesformad.app.models.entity.Formacion;
import com.chubb.gesformad.app.models.entity.Formador;
import com.chubb.gesformad.app.models.entity.Franquicia;
import com.chubb.gesformad.app.models.entity.Cliente;
import com.chubb.gesformad.app.models.entity.Tienda;
import com.chubb.gesformad.app.models.entity.Zona;
import com.chubb.gesformad.app.models.services.IClienteService;

@Controller
public class ClienteController {

		@Autowired
		private IClienteService clienteService;
		
		@GetMapping ("/clienteConsulta")
		public String cliente (Model model) {model.addAttribute("zonas", clienteService.findAllZonas());
		model.addAttribute("clientes", clienteService.findAllClientes());
			return "clienteConsulta";
		}
		
		//PRIMEROS PASOS CON LA APLICACION
		@GetMapping ("/clienteInicial")
		public String clienteInicialNuevo (Model model) {
			Cliente cliente = new Cliente();
			model.addAttribute("cliente", cliente);
			return "clienteInicial";
		}
		
		@PostMapping ("/clienteInicial")
		public String creaClienteInicial (Cliente cliente, Model model) {
			clienteService.saveCliente(cliente);
			model.addAttribute("cliente", cliente);
			return "redirect:/index";		
		}
		
		//FIN PRIMEROS PASOS CON LA APLICACION
		
		@GetMapping ("/clienteNuevo")
		public String clienteNuevo (Model model) {
			Cliente cliente = new Cliente();
			model.addAttribute("cliente", cliente);
			return "clienteNuevo";
		}
		
		@PostMapping ("/clienteNuevo")
		public String creaCliente (Cliente cliente, Model model) {
			clienteService.saveCliente(cliente);
			model.addAttribute("cliente", cliente);
			return "redirect:/index";		
		}
		
		@GetMapping("clienteNuevo/{idCliente}")
		public String editaCliente (@PathVariable("idCliente") Long idCliente, Model model) {
			
			Cliente cliente = null;
			if (idCliente > 0) {
				cliente = clienteService.findOneCliente(idCliente);
			}
			else {
				return "redirect:/clienteConsulta";	
			}
			model.addAttribute("cliente", cliente);
			return "clienteNuevo";
		}		
		
		@GetMapping("/clienteEliminar/{idCliente}")
		public String eliminarCliente(@PathVariable("idCliente")Long idCliente, Model model) {
			clienteService.deleteCliente(idCliente);
			return "redirect:/clienteConsulta";			
		}
		
		
		@GetMapping("clienteVer/{idCliente}")
		public String verCliente (@PathVariable("idCliente") Long idCliente, Model model) {
						
			//LISTA DE ZONAS
			List <Zona> listaZonas = clienteService.findAllZonas();
			List <Zona> listaZonasId = new ArrayList<Zona>();
			for (Zona i:listaZonas) {
				if (i.getCliente().getIdCliente() == idCliente) {
					listaZonasId.add(i);
				}
			}
			model.addAttribute("listaZonasId", listaZonasId);
			
			//LISTA DE CAMPAÑAS
			List <Campagna> listaCampagnas = clienteService.findAllCampagnas();
				//Si es la primera vez que accede a un cliente, se cargarán algunos datos por defecto
				if (listaCampagnas.isEmpty()) {
					EstadoCampagna activo = new EstadoCampagna((long) 1, "Activo");
					EstadoCampagna inactivo = new EstadoCampagna((long) 2, "Inactivo");
					clienteService.saveEstado(activo);
					clienteService.saveEstado(inactivo);
				}
				//Fin llenado ESTADOS primer inicio de aplicación
			
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
			
				//asignar formador
				Formador formador = new Formador();
				model.addAttribute("formador", formador);
				model.addAttribute("formadores", listaFormadores);
				
			
			//LISTA DE FORMACIONES
			List <Formacion> listaFormaciones = clienteService.findAllFormaciones();
			List <Formacion> listaFormacionesId = new ArrayList<Formacion>();
			for (Formacion i:listaFormaciones) {
				if (i.getCliente().getIdCliente() == idCliente) {
					listaFormacionesId.add(i);
				}
			}
			model.addAttribute("formacionesId", listaFormacionesId);
			
			//RESTO
			Cliente cliente = null;
			if (idCliente > 0) {
				cliente = clienteService.findOneCliente(idCliente);
			}
			else {
				return "redirect:/clienteConsulta";	
			}
			
			model.addAttribute("cliente", cliente);

			return "clienteVer";
		}
		
		@PostMapping("/clienteVer/{idCliente}")
		public String asignaClienteFormador (@PathVariable("idCliente") Long idCliente, Formador formador, Model model) {
			Cliente cliente = null;
			 if(idCliente > 0) {
				 cliente = clienteService.findOneCliente(idCliente);
			 }
			 else {
				 return "redirect:/clienteVer/" + idCliente;
			 }
			 Long id = formador.getIdFormador();
			 Formador formadorListo = clienteService.findOneFormador(id);
			 if (formadorListo.getClientes().contains(cliente) != true) {
			 formadorListo.getClientes().add(cliente);
			 clienteService.saveFormador(formadorListo);
			 model.addAttribute("clienteExiste", 0);
			 }
			 else {
				 model.addAttribute("clienteExiste", "¡Ya está asignado a este Cliente!");
			 }
			return "redirect:/clienteVer/" + idCliente;
		}
		
		@GetMapping("/clienteEliminarFormador/{idCliente}/{idFormador}")
		public String eliminarCliente(@PathVariable("idCliente")Long idCliente, @PathVariable("idFormador")Long idFormador, Model model) {
			Cliente cliente = clienteService.findOneCliente(idCliente);
			Formador formador = clienteService.findOneFormador(idFormador);
			Cliente provX = null;
		
			for (Cliente i : formador.getClientes()) {
				if (cliente.getIdCliente() == i.getIdCliente()){
					provX = i;
				}
			}
			
			formador.getClientes().remove(provX);
			clienteService.saveFormador(formador);
			return "redirect:/clienteVer/" + idCliente;			
		}
		
}
