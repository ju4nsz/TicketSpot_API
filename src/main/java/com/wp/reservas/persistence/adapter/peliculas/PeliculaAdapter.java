package com.wp.reservas.persistence.adapter.peliculas;

import com.wp.reservas.domain.models.dto.peliculas.PeliculaDto;
import com.wp.reservas.domain.service.out.peliculas.PeliculaOutService;
import com.wp.reservas.persistence.mapper.peliculas.PeliculaMapper;
import com.wp.reservas.persistence.repository.peliculas.PeliculaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.StreamSupport;

@Repository
@RequiredArgsConstructor
public class PeliculaAdapter implements PeliculaOutService {

    private final PeliculaRepository peliculaRepository;
    private final PeliculaMapper peliculaMapper;

    @Override
    public PeliculaDto crearPelicula(PeliculaDto pelicula) {
        return peliculaMapper.toPeliculaDto(peliculaRepository.save(peliculaMapper.toPeliculaEntity(pelicula)));
    }

    @Override
    public boolean existePorNombre(String nombrePelicula) {
        return peliculaRepository.existsByNombre(nombrePelicula);
    }

    @Override
    public List<PeliculaDto> obtenerPeliculas() {
        return StreamSupport.stream(peliculaRepository.findAll().spliterator(), false)
                .map(peliculaMapper::toPeliculaDto)
                .toList();
    }
}
