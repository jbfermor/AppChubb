package com.chubb.gesformad.app.models.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "localidad")
public class Localidad {
	
	@Id
	@Column(name = "id_localidad")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idLocalidad;
	
	@Column(name = "nombre_localidad")
	private String nombreLocalidad;
	
	//FOREIGN
	@ManyToOne(fetch = FetchType.LAZY,  optional = false)
	private Provincia provincia;
	
	@OneToMany(mappedBy = "localidad" , fetch = FetchType.LAZY, cascade = CascadeType.ALL )
	private List <Formador> formadores;
	
	@OneToMany(mappedBy = "localidad" , fetch = FetchType.LAZY, cascade = CascadeType.ALL )
	private List <Tienda> tiendas;
	
	@OneToMany(mappedBy = "localidad" , fetch = FetchType.LAZY, cascade = CascadeType.ALL )
	private List <Visita> visitas;

	
	//CONSTRUCTORES
	public Localidad () {}

	public Localidad(Long idLocalidad, String nombreLocalidad, Provincia provincia, List<Formador> formadores,
			List<Tienda> tiendas, List<Visita> visitas) {
		this.idLocalidad = idLocalidad;
		this.nombreLocalidad = nombreLocalidad;
		this.provincia = provincia;
		this.formadores = formadores;
		this.tiendas = tiendas;
		this.visitas = visitas;
	}

	public Localidad(String nombreLocalidad, Provincia provincia) {
		this.nombreLocalidad = nombreLocalidad;
		this.provincia = provincia;
	}
	

	//GETTERS Y SETTERS

	

	public Long getIdLocalidad() {
		return idLocalidad;
	}

	public void setIdLocalidad(Long idLocalidad) {
		this.idLocalidad = idLocalidad;
	}

	public String getNombreLocalidad() {
		return nombreLocalidad;
	}

	public void setNombreLocalidad(String nombreLocalidad) {
		this.nombreLocalidad = nombreLocalidad;
	}

	public Provincia getProvincia() {
		return provincia;
	}

	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
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

	public List<Visita> getVisitas() {
		return visitas;
	}

	public void setVisitas(List<Visita> visitas) {
		this.visitas = visitas;
	}

	
}
