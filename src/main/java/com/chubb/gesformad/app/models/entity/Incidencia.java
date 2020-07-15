package com.chubb.gesformad.app.models.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "incidencia")
public class Incidencia implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8799795350064055960L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_incidencia")
	private Long idIncidencia;
	
	@Column(name = "nombre_incidencia")
	private String nombreIncidencia;
	
	//FOREIGN
	
	@ManyToMany(mappedBy = "incidenciasVisita", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List <Visita> visitaIncidencia;
	
	//CONSTRUCTORES
	
	public Incidencia () {}
	
	public Incidencia(Long idIncidencia, String nombreIncidencia) {
		this.idIncidencia = idIncidencia;
		this.nombreIncidencia = nombreIncidencia;
	}

	public Long getIdIncidencia() {
		return idIncidencia;
	}

	public void setIdIncidencia(Long idIncidencia) {
		this.idIncidencia = idIncidencia;
	}

	public String getNombreIncidencia() {
		return nombreIncidencia;
	}

	public void setNombreIncidencia(String nombreIncidencia) {
		this.nombreIncidencia = nombreIncidencia;
	}

	public List<Visita> getVisitaIncidencia() {
		return visitaIncidencia;
	}

	public void setVisitaIncidencia(List<Visita> visitaIncidencia) {
		this.visitaIncidencia = visitaIncidencia;
	}
	
	//GETTER, SETTER
	
	

}
