package com.wp.reservas.persistence.adapter.configuraciones;

import com.wp.reservas.domain.models.dto.configuraciones.GeneroPersonaDto;
import com.wp.reservas.domain.service.out.configuraciones.GeneroPersonasOutService;
import com.wp.reservas.persistence.mapper.configuraciones.GeneroPersonaMapper;
import com.wp.reservas.persistence.repository.configuraciones.GeneroPersonasRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@Repository
@RequiredArgsConstructor
public class GeneroPersonaAdapter implements GeneroPersonasOutService {

    private final GeneroPersonasRepository generoPersonasRepository;
    private final GeneroPersonaMapper generoPersonaMapper;

    @Override
    public boolean existeGeneroPersona(Integer id) {
        return generoPersonasRepository.existsById(id);
    }

    @Override
    public List<GeneroPersonaDto> obtenerGeneros() {
        return StreamSupport.stream(generoPersonasRepository.findAll().spliterator(), false)
                .map(generoPersonaMapper::toGeneroPersonaDto)
                .toList();
    }
}
