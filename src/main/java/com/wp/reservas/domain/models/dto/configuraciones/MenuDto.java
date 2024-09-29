package com.wp.reservas.domain.models.dto.configuraciones;

import lombok.Getter;
import lombok.Setter;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.wp.reservas.persistence.entity.configuraciones.MenuEntity}
 */
@Getter
@Setter
public class MenuDto implements Serializable {
    Integer id;
    Integer idPadre;
    String ruta;
    String nombre;
    String icono;
}