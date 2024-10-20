package com.wp.reservas.persistence.mapper.usuarios;

import com.wp.reservas.domain.models.dto.usuarios.UsuarioFotoDto;
import com.wp.reservas.persistence.entity.usuarios.UsuarioFotoEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsuarioFotoMapper {

    UsuarioFotoDto toDto(UsuarioFotoEntity usuarioFotoEntity);
    UsuarioFotoEntity toEntity(UsuarioFotoDto usuarioFotoDto);

}
