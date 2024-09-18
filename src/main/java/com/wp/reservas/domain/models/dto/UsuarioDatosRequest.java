package com.wp.reservas.domain.models.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioDatosRequest {

    private String usuario;
    private String contrasenia;
    private Integer idRol;

}
