package com.chubb.gesformad.app.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.chubb.gesformad.app.models.dao.ITiendaDao;
import com.chubb.gesformad.app.models.dao.IIncidenciaDao;
import com.chubb.gesformad.app.models.entity.Incidencia;
import com.chubb.gesformad.app.models.entity.Tienda;


@Service
public class TiendaServiceImpl implements ITiendaService {
	
	@Autowired
	ITiendaDao tiendaDao;
	
	@Autowired
	IIncidenciaDao incidenciaDao;
	

	@Override
	@Transactional
	public List<Tienda> findAllTiendas() {
		return (List<Tienda>) tiendaDao.findAll();
	}

	@Override
	@Transactional
	public void saveTienda(Tienda tienda) {
		tiendaDao.save(tienda);
	}

	@Override
	@Transactional
	public void deleteTienda(Long idTienda) {
		Tienda tienda = tiendaDao.findById(idTienda).orElse(null);
		tiendaDao.delete(tienda);
	}

	@Override
	@Transactional
	public Tienda findOneTienda(Long idTienda) {
		Tienda tienda = tiendaDao.findById(idTienda).orElse(null);
		return tienda;
	}
	
	//PROVEEDORES
	
	@Override
	@Transactional
	public List<Incidencia> findAllIncidencias() {
		return (List<Incidencia>) incidenciaDao.findAll();
	}
	
	@Override
	@Transactional
	public Incidencia findOneIncidencia(Long idIncidencia) {
		return incidenciaDao.findById(idIncidencia).orElse(null);
	}
	
	@Override
	@Transactional
	public void saveIncidencia(Incidencia incidencia) {
		incidenciaDao.save(incidencia);
	}
	
	@Override
	@Transactional
	public void deleteIncidencia(Long idIncidencia) {
		Incidencia incidencia = incidenciaDao.findById(idIncidencia).orElse(null);
		incidenciaDao.delete(incidencia);
	}
	
}
