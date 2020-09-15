package com.chubb.gesformad.app.models.entity;

public class LocalidadElegida {
	
	private Long idLocalidad;
	private String nombreLocalidad;
	
	public LocalidadElegida() {}	
	
	public LocalidadElegida(Long idLocalidad, String nombreLocalidad) {
		this.idLocalidad = idLocalidad;
		this.nombreLocalidad = nombreLocalidad;
	}

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
	
	

}
