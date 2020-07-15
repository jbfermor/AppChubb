package com.chubb.gesformad.app.controllers;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.chubb.gesformad.app.models.entity.Proveedor;
import com.chubb.gesformad.app.models.entity.Zona;
import com.chubb.gesformad.app.models.services.IProveedorService;

@Controller
public class ZonaController {
	
	@Autowired
	private IProveedorService proveedorService;

	@GetMapping("/zonaConsulta")
	public String zonaConsulta (Model model) {
		model.addAttribute("listazonas", proveedorService.findAllZonas());
		return "/zonaConsulta";
	}
	
	@GetMapping("/zonaConsulta/{idProveedor}")
	public String zonaConsultaProveedor(@PathVariable(value = "idProveedor") Long idProveedor, Model model) {
		
		List <Zona> listaZonas =  proveedorService.findAllZonas();
		List <Zona> listaZonaProveedor = new ArrayList<Zona>();
			for(Zona i : listaZonas) {
				if (idProveedor == i.getProveedor().getIdProveedor()) {
					listaZonaProveedor.add(i);
				}
			}
		model.addAttribute("listaZonaProveedor", listaZonaProveedor);
		return "/proveedorVer";
	}
	
	@GetMapping("/zonaNueva")
	public String zonaNueva (Model model) {
		Zona zona = new Zona();
		model.addAttribute("proveedores", proveedorService.findAllProveedores());
		model.addAttribute("zona", zona);
		return "/zonaNueva";
	}
	
	@PostMapping("/zonaNueva")
	public String zonaCrear (Zona zona, Model model) {
		proveedorService.saveZona(zona);
		model.addAttribute("zona", zona);
		return "redirect:/zonaConsulta";
	}
	
	@GetMapping("/zonaNueva/{idZona}")
	public String zonaEditar (@PathVariable("idZona") Long idZona, Model model) {
		
		Zona zona = null;
		
		if (idZona > 0) {
			zona = proveedorService.findOneZona(idZona);
		}
		else { 
			return "redirect:/zonaConsulta";
			}
		
		model.addAttribute("zona", zona);
		return "/zonaNueva";	
	}
	

	@GetMapping("/eliminarZona/{idZona}")
	public String zonaEliminar (@PathVariable("idZona") Long idZona, Model model) {
		proveedorService.deleteZona(idZona);
		return "redirect:/zonaConsulta";
	}
	
	
	//PROVEEDOR
	@GetMapping("/zonaNuevaProveedor/{idProveedor}")
	public String zonaNuevaProveedor(@PathVariable(value = "idProveedor") Long idProveedor, Model model) {
		
		Proveedor proveedor = proveedorService.findOneProveedor(idProveedor);
		model.addAttribute("zonas", proveedorService.findAllZonas());
			if (proveedor == null) {
				return "redirect:/proveedorVer/{idProveedor}";
			}
		Zona zona = new Zona();
		zona.setProveedor(proveedor);
		model.addAttribute("zona", zona);
		model.addAttribute("titulo", proveedor.getNombreProveedor());
		return "/zonaNuevaProveedor";
	}

	@PostMapping ("/zonaNuevaProveedor")
	public String zonaCreaEnProveedor (Zona zona, Model model) {
		proveedorService.saveZona(zona);
		model.addAttribute("zona", zona); 	
		long id = zona.getProveedor().getIdProveedor();
		return "redirect:/proveedorVer/" + id;
	 }
	
	@GetMapping("/zonaNuevaProveedor/{idZona}/{idProveedor}")
	public String zonaProveedorEditar (@PathVariable("idZona") Long idZona, @PathVariable("idProveedor") Long idProveedor, Model model) {
		
		Proveedor proveedor = null;
		
		if (idProveedor > 0 ) {
			proveedor = proveedorService.findOneProveedor(idProveedor);
		}
		else {
			return "redirect:/proveedorVer/{idProveedor}";
		}
		
		Zona zona = null;
		
		if (idZona > 0) {
			zona = proveedorService.findOneZona(idZona);
			zona.setProveedor(proveedor);
		}
		else { 
			return "redirect:/proveedorVer/{idProveedor}";
			}
		
		model.addAttribute("zona", zona);
		return "/zonaNuevaProveedor";	
	}
	
	@GetMapping("/eliminarZonaProveedor/{idZona}")
	public String zonaProveedorEliminar (@PathVariable("idZona") Long idZona, Model model) {
		Zona zona = proveedorService.findOneZona(idZona);
		long id = zona.getProveedor().getIdProveedor();
		proveedorService.deleteZona(idZona);
		return "redirect:/proveedorVer/" + id;
	}
	
	
}
