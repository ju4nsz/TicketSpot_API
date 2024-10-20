package com.wp.reservas.domain.models.dto.usuarios;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UsuarioFotoDto {
    private Integer id;
    private Integer idUsuario;
    private String rutaFoto;
    private String hashFoto;
    private boolean activo;
}
