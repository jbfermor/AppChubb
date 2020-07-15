package com.chubb.gesformad.app.models.services;

import java.util.List;

import com.chubb.gesformad.app.models.entity.Comercial;
import com.chubb.gesformad.app.models.entity.Formacion;
import com.chubb.gesformad.app.models.entity.Formador;
import com.chubb.gesformad.app.models.entity.Proveedor;
import com.chubb.gesformad.app.models.entity.Rol;

public interface IFormadorService {
	
	public List <Formador> findAllFormadores();
	
	public void saveFormador (Formador formador);
	
	public void deleteFormador (Long idFormador);
	
	public Formador findOneFormador (Long idFormador);
	
	//PROVEEDORES
	
	public List <Proveedor> findAllProveedores();
	
	public Proveedor findOneProveedor(Long idProveedor);
	
	public void saveProveedor(Proveedor proveedor);
	
	
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
}
