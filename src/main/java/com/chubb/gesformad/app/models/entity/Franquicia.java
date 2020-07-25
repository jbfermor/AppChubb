package com.chubb.gesformad.app.models.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "franquicia")
public class Franquicia {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_franquicia")
	private Long idFranquicia;
	
	@Column(name="nombre_franquicia")
	private String nombreFranquicia;
	
	//FOREIGN
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name="id_cliente", nullable = false)
	private Cliente cliente;
	
	@OneToMany(mappedBy = "franquicia", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List <Tienda> tiendas;
	
	//CONSTRUCTORES
	public Franquicia() {}

	public Franquicia(Long idFranquicia, String nombreFranquicia) {
		this.idFranquicia = idFranquicia;
		this.nombreFranquicia = nombreFranquicia;
	}

	//GETTER Y SETTERS

	public Long getIdFranquicia() {
		return idFranquicia;
	}

	public void setIdFranquicia(Long idFranquicia) {
		this.idFranquicia = idFranquicia;
	}

	public String getNombreFranquicia() {
		return nombreFranquicia;
	}

	public void setNombreFranquicia(String nombreFranquicia) {
		this.nombreFranquicia = nombreFranquicia;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
}
