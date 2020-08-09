package com.chubb.gesformad.app.models.services;

import java.util.List;

import com.chubb.gesformad.app.models.entity.Visita;

public interface IVisitaService {
	
	public List <Visita> findAllVisitas();
	
	public Visita findOneVisitaId(Long idVisita);
	
	public void saveVisita(Visita visita);
	
	public void deleteVisita(Long idVisita);

}
