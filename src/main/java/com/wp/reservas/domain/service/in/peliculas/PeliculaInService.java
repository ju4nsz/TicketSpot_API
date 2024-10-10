package com.wp.reservas.domain.service.in.peliculas;

import com.wp.reservas.domain.models.dto.peliculas.PeliculaDto;
import com.wp.reservas.domain.models.request.peliculas.PeliculaRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PeliculaInService {

    PeliculaDto crearPelicula(PeliculaRequest request);

    Page<PeliculaDto> obtenerPeliculas(Pageable pageable);

}
