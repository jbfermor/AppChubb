package com.chubb.gesformad.app.models.services;

import java.util.List;

import com.chubb.gesformad.app.models.entity.Comercial;
import com.chubb.gesformad.app.models.entity.Formacion;
import com.chubb.gesformad.app.models.entity.Formador;
import com.chubb.gesformad.app.models.entity.Incidencia;
import com.chubb.gesformad.app.models.entity.Cliente;
import com.chubb.gesformad.app.models.entity.Rol;
import com.chubb.gesformad.app.models.entity.Tienda;

public interface ITiendaService {
	
	public List <Tienda> findAllTiendas();
	
	public void saveTienda (Tienda tienda);
	
	public void deleteTienda (Long idTienda);
	
	public Tienda findOneTienda (Long idTienda);
	
	//INCIDENCIAS
	

	public void saveIncidencia (Incidencia incidencia);
	
	public void deleteIncidencia (Long idIncidencia);
	
	public Incidencia findOneIncidencia (Long idIncidencia);
	
	public List <Incidencia> findAllIncidencias();
	
	

}
