package com.wp.reservas.domain.service.impl.peliculas;

import com.wp.reservas.domain.models.dto.peliculas.PeliculaDto;
import com.wp.reservas.domain.models.exceptions.HttpGenericException;
import com.wp.reservas.domain.service.in.peliculas.PeliculaInService;
import com.wp.reservas.domain.service.out.peliculas.GeneroPeliculaOutService;
import com.wp.reservas.domain.service.out.peliculas.PeliculaOutService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class PeliculaServiceImpl implements PeliculaInService {

    private final PeliculaOutService peliculaOutService;
    private final GeneroPeliculaOutService generoPeliculaOutService;


    @Override
    public PeliculaDto crearPelicula(PeliculaDto peliculaDto) {

        log.info("Verificando que exista el género de película {}...", peliculaDto.getIdGenero());
        if (!generoPeliculaOutService.existeById(peliculaDto.getIdGenero())){
            throw new HttpGenericException(HttpStatus.NOT_FOUND, "¡Ups! El género que ha intentado ingresar no coincide con nuestros datos :/");
        }

        log.info("Verificando que la película {} no exista...", peliculaDto.getNombre());
        if (peliculaOutService.existePorNombre(peliculaDto.getNombre())){
            throw new HttpGenericException(HttpStatus.BAD_REQUEST, "¡Ups! Ya hay una película con ese nombre :/");
        }

        log.info("Creando la película {} con género {}...", peliculaDto.getNombre(), peliculaDto.getIdGenero());
        return peliculaOutService.crearPelicula(peliculaDto);
    }

    @Override
    public List<PeliculaDto> obtenerPeliculas() {
        return peliculaOutService.obtenerPeliculas();
    }
}
