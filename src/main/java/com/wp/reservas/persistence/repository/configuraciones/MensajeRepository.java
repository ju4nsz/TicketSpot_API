package com.wp.reservas.persistence.repository.configuraciones;

import com.wp.reservas.persistence.entity.configuraciones.MensajeEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MensajeRepository extends CrudRepository<MensajeEntity, Integer> {

    List<MensajeEntity> findByIdTipoMensaje(Integer idTipoMensaje);

}
