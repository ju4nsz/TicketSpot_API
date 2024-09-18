package com.wp.reservas.persistence.repository;

import com.wp.reservas.persistence.entity.RoleEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RolRepository extends CrudRepository<RoleEntity, Integer> {

    @Query(value = """
    SELECT p.permiso FROM public.roles_permisos rp\s
           INNER JOIN public.permisos p ON rp.id_permiso = p.id\s
           WHERE rp.id_rol = :ID_ROL
    """, nativeQuery = true)
    List<String> obtenerPermisosPorIdRol(@Param("ID_ROL") Integer idRol);

}
