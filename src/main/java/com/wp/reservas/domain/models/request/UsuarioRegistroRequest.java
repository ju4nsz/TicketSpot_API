package com.wp.reservas.domain.models.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class UsuarioRegistroRequest {

    private Integer id;

    @Email
    @NotEmpty
    @NotBlank
    private String correoElectronico;

    @Size
    @NotEmpty
    @NotBlank
    private String contrasenia;

    @NotEmpty
    @NotBlank
    private String usuario;

    @NotEmpty
    @NotBlank
    private String nombre1;

    private String nombre2;

    @NotEmpty
    @NotBlank
    private String apellido1;

    private String apellido2;

    private Date fechaNacimiento;

    private Integer edad;

    private Integer idGenero;

    private Integer idRol;

}
