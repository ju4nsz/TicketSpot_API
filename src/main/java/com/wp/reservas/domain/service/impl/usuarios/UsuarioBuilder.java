package com.wp.reservas.domain.service.impl.usuarios;

import com.wp.reservas.domain.models.dto.usuarios.UsuarioFotoDto;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UsuarioBuilder {
    public static UsuarioFotoDto construirDtoFoto(Integer idUsuario, String hash, String ruta){
        return UsuarioFotoDto.builder()
                .idUsuario(idUsuario)
                .activo(true)
                .hashFoto(hash)
                .rutaFoto(ruta)
                .build();
    }
}
