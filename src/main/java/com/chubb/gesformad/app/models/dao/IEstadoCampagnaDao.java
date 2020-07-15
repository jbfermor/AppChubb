package com.chubb.gesformad.app.models.dao;

import org.springframework.data.repository.CrudRepository;
import com.chubb.gesformad.app.models.entity.EstadoCampagna;

public interface IEstadoCampagnaDao extends CrudRepository<EstadoCampagna, Long> {

	
}
