package com.wp.reservas.domain.models.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@Builder
public class UsuarioDatosResponse {

    private String correoElectronico;
    private String usuario;
    private String nombre1;
    private String nombre2;
    private String apellido1;
    private String apellido2;
    private List<String> permisos;

}
