package com.wp.reservas.domain.service.in.usuarios;

import com.wp.reservas.domain.models.dto.UsuarioDto;
import com.wp.reservas.domain.models.request.UsuarioRegistroRequest;

public interface UsuarioInService {
    UsuarioDto registrarse(UsuarioRegistroRequest usuarioDto) throws IllegalAccessException;
}
