package com.wp.reservas.web.controller.peliculas;

import com.wp.reservas.domain.models.dto.peliculas.PeliculaDto;
import com.wp.reservas.domain.models.request.peliculas.PeliculaRequest;
import com.wp.reservas.domain.service.in.peliculas.PeliculaInService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/peliculas")
public class PeliculaController {

    private final PeliculaInService peliculaInService;

    @PreAuthorize("hasAuthority('pelicula:crear')")
    @PostMapping
    public ResponseEntity<PeliculaDto> crearPelicula(@RequestBody @Valid PeliculaRequest request){
        return ResponseEntity.ok(peliculaInService.crearPelicula(request));
    }

    @PreAuthorize("hasAuthority('pelicula:obtener-peliculas')")
    @GetMapping
    public ResponseEntity<List<PeliculaDto>> obtenerPeliculas(){
        return ResponseEntity.ok(peliculaInService.obtenerPeliculas());
    }

}
