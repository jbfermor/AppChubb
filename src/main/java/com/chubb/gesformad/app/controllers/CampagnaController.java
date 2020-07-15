package com.chubb.gesformad.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.chubb.gesformad.app.models.entity.Campagna;
import com.chubb.gesformad.app.models.entity.EstadoCampagna;
import com.chubb.gesformad.app.models.entity.Proveedor;
import com.chubb.gesformad.app.models.services.IProveedorService;

@Controller
public class CampagnaController {

	@Autowired
	private IProveedorService proveedorService;

	@GetMapping("/campagnaConsulta")
	public String campagnaConsulta(Model model) {
		//ELIMINAR EN VERSION FINAL	
		Proveedor proveedor = new Proveedor((long) 1, "Orange");
		EstadoCampagna estadoUno = new EstadoCampagna((long) 1, "Activo");
		proveedorService.saveProveedor(proveedor);
		proveedorService.saveEstado(estadoUno);
		//ELIMINAR EN VERSION FINAL
		
		model.addAttribute("campagnas", proveedorService.findAllCampagnas());
		return "/campagnaConsulta";
	}

	@GetMapping("/campagnaNueva")
	public String campagnaNueva(Model model) {
		model.addAttribute("proveedores", proveedorService.findAllProveedores());
		model.addAttribute("estados", proveedorService.findAllEstados());
		Campagna campagna = new Campagna();
		model.addAttribute("campagna", campagna);
		return "/campagnaNueva";
	}
	
	@PostMapping ("/campagnaNueva") public String campagnaCrea (Campagna campagna, Model model) {
		proveedorService.saveCampagna(campagna);
		model.addAttribute("campagna", campagna); 
		return "redirect:/campagnaConsulta"; 
	 }
	
	@GetMapping("/campagnaNueva/{idCampagna}")
	public String CampagnaEdita (@PathVariable("idCampagna") Long idCampagna, Model model) {
		model.addAttribute("proveedores", proveedorService.findAllProveedores());
		model.addAttribute("estados", proveedorService.findAllEstados());
		Campagna campagna = null;
		if (idCampagna > 0) {
			campagna = proveedorService.findOneCampagna(idCampagna); 
			}
		else { 
			return "redirect:/campagnaConsulta"; 
			}
		model.addAttribute("campagna", campagna);
		return "/campagnaNueva"; 
		}
	

	
	@GetMapping("/eliminarCampagna/{idCampagna}")
	public String campagnaElimina(@PathVariable("idCampagna") Long idCampagna, Model model){
	 proveedorService.deleteCampagna(idCampagna);
	 return "redirect:/campagnaConsulta"; 
	 }
	
	//PROVEEDOR
	@GetMapping("/campagnaNuevaProveedor/{idProveedor}")
	public String campagnaNuevaProveedor(@PathVariable(value = "idProveedor") Long idProveedor, Model model) {
		
		Proveedor proveedor = proveedorService.findOneProveedor(idProveedor);
			if (proveedor == null) {
				return "redirect:/proveedorVer/" + idProveedor;
			}
		Campagna campagna = new Campagna();
		campagna.setProveedor(proveedor);
		model.addAttribute("campagna", campagna);
		model.addAttribute("proveedores", proveedorService.findAllProveedores());
		model.addAttribute("estados", proveedorService.findAllEstados());
		return "/campagnaNuevaProveedor";
	}

	@PostMapping ("/campagnaNuevaProveedor") public String campagnaCreaEnProveedor (Campagna campagna, Model model) {
		proveedorService.saveCampagna(campagna);
		model.addAttribute("campagna", campagna); 
		long id = campagna.getProveedor().getIdProveedor();
		return "redirect:/proveedorVer/" + id;
	 }
		
	@GetMapping("/campagnaEditaProveedor/{idCampagna}/{idProveedor}")
	public String campagnaProveedorEditar (@PathVariable("idCampagna") Long idCampagna, @PathVariable("idProveedor") Long idProveedor, Model model) {
			
			Proveedor proveedor = null;
			
			if (idProveedor > 0 ) {
				proveedor = proveedorService.findOneProveedor(idProveedor);
			}
			else {
				return "redirect:/verProveedor/{idProveedor}";
			}
			
			Campagna campagna = null;
			
			if (idCampagna > 0) {
				campagna = proveedorService.findOneCampagna(idCampagna);
				campagna.setProveedor(proveedor);
			}
			else { 
				return "redirect:/verProveedor/{idProveedor}";
				}
			model.addAttribute("proveedores", proveedorService.findAllProveedores());
			model.addAttribute("estados", proveedorService.findAllEstados());
			model.addAttribute("campagna", campagna);
			return "/campagnaNuevaProveedor";	
		}
	
	@GetMapping("/eliminarCampagnaProveedor/{idCampagna}")
	public String campagnaProveedorEliminar (@PathVariable("idCampagna") Long idCampagna, Model model) {
		Campagna campagna = proveedorService.findOneCampagna(idCampagna);
		long id = campagna.getProveedor().getIdProveedor();
		proveedorService.deleteCampagna(idCampagna);
		return "redirect:/proveedorVer/" + id;
	}

}
