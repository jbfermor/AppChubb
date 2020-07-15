package com.chubb.gesformad.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.chubb.gesformad.app.models.entity.Franquicia;
import com.chubb.gesformad.app.models.entity.Proveedor;
import com.chubb.gesformad.app.models.services.IProveedorService;

@Controller
public class FranquiciaController {

	@Autowired
	private IProveedorService proveedorService;

	@GetMapping("/franquiciaConsulta")
	public String franquiciaConsulta(Model model) {
		model.addAttribute("franquicias", proveedorService.findAllFranquicias());
		Proveedor proveedor = new Proveedor((long) 1, "Orange");
		proveedorService.saveProveedor(proveedor);
		return "franquiciaConsulta";
	}

	@GetMapping("/franquiciaNueva")
	public String franquiciaNueva(Model model) {
		model.addAttribute("proveedores", proveedorService.findAllProveedores());
		Franquicia franquicia = new Franquicia();
		model.addAttribute("franquicia", franquicia);
		return "/franquiciaNueva";
	}
	
	@PostMapping ("/franquiciaNueva") public String franquiciaCrea (Franquicia franquicia, Model model) {
		proveedorService.saveFranquicia(franquicia);
		model.addAttribute("franquicia", franquicia); 
		return "redirect:/franquiciaConsulta"; 
	 }
	
	@GetMapping("/franquiciaNueva/{idFranquicia}")
	public String franquiciaEdita (@PathVariable("idFranquicia") Long idFranquicia, Model model) {
		model.addAttribute("proveedores", proveedorService.findAllProveedores());
		Franquicia franquicia = null;
		if (idFranquicia > 0) {
			franquicia = proveedorService.findOneFranquicia(idFranquicia); 
			}
		else { 
			return "redirect:/franquiciaConsulta"; 
			}
		model.addAttribute("franquicia", franquicia);
		return "/franquiciaNueva"; 
		}
	
	@GetMapping("/eliminarFranquicia/{idFranquicia}")
	public String franquiciaElimina(@PathVariable("idFranquicia") Long idFranquicia, Model model)
	{
	 proveedorService.deleteFranquicia(idFranquicia);
	 return "redirect:/franquiciaConsulta"; 
	 }
	
	
	//PROVEEDOR
	
	@GetMapping("/franquiciaNuevaProveedor/{idProveedor}")
	public String franquiciaNuevaProveedor(@PathVariable(value = "idProveedor") Long idProveedor, Model model) {
		Proveedor proveedor = proveedorService.findOneProveedor(idProveedor);
			if (proveedor == null) {
				return "redirect:/proveedorVer/" + idProveedor;
			}
		Franquicia franquicia = new Franquicia();
		franquicia.setProveedor(proveedor);
		model.addAttribute("franquicia", franquicia);
		model.addAttribute("proveedores", proveedorService.findAllProveedores());
		return "/franquiciaNuevaProveedor";
	}


	@PostMapping ("/franquiciaNuevaProveedor") public String franquiciaCreaEnProveedor (Franquicia franquicia, Model model) {
		proveedorService.saveFranquicia(franquicia);
		model.addAttribute("franquicia", franquicia); 
		long idProveedor = franquicia.getProveedor().getIdProveedor();
		return "redirect:/proveedorVer/" + idProveedor; 
	 }
	
	@GetMapping("/franquiciaEditaProveedor/{idFranquicia}/{idProveedor}")
	public String franquiciaProveedorEditar (@PathVariable("idFranquicia") Long idFranquicia, @PathVariable("idProveedor") Long idProveedor, Model model) {
			
			Proveedor proveedor = null;
			
			if (idProveedor > 0 ) {
				proveedor = proveedorService.findOneProveedor(idProveedor);
			}
			else {
				return "redirect:/verProveedor/{idProveedor}";
			}
			
			Franquicia franquicia = null;
			
			if (idFranquicia > 0) {
				franquicia = proveedorService.findOneFranquicia(idFranquicia);
				franquicia.setProveedor(proveedor);
			}
			else { 
				return "redirect:/verProveedor/{idProveedor}";
				}
			model.addAttribute("proveedores", proveedorService.findAllProveedores());
			model.addAttribute("franquicia", franquicia);
			return "/franquiciaNuevaProveedor";	
		}
	
	@GetMapping("/eliminarFranquiciaProveedor/{idFranquicia}")
	public String franquiciaProveedorEliminar (@PathVariable("idFranquicia") Long idFranquicia, Model model) {
		Franquicia franquicia = proveedorService.findOneFranquicia(idFranquicia);
		long id = franquicia.getProveedor().getIdProveedor();
		proveedorService.deleteFranquicia(idFranquicia);
		return "redirect:/proveedorVer/" + id;
	}
	

}
