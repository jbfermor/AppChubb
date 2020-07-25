package com.chubb.gesformad.app.models.entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="campagna")
public class Campagna implements Serializable {
	
	//Variables
	private static final long serialVersionUID = 1519432522076080761L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_campaña")
	private Long idCampagna;
	
	@Column(name = "nombre_campaña")
	private String nombreCampagna;
	
	@Column(name = "d_inicio_campaña")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dInicioCampagna;
	
	@Column(name = "d_fin_campaña")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dFinCampagna;
	
	//FOREIGN
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name="id_cliente", nullable = false)
	private Cliente cliente;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name="id_estado_campagna", nullable = false)
	private EstadoCampagna estadoCampagna;
	
	@OneToMany(mappedBy = "campagna", fetch = FetchType.LAZY, cascade = CascadeType.ALL )
	private List <Formacion> formaciones;
	
	//Constructores
	public Campagna() {}

	public Campagna(Long idCampagna, String nombreCampagna, Date dInicioCampagna, Date dFinCampagna) {
		this.idCampagna = idCampagna;
		this.nombreCampagna = nombreCampagna;
		this.dInicioCampagna = dInicioCampagna;
		this.dFinCampagna = dFinCampagna;
	}


	//Setters y getters
	
	public Long getIdCampagna() {
		return idCampagna;
	}

	public void setIdCampagna(Long idCampagna) {
		this.idCampagna = idCampagna;
	}

	public String getNombreCampagna() {
		return nombreCampagna;
	}

	public void setNombreCampagna(String nombreCampagna) {
		this.nombreCampagna = nombreCampagna;
	}

	public Date getdInicioCampagna() {
		return dInicioCampagna;
	}

	public void setdInicioCampagna(Date dInicioCampagna) {
		this.dInicioCampagna = dInicioCampagna;
	}

	public Date getdFinCampagna() {
		return dFinCampagna;
	}

	public void setdFinCampagna(Date dFinCampagna) {
		this.dFinCampagna = dFinCampagna;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public EstadoCampagna getEstadoCampagna() {
		return estadoCampagna;
	}

	public void setEstadoCampagna(EstadoCampagna estadoCampagna) {
		this.estadoCampagna = estadoCampagna;
	}
	
	
}
