package com.wp.reservas.persistence.mapper.configuraciones;

import com.wp.reservas.domain.models.dto.configuraciones.MenuDto;
import com.wp.reservas.persistence.projection.MenuProjection;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MenuMapper {

    MenuDto toMenuDto(MenuProjection menuProjection);

}
