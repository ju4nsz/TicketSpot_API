package com.wp.reservas.domain.models.response;

import com.wp.reservas.domain.models.dto.configuraciones.MenuDto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class AutenticacionResponse {

    private String accessToken;
    private UsuarioDatosResponse usuarioDatosResponse;
    private List<MenuDto> menuOpciones;

}
