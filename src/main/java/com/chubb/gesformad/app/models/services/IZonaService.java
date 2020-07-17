package com.chubb.gesformad.app.models.services;

import java.util.List;

import com.chubb.gesformad.app.models.entity.Zona;

public interface IZonaService {
	
	
	public List<Zona> findAll();
	
	
	public void save(Zona zonaNueva);
	
	
	public void delete(Long id);

	
	public Zona findOne(Long idZona);
	
	
}
