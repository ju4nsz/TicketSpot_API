package com.wp.reservas.domain.service.in.peliculas;

import com.wp.reservas.domain.models.dto.peliculas.PeliculaDto;

import java.util.List;

public interface PeliculaInService {

    PeliculaDto crearPelicula(PeliculaDto peliculaDto);

    List<PeliculaDto> obtenerPeliculas();

}
