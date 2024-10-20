package com.wp.reservas.domain.models.request.usuarios;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
public class UsuarioFotoRequest {

    @NotNull(message = "Por favor, debes enviar el usuario que va a añadir su foto :/")
    private Integer idUsuario;

    @NotNull(message = "Por favor, debes enviar la foto para añadirla :/")
    private MultipartFile foto;
}
