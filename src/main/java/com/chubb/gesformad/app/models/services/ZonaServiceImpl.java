package com.chubb.gesformad.app.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chubb.gesformad.app.models.dao.IZonaDao;
import com.chubb.gesformad.app.models.entity.Zona;

@Service
public class ZonaServiceImpl implements IZonaService {

	@Autowired
	private IZonaDao zonaDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Zona> findAll() {
		return (List<Zona>) zonaDao.findAll();		 
	}

	@Override
	@Transactional
	public void save(Zona zonaNueva) {
		zonaDao.save(zonaNueva);
	}

	@Override
	@Transactional
	public void delete(Long idZona) {
		zonaDao.deleteById(idZona);		
	}

	@Override
	@Transactional(readOnly = true)
	public Zona findOne(Long idZona) {
		return zonaDao.findById(idZona).orElse(null);
	}
	
}
