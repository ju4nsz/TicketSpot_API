package com.wp.reservas.persistence.repository.configuraciones;

import com.wp.reservas.persistence.entity.configuraciones.ParametroEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ParametroRepository extends CrudRepository<ParametroEntity, Integer> {

    Optional<ParametroEntity> findByClave(String clave);

}
