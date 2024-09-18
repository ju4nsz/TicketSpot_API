package com.wp.reservas.persistence.mapper;

import com.wp.reservas.domain.models.dto.UsuarioDatosRequest;
import com.wp.reservas.domain.models.dto.UsuarioDto;
import com.wp.reservas.domain.models.response.UsuarioDatosResponse;
import com.wp.reservas.persistence.entity.UsuarioEntity;
import com.wp.reservas.persistence.projection.UsuarioDatosProjection;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    UsuarioDto toUsuarioDto(UsuarioEntity entity);

    UsuarioEntity toUsuarioEntity(UsuarioDto dto);

    UsuarioDatosRequest toUserDatosResponse(UsuarioDatosProjection projection);

}
