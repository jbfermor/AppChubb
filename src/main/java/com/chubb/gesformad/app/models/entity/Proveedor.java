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
@Table(name="proveedor")
public class Proveedor implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7449108292936675354L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_proveedor")
	private Long idProveedor;
	
	@Column(name = "nombre_proveedor")
	private String nombreProveedor;
	
	//FOREIGN KEY
	@OneToMany (mappedBy = "proveedor", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List <Campagna> campagnas;
	
	@OneToMany (mappedBy = "proveedor", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List <Franquicia> franquicias;
	
	@OneToMany (mappedBy = "proveedor", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List <Zona> zonas;
	
	@OneToMany (mappedBy = "proveedor", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List <Tienda> tiendas;
	
	@OneToMany (mappedBy = "proveedor", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List <Formacion> formaciones;
	
	@ManyToMany (mappedBy = "proveedores")
	private List <Formador> formadores;
	
	//CONSTRUCTORES
	
	public Proveedor() {}
	
	public Proveedor(Long idProveedor, String nombreProveedor, List<Campagna> campagnas, List<Franquicia> franquicias,
			List<Zona> zonas, List<Tienda> tiendas, List<Formacion> formaciones, List<Formador> formadores) {

		this.idProveedor = idProveedor;
		this.nombreProveedor = nombreProveedor;
		this.campagnas = campagnas;
		this.franquicias = franquicias;
		this.zonas = zonas;
		this.tiendas = tiendas;
		this.formaciones = formaciones;
		this.formadores = formadores;
	}


	public Proveedor(Long idProveedor, String nombreProveedor) {
		this.idProveedor = idProveedor;
		this.nombreProveedor = nombreProveedor;
	}

	//SETTER Y GETTERS
	public Long getIdProveedor() {
		return idProveedor;
	}

	public void setIdProveedor(Long idProveedor) {
		this.idProveedor = idProveedor;
	}

	public String getNombreProveedor() {
		return nombreProveedor;
	}

	public void setNombreProveedor(String nombreProveedor) {
		this.nombreProveedor = nombreProveedor;
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

	
	
	
}
