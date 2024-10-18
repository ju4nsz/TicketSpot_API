package com.wp.reservas.persistence.adapter.usuarios;

import com.wp.reservas.domain.models.dto.usuarios.UsuarioFotoDto;
import com.wp.reservas.domain.service.out.usuarios.UsuarioFotoOutService;
import com.wp.reservas.persistence.mapper.usuarios.UsuarioFotoMapper;
import com.wp.reservas.persistence.repository.usuarios.UsuarioFotoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UsuarioFotoAdapter implements UsuarioFotoOutService {

    private final UsuarioFotoMapper mapper;
    private final UsuarioFotoRepository repository;

    @Override
    public UsuarioFotoDto subir(UsuarioFotoDto usuarioFotoDto) {
        return mapper.toDto(repository.save(mapper.toEntity(usuarioFotoDto)));
    }
}
