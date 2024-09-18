package com.wp.reservas.domain.models.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AutenticacionRequest {

    @NotEmpty(message = "El usuario no puede ser nulo.")
    @Size(max = 30, message = "El usuario debe tener máximo 10 carácteres.")
    private String usuario;

    @NotEmpty(message = "La contraseña no puede ser nula.")
    @Size(max = 20, message = "La contraseña debe tener máximo 20 caracteres.")
    private String contrasenia;

}
