package com.wp.reservas.domain.models.dto.usuarios;

import com.wp.reservas.persistence.entity.usuarios.UsuarioEntity;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

/**
 * DTO for {@link UsuarioEntity}
 */
@Getter
@Setter
public class UsuarioDto implements Serializable {

    private Integer id;

    @Email(message = "El correo electrónico debe ser un email válido, revísalo por favor :)")
    @NotEmpty(message = "No puedes registrarte sin correo electrónico, revísalo por favor :/")
    @NotBlank(message = "No puedes registrarte sin correo electrónico, revísalo por favor :/")
    private String correoElectronico;

    @NotEmpty(message = "No puedes registrarte sin un nombre que te identifique, revísalo por favor :/")
    @NotBlank(message = "No puedes registrarte sin un nombre que te identifique, revísalo por favor :/")
    private String usuario;

    @NotEmpty(message = "Necesitamos saber tu nombre para hablarte con más confianza :)")
    @NotBlank(message = "Necesitamos saber tu nombre para hablarte con más confianza :)")
    private String nombre1;

    private String nombre2;

    @NotEmpty(message = "Necesitamos saber tu nombre completo para hablarte con más confianza :)")
    @NotBlank(message = "Necesitamos saber tu nombre completo para hablarte con más confianza :)")
    private String apellido1;

    private String apellido2;

    @NotEmpty(message = "Necesitamos saber tu edad para completar el registro :/")
    @NotBlank(message = "Necesitamos saber tu edad para completar el registro :/")
    private LocalDate fechaNacimiento;

    private Integer edad;

    private Integer idGenero;

    private Integer idRol;

}