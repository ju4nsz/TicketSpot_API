package com.wp.reservas.domain.service.out.peliculas;

import com.wp.reservas.domain.models.dto.peliculas.GeneroPeliculaDto;

public interface GeneroPeliculaOutService {

    GeneroPeliculaDto obtenerGeneroPelicula(Integer idGeneroPelicula);

    boolean existeById(Integer idGeneroPelicula);

}
