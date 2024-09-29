package com.wp.reservas.domain.service.impl.autenticacion;

import com.wp.reservas.domain.models.dto.configuraciones.MenuDto;
import com.wp.reservas.domain.models.dto.usuarios.UsuarioDatosRequest;
import com.wp.reservas.domain.models.response.AutenticacionResponse;
import com.wp.reservas.domain.models.response.UsuarioDatosResponse;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AutenticacionBuilder {

    public static AutenticacionResponse construirAuthResponse(String jwt, UsuarioDatosRequest request, List<String> permisos, List<MenuDto> menuOpciones){
        return AutenticacionResponse.builder()
                .accessToken(jwt)
                .usuarioDatosResponse(UsuarioDatosResponse.builder()
                        .nombre1(request.getNombre1())
                        .nombre2(request.getNombre2())
                        .apellido1(request.getApellido2())
                        .apellido2(request.getApellido2())
                        .correoElectronico(request.getCorreoElectronico())
                        .usuario(request.getUsuario())
                        .permisos(permisos)
                        .build())
                .menuOpciones(menuOpciones)
                .build();
    }

}
