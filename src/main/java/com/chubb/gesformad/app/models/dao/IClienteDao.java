package com.chubb.gesformad.app.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.chubb.gesformad.app.models.entity.Cliente;

public interface IClienteDao extends CrudRepository <Cliente, Long> {
	

}
