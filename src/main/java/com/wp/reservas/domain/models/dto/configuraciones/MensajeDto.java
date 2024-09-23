package com.wp.reservas.domain.models.dto.configuraciones;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MensajeDto {

    private Integer id;
    private String clave;
    private String valor;
    private String descripcion;
    private Integer idTipoMensaje;

}
