package com.wp.reservas.persistence.adapter.peliculas;

import com.wp.reservas.domain.models.dto.peliculas.GeneroPeliculaDto;
import com.wp.reservas.domain.service.out.peliculas.GeneroPeliculaOutService;
import com.wp.reservas.persistence.mapper.peliculas.GeneroPeliculaMapper;
import com.wp.reservas.persistence.repository.peliculas.GeneroPeliculaRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.StreamSupport;

@Repository
@RequiredArgsConstructor
public class GeneroPeliculaAdapter implements GeneroPeliculaOutService {

    private final GeneroPeliculaRepository generoPeliculaRepository;
    private final GeneroPeliculaMapper generoPeliculaMapper;

    @Override
    public GeneroPeliculaDto obtenerGeneroPelicula(Integer idGeneroPelicula) {
        return generoPeliculaRepository.findByActivo(true)
                .map(generoPeliculaMapper::toGeneroPeliculaDto)
                .orElseThrow(() -> new EntityNotFoundException("¡Ups! El género que ha intentado ingresar no coincide con nuestros datos :/"));
    }

    @Override
    public boolean existeById(Integer idGeneroPelicula) {
        return generoPeliculaRepository.existsById(idGeneroPelicula);
    }

    @Override
    public List<GeneroPeliculaDto> obtenerGeneros(List<Integer> ids){
        return StreamSupport.stream(generoPeliculaRepository.findAllById(ids).spliterator(), false)
                .map(generoPeliculaMapper::toGeneroPeliculaDto)
                .toList();
    }

}
