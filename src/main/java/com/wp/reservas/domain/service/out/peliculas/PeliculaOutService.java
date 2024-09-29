package com.wp.reservas.domain.service.out.peliculas;

import com.wp.reservas.domain.models.dto.peliculas.PeliculaDto;

import java.util.List;

public interface PeliculaOutService {

    PeliculaDto crearPelicula(PeliculaDto pelicula);

    boolean existePorNombre(String nombrePelicula);

    List<PeliculaDto> obtenerPeliculas();

}
