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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "formador")
public class Formador implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 926726324961886162L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_Formador")
	private Long idFormador;
	
	@Column(name = "nif_formador")
	private String nifFormador;
	
	@Column(name = "pass_formador")
	private String passFormador;
	
	@Column(name = "nombre_formador")
	private String nombreFormador;
	
	@Column(name = "ap1_formador")
	private String ap1Formador;
	
	@Column(name = "ap2_formador")
	private String ap2Formador;
	
	@Column(name = "direccion_formador")
	private String direccionFormador;
	
	@Column(name = "cp_formador")
	private int cpFormador;
	
	@Column(name = "localidad_formador")
	private String localidadFormador;
	
	@Column(name = "provincia_formador")
	private String provinciaFormador;
	
	@Column(name = "tel1_formador")
	private String tel1Formador;
	
	@Column(name = "tel2_formador")
	private String tel2Formador;
	
	@Column(name = "mail1_formador")
	private String mail1Formador;
	
	@Column(name = "mail2_formador")
	private String mail2Formador;
	
	@Column(name = "cuenta_Bancaria_Formador")
	private String cuentaBancariaFormador;
	
	//FOREIGN
	
	@OneToMany(mappedBy = "formador" , fetch = FetchType.LAZY, cascade = CascadeType.ALL )
	private List <Visita> visitas;
	
	@OneToMany (mappedBy = "formadores", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List <Zona> zonas;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "id_rol")
	Rol rol;
	
	@ManyToMany (mappedBy = "formadores")
	private List <Formacion> formaciones;
	
	@ManyToMany (mappedBy = "formadores")
	private List <Comercial> comerciales;
	
	@ManyToMany (fetch = FetchType.LAZY,  cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(
			name = "formadores_proveedores",
			joinColumns = @JoinColumn(name = "id_formador"),
			inverseJoinColumns = @JoinColumn(name = "id_proveedor"))
	private List <Proveedor> proveedores;
	
	
	//CONSTRUCTORES
	
	public Formador() {}

	public Formador(Long idFormador, String nifFormador, String passFormador, String nombreFormador, String ap1Formador,
			String ap2Formador, String direccionFormador, int cpFormador, String localidadFormador,
			String provinciaFormador, String tel1Formador, String tel2Formador, String mail1Formador,
			String mail2Formador, String cuentaBancariaFormador, List<Visita> visitas, List<Zona> zonas, Rol rol,
			List<Formacion> formaciones, List<Comercial> comerciales, List<Proveedor> proveedores) {
		this.idFormador = idFormador;
		this.nifFormador = nifFormador;
		this.passFormador = passFormador;
		this.nombreFormador = nombreFormador;
		this.ap1Formador = ap1Formador;
		this.ap2Formador = ap2Formador;
		this.direccionFormador = direccionFormador;
		this.cpFormador = cpFormador;
		this.localidadFormador = localidadFormador;
		this.provinciaFormador = provinciaFormador;
		this.tel1Formador = tel1Formador;
		this.tel2Formador = tel2Formador;
		this.mail1Formador = mail1Formador;
		this.mail2Formador = mail2Formador;
		this.cuentaBancariaFormador = cuentaBancariaFormador;
		this.visitas = visitas;
		this.zonas = zonas;
		this.rol = rol;
		this.formaciones = formaciones;
		this.comerciales = comerciales;
		this.proveedores = proveedores;
	}



	//GETTERS, SETTERS
	
	public Long getIdFormador() {
		return idFormador;
	}

	public void setIdFormador(Long idFormador) {
		this.idFormador = idFormador;
	}

	public String getNifFormador() {
		return nifFormador;
	}


	public void setNifFormador(String nifFormador) {
		this.nifFormador = nifFormador;
	}


	public String getPassFormador() {
		return passFormador;
	}


	public void setPassFormador(String passFormador) {
		this.passFormador = passFormador;
	}


	public String getNombreFormador() {
		return nombreFormador;
	}


	public void setNombreFormador(String nombreFormador) {
		this.nombreFormador = nombreFormador;
	}


	public String getAp1Formador() {
		return ap1Formador;
	}


	public void setAp1Formador(String ap1Formador) {
		this.ap1Formador = ap1Formador;
	}


	public String getAp2Formador() {
		return ap2Formador;
	}


	public void setAp2Formador(String ap2Formador) {
		this.ap2Formador = ap2Formador;
	}


	public String getDireccionFormador() {
		return direccionFormador;
	}


	public void setDireccionFormador(String direccionFormador) {
		this.direccionFormador = direccionFormador;
	}


	public int getCpFormador() {
		return cpFormador;
	}


	public void setCpFormador(int cpFormador) {
		this.cpFormador = cpFormador;
	}


	public String getLocalidadFormador() {
		return localidadFormador;
	}


	public void setLocalidadFormador(String localidadFormador) {
		this.localidadFormador = localidadFormador;
	}


	public String getProvinciaFormador() {
		return provinciaFormador;
	}


	public void setProvinciaFormador(String provinciaFormador) {
		this.provinciaFormador = provinciaFormador;
	}


	public String getTel1Formador() {
		return tel1Formador;
	}


	public void setTel1Formador(String tel1Formador) {
		this.tel1Formador = tel1Formador;
	}


	public String getTel2Formador() {
		return tel2Formador;
	}


	public void setTel2Formador(String tel2Formador) {
		this.tel2Formador = tel2Formador;
	}


	public String getMail1Formador() {
		return mail1Formador;
	}


	public void setMail1Formador(String mail1Formador) {
		this.mail1Formador = mail1Formador;
	}


	public String getMail2Formador() {
		return mail2Formador;
	}


	public void setMail2Formador(String mail2Formador) {
		this.mail2Formador = mail2Formador;
	}


	public List<Visita> getVisitas() {
		return visitas;
	}


	public void setVisitas(List<Visita> visitas) {
		this.visitas = visitas;
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


	public String getCuentaBancariaFormador() {
		return cuentaBancariaFormador;
	}


	public void setCuentaBancariaFormador(String cuentaBancariaFormador) {
		this.cuentaBancariaFormador = cuentaBancariaFormador;
	}


	public List<Zona> getZonas() {
		return zonas;
	}


	public void setZonas(List<Zona> zonas) {
		this.zonas = zonas;
	}


	public Rol getRol() {
		return rol;
	}


	public void setRol(Rol rol) {
		this.rol = rol;
	}


	public List<Proveedor> getProveedores() {
		return proveedores;
	}


	public void setProveedores(List<Proveedor> proveedores) {
		this.proveedores = proveedores;
	}
	
	
	
	
	
}
