package com.chubb.gesformad.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.chubb.gesformad.app.models.entity.Formador;
import com.chubb.gesformad.app.models.entity.Proveedor;
import com.chubb.gesformad.app.models.entity.Rol;
import com.chubb.gesformad.app.models.services.IFormadorService;

@Controller
public class IndexController {
	
	@Autowired
	IFormadorService formadorService;
		
	@GetMapping({"/index", "", "/"})
	public String index (Model model) {
		List <Proveedor> proveedores = formadorService.findAllProveedores();
		List <Formador> formadores = formadorService.findAllFormadores();
		List <Rol> roles = formadorService.findAllRoles();
			if (roles.isEmpty()){
				Rol admin = new Rol((long)1, "admin");
				Rol formador = new Rol((long)2, "formador");
				formadorService.saveRol(admin);
				formadorService.saveRol(formador);
			}
			
		int segInicio = 0;
		
		if (proveedores.size() > 0 && formadores.isEmpty()) {
			segInicio = 1;
		}
		
		if (proveedores.size() > 0 && formadores.size() > 0) {
			segInicio = 2;
		}

		model.addAttribute("segInicio", segInicio);
		model.addAttribute("proveedores", proveedores);
		model.addAttribute("formadores", formadores);
		return "index";
	}
		
}
