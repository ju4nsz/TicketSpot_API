package com.wp.reservas.persistence.repository.usuarios;

import com.wp.reservas.persistence.entity.usuarios.UsuarioEntity;
import com.wp.reservas.persistence.entity.usuarios.UsuarioFotoEntity;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioFotoRepository extends CrudRepository<UsuarioFotoEntity,Integer> {
}
