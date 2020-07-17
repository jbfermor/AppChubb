package com.chubb.gesformad.app.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chubb.gesformad.app.models.dao.ICampagnaDao;
import com.chubb.gesformad.app.models.dao.IFormacionDao;
import com.chubb.gesformad.app.models.entity.Campagna;
import com.chubb.gesformad.app.models.entity.Formacion;

@Service
public class FormacionServiceImpl implements IFormacionService {

	@Autowired
	private IFormacionDao formacionDao;
	
	@Autowired
	private ICampagnaDao campagnaDao;

	@Override
	@Transactional
	public List<Formacion> findAllFormaciones() {
		return (List<Formacion>) formacionDao.findAll();
	}

	@Override
	@Transactional
	public void saveFormacion(Formacion formacion) {
		formacionDao.save(formacion);
		
	}

	@Override
	@Transactional
	public void deleteFormacion(Long idFormacion) {
		formacionDao.deleteById(idFormacion);
	}

	@Override
	@Transactional
	public Formacion findOneFormacion(Long idFormacion) {
		return formacionDao.findById(idFormacion).orElse(null);
	}

	@Override
	@Transactional
	public List<Campagna> findAllCampagnas() {
		return (List<Campagna>) campagnaDao.findAll();
	}

	@Override
	@Transactional
	public Campagna finOneCampagna(Long idCampagna) {
		return campagnaDao.findById(idCampagna).orElse(null);
	}
	
}
