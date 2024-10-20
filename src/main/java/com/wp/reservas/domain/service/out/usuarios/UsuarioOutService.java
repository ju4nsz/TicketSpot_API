package com.wp.reservas.domain.service.out.usuarios;

import com.wp.reservas.domain.models.dto.usuarios.UsuarioDatosRequest;
import com.wp.reservas.domain.models.dto.usuarios.UsuarioDto;
import com.wp.reservas.domain.models.request.usuarios.UsuarioRegistroRequest;

public interface UsuarioOutService {

    UsuarioDto obtenerUsuario(String usuario);
    UsuarioDto obtenerUsuarioByCorreoElectronico(String correoElectronico);

    UsuarioDatosRequest obtenerDatosUsuario(String usuario);

    boolean existeUsuario(String usuario, String correoElectronico);

    UsuarioDto guardarUsuario(UsuarioRegistroRequest usuarioRegistroRequest);

    boolean existeUsuario(Integer id);
}
