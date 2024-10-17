package com.wp.reservas.domain.models.request.peliculas;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Getter
@Setter
public class PeliculaFotoRequest {

    @NotNull(message = "Por favor, debes enviar la película a la que le quieres añadir las fotos :/")
    private Integer idPelicula;

    @NotNull(message = "Por favor, debes enviar por lo menos 1 foto para crear la película :/")
    private List<MultipartFile> fotos;

}
