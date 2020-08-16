package com.chubb.gesformad.app.models.services;

import java.util.List;

import com.chubb.gesformad.app.models.entity.Comercial;
import com.chubb.gesformad.app.models.entity.Formacion;
import com.chubb.gesformad.app.models.entity.Formador;
import com.chubb.gesformad.app.models.entity.Provincia;
import com.chubb.gesformad.app.models.entity.Cliente;
import com.chubb.gesformad.app.models.entity.Rol;
import com.chubb.gesformad.app.models.entity.Zona;

public interface IFormadorService {
	
	public List <Formador> findAllFormadores();
	
	public void saveFormador (Formador formador);
	
	public void deleteFormador (Long idFormador);
	
	public Formador findOneFormador (Long idFormador);
	
	
	//CLIENTES
	
	public List <Cliente> findAllClientes();
	
	public Cliente findOneCliente(Long idCliente);
	
	public void saveCliente(Cliente cliente);
	
	
	//ZONAS
	
	public List<Zona> findAllZonas();
	
	public Zona findOneZona(Long idZona);
	
	public void saveZona(Zona zona);
	
	
	//FORMACIONES
	
	public List<Formacion> findAllFormaciones();
	
	public Formacion findOneFormacion(Long idFormacion);
	
	
	//COMERCIALES
	
	public List <Comercial> findAllComerciales();

	public Formacion findOneComercial(Long idComercial);
	
	
	//ROLES
	
	public List <Rol> findAllRoles();
	
	public Rol findOneRol(Long idRol);
	
	public void saveRol(Rol rol);
	
	
	//PROVINCIAS
	
	public List <Provincia> findAllProvincias();
	
	public Provincia findOneProvincia (Long idProvincia);
	
	public void saveProvincia (Provincia provincia);
	
}
