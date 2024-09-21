package com.wp.reservas.domain.service.out.configuraciones;

import com.wp.reservas.domain.models.dto.configuraciones.ParametroDto;

public interface ParametroOutService {

    ParametroDto obtenerParametro(String clave);

}