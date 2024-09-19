package com.wp.reservas.domain.service.in.autenticacion;

import com.wp.reservas.domain.models.request.AutenticacionRequest;
import com.wp.reservas.domain.models.response.AutenticacionResponse;

public interface AutenticacionInService {

    AutenticacionResponse iniciarSesion(AutenticacionRequest autenticacionRequest);

}
