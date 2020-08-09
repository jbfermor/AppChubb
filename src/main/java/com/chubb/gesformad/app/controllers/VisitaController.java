package com.chubb.gesformad.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.chubb.gesformad.app.models.services.IClienteService;

@Controller
public class VisitaController {
	
	@Autowired
	private IClienteService clienteService;
	
	@GetMapping ("/visitaConsulta")
	public String visitaConsulta (Model model) {
		model.addAttribute("visitas", clienteService.findAllVisitas());
		return "visitaConsulta";
	}
	
}
