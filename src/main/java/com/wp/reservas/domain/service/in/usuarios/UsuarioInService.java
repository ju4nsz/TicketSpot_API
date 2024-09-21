package com.wp.reservas.domain.service.in.usuarios;

import com.wp.reservas.domain.models.dto.usuarios.UsuarioDto;
import com.wp.reservas.domain.models.request.UsuarioRegistroRequest;

public interface UsuarioInService {
    UsuarioDto registrarse(UsuarioRegistroRequest usuarioDto);
}
