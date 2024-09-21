package com.wp.reservas.persistence.mapper.configuraciones;

import com.wp.reservas.domain.models.dto.configuraciones.ParametroDto;
import com.wp.reservas.persistence.entity.configuraciones.ParametroEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ParametroMapper {

    @Mapping(target = "valorConvertido", ignore = true)
    ParametroDto toParametroDto(ParametroEntity parametroEntity);

}
