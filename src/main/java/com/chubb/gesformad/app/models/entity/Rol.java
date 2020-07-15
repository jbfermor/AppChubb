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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "rol")
public class Rol implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5112968859064338877L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_rol")
	private Long idRol;
	
	@Column(name = "tipo_rol")
	private String tipoRol;
	
	//FOREIGN
	
	@OneToMany (mappedBy = "rol", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List <Formador> formadores;
	
	@OneToMany (mappedBy = "rol", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List <Admin> administradores;
	
	//CONSTRUCTORES
	
	public Rol() {}

	public Rol(Long idRol, String tipoRol) {
		super();
		this.idRol = idRol;
		this.tipoRol = tipoRol;
	}
	
	//SETTER,GETTERS

	public Long getIdRol() {
		return idRol;
	}

	public void setIdRol(Long idRol) {
		this.idRol = idRol;
	}

	public String getTipoRol() {
		return tipoRol;
	}

	public void setTipoRol(String tipoRol) {
		this.tipoRol = tipoRol;
	}

	public List<Formador> getFormadores() {
		return formadores;
	}

	public void setFormadores(List<Formador> formadores) {
		this.formadores = formadores;
	}
	

	
	
	

}
