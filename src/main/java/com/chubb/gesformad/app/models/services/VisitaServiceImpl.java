package com.chubb.gesformad.app.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.chubb.gesformad.app.models.dao.IVisitaDao;
import com.chubb.gesformad.app.models.entity.Visita;

public class VisitaServiceImpl implements IVisitaService {
	
	@Autowired
	private IVisitaDao visitaDao;

	@Override
	public List<Visita> findAllVisitas() {
		return (List<Visita>) visitaDao.findAll();
	}

	@Override
	public Visita findOneVisitaId(Long idVisita) {
		return visitaDao.findById(idVisita).orElse(null);
	}

	@Override
	public void saveVisita(Visita visita) {
		visitaDao.save(visita);
	}

	@Override
	public void deleteVisita(Long idVisita) {
		visitaDao.deleteById(idVisita);	
	}

}
