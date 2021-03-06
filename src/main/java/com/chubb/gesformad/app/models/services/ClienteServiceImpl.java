package com.chubb.gesformad.app.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chubb.gesformad.app.models.dao.ICampagnaDao;
import com.chubb.gesformad.app.models.dao.IEstadoCampagnaDao;
import com.chubb.gesformad.app.models.dao.IFormacionDao;
import com.chubb.gesformad.app.models.dao.IFormadorDao;
import com.chubb.gesformad.app.models.dao.IFranquiciaDao;
import com.chubb.gesformad.app.models.dao.IIncidenciaDao;
import com.chubb.gesformad.app.models.dao.ILocalidadDao;
import com.chubb.gesformad.app.models.dao.IProvinciaDao;
import com.chubb.gesformad.app.models.dao.IClienteDao;
import com.chubb.gesformad.app.models.dao.ITiendaDao;
import com.chubb.gesformad.app.models.dao.IVisitaDao;
import com.chubb.gesformad.app.models.dao.IZonaDao;
import com.chubb.gesformad.app.models.entity.Campagna;
import com.chubb.gesformad.app.models.entity.EstadoCampagna;
import com.chubb.gesformad.app.models.entity.Formacion;
import com.chubb.gesformad.app.models.entity.Formador;
import com.chubb.gesformad.app.models.entity.Franquicia;
import com.chubb.gesformad.app.models.entity.Incidencia;
import com.chubb.gesformad.app.models.entity.Localidad;
import com.chubb.gesformad.app.models.entity.Provincia;
import com.chubb.gesformad.app.models.entity.Cliente;
import com.chubb.gesformad.app.models.entity.Tienda;
import com.chubb.gesformad.app.models.entity.Visita;
import com.chubb.gesformad.app.models.entity.Zona;

@Service
public class ClienteServiceImpl implements IClienteService {

	@Autowired
	private IClienteDao clienteDao;
	
	@Autowired
	private IZonaDao zonaDao;
	
	@Autowired
	private ICampagnaDao campagnaDao;
	
	@Autowired
	private IEstadoCampagnaDao estadoCampagnaDao;
	
	@Autowired
	private IFranquiciaDao franquiciaDao;
	
	@Autowired
	private ITiendaDao tiendaDao;
	
	@Autowired
	private IFormadorDao formadorDao;
	
	@Autowired
	private IFormacionDao formacionDao;
	
	@Autowired
	private IIncidenciaDao incidenciaDao;
	
	@Autowired
	private IVisitaDao visitaDao;
	
	@Autowired
	private IProvinciaDao provinciaDao;
	
	@Autowired
	private ILocalidadDao localidadDao;
	
	@Override
	@Transactional
	public List<Cliente> findAllClientes() {
		return (List<Cliente>) clienteDao.findAll();
	}

	@Override
	@Transactional
	public void saveCliente(Cliente cliente) {
		clienteDao.save(cliente);
	}

	@Override
	@Transactional
	public void deleteCliente(Long idCliente) {
		clienteDao.deleteById(idCliente);
	}

	@Override
	@Transactional
	public Cliente findOneCliente(Long idCliente) {
		return clienteDao.findById(idCliente).orElse(null);
	}
	
	//ZONAS
	
	@Override
	@Transactional(readOnly = true)
	public List<Zona> findAllZonas() {
		return (List<Zona>) zonaDao.findAll();		 
	}

	@Override
	@Transactional
	public void saveZona(Zona zona) {
		zonaDao.save(zona);
	}

	@Override
	@Transactional
	public void deleteZona(Long idZona) {
		zonaDao.deleteById(idZona);		
	}

	@Override
	@Transactional(readOnly = true)
	public Zona findOneZona(Long idZona) {
		return zonaDao.findById(idZona).orElse(null);
	}
	
	//CAMPAÑA
	
	@Override
	@Transactional
	public void saveCampagna(Campagna campagna) {
		campagnaDao.save(campagna);
	}
	
	@Override
	@Transactional
	public List <Campagna> findAllCampagnas() {
		return (List <Campagna>) campagnaDao.findAll();
	}

	@Override
	@Transactional
	public Campagna findOneCampagna(Long idCampagna) {
		return campagnaDao.findById(idCampagna).orElse(null);
	}

	@Override
	@Transactional
	public void deleteCampagna(Long idCampagna) {
		campagnaDao.deleteById(idCampagna);
	}
	

