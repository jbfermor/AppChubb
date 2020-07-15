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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "formacion")
public class Formacion implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8488898302300489065L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_formacion")
	private Long idFormacion;
	
	@Column(name = "nombre_formacion")
	private String nombreFormacion;
	
	//FOREIGN
	
	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "id_proveedor", nullable = true)
	private Proveedor proveedor;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "id_campagna", nullable = false)
	private Campagna campagna;
	
	@ManyToMany(mappedBy = "formaciones")
	private List <Comercial> comerciales;
	
	@ManyToMany ( cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(
			name = "formador_formacion",
			joinColumns = @JoinColumn(name = "id_formacion"),
			inverseJoinColumns = @JoinColumn(name = "nif_formador"))
	private List <Formador> formadores;
	
	//CONSTRUCTORES
	
	public Formacion() {}

	public Formacion(Long idFormacion, String nombreFormacion) {
		this.idFormacion = idFormacion;
		this.nombreFormacion = nombreFormacion;
	}

	
	//GETTERS, SETTERS
	
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

	public Campagna getCampagna() {
		return campagna;
	}

	public void setCampagna(Campagna campagna) {
		this.campagna = campagna;
	}

	public List<Comercial> getComerciales() {
		return comerciales;
	}

	public void setComerciales(List<Comercial> comerciales) {
		this.comerciales = comerciales;
	}

	public List<Formador> getFormadores() {
		return formadores;
	}

	public void setFormadores(List<Formador> formadores) {
		this.formadores = formadores;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}



}
