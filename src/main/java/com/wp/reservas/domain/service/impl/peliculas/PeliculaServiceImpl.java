package com.wp.reservas.domain.service.impl.peliculas;

import com.wp.reservas.domain.models.dto.peliculas.GeneroPeliculaDto;
import com.wp.reservas.domain.models.dto.peliculas.PeliculaDto;
import com.wp.reservas.domain.models.exceptions.HttpGenericException;
import com.wp.reservas.domain.models.request.peliculas.PeliculaRequest;
import com.wp.reservas.domain.service.in.peliculas.PeliculaInService;
import com.wp.reservas.domain.service.out.peliculas.GeneroPeliculaOutService;
import com.wp.reservas.domain.service.out.peliculas.PeliculaOutService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class PeliculaServiceImpl implements PeliculaInService {

    private final PeliculaOutService peliculaOutService;
    private final GeneroPeliculaOutService generoPeliculaOutService;

    /**
     * Servicio para crear una película
     * @param request request de película con las ids de géneros a añadir
     * @return Se retorna el DTO de la película con sus géneros.
     */
    @Override
    public PeliculaDto crearPelicula(PeliculaRequest request) {

        log.info("Obteniendo los géneros recibidos...");
        List<GeneroPeliculaDto> generosPeliculas = generoPeliculaOutService.obtenerGenerosPorIds(request.getGeneros());
        if (generosPeliculas.size() != request.getGeneros().size()){
            log.error("Se ha intentado ingresar un género que no existe...");
            throw new HttpGenericException(HttpStatus.NOT_FOUND, "¡Ups! Has intentado ingresar un género que no tenemos :/");
        }

        log.info("Verificando que la película {} no exista...", request.getNombre());
        if (peliculaOutService.existePorNombre(request.getNombre())){
            throw new HttpGenericException(HttpStatus.BAD_REQUEST, "¡Ups! Ya hay una película con ese nombre :/");
        }

        return peliculaOutService.crearPelicula(PeliculaDto.builder()
                        .id(request.getId())
                        .nombre(request.getNombre())
                        .edadMinima(request.getEdadMinima())
                        .descripcion(request.getDescripcion())
                        .generos(generosPeliculas)
                .build());
    }

    @Override
    public Page<PeliculaDto> obtenerPeliculas(Pageable pageable) {


        return peliculaOutService.obtenerPeliculas(pageable);
    }
}
