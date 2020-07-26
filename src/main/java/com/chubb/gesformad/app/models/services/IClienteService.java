package com.chubb.gesformad.app.models.services;

import java.util.List;

import com.chubb.gesformad.app.models.entity.Campagna;
import com.chubb.gesformad.app.models.entity.EstadoCampagna;
import com.chubb.gesformad.app.models.entity.Formacion;
import com.chubb.gesformad.app.models.entity.Formador;
import com.chubb.gesformad.app.models.entity.Franquicia;
import com.chubb.gesformad.app.models.entity.Cliente;
import com.chubb.gesformad.app.models.entity.Tienda;
import com.chubb.gesformad.app.models.entity.Zona;

public interface IClienteService {

	public List <Cliente> findAllClientes();
	
	public void saveCliente (Cliente cliente);
	
	public void deleteCliente (Long idCliente);
	
	public Cliente findOneCliente (Long idCliente);
	
	
	//CON ZONAS
	
	public List<Zona> findAllZonas();
	
	public void saveZona(Zona zonaNueva);
	
	public void deleteZona(Long id);
	
	public Zona findOneZona(Long idZona);
	
	//CAMPAÑA
	
	public void saveCampagna (Campagna campagna);
	
	public List <Campagna> findAllCampagnas();

	public Campagna findOneCampagna(Long idCampagna);

	public void deleteCampagna(Long idCampagna);
	
	
	//CON ESTADOS
	
	public List <EstadoCampagna> findAllEstados();

	public void saveEstado(EstadoCampagna estadoCampagna);
	
	public EstadoCampagna findOneEstadoCampagna(Long idEstadoCampagna);
	
	public void deleteEstadoCampagna (Long idEstadoCampagna);
	
	
	//CON FRANQUICIAS
	
	public void saveFranquicia (Franquicia franquicia);
	
	public List <Franquicia> findAllFranquicias();
	
	public Franquicia findOneFranquicia (Long idFranquicia);
	
	public void deleteFranquicia (Long idFranquicia);
	
	
	//CON TIENDAS
	
	public void saveTienda (Tienda tienda);
	
	public List<Tienda> findAllTiendas();
	
	public Tienda findOneTienda (Long idTienda);
	
	public void deleteTienda (Long idTienda);
	
	
	//CON FORMADORES
	
	public void saveFormador (Formador formador);
	
	public List<Formador> findAllFormadores();
	
	public Formador findOneFormador(Long id);
	
	
	//CON FORMACIONES
	
	public void saveFormacion (Formacion formacion);
	
	public void deleteFormacion (Long idFormacion);
	
	public List<Formacion> findAllFormaciones();
	
	public Formacion findOneFormacion (Long idFormacion);
}
