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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="cliente")
public class Cliente implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7449108292936675354L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_cliente")
	private Long idCliente;
	
	@Column(name = "nombre_cliente")
	private String nombreCliente;
	
	//FOREIGN KEY
	@OneToMany (mappedBy = "cliente", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List <Campagna> campagnas;
	
	@OneToMany (mappedBy = "cliente", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List <Franquicia> franquicias;
	
	@OneToMany (mappedBy = "cliente", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List <Zona> zonas;
	
	@OneToMany (mappedBy = "cliente", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List <Tienda> tiendas;
	
	@OneToMany (mappedBy = "cliente", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List <Formacion> formaciones;
	
	@OneToMany (mappedBy = "cliente", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List <Visita> visitas;
	
	@ManyToMany (mappedBy = "clientes")
	private List <Formador> formadores;
	
	//CONSTRUCTORES
	
	public Cliente() {}
	
	public Cliente(Long idCliente, String nombreCliente, List<Campagna> campagnas, List<Franquicia> franquicias,
			List<Zona> zonas, List<Tienda> tiendas, List<Formacion> formaciones, List<Formador> formadores) {

		this.idCliente = idCliente;
		this.nombreCliente = nombreCliente;
		this.campagnas = campagnas;
		this.franquicias = franquicias;
		this.zonas = zonas;
		this.tiendas = tiendas;
		this.formaciones = formaciones;
		this.formadores = formadores;
	}


	public Cliente(Long idCliente, String nombreCliente) {
		this.idCliente = idCliente;
		this.nombreCliente = nombreCliente;
	}

	//SETTER Y GETTERS
	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public List<Campagna> getCampagnas() {
		return campagnas;
	}

	public void setCampagnas(List<Campagna> campagnas) {
		this.campagnas = campagnas;
	}

	public List<Franquicia> getFranquicias() {
		return franquicias;
	}

	public void setFranquicias(List<Franquicia> franquicias) {
		this.franquicias = franquicias;
	}

	public List<Zona> getZonas() {
		return zonas;
	}

	public void setZonas(List<Zona> zonas) {
		this.zonas = zonas;
	}

	public List<Tienda> getTiendas() {
		return tiendas;
	}

	public void setTiendas(List<Tienda> tiendas) {
		this.tiendas = tiendas;
	}

	public List<Formador> getFormadores() {
		return formadores;
	}

	public void setFormadores(List<Formador> formadores) {
		this.formadores = formadores;
	}

	public List<Formacion> getFormaciones() {
		return formaciones;
	}

	public void setFormaciones(List<Formacion> formaciones) {
		this.formaciones = formaciones;
	}

	public List<Visita> getVisitas() {
		return visitas;
	}

	public void setVisitas(List<Visita> visitas) {
		this.visitas = visitas;
	}

	
	
	
}
