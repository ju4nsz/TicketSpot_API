package com.wp.reservas.persistence.repository.peliculas;

import com.wp.reservas.persistence.entity.peliculas.PeliculaEntity;
import org.springframework.data.repository.CrudRepository;

public interface PeliculaRepository extends CrudRepository<PeliculaEntity, Integer> {

    boolean existsByNombre(String nombre);

}