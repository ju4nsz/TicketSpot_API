package com.wp.reservas.domain.models.request.peliculas;

import com.wp.reservas.domain.models.dto.peliculas.GeneroPeliculaDto;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PeliculaRequest {

    private Integer id;

    @NotEmpty(message = "¡Lo sentimos! No puedes crear una película sin nombre :/")
    @Size(min = 3, max = 25, message = "¡Ups! El nombre de la película debe tener entre 3 y 25 carácteres :)")
    private String nombre;

    @Size(min = 10, max = 255, message = "¡Ups! La descripción debe tener entre 10 y 255 carácteres :/")
    private String descripcion;

    @NotNull(message = "¡Espera un momento! La película necesita tener una edad mínima para poder verla :)")
    private Integer edadMinima;

    private List<Integer> generos;

}
