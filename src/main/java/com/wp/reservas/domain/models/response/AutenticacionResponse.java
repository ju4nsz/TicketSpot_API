package com.wp.reservas.domain.models.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class AutenticacionResponse {

    private String accessToken;
    private UsuarioDatosResponse usuarioDatosResponse;

}
