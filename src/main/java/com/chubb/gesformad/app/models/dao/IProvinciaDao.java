package com.chubb.gesformad.app.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.chubb.gesformad.app.models.entity.Campagna;
import com.chubb.gesformad.app.models.entity.Provincia;

public interface IProvinciaDao extends CrudRepository <Provincia, Long> {

	
}
