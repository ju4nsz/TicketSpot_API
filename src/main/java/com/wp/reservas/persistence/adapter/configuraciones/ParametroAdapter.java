package com.wp.reservas.persistence.adapter.configuraciones;

import com.wp.reservas.domain.models.dto.configuraciones.ParametroDto;
import com.wp.reservas.domain.service.out.configuraciones.ParametroOutService;
import com.wp.reservas.persistence.mapper.configuraciones.ParametroMapper;
import com.wp.reservas.persistence.repository.configuraciones.ParametroRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ParametroAdapter implements ParametroOutService {

    private final ParametroRepository parametroRepository;
    private final ParametroMapper parametroMapper;

    @Override
    public ParametroDto obtenerParametro(String clave) {
        return parametroRepository.findByClave(clave)
                .map(parametroMapper::toParametroDto)
                .orElseThrow(() -> new EntityNotFoundException("No se encontró el parámetro con la clave ingresada :/"));
    }
}
