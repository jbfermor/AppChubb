package com.chubb.gesformad.app.models.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "comercial")
public class Comercial implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6592037181020244361L;
	
	@Id
	@Column(name = "id_comercial")
	private String idComercial;
	
	@Column(name = "nombre_comercial")
	private String nombreComercial;
	
	@Column(name = "estado_comercial")
	private Boolean estadoComercial;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
			  name = "tienda_Comercial",
			  joinColumns = @JoinColumn(name = "id_comercial"), 
			  inverseJoinColumns = @JoinColumn(name = "id_tienda"))
	private List <Tienda> tiendaComercial;
	
	@ManyToMany ( cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(
			name = "formacion_comercial",
			joinColumns = @JoinColumn(name = "id_comercial"),
			inverseJoinColumns = @JoinColumn(name = "id_formacion"))
	private List <Formacion> formaciones;
	
	@ManyToMany ( cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(
			name = "formador_comercial",
			joinColumns = @JoinColumn(name = "id_comercial"),
			inverseJoinColumns = @JoinColumn(name = "nif_formador"))
	private List <Formador> formadores;
	
	
	@ManyToMany (mappedBy = "comerciales")
	private List <Visita> visitas;
}


