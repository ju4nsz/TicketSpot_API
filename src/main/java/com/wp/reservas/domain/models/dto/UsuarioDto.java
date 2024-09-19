package com.wp.reservas.domain.models.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;

import java.io.Serializable;
import java.util.Date;

/**
 * DTO for {@link com.wp.reservas.persistence.entity.UsuarioEntity}
 */
@Getter
@Setter
public class UsuarioDto implements Serializable {

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