package com.chubb.gesformad.app.models.entity;

public class FormacionElegida {
	
	private Long idFormacion;
	
	private String nombreFormacion;
	
	public FormacionElegida() {}
	
	
	public FormacionElegida(Long idFormacion, String nombreFormacion) {
		this.idFormacion = idFormacion;
		this.nombreFormacion = nombreFormacion;
	}


	public Long getIdFormacion() {
		return idFormacion;
	}

	public void setIdFormacion(Long idFormacion) {
		this.idFormacion = idFormacion;
	}

	public String getNombreFormacion() {
		return nombreFormacion;
	}

	public void setNombreFormacion(String nombreFormacion) {
		this.nombreFormacion = nombreFormacion;
	}
	
	
}
