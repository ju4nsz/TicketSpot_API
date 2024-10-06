package com.wp.reservas.domain.service.in.peliculas;

import com.wp.reservas.domain.models.dto.peliculas.PeliculaDto;
import com.wp.reservas.domain.models.request.peliculas.PeliculaRequest;

import java.util.List;

public interface PeliculaInService {

    PeliculaDto crearPelicula(PeliculaRequest request);

    List<PeliculaDto> obtenerPeliculas();

}
