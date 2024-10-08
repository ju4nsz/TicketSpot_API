package com.wp.reservas.persistence.repository.peliculas;

import com.wp.reservas.persistence.entity.peliculas.GeneroPeliculaEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface GeneroPeliculaRepository extends CrudRepository<GeneroPeliculaEntity, Integer> {

    Optional<GeneroPeliculaEntity> findByActivo(boolean activo);

    List<GeneroPeliculaEntity> findAllByIdInAndActivo(List<Integer> ids, boolean activo);

    List<GeneroPeliculaEntity> findAllByActivo(boolean activo);

}
