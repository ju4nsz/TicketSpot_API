package com.wp.reservas.domain.models.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.wp.reservas.persistence.entity.UsuarioEntity}
 */
@Value
public class UsuarioDto implements Serializable {

    Integer id;

    @Email
    @NotEmpty
    @NotBlank
    String correoElectronico;

    @Size
    @NotEmpty
    @NotBlank
    String contrasenia;

    @NotEmpty
    @NotBlank
    String usuario;

    @NotEmpty
    @NotBlank
    String nombre1;

    String nombre2;

    @NotEmpty
    @NotBlank
    String apellido1;

    String apellido2;
}