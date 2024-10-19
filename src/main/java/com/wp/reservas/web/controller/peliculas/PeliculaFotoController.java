package com.wp.reservas.web.controller.peliculas;

import com.wp.reservas.domain.models.request.peliculas.PeliculaFotoRequest;
import com.wp.reservas.domain.models.response.GenericResponse;
import com.wp.reservas.domain.service.in.peliculas.PeliculaFotoInService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/pelicula-foto")
@RequiredArgsConstructor
public class PeliculaFotoController {

    private final PeliculaFotoInService peliculaFotoInService;

    @PreAuthorize("hasAuthority('pelicula:subir-foto')")
    @PostMapping
    public ResponseEntity<GenericResponse> subirFotosPelicula(@ModelAttribute @Valid PeliculaFotoRequest request) {
        return ResponseEntity.ok(peliculaFotoInService.subir(request));
    }

}
