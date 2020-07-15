package com.chubb.gesformad.app.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="zona")
public class Zona implements Serializable {
	
	//Variables
	private static final long serialVersionUID = 1519432522076080761L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_zona")
	private Long idZona;
	
	@Column(name = "nombre_zona")
	private String nombreZona;
	
	//FOREIGN
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_proveedor")
	private Proveedor proveedor;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "nif_formador")
	private Formador formadores;
	
	//Constructores
	public Zona() {}
	
	public Zona(Long idZona, String nombreZona) {
		this.idZona = idZona;
		this.nombreZona = nombreZona;
	}


	//Getters y setters
	public Long getIdZona() {
		return idZona;
	}

	public void setIdZona(Long idZona) {
		this.idZona = idZona;
	}

	public String getNombreZona() {
		return nombreZona;
	}

	public void setNombreZona(String nombreZona) {
		this.nombreZona = nombreZona;
	}
		
	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
		
		
	}

	public Formador getFormadores() {
		return formadores;
	}

	public void setFormadores(Formador formadores) {
		this.formadores = formadores;
	}

	//ToString
	@Override
	public String toString() {
		return "Zona [idZona=" + idZona + ", nombreZona=" + nombreZona + "]";
	}
	
	
	
	
}
