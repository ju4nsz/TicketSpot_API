package com.wp.reservas.domain.service.out;

import com.wp.reservas.domain.models.dto.UsuarioDatosRequest;
import com.wp.reservas.domain.models.dto.UsuarioDto;
import com.wp.reservas.domain.models.request.UsuarioRegistroRequest;

public interface UsuarioOutService {

    UsuarioDto obtenerUsuario(String usuario);
    UsuarioDto obtenerUsuarioByCorreoElectronico(String correoElectronico);

    UsuarioDatosRequest obtenerDatosUsuario(String usuario);

    boolean existeUsuario(String usuario, String correoElectronico);

    UsuarioDto guardarUsuario(UsuarioRegistroRequest usuarioRegistroRequest);
}
