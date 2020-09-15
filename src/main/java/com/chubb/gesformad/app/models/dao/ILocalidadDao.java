package com.chubb.gesformad.app.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chubb.gesformad.app.models.entity.Localidad;

public interface ILocalidadDao extends JpaRepository <Localidad, Long> {
	
}
