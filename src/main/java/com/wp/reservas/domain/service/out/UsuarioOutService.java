package com.wp.reservas.domain.service.out;

import com.wp.reservas.domain.models.dto.UsuarioDatosRequest;
import com.wp.reservas.domain.models.dto.UsuarioDto;

public interface UsuarioOutService {

    UsuarioDto obtenerUsuario(String usuario);
    UsuarioDto obtenerUsuarioByCorreoElectronico(String correoElectronico);

    UsuarioDatosRequest obtenerDatosUsuario(String usuario);

}
