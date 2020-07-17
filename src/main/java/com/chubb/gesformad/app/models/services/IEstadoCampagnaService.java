package com.chubb.gesformad.app.models.services;

import java.util.List;

import com.chubb.gesformad.app.models.entity.Campagna;
import com.chubb.gesformad.app.models.entity.EstadoCampagna;

public interface IEstadoCampagnaService {
	
	public List <EstadoCampagna> findAllEstados();
	
	public void saveEstado (EstadoCampagna estadoCampagna);
	
	public void deleteEstado (Long idEstadoCampagna);
	
	public EstadoCampagna findOneEstado(Long idEstadoCampagna);
	
	//CAMPAÑA
	
		public void saveCampagna (Campagna campagna);
		
		public List <Campagna> findAllCampagnas();

		public Campagna findOneCampagna(Long idCampagna);

		public void deleteCampagna(Long idCampagna);
		
	
}
