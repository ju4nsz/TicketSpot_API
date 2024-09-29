package com.wp.reservas.domain.models.dto.peliculas;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * DTO for {@link com.wp.reservas.persistence.entity.peliculas.PeliculaEntity}
 */
@Getter
@Setter
public class PeliculaDto implements Serializable {
    Integer id;

    @NotEmpty(message = "¡Lo sentimos! No puedes crear una película sin nombre :/")
    @Size(min = 3, max = 25, message = "¡Ups! El nombre de la película debe tener entre 3 y 25 carácteres :)")
    String nombre;

    @Size(min = 10, max = 255, message = "¡Ups! La descripción debe tener entre 10 y 255 carácteres :/")
    String descripcion;

    @NotNull(message = "¡Espera un momento! La película necesita tener una edad mínima para poder verla :)")
    Integer edadMinima;

    @NotNull(message = "¡Espera un minuto! Necesitamos que nos digas el género de la película :)")
    Integer idGenero;
}