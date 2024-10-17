package com.wp.reservas.domain.service.out.peliculas;

import com.wp.reservas.domain.models.dto.peliculas.PeliculaFotoDto;

import java.util.List;

public interface PeliculaFotoOutService {

    Integer obtenerCantidadFotosPorPelicula(Integer idPelicula);

    PeliculaFotoDto guardar(PeliculaFotoDto peliculaFotoDto);

}
