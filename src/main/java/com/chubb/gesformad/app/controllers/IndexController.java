package com.chubb.gesformad.app.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.util.List;

import org.apache.tomcat.util.http.fileupload.disk.DiskFileItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



import com.chubb.gesformad.app.models.entity.Formador;
import com.chubb.gesformad.app.models.entity.Localidad;
import com.chubb.gesformad.app.models.entity.Cliente;
import com.chubb.gesformad.app.models.entity.Rol;
import com.chubb.gesformad.app.models.entity.Provincia;
import com.chubb.gesformad.app.models.services.IFormadorService;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;


@Controller
public class IndexController {
	
	@Autowired
	IFormadorService formadorService;
		
	@GetMapping({"", "/"})
	public String inicio (Model model) throws IOException, CsvException {
		
		List <Rol> roles = formadorService.findAllRoles();
		if (roles.isEmpty()){
			Rol admin = new Rol((long)1, "admin");
			Rol formador = new Rol((long)2, "formador");
			formadorService.saveRol(admin);
			formadorService.saveRol(formador);
		}
		
		List <Provincia> provincias = formadorService.findAllProvincias();		
		if (provincias.isEmpty()) {
			File provinciasA = new File ("C:\\Users\\jbfer\\OneDrive\\WORKSPACE\\AppChubb - RELEASE\\src\\main\\resources\\static\\provincias.csv");
			CSVReader csvReaderProvincias = new CSVReader(new FileReader(provinciasA));
			String[] filaProvincia = null;
			
			while((filaProvincia = csvReaderProvincias.readNext()) != null) {
				String nombreP = filaProvincia[0];
				provincias.add(new Provincia(nombreP));				
				}
				formadorService.saveAllProvincias(provincias);
		}
		
		
		List <Localidad> localidades = formadorService.findAllLocalidades();
		if (localidades.isEmpty() == true) {
			File localidadesA = new File ("C:\\Users\\jbfer\\OneDrive\\WORKSPACE\\AppChubb - RELEASE\\src\\main\\resources\\static\\localidades.csv");
			CSVReader csvReader = new CSVReader(new FileReader(localidadesA));
			String[] filaLocalidad = null;
			
			while((filaLocalidad = csvReader.readNext()) != null) {
			Long idPl = Long.parseLong(filaLocalidad[2]);	
			String nombreL = filaLocalidad[1];
			Provincia provinciaLocalidad = formadorService.findOneProvincia(idPl);
			localidades.add(new Localidad(nombreL,provinciaLocalidad));				
			}
			formadorService.saveAllLocalidades(localidades);
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
