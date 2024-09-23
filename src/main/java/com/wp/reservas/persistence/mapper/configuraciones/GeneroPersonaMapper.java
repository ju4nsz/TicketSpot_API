package com.wp.reservas.persistence.mapper.configuraciones;

import com.wp.reservas.domain.models.dto.configuraciones.GeneroPersonaDto;
import com.wp.reservas.persistence.entity.configuraciones.GeneroPersonasEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GeneroPersonaMapper {

    GeneroPersonaDto toGeneroPersonaDto(GeneroPersonasEntity entity);

}
