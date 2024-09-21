package com.wp.reservas.persistence.mapper.usuarios;

import com.wp.reservas.domain.models.dto.usuarios.UsuarioDatosRequest;
import com.wp.reservas.domain.models.dto.usuarios.UsuarioDto;
import com.wp.reservas.domain.models.request.UsuarioRegistroRequest;
import com.wp.reservas.persistence.entity.usuarios.UsuarioEntity;
import com.wp.reservas.persistence.projection.UsuarioDatosProjection;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    UsuarioDto toUsuarioDto(UsuarioEntity entity);

    UsuarioEntity toUsuarioEntity(UsuarioRegistroRequest request);

    UsuarioEntity toUsuarioEntity(UsuarioDto dto);

    UsuarioDatosRequest toUserDatosResponse(UsuarioDatosProjection projection);

}
