package com.chubb.gesformad.app.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chubb.gesformad.app.models.dao.IEstadoCampagnaDao;
import com.chubb.gesformad.app.models.entity.Campagna;
import com.chubb.gesformad.app.models.entity.EstadoCampagna;

@Service
public class EstadoCampagnaServiceImpl implements IEstadoCampagnaService {
	
	@Autowired
	private IEstadoCampagnaDao estadoCampagnaDao;

	@Override
	@Transactional
	public List<EstadoCampagna> findAllEstados() {
		return (List <EstadoCampagna>) estadoCampagnaDao.findAll();
	}

	@Override
	@Transactional
	public void saveEstado(EstadoCampagna estadoCampagna) {
		estadoCampagnaDao.save(estadoCampagna);
	}

	@Override
	@Transactional
	public void deleteEstado(Long idEstadoCampagna) {
		estadoCampagnaDao.deleteById(idEstadoCampagna);
	}

	@Override
	@Transactional
	public EstadoCampagna findOneEstado(Long idEstadoCampagna) {
		return estadoCampagnaDao.findById(idEstadoCampagna).orElse(null);
	}
	
	//CAMPAÑA

	@Override
	@Transactional
	public void saveCampagna(Campagna campagna) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Transactional
	public List<Campagna> findAllCampagnas() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public Campagna findOneCampagna(Long idCampagna) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public void deleteCampagna(Long idCampagna) {
		// TODO Auto-generated method stub
		
	}

}
