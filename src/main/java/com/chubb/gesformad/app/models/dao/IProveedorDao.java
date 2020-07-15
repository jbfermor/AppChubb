package com.chubb.gesformad.app.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.chubb.gesformad.app.models.entity.Proveedor;

public interface IProveedorDao extends CrudRepository <Proveedor, Long> {
	

}
