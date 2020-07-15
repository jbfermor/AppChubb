package com.chubb.gesformad.app.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.chubb.gesformad.app.models.entity.Formacion;

public interface IFormacionDao extends CrudRepository <Formacion, Long> {

}
