package com.wp.reservas.domain.models.dto.peliculas;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * DTO for {@link com.wp.reservas.persistence.entity.peliculas.PeliculaEntity}
 */
@Getter
@Setter
@Builder
public class PeliculaDto implements Serializable {

    private Integer id;

    private String nombre;

    private String descripcion;

    private Integer edadMinima;

    private List<GeneroPeliculaDto> generos;

}