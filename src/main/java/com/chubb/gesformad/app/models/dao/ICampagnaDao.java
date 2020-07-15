package com.chubb.gesformad.app.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.chubb.gesformad.app.models.entity.Campagna;

public interface ICampagnaDao extends CrudRepository <Campagna, Long> {

	
}
