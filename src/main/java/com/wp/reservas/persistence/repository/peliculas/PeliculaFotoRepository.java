package com.wp.reservas.persistence.repository.peliculas;

import com.wp.reservas.persistence.entity.peliculas.PeliculaFotoEntity;
import org.springframework.data.repository.CrudRepository;

public interface PeliculaFotoRepository extends CrudRepository<PeliculaFotoEntity, Integer> {

    Integer countByIdPelicula(Integer idPelicula);

}
