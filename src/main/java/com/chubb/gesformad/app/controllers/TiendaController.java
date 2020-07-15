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
import com.chubb.gesformad.app.models.entity.Proveedor;
import com.chubb.gesformad.app.models.entity.Tienda;
import com.chubb.gesformad.app.models.entity.Zona;
import com.chubb.gesformad.app.models.services.IProveedorService;

@Controller
public class TiendaController {
	
	@Autowired
	private IProveedorService proveedorService;
	
	@GetMapping("/tiendaConsulta")
	public String consultaTienda (Model model) {
		model.addAttribute("tiendas", proveedorService.findAllTiendas());
		return "/tiendaConsulta";
	}
	
	
	//DESDE PROVEEDOR
	@GetMapping("/tiendaEditaProveedor/{idTienda}/{idProveedor}")
	public String editaTiendaProveedor(@PathVariable("idProveedor") Long idProveedor, @PathVariable("idTienda") Long idTienda, Model model) {
		
		Tienda tienda = null;
		if (idProveedor > 0) {
			tienda = proveedorService.findOneTienda(idTienda);
		}
		else {
			return "redirect:/tiendaConsulta";
		}
		
		
		List <Franquicia> listaFranquiciasP = new ArrayList <Franquicia>();
		List <Franquicia> franquiciasP = new ArrayList <Franquicia>();
		List <Zona> listaZonasP = new ArrayList <Zona>();
		List <Zona> zonasP = new ArrayList <Zona>();
		
		franquiciasP = proveedorService.findAllFranquicias();
		zonasP = proveedorService.findAllZonas();
		
		for(Franquicia i : franquiciasP) {
			if(i.getProveedor().getIdProveedor() == idProveedor) {
				listaFranquiciasP.add(i);
			}
		}
		
		for(Zona i : zonasP) {
			if(i.getProveedor().getIdProveedor() == idProveedor) {
				listaZonasP.add(i);
			}
		}
		
		model.addAttribute("listaFranquiciasP", listaFranquiciasP);
		model.addAttribute("listaZonasP", listaZonasP);
		model.addAttribute("tienda", tienda);
		return "/tiendaEditaProveedor";
	}
	
	@PostMapping("tiendaEditaProveedor")
	public String editaTienda (Tienda tienda, Model model) {
		proveedorService.saveTienda(tienda);
		model.addAttribute("tienda", tienda);
		return "redirect:/tiendaConsulta/";
	}
	
	
	@PostMapping("tiendaNuevaProveedor")
	public String creaTienda (Tienda tienda, Model model) {
		proveedorService.saveTienda(tienda);
		long id = tienda.getProveedor().getIdProveedor();
		model.addAttribute("tienda", tienda);
		return "redirect:/proveedorVer/" + id;
	}
	
	@GetMapping("/tiendaNuevaProveedor/{idProveedor}")
	public String nuevaTienda(@PathVariable("idProveedor") Long idProveedor, Model model) {
		
		Proveedor proveedor = null;
		if (idProveedor > 0) {
			proveedor = proveedorService.findOneProveedor(idProveedor);
		}
		else {
			return "redirect:/tiendaConsulta";
		}
		
		Tienda tienda = new Tienda();
		tienda.setProveedor(proveedor);
		
		List <Franquicia> listaFranquiciasP = new ArrayList <Franquicia>();
		List <Franquicia> franquiciasP = new ArrayList <Franquicia>();
		List <Zona> listaZonasP = new ArrayList <Zona>();
		List <Zona> zonasP = new ArrayList <Zona>();
		
		franquiciasP = proveedorService.findAllFranquicias();
		zonasP = proveedorService.findAllZonas();
		
		for(Franquicia i : franquiciasP) {
			if(i.getProveedor().getIdProveedor() == idProveedor) {
				listaFranquiciasP.add(i);
			}
		}
		
		for(Zona i : zonasP) {
			if(i.getProveedor().getIdProveedor() == idProveedor) {
				listaZonasP.add(i);
			}
		}
		
		model.addAttribute("listaFranquiciasP", listaFranquiciasP);
		model.addAttribute("listaZonasP", listaZonasP);
		model.addAttribute("tienda", tienda);
		return "/tiendaNuevaProveedor";
	}
	
	
	//DESDE FRANQUICIAS
	
	
	@GetMapping("/tiendaNuevaFranquicia/{idFranquicia}")
	public String nuevaTiendaFranquicia (@PathVariable("idFranquicia") Long idFranquicia, Model model) {
		
		Franquicia franquicia = proveedorService.findOneFranquicia(idFranquicia);
			if(franquicia == null) {
				return "redirect:/tiendaConsulta";
			}
		Tienda tienda = new Tienda();
		tienda.setFranquicia(franquicia);
		model.addAttribute("zonas", proveedorService.findAllZonas());
		model.addAttribute("tienda", tienda);
		model.addAttribute("nombreFranquicia", franquicia.getNombreFranquicia());
		return "/tiendaNuevaFranquicia";
	}
	
	@PostMapping ("/tiendaNuevaFranquicia")
	public String creaTiendaFranquicia (Tienda tienda, Model model) {
		proveedorService.saveTienda(tienda);
		model.addAttribute("tienda", tienda);
		return "redirect:/franquiciaConsulta";
	}
	
	@GetMapping ("/eliminarTienda/{idTienda}")
	public String eliminarTienda (@PathVariable("idTienda") Long idTienda, Model model) {
		proveedorService.deleteTienda(idTienda);
		return "redirect:/tiendaConsulta";
	}
	
	@GetMapping("/tiendaVer/{idTienda}")
	public String verTienda (@PathVariable("idTienda") Long idTienda, Model model) {
		Tienda tienda = proveedorService.findOneTienda(idTienda);
		model.addAttribute("tienda", tienda);
		return "/tiendaVer";
	}
}
