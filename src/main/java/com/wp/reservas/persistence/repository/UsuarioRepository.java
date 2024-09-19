package com.wp.reservas.persistence.repository;

import com.wp.reservas.persistence.entity.UsuarioEntity;
import com.wp.reservas.persistence.projection.UsuarioDatosProjection;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UsuarioRepository extends CrudRepository<UsuarioEntity, Integer> {

    Optional<UsuarioEntity> findByCorreoElectronico(String correoElectronico);

    Optional<UsuarioEntity> findByUsuario(String usuario);

    @Query(value = "SELECT u.usuario AS usuario, u.contrasenia AS contrasenia, u.id_rol AS idRol FROM public.usuarios u WHERE u.usuario = :usuario", nativeQuery = true)
    Optional<UsuarioDatosProjection> obtenerDatosUsuario(@Param("usuario") String usuario);

    Optional<UsuarioEntity> findByUsuarioOrCorreoElectronico(String usuario, String correoElectronico);

}
