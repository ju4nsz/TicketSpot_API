package com.wp.reservas.persistence.repository.usuarios;

import com.wp.reservas.persistence.entity.usuarios.UsuarioEntity;
import com.wp.reservas.persistence.projection.UsuarioDatosProjection;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UsuarioRepository extends CrudRepository<UsuarioEntity, Integer> {

    Optional<UsuarioEntity> findByCorreoElectronico(String correoElectronico);

    Optional<UsuarioEntity> findByUsuario(String usuario);

    @Query(value = "SELECT u.usuario AS usuario, u.contrasenia AS contrasenia, u.id_rol AS idRol, u.nombre1, u.nombre2, u.apellido1, u.apellido2, u.correo_electronico AS correoElectronico FROM public.usuarios u WHERE u.usuario = :usuario", nativeQuery = true)
    Optional<UsuarioDatosProjection> obtenerDatosUsuario(@Param("usuario") String usuario);

    boolean existsByUsuarioOrCorreoElectronico(String usuario, String correoElectronico);

}
