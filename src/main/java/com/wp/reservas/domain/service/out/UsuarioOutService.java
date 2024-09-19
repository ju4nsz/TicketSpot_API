package com.wp.reservas.domain.service.out;

import com.wp.reservas.domain.models.dto.UsuarioDatosRequest;
import com.wp.reservas.domain.models.dto.UsuarioDto;

public interface UsuarioOutService {

    UsuarioDto obtenerUsuario(String usuario);
    UsuarioDto obtenerUsuarioByCorreoElectronico(String correoElectronico);

    UsuarioDatosRequest obtenerDatosUsuario(String usuario);

    UsuarioDto buscarUsuario(String usuario, String correoElectronico);

    UsuarioDto guardarUsuario(UsuarioDto usuarioDto);
}
