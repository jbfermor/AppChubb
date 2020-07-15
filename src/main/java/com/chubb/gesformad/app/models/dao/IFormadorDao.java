package com.chubb.gesformad.app.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.chubb.gesformad.app.models.entity.Formador;

public interface IFormadorDao extends CrudRepository <Formador, Long> {

	public Formador findFormadorByNifFormador(String nifFormador);
	
}
