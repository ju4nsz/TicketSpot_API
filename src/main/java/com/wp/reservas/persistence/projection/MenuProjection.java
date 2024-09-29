package com.wp.reservas.persistence.projection;

/**
 * Projection for {@link com.wp.reservas.persistence.entity.configuraciones.MenuEntity}
 */
public interface MenuProjection {
    Integer getId();

    Integer getIdPadre();

    String getRuta();

    String getNombre();

    String getIcono();
}