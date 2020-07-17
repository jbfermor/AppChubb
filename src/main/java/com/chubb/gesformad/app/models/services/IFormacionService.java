package com.chubb.gesformad.app.models.services;

import java.util.List;

import com.chubb.gesformad.app.models.entity.Campagna;
import com.chubb.gesformad.app.models.entity.Formacion;

public interface IFormacionService {
	
	public List<Formacion> findAllFormaciones();
	
	public void saveFormacion(Formacion formacion);
	
	public void deleteFormacion(Long idFormacion);

	public Formacion findOneFormacion(Long idFormacion);

	
	//CAMPAÑA
	
	public List <Campagna> findAllCampagnas();
	
	public Campagna finOneCampagna(Long idCampagna);
	
}
