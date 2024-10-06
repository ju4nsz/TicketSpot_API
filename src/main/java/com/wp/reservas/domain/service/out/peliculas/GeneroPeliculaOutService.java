package com.wp.reservas.domain.service.out.peliculas;

import com.wp.reservas.domain.models.dto.peliculas.GeneroPeliculaDto;

import java.util.List;

public interface GeneroPeliculaOutService {

    GeneroPeliculaDto obtenerGeneroPelicula(Integer idGeneroPelicula);

    boolean existeById(Integer idGeneroPelicula);

    List<GeneroPeliculaDto> obtenerGeneros(List<Integer> ids);

}
