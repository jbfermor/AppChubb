package com.chubb.gesformad.app.models.entity;

public class TiendaElegida {
	
	private Long idTienda;
	
	private String nombreTienda;
	
	public TiendaElegida() {}

	public TiendaElegida(Long idTienda, String nombreTienda) {
		this.idTienda = idTienda;
		this.nombreTienda = nombreTienda;
	}

	public Long getIdTienda() {
		return idTienda;
	}

	public void setIdTienda(Long idTienda) {
		this.idTienda = idTienda;
	}

	public String getNombreTienda() {
		return nombreTienda;
	}

	public void setNombreTienda(String nombreTienda) {
		this.nombreTienda = nombreTienda;
	}
	
	

}
