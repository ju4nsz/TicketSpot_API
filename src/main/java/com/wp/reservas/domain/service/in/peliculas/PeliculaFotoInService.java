package com.wp.reservas.domain.service.in.peliculas;

import com.wp.reservas.domain.models.request.peliculas.PeliculaFotoRequest;
import com.wp.reservas.domain.models.response.GenericResponse;

public interface PeliculaFotoInService {

    GenericResponse subir(PeliculaFotoRequest request);
}
