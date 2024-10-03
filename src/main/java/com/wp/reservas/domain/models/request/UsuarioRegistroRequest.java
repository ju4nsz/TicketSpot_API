package com.wp.reservas.domain.models.request;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class UsuarioRegistroRequest {

    @Null
    private Integer id;

    @Size(max = 50, message = "Tu correo electrónico no debe contener más de 50 cáracteres :/")
    @Email(message = "El correo electrónico debe ser un email válido, revísalo por favor :)")
    @NotBlank(message = "No puedes registrarte sin correo electrónico, revísalo por favor :/")
    private String correoElectronico;

    @NotEmpty(message = "No puedes registrarte sin una contraseña para ingresar la próxima vez, revísalo por favor :/")
    private String contrasenia;

    @Size(min = 5, max = 15, message = "Tu usuario debe contener entre 5 y 15 cáracteres :/")
    @NotBlank(message = "No puedes registrarte sin un nombre que te identifique, revísalo por favor :/")
    private String usuario;

    @Size(min = 3, max = 15, message = "Tu nombre debe contener entre 3 y 15 cáracteres :/")
    @Pattern(regexp = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$", message = "El apellido no puede contener números o caracteres especiales :/")
    @NotBlank(message = "Necesitamos saber tu nombre para hablarte con más confianza :)")
    private String nombre1;

    @Size(min = 3, max = 15, message = "Tu nombre debe contener entre 3 y 15 cáracteres :/")
    @Pattern(regexp = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$", message = "El apellido no puede contener números o caracteres especiales :/")
    private String nombre2;

    @Size(min = 3, max = 15, message = "Tu nombre debe contener entre 3 y 15 cáracteres :/")
    @Pattern(regexp = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$", message = "El apellido no puede contener números o caracteres especiales :/")
    @NotBlank(message = "Necesitamos saber tu nombre completo para hablarte con más confianza :)")
    private String apellido1;

    @Size(min = 3, max = 15, message = "Tu nombre debe contener entre 3 y 15 cáracteres :/")
    @Pattern(regexp = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$", message = "El apellido no puede contener números o caracteres especiales :/")
    private String apellido2;


    @Past(message = "No logramos validar tu fecha de nacimiento :(")
    @NotNull(message = "Necesitamos saber tu edad para completar el registro :/")
    private LocalDate fechaNacimiento;

    @Null
    private Integer edad;

    @NotNull(message = "Necesitamos saber tu género para completar tu información :/")
    private Integer idGenero;

    @Null
    private Integer idRol;

}
