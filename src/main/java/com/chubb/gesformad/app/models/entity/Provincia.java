package com.chubb.gesformad.app.models.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "provincia")
public class Provincia {
	
	@Id
	@Column(name = "id_provincia")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idProvincia;
	
	@Column(name = "nombre_provincia")
	private String nombreProvincia;
	
	//FOREIGN
	@OneToMany(mappedBy = "provincia" , fetch = FetchType.LAZY, cascade = CascadeType.ALL )
	private List <Formador> formadores;
	
	@OneToMany(mappedBy = "provincia" , fetch = FetchType.LAZY, cascade = CascadeType.ALL )
	private List <Tienda> tiendas;
	
	
	//CONSTRUCTORES
	public Provincia () {}

	public Provincia(Long idProvincia, String nombreProvincia, List<Formador> formadores, List<Tienda> tiendas) {
		this.idProvincia = idProvincia;
		this.nombreProvincia = nombreProvincia;
		this.formadores = formadores;
		this.tiendas = tiendas;
	}
	
	public Provincia (Long idProvincia, String nombreProvincia) {
		this.idProvincia = idProvincia;
		this.nombreProvincia = nombreProvincia;
	}


	//GETTERS Y SETTERS


	
	public Long getIdProvincia() {
		return idProvincia;
	}

	public void setIdProvincia(Long idProvincia) {
		this.idProvincia = idProvincia;
	}

	public String getNombreProvincia() {
		return nombreProvincia;
	}

	public void setNombreProvincia(String nombreProvincia) {
		this.nombreProvincia = nombreProvincia;
	}

	public List<Formador> getFormadores() {
		return formadores;
	}

	public void setFormadores(List<Formador> formadores) {
		this.formadores = formadores;
	}

	public List<Tienda> getTiendas() {
		return tiendas;
	}

	public void setTiendas(List<Tienda> tiendas) {
		this.tiendas = tiendas;
	}



}
