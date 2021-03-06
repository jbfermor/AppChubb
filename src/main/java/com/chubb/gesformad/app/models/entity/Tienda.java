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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name = "tienda")
public class Tienda implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -361306756532750881L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_tienda")
	private Long idTienda;
	
	@Column(name = "nombre_tienda")
	private String nombreTienda;
	
	@Column(name = "codigo_tienda")
	private String codigoTienda;
	
	@Column(name = "direccion_tienda")
	private String direccionTienda;
	
	@Column(name = "cp_tienda")
	private int cpTienda;	
	
	@Column(name = "tel_tienda")
	private int telTienda;
	
	@Column(name = "mail_tienda")
	private String mailTienda;
	
	
	//FOREIGN
	
	@OneToMany(mappedBy = "tienda", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List <Visita> visitas;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name="id_zona", nullable = false)
	private Zona zona;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name="id_provincia", nullable = false)
	private Provincia provincia;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name="id_localidad", nullable = false)
	private Localidad localidad;
		
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "id_franquicia", nullable = false)
	private Franquicia franquicia;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "id_cliente", nullable = false)
	private Cliente cliente;
	
	@ManyToMany(mappedBy = "tiendaComercial")
	private List <Comercial> comercialTienda;
	
		
	//CONSTRUCTORES
	
	public Tienda() {}


	public Tienda(Long idTienda, String nombreTienda, String codigoTienda, String direccionTienda, int cpTienda,
			int telTienda, String mailTienda, List<Visita> visitas, Zona zona, Provincia provincia, Localidad localidad,
			Franquicia franquicia, Cliente cliente, List<Comercial> comercialTienda) {
		this.idTienda = idTienda;
		this.nombreTienda = nombreTienda;
		this.codigoTienda = codigoTienda;
		this.direccionTienda = direccionTienda;
		this.cpTienda = cpTienda;
		this.telTienda = telTienda;
		this.mailTienda = mailTienda;
		this.visitas = visitas;
		this.zona = zona;
		this.provincia = provincia;
		this.localidad = localidad;
		this.franquicia = franquicia;
		this.cliente = cliente;
		this.comercialTienda = comercialTienda;
	}

//GETTERS Y SETTERS
	
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


	public String getCodigoTienda() {
		return codigoTienda;
	}


	public void setCodigoTienda(String codigoTienda) {
		this.codigoTienda = codigoTienda;
	}


	public String getDireccionTienda() {
		return direccionTienda;
	}


	public void setDireccionTienda(String direccionTienda) {
		this.direccionTienda = direccionTienda;
	}


	public int getCpTienda() {
		return cpTienda;
	}


	public void setCpTienda(int cpTienda) {
		this.cpTienda = cpTienda;
	}


	public int getTelTienda() {
		return telTienda;
	}


	public void setTelTienda(int telTienda) {
		this.telTienda = telTienda;
	}


	public String getMailTienda() {
		return mailTienda;
	}


	public void setMailTienda(String mailTienda) {
		this.mailTienda = mailTienda;
	}


	public List<Visita> getVisitas() {
		return visitas;
	}


	public void setVisitas(List<Visita> visitas) {
		this.visitas = visitas;
	}


	public Zona getZona() {
		return zona;
	}


	public void setZona(Zona zona) {
		this.zona = zona;
	}


	public Provincia getProvincia() {
		return provincia;
	}


	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}


	public Localidad getLocalidad() {
		return localidad;
	}


	public void setLocalidad(Localidad localidad) {
		this.localidad = localidad;
	}


	public Franquicia getFranquicia() {
		return franquicia;
	}


	public void setFranquicia(Franquicia franquicia) {
		this.franquicia = franquicia;
	}


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public List<Comercial> getComercialTienda() {
		return comercialTienda;
	}


	public void setComercialTienda(List<Comercial> comercialTienda) {
		this.comercialTienda = comercialTienda;
	}

	


}
