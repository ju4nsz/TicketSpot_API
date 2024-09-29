package com.wp.reservas.persistence.mapper.configuraciones;

import com.wp.reservas.domain.models.dto.configuraciones.GeneroPersonaDto;
import com.wp.reservas.persistence.entity.configuraciones.GeneroPersonaEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GeneroPersonaMapper {

    GeneroPersonaDto toGeneroPersonaDto(GeneroPersonaEntity entity);

}
