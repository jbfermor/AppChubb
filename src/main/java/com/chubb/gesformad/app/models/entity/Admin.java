package com.chubb.gesformad.app.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "admin")
public class Admin implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7345710824694321334L;
	
	@Id
	@Column(name = "nif_admin")
	private String nifAdmin;
	
	@Column(name = "pass_admin")
	private String passAdmin;
	
	@Column(name = "nombre_admin")
	private String nombreAdmin;
	
	@Column(name = "telAdmin")
	private String telAdmin;
	
	@Column(name = "mail_admin")
	private String mailAdmin;
	
	//FOREIGN
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "id_rol")
	Rol rol;
	
	//CONSTRUCTORES
	
	public Admin() {}

	public Admin(String nifAdmin, String passAdmin, String nombreAdmin, String telAdmin, String mailAdmin) {
		this.nifAdmin = nifAdmin;
		this.passAdmin = passAdmin;
		this.nombreAdmin = nombreAdmin;
		this.telAdmin = telAdmin;
		this.mailAdmin = mailAdmin;
	}
	
	
	//SETTERS Y GETTERS

	public String getNifAdmin() {
		return nifAdmin;
	}

	public void setNifAdmin(String nifAdmin) {
		this.nifAdmin = nifAdmin;
	}

	public String getPassAdmin() {
		return passAdmin;
	}

	public void setPassAdmin(String passAdmin) {
		this.passAdmin = passAdmin;
	}

	public String getNombreAdmin() {
		return nombreAdmin;
	}

	public void setNombreAdmin(String nombreAdmin) {
		this.nombreAdmin = nombreAdmin;
	}

	public String getTelAdmin() {
		return telAdmin;
	}

	public void setTelAdmin(String telAdmin) {
		this.telAdmin = telAdmin;
	}

	public String getMailAdmin() {
		return mailAdmin;
	}

	public void setMailAdmin(String mailAdmin) {
		this.mailAdmin = mailAdmin;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}
	
	

	
}
