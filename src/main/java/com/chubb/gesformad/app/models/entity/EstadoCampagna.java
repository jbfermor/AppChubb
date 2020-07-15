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
@Table(name="estado_campaña")
public class EstadoCampagna implements Serializable {
	
	//Variables

	private static final long serialVersionUID = 286233743506537538L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_estado_campaña")
	private Long idEstadoCampagna;
	
	@Column(name = "nombre_estado_campaña")
	private String nombreEstadoCampagna;
	
	@OneToMany (mappedBy = "estadoCampagna", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List <Campagna> campagnas;
	
	//CONSTRUCTORES
	
	public EstadoCampagna() {}

	public EstadoCampagna(Long idEstadoCampagna, String nombreEstadoCampagna) {
		this.idEstadoCampagna = idEstadoCampagna;
		this.nombreEstadoCampagna = nombreEstadoCampagna;
	}

	//SETTER Y GETTERS

	public Long getIdEstadoCampagna() {
		return idEstadoCampagna;
	}

	public void setIdEstadoCampagna(Long idEstadoCampagna) {
		this.idEstadoCampagna = idEstadoCampagna;
	}

	public String getNombreEstadoCampagna() {
		return nombreEstadoCampagna;
	}

	public void setNombreEstadoCampagna(String nombreEstadoCampagna) {
		this.nombreEstadoCampagna = nombreEstadoCampagna;
	}

	public List<Campagna> getCampagnas() {
		return campagnas;
	}

	public void setCampagnas(List<Campagna> campagnas) {
		this.campagnas = campagnas;
	}
	
	
}
