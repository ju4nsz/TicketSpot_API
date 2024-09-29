package com.wp.reservas.persistence.repository.peliculas;

import com.wp.reservas.persistence.entity.peliculas.GeneroPeliculaEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface GeneroPeliculaRepository extends CrudRepository<GeneroPeliculaEntity, Integer> {

    Optional<GeneroPeliculaEntity> findByActivo(boolean activo);

}
