package com.chubb.gesformad.app.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.chubb.gesformad.app.models.entity.Formador;
import com.chubb.gesformad.app.models.entity.Cliente;
import com.chubb.gesformad.app.models.entity.Rol;
import com.chubb.gesformad.app.models.entity.Provincia;
import com.chubb.gesformad.app.models.services.IFormadorService;

@Controller
public class IndexController {
	
	@Autowired
	IFormadorService formadorService;
		
	@GetMapping({"", "/"})
	public String inicio (Model model) {
		
		List <Rol> roles = formadorService.findAllRoles();
		if (roles.isEmpty()){
			Rol admin = new Rol((long)1, "admin");
			Rol formador = new Rol((long)2, "formador");
			formadorService.saveRol(admin);
			formadorService.saveRol(formador);
		}
		
		List <Provincia> provincias = formadorService.findAllProvincias();
		if (provincias.isEmpty()) {
			Provincia p1 = new Provincia((long)1, "Álava");
			Provincia p2 = new Provincia((long)2, "Albacete");
			Provincia p3 = new Provincia((long)3, "Alicante");
			Provincia p4 = new Provincia((long)4, "Almería");
			Provincia p5 = new Provincia((long)5, "Ávila");
			Provincia p6 = new Provincia((long)6, "Badajoz");
			Provincia p7 = new Provincia((long)7, "Illes Balears");
			Provincia p8 = new Provincia((long)8, "Barcelona");
			Provincia p9 = new Provincia((long)9, "Burgos");
			Provincia p10 = new Provincia((long)10, "Cáceres");
			Provincia p11 = new Provincia((long)11, "Cádiz");
			Provincia p12 = new Provincia((long)12, "Castellón");
			Provincia p13 = new Provincia((long)13, "Ciudad Real");
			Provincia p14 = new Provincia((long)14, "Córdoba");
			Provincia p15 = new Provincia((long)15, "A Coruña");
			Provincia p16 = new Provincia((long)16, "Cuenca");
			Provincia p17 = new Provincia((long)17, "Girona");
			Provincia p18 = new Provincia((long)18, "Granada");
			Provincia p19 = new Provincia((long)19, "Guadalajara");
			Provincia p20 = new Provincia((long)20, "Gipuzkoa");
			Provincia p21 = new Provincia((long)21, "Huelva");
			Provincia p22 = new Provincia((long)22, "Huesca");
			Provincia p23 = new Provincia((long)23, "Jaén");
			Provincia p24 = new Provincia((long)24, "León");
			Provincia p25 = new Provincia((long)25, "Lleida");
			Provincia p26 = new Provincia((long)26, "La Rioja");
			Provincia p27 = new Provincia((long)27, "Lugo");
			Provincia p28 = new Provincia((long)28, "Madrid");
			Provincia p29 = new Provincia((long)29, "Málaga");
			Provincia p30 = new Provincia((long)30, "Murcia");
			Provincia p31 = new Provincia((long)31, "Navarra");
			Provincia p32 = new Provincia((long)32, "Ourense");
			Provincia p33 = new Provincia((long)33, "Asturias");
			Provincia p34 = new Provincia((long)34, "Palencia");
			Provincia p35 = new Provincia((long)35, "Las Palmas");
			Provincia p36 = new Provincia((long)36, "Pontevedra");
			Provincia p37 = new Provincia((long)37, "Salamanca");
			Provincia p38 = new Provincia((long)38, "Santa Cruz de Tenerife");
			Provincia p39 = new Provincia((long)39, "Cantabria");
			Provincia p40 = new Provincia((long)40, "Segovia");
			Provincia p41 = new Provincia((long)41, "Sevilla");
			Provincia p42 = new Provincia((long)42, "Soria");
			Provincia p43 = new Provincia((long)43, "Tarragona");
			Provincia p44 = new Provincia((long)44, "Teruel");
			Provincia p45 = new Provincia((long)45, "Toledo");
			Provincia p46 = new Provincia((long)46, "Valencia");
			Provincia p47 = new Provincia((long)47, "Valladolid");
			Provincia p48 = new Provincia((long)48, "Bizkaia");
			Provincia p49 = new Provincia((long)49, "Zamora");
			Provincia p50 = new Provincia((long)50, "Zaragoza");
			Provincia p51 = new Provincia((long)51, "Ceuta");
			Provincia p52 = new Provincia((long)52, "Melilla");
			
			formadorService.saveProvincia(p1);
			formadorService.saveProvincia(p2);
			formadorService.saveProvincia(p3);
			formadorService.saveProvincia(p4);
			formadorService.saveProvincia(p5);
			formadorService.saveProvincia(p6);
			formadorService.saveProvincia(p7);
			formadorService.saveProvincia(p8);
			formadorService.saveProvincia(p9);
			formadorService.saveProvincia(p10);
			formadorService.saveProvincia(p11);
			formadorService.saveProvincia(p12);
			formadorService.saveProvincia(p13);
			formadorService.saveProvincia(p14);
			formadorService.saveProvincia(p15);
			formadorService.saveProvincia(p16);
			formadorService.saveProvincia(p17);
			formadorService.saveProvincia(p18);
			formadorService.saveProvincia(p19);
			formadorService.saveProvincia(p20);
			formadorService.saveProvincia(p21);
			formadorService.saveProvincia(p22);
			formadorService.saveProvincia(p23);
			formadorService.saveProvincia(p24);
			formadorService.saveProvincia(p25);
			formadorService.saveProvincia(p26);
			formadorService.saveProvincia(p27);
			formadorService.saveProvincia(p28);
			formadorService.saveProvincia(p29);
			formadorService.saveProvincia(p30);
			formadorService.saveProvincia(p31);
			formadorService.saveProvincia(p32);
			formadorService.saveProvincia(p33);
			formadorService.saveProvincia(p34);
			formadorService.saveProvincia(p35);
			formadorService.saveProvincia(p36);
			formadorService.saveProvincia(p37);
			formadorService.saveProvincia(p38);
			formadorService.saveProvincia(p39);
			formadorService.saveProvincia(p40);
			formadorService.saveProvincia(p41);
			formadorService.saveProvincia(p42);
			formadorService.saveProvincia(p43);
			formadorService.saveProvincia(p44);
			formadorService.saveProvincia(p45);
			formadorService.saveProvincia(p46);
			formadorService.saveProvincia(p47);
			formadorService.saveProvincia(p49);
			formadorService.saveProvincia(p49);
			formadorService.saveProvincia(p50);
			formadorService.saveProvincia(p51);
			formadorService.saveProvincia(p52);
		}
		
		
		return "redirect:/index";
	}
	
	@GetMapping("/index")
	public String index (Model model) {
		
		List <Cliente> clientes = formadorService.findAllClientes();
		List <Formador> formadores = formadorService.findAllFormadores();
		
		
		int segInicio = 0;
		
		if (clientes.size() > 0 && formadores.isEmpty()) {
			segInicio = 1;
		}
		
		if (clientes.size() > 0 && formadores.size() > 0) {
			segInicio = 2;
		}
		
		model.addAttribute("clientes", clientes);
		model.addAttribute("formadores", formadores);
		model.addAttribute("segInicio", segInicio);
		return "index";
	}
}
