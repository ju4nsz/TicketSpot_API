package com.wp.reservas.domain.service.out.configuraciones;

import com.wp.reservas.domain.models.dto.configuraciones.MensajeDto;

import java.util.List;

public interface MensajeOutService {

    List<MensajeDto> obtenerMensajesBienvenida(Integer idTipoBienvenida);

}
