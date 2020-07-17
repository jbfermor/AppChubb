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
import com.chubb.gesformad.app.models.entity.Proveedor;
import com.chubb.gesformad.app.models.entity.Tienda;
import com.chubb.gesformad.app.models.entity.Zona;
import com.chubb.gesformad.app.models.services.IProveedorService;

@Controller
public class ProveedorController {

		@Autowired
		private IProveedorService proveedorService;
		
		@GetMapping ("/proveedorConsulta")
		public String proveedor (Model model) {model.addAttribute("zonas", proveedorService.findAllZonas());
		model.addAttribute("proveedores", proveedorService.findAllProveedores());
			return "proveedorConsulta";
		}
		
		//PRIMEROS PASOS CON LA APLICACION
		@GetMapping ("/proveedorInicial")
		public String proveedorInicialNuevo (Model model) {
			Proveedor proveedor = new Proveedor();
			model.addAttribute("proveedor", proveedor);
			return "proveedorInicial";
		}
		
		@PostMapping ("/proveedorInicial")
		public String creaProveedorInicial (Proveedor proveedor, Model model) {
			proveedorService.saveProveedor(proveedor);
			model.addAttribute("proveedor", proveedor);
			return "redirect:/index";		
		}
		
		//FIN PRIMEROS PASOS CON LA APLICACION
		
		@GetMapping ("/proveedorNuevo")
		public String proveedorNuevo (Model model) {
			Proveedor proveedor = new Proveedor();
			model.addAttribute("proveedor", proveedor);
			return "proveedorNuevo";
		}
		
		@PostMapping ("/proveedorNuevo")
		public String creaProveedor (Proveedor proveedor, Model model) {
			proveedorService.saveProveedor(proveedor);
			model.addAttribute("proveedor", proveedor);
			return "redirect:/index";		
		}
		
		@GetMapping("proveedorNuevo/{idProveedor}")
		public String editaProveedor (@PathVariable("idProveedor") Long idProveedor, Model model) {
			
			Proveedor proveedor = null;
			if (idProveedor > 0) {
				proveedor = proveedorService.findOneProveedor(idProveedor);
			}
			else {
				return "redirect:/proveedorConsulta";	
			}
			model.addAttribute("proveedor", proveedor);
			return "proveedorNuevo";
		}		
		
		@GetMapping("/proveedorEliminar/{idProveedor}")
		public String eliminarProveedor(@PathVariable("idProveedor")Long idProveedor, Model model) {
			proveedorService.deleteProveedor(idProveedor);
			return "redirect:/proveedorConsulta";			
		}
		
		
		@GetMapping("proveedorVer/{idProveedor}")
		public String verProveedor (@PathVariable("idProveedor") Long idProveedor, Model model) {
			
			
			
			//LISTA DE ZONAS
			List <Zona> listaZonas = proveedorService.findAllZonas();
			List <Zona> listaZonasId = new ArrayList<Zona>();
			for (Zona i:listaZonas) {
				if (i.getProveedor().getIdProveedor() == idProveedor) {
					listaZonasId.add(i);
				}
			}
			model.addAttribute("listaZonasId", listaZonasId);
			
			//LISTA DE CAMPAÑAS
			List <Campagna> listaCampagnas = proveedorService.findAllCampagnas();
				//Si es la primera vez que accede a un porveedor, se cargarán algunos datos por defecto
				if (listaCampagnas.isEmpty()) {
					EstadoCampagna activo = new EstadoCampagna((long) 1, "Activo");
					EstadoCampagna inactivo = new EstadoCampagna((long) 2, "Inactivo");
					proveedorService.saveEstado(activo);
					proveedorService.saveEstado(inactivo);
				}
				//Fin llenado ESTADOS primer inicio de aplicación
			
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
			
				//asignar formador
				Formador formador = new Formador();
				model.addAttribute("formador", formador);
				model.addAttribute("formadores", listaFormadores);
				
			
			//LISTA DE FORMACIONES
			List <Formacion> listaFormaciones = proveedorService.findAllFormaciones();
			List <Formacion> listaFormacionesId = new ArrayList<Formacion>();
			for (Formacion i:listaFormaciones) {
				if (i.getProveedor().getIdProveedor() == idProveedor) {
					listaFormacionesId.add(i);
				}
			}
			model.addAttribute("formacionesId", listaFormacionesId);
			
			//RESTO
			Proveedor proveedor = null;
			if (idProveedor > 0) {
				proveedor = proveedorService.findOneProveedor(idProveedor);
			}
			else {
				return "redirect:/proveedorConsulta";	
			}
			
			model.addAttribute("proveedor", proveedor);

			return "proveedorVer";
		}
		
		@PostMapping("/proveedorVer/{idProveedor}")
		public String asignaProveedorFormador (@PathVariable("idProveedor") Long idProveedor, Formador formador, Model model) {
			Proveedor proveedor = null;
			 if(idProveedor > 0) {
				 proveedor = proveedorService.findOneProveedor(idProveedor);
			 }
			 else {
				 return "redirect:/proveedorVer/" + idProveedor;
			 }
			 Long id = formador.getIdFormador();
			 Formador formadorListo = proveedorService.findOneFormador(id);
			 if (formadorListo.getProveedores().contains(proveedor) != true) {
			 formadorListo.getProveedores().add(proveedor);
			 proveedorService.saveFormador(formadorListo);
			 model.addAttribute("proveedorExiste", 0);
			 }
			 else {
				 model.addAttribute("proveedorExiste", "¡Ya está asignado a este Proveedor!");
			 }
			return "redirect:/proveedorVer/" + idProveedor;
		}
		
		@GetMapping("/proveedorEliminarFormador/{idProveedor}/{idFormador}")
		public String eliminarProveedor(@PathVariable("idProveedor")Long idProveedor, @PathVariable("idFormador")Long idFormador, Model model) {
			Proveedor proveedor = proveedorService.findOneProveedor(idProveedor);
			Formador formador = proveedorService.findOneFormador(idFormador);
			Proveedor provX = null;
		
			for (Proveedor i : formador.getProveedores()) {
				if (proveedor.getIdProveedor() == i.getIdProveedor()){
					provX = i;
				}
			}
			
			formador.getProveedores().remove(provX);
			proveedorService.saveFormador(formador);
			return "redirect:/proveedorVer/" + idProveedor;			
		}
		
}
