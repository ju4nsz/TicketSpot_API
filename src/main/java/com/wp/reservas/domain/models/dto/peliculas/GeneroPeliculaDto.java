package com.wp.reservas.domain.models.dto.peliculas;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.wp.reservas.persistence.entity.peliculas.GeneroPeliculaEntity}
 */
@Value
public class GeneroPeliculaDto implements Serializable {
    Integer id;
    String nombre;
    String descripcion;
    boolean activo;
}