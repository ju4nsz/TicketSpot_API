package com.wp.reservas.domain.service.out.peliculas;

import com.wp.reservas.domain.models.dto.peliculas.PeliculaDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PeliculaOutService {

    PeliculaDto crearPelicula(PeliculaDto pelicula);

    boolean existePorNombre(String nombrePelicula);

    Page<PeliculaDto> obtenerPeliculas(Pageable pageable);

    boolean existePorId(Integer id);

}
