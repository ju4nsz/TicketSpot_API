package com.wp.reservas.persistence.repository.peliculas;

import com.wp.reservas.persistence.entity.peliculas.PeliculaEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PeliculaRepository extends JpaRepository<PeliculaEntity, Integer> {

    boolean existsByNombre(String nombre);


}