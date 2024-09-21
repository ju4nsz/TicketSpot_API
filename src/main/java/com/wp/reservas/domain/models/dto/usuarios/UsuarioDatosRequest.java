package com.wp.reservas.domain.models.dto.usuarios;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioDatosRequest {

    private String usuario;
    private String contrasenia;
    private Integer idRol;
    private String nombre1;
    private String nombre2;
    private String apellido1;
    private String apellido2;
    private String correoElectronico;

}
