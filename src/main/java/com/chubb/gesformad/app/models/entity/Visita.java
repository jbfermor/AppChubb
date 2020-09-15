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
	@Column(name = "id_visita")
	private Long idVisita;
	
	@Column(name = "fecha_estimada_visita")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date fechaEstimadaVisita;
	
	@Column(name = "hora_inicio_estimada_visita")
	@Temporal(TemporalType.TIME)
	@DateTimeFormat(pattern = "h:mm a")
	private Date horaInicioEstimadaVisita;
	
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
	
	@Column(name = "tiempo_visita")
	@Temporal(TemporalType.TIME)
	@DateTimeFormat(pattern = "h:mm a")
	private Date tiempoVisita;
	
	@Column(name = "num_comerciales_formados_visita")
	private int numComercialesFormados;
	
	@Column(name = "num_comerciales_formacion_1")
	private int numComercialesFormacion1;
	
	@Column(name = "num_comerciales_formacion_2")
	private int numComercialesFormacion2;
	
	@Column(name = "num_comerciales_formacion_3")
	private int numComercialesFormacion3;
	
	@Column(name = "num_comerciales_formacion_4")
	private int numComercialesFormacion4;
	
	@Column(name = "num_comerciales_formacion_5")
	private int numComercialesFormacion5;
	
	@Column(name = "observaciones_visita")
	private String observacionesVisita;
	
	
	// FOREIGN
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "id_cliente")
	private Cliente cliente;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "id_tienda")
	private Tienda tienda;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "id_formador")
	private Formador formador;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "id_provincia")
	private Provincia provincia;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "id_localidad")
	private Localidad localidad;
	
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
	
	//CONSTRUCTORES

	public Visita() {}
	
	public Visita(Long idVisita, Date fechaEstimadaVisita, Date horaInicioEstimadaVisita, Date fechaVisita,
			Date horaInicioVisita, Date horaFinVisita, Date tiempoVisita, int numComercialesFormados,
			int numComercialesFormacion1, int numComercialesFormacion2, int numComercialesFormacion3,
			int numComercialesFormacion4, int numComercialesFormacion5, String observacionesVisita, Cliente cliente,
			Tienda tienda, Formador formador, List<Formacion> formaciones, List<Comercial> comerciales,
			List<Incidencia> incidenciasVisita) {
		this.idVisita = idVisita;
		this.fechaEstimadaVisita = fechaEstimadaVisita;
		this.horaInicioEstimadaVisita = horaInicioEstimadaVisita;
		this.fechaVisita = fechaVisita;
		this.horaInicioVisita = horaInicioVisita;
		this.horaFinVisita = horaFinVisita;
		this.tiempoVisita = tiempoVisita;
		this.numComercialesFormados = numComercialesFormados;
		this.numComercialesFormacion1 = numComercialesFormacion1;
		this.numComercialesFormacion2 = numComercialesFormacion2;
		this.numComercialesFormacion3 = numComercialesFormacion3;
		this.numComercialesFormacion4 = numComercialesFormacion4;
		this.numComercialesFormacion5 = numComercialesFormacion5;
		this.observacionesVisita = observacionesVisita;
		this.cliente = cliente;
		this.tienda = tienda;
		this.formador = formador;
		this.formaciones = formaciones;
		this.comerciales = comerciales;
		this.incidenciasVisita = incidenciasVisita;
	}



	//SETTER Y GETTERS

	public Long getIdVisita() {
		return idVisita;
	}

	public void setIdVisita(Long idVisita) {
		this.idVisita = idVisita;
	}

	public Date getFechaEstimadaVisita() {
		return fechaEstimadaVisita;
	}

	public void setFechaEstimadaVisita(Date fechaEstimadaVisita) {
		this.fechaEstimadaVisita = fechaEstimadaVisita;
	}

	public Date getHoraInicioEstimadaVisita() {
		return horaInicioEstimadaVisita;
	}

	public void setHoraInicioEstimadaVisita(Date horaInicioEstimadaVisita) {
		this.horaInicioEstimadaVisita = horaInicioEstimadaVisita;
	}

	public Date getFechaVisita() {
		return fechaVisita;
	}

	public void setFechaVisita(Date fechaVisita) {
		this.fechaVisita = fechaVisita;
	}

	public Date getHoraInicioVisita() {
		return horaInicioVisita;
	}

	public void setHoraInicioVisita(Date horaInicioVisita) {
		this.horaInicioVisita = horaInicioVisita;
	}

	public Date getHoraFinVisita() {
		return horaFinVisita;
	}

	public void setHoraFinVisita(Date horaFinVisita) {
		this.horaFinVisita = horaFinVisita;
	}

	public Date getTiempoVisita() {
		return tiempoVisita;
	}

	public void setTiempoVisita(Date tiempoVisita) {
		this.tiempoVisita = tiempoVisita;
	}

	public int getNumComercialesFormados() {
		return numComercialesFormados;
	}

	public void setNumComercialesFormados(int numComercialesFormados) {
		this.numComercialesFormados = numComercialesFormados;
	}

	public int getNumComercialesFormacion1() {
		return numComercialesFormacion1;
	}

	public void setNumComercialesFormacion1(int numComercialesFormacion1) {
		this.numComercialesFormacion1 = numComercialesFormacion1;
	}

	public int getNumComercialesFormacion2() {
		return numComercialesFormacion2;
	}

	public void setNumComercialesFormacion2(int numComercialesFormacion2) {
		this.numComercialesFormacion2 = numComercialesFormacion2;
	}

	public int getNumComercialesFormacion3() {
		return numComercialesFormacion3;
	}

	public void setNumComercialesFormacion3(int numComercialesFormacion3) {
		this.numComercialesFormacion3 = numComercialesFormacion3;
	}

	public int getNumComercialesFormacion4() {
		return numComercialesFormacion4;
	}

	public void setNumComercialesFormacion4(int numComercialesFormacion4) {
		this.numComercialesFormacion4 = numComercialesFormacion4;
	}

	public int getNumComercialesFormacion5() {
		return numComercialesFormacion5;
	}

	public void setNumComercialesFormacion5(int numComercialesFormacion5) {
		this.numComercialesFormacion5 = numComercialesFormacion5;
	}

	public String getObservacionesVisita() {
		return observacionesVisita;
	}

	public void setObservacionesVisita(String observacionesVisita) {
		this.observacionesVisita = observacionesVisita;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Tienda getTienda() {
		return tienda;
	}

	public void setTienda(Tienda tienda) {
		this.tienda = tienda;
	}

	public Formador getFormador() {
		return formador;
	}

	public void setFormador(Formador formador) {
		this.formador = formador;
	}

	public List<Formacion> getFormaciones() {
		return formaciones;
	}

	public void setFormaciones(List<Formacion> formaciones) {
		this.formaciones = formaciones;
	}

	public List<Comercial> getComerciales() {
		return comerciales;
	}

	public void setComerciales(List<Comercial> comerciales) {
		this.comerciales = comerciales;
	}

	public List<Incidencia> getIncidenciasVisita() {
		return incidenciasVisita;
	}

	public void setIncidenciasVisita(List<Incidencia> incidenciasVisita) {
		this.incidenciasVisita = incidenciasVisita;
	}
	
	
	

	
	
	
}
