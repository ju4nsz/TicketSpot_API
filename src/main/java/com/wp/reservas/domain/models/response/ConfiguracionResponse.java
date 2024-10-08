package com.wp.reservas.domain.models.response;

import com.wp.reservas.domain.models.dto.configuraciones.GeneroPersonaDto;
import com.wp.reservas.domain.models.dto.configuraciones.MensajeDto;
import com.wp.reservas.domain.models.dto.peliculas.GeneroPeliculaDto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class ConfiguracionResponse {

    private List<MensajeDto> mensajesBienvenida;
    private List<GeneroPersonaDto> generosPersonas;
    private List<GeneroPeliculaDto> generosPeliculas;
    private Integer edadMinima;

}
