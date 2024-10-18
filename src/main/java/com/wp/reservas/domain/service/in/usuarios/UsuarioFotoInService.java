package com.wp.reservas.domain.service.in.usuarios;

import com.wp.reservas.domain.models.request.usuarios.UsuarioFotoRequest;
import com.wp.reservas.domain.models.response.GenericResponse;

public interface UsuarioFotoInService {

    GenericResponse subir(UsuarioFotoRequest request);

}
