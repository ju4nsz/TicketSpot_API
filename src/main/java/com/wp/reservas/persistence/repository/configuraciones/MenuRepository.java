package com.wp.reservas.persistence.repository.configuraciones;

import com.wp.reservas.persistence.entity.configuraciones.MenuEntity;
import com.wp.reservas.persistence.projection.MenuProjection;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MenuRepository extends CrudRepository<MenuEntity, Integer> {

    @Query(value = """
        SELECT m.id AS id, m.id_padre, m.ruta, m.nombre, m.icono
        FROM menu m
    	JOIN roles_permisos rp ON rp.id_permiso = m.id_permiso
    	JOIN roles r ON r.id = rp.id_rol
        WHERE r.id = :idRol
    """, nativeQuery = true)
    List<MenuProjection> obtenerMenuByIdRol(@Param("idRol") Integer idRol);

}