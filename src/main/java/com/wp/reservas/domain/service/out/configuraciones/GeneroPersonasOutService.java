package com.wp.reservas.domain.service.out.configuraciones;

import com.wp.reservas.domain.models.dto.configuraciones.GeneroPersonaDto;

import java.util.List;

public interface GeneroPersonasOutService {
    boolean existeGeneroPersona(Integer id);

    List<GeneroPersonaDto> obtenerGeneros();

}
