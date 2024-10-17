package com.wp.reservas.domain.models.dto.peliculas;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class PeliculaFotoDto {

    private Integer id;
    private Integer idPelicula;
    private String rutaFoto;
    private String hashFoto;
    private boolean activo;

}
