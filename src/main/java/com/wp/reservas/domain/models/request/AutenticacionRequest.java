package com.wp.reservas.domain.models.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AutenticacionRequest {

    @NotEmpty(message = "No puedes iniciar sesión sin proporcionarnos tu usuario :/")
    @Size(max = 15, message = "El usuario debe tener máximo 15 carácteres.")
    private String usuario;

    @NotEmpty(message = "No podemos validar tu información sin tu contraseña :(")
    @Size(max = 20, message = "La contraseña debe tener máximo 20 caracteres.")
    private String contrasenia;

}
