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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "visita")
public class Visita implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4802624288327463440L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idVisita;
	
	@Column(name = "fecha_prev_visita")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date fechaPrevVisita;
	
	@Column(name = "hora_prev_visita")
	@Temporal(TemporalType.TIME)
	@DateTimeFormat(pattern = "h:mm a")
	private Date horaPrevVisita;
	
	@Column(name = "fecha_visita")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date fechaVisita;
	
	@Column(name = "hora_inicio_visita")
	@Temporal(TemporalType.TIME)
	@DateTimeFormat(pattern = "h:mm a")
	private Date horaInicioVisita;
	
	@Column(name = "hora_fin_visita")
	@Temporal(TemporalType.TIME)
	@DateTimeFormat(pattern = "h:mm a")
	private Date horaFinVisita;
	
	@Column(name = "num_comerciales_formados_visita")
	private int numComercialesFormados;
	
	@Column(name = "observaciones_visita")
	private String observacionesVisita;
	
	
	// FOREIGN
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "id_tienda")
	private Tienda tienda;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "id_formador")
	private Formador formador;
	
	@ManyToMany (cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(
			name = "visita_formacion",
			joinColumns = @JoinColumn(name = "id_visita"), 
			inverseJoinColumns = @JoinColumn(name = "id_formacion"))
	private List <Formacion> formaciones;
	
	@ManyToMany (cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(
			name = "visita_comercial",
			joinColumns = @JoinColumn(name = "id_visita"), 
			inverseJoinColumns = @JoinColumn(name = "id_comercial"))
	private List <Comercial> comerciales;
	
	@ManyToMany (cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(
			name = "visita_incidencia",
			joinColumns = @JoinColumn(name = "id_visita"), 
			inverseJoinColumns = @JoinColumn(name = "id_incidencia"))
	private List <Incidencia> incidenciasVisita;
	
}
