package com.wp.reservas.domain.service.impl.peliculas;

import com.wp.reservas.domain.models.dto.peliculas.PeliculaFotoDto;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PeliculaBuilder {

    public static PeliculaFotoDto construirDtoFoto(Integer idPelicula, String hash, String ruta){
        return PeliculaFotoDto.builder()
                .idPelicula(idPelicula)
                .activo(true)
                .hashFoto(hash)
                .rutaFoto(ruta)
                .build();
    }

}