	//ESTADO CAMPAÑAS
	@Override
	@Transactional
	public List <EstadoCampagna> findAllEstados() {
		return (List <EstadoCampagna>) estadoCampagnaDao.findAll();
	}

	@Override
	@Transactional
	public void saveEstado(EstadoCampagna estadoCampagna) {
		estadoCampagnaDao.save(estadoCampagna);	
	}
	
	@Override
	@Transactional
	public EstadoCampagna findOneEstadoCampagna(Long idEstadoCampagna) {
		return estadoCampagnaDao.findById(idEstadoCampagna).orElse(null);
	}

	@Override
	@Transactional
	public void deleteEstadoCampagna(Long idEstadoCampagna) {
		estadoCampagnaDao.deleteById(idEstadoCampagna);
	}

	//FRANQUICIAS
	
	@Override
	@Transactional
	public void saveFranquicia(Franquicia franquicia) {
		franquiciaDao.save(franquicia);
	}

	@Override
	@Transactional
	public List<Franquicia> findAllFranquicias() {
		return (List<Franquicia>) franquiciaDao.findAll();
	}

	@Override
	@Transactional
	public Franquicia findOneFranquicia(Long idFranquicia) {
		return franquiciaDao.findById(idFranquicia).orElse(null);
	}

	@Override
	@Transactional
	public void deleteFranquicia(Long idFranquicia) {
		franquiciaDao.deleteById(idFranquicia);
	}
	
	
	//TIENDAS
	
	@Override
	@Transactional
	public void saveTienda(Tienda tienda) {
		tiendaDao.save(tienda);
	}

	@Override
	@Transactional
	public List<Tienda> findAllTiendas() {
		return (List<Tienda>) tiendaDao.findAll();
	}

	@Override
	@Transactional
	public Tienda findOneTienda(Long idTienda) {
		return tiendaDao.findById(idTienda).orElse(null);
	}

	@Override
	@Transactional
	public void deleteTienda(Long idTienda) {
		tiendaDao.deleteById(idTienda);
	}
	
	//FORMADORES
	
	@Override
	@Transactional
	public List<Formador> findAllFormadores() {
		return (List<Formador>) formadorDao.findAll();
		}

	@Override
	@Transactional
	public void saveFormador(Formador formador) {
		formadorDao.save(formador);
		
	}

	@Override
	@Transactional
	public Formador findOneFormador(Long idFormador) {
		return formadorDao.findById(idFormador).orElse(null);
				}
	
	//FORMACIONES
	
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
	
	
	//INCIDENCIAS TIENDA
	
	@Override
	@Transactional
	public List<Incidencia> findAllIncidencias() {
		return (List<Incidencia>) incidenciaDao.findAll();
	}
	
	@Override
	@Transactional
	public Incidencia findOneIncidencia(Long idIncidencia) {
		return incidenciaDao.findById(idIncidencia).orElse(null);
	}
	
	@Override
	@Transactional
	public void saveIncidencia(Incidencia incidencia) {
		incidenciaDao.save(incidencia);
	}
	
	@Override
	@Transactional
	public void deleteIncidencia(Long idIncidencia) {
		Incidencia incidencia = incidenciaDao.findById(idIncidencia).orElse(null);
		incidenciaDao.delete(incidencia);
	}
	
	//VISITAS

	@Override
	@Transactional
	public List<Visita> findAllVisitas() {
		return (List<Visita>) visitaDao.findAll();
	}

	@Override
	@Transactional
	public Visita findOneVisitaId(Long idVisita) {
		return visitaDao.findById(idVisita).orElse(null);
	}

	@Override
	@Transactional
	public void saveVisita(Visita visita) {
		visitaDao.save(visita);
	}

	@Override
	@Transactional
	public void deleteVisita(Long idVisita) {
		visitaDao.deleteById(idVisita);	
	}
	
	//PROVINCIAS
	
		@Override
		@Transactional
		public List<Provincia> findAllProvincias() {
			return (List<Provincia>) provinciaDao.findAll();
		}

		@Override
		public Provincia findOneProvincia(Long idProvincia) {
			return provinciaDao.findById(idProvincia).orElse(null);
		}
		
		@Override
		@Transactional
		public void saveProvincia(Provincia provincia) {
			provinciaDao.save(provincia);
		}
		
		//LOCALIDADES
		
		@Override
		@Transactional
		public List<Localidad> findAllLocalidades() {
			return (List<Localidad>) localidadDao.findAll();
		}

}
