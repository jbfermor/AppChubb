package com.chubb.gesformad.app.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chubb.gesformad.app.models.dao.IComercialDao;
import com.chubb.gesformad.app.models.dao.IFormacionDao;
import com.chubb.gesformad.app.models.dao.IFormadorDao;
import com.chubb.gesformad.app.models.dao.IProveedorDao;
import com.chubb.gesformad.app.models.dao.IRolDao;
import com.chubb.gesformad.app.models.dao.IZonaDao;
import com.chubb.gesformad.app.models.entity.Comercial;
import com.chubb.gesformad.app.models.entity.Formacion;
import com.chubb.gesformad.app.models.entity.Formador;
import com.chubb.gesformad.app.models.entity.Proveedor;
import com.chubb.gesformad.app.models.entity.Rol;
import com.chubb.gesformad.app.models.entity.Zona;

@Service
public class FormadorServiceImpl implements IFormadorService {
	
	@Autowired
	IFormadorDao formadorDao;
	
	@Autowired
	IFormacionDao formacionDao;
	
	@Autowired
	IComercialDao comercialDao;
	
	@Autowired
	IRolDao rolDao;
	
	@Autowired
	IProveedorDao proveedorDao;
	
	@Autowired
	IZonaDao zonaDao;

	@Override
	@Transactional
	public List<Formador> findAllFormadores() {
		return (List<Formador>) formadorDao.findAll();
	}

	@Override
	@Transactional
	public void saveFormador(Formador formador) {
		formadorDao.save(formador);
	}

	@Override
	@Transactional
	public void deleteFormador(Long idFormador) {
		Formador formador = formadorDao.findById(idFormador).orElse(null);
		formadorDao.delete(formador);
	}

	@Override
	@Transactional
	public Formador findOneFormador(Long idFormador) {
		Formador formador = formadorDao.findById(idFormador).orElse(null);
		return formador;
	}
	
	//PROVEEDORES
	
	@Override
	@Transactional
	public List<Proveedor> findAllProveedores() {
		return (List<Proveedor>) proveedorDao.findAll();
	}
	
	@Override
	@Transactional
	public Proveedor findOneProveedor(Long idProveedor) {
		return proveedorDao.findById(idProveedor).orElse(null);
	}
	
	@Override
	@Transactional
	public void saveProveedor(Proveedor proveedor) {
		proveedorDao.save(proveedor);
	}
	
	//ZONAS
	
	@Override
	@Transactional
	public List<Zona> findAllZonas() {
		return (List<Zona>) zonaDao.findAll();
	}
	
	@Override
	@Transactional
	public Zona findOneZona(Long idZona) {
		return zonaDao.findById(idZona).orElse(null);
	}
	
	@Override
	@Transactional
	public void saveZona(Zona zona) {
		zonaDao.save(zona);
	}
	
	
	 // FORMACIONES
	
	@Override
	@Transactional
	public List<Formacion> findAllFormaciones() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public Formacion findOneFormacion(Long idFormacion) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	//COMERCIALES

	@Override
	@Transactional
	public List<Comercial> findAllComerciales() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public Formacion findOneComercial(Long idComercial) {
		// TODO Auto-generated method stub
		return null;
	}
	
	//ROLES
	
	@Override
	@Transactional
	public List<Rol> findAllRoles() {
		return (List<Rol>) rolDao.findAll();
	}

	@Override
	public Rol findOneRol(Long idRol) {
		return rolDao.findById(idRol).orElse(null);
	}
	
	@Override
	@Transactional
	public void saveRol(Rol rol) {
		rolDao.save(rol);
	}

}
