package com.wp.reservas.persistence.adapter.configuraciones;

import com.wp.reservas.domain.service.out.configuraciones.GeneroPersonasOutService;
import com.wp.reservas.persistence.repository.configuraciones.GeneroPersonasRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class GeneroPersonaAdapter implements GeneroPersonasOutService {

    private final GeneroPersonasRepository generoPersonasRepository;

    @Override
    public boolean existeGeneroPersona(Integer id) {
        return generoPersonasRepository.existsById(id);
    }
}
