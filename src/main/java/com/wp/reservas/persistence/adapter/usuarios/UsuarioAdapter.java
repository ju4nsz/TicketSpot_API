package com.wp.reservas.persistence.adapter.usuarios;

import com.wp.reservas.domain.models.dto.usuarios.UsuarioDatosRequest;
import com.wp.reservas.domain.models.dto.usuarios.UsuarioDto;
import com.wp.reservas.domain.models.request.UsuarioRegistroRequest;
import com.wp.reservas.domain.service.out.usuarios.UsuarioOutService;
import com.wp.reservas.persistence.mapper.usuarios.UsuarioMapper;
import com.wp.reservas.persistence.repository.usuarios.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UsuarioAdapter implements UsuarioOutService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;

    @Override
    public UsuarioDto obtenerUsuario(String usuario) {
        return usuarioRepository.findByUsuario(usuario)
                .map(usuarioMapper::toUsuarioDto).orElseThrow(() -> new UsernameNotFoundException("Usuario '" + usuario + "' no encontrado."));
    }

    @Override
    public UsuarioDto obtenerUsuarioByCorreoElectronico(String correoElectronico) {
        return usuarioRepository.findByCorreoElectronico(correoElectronico)
                .map(usuarioMapper::toUsuarioDto)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));
    }

    @Override
    public UsuarioDatosRequest obtenerDatosUsuario(String usuario) {
        return usuarioRepository.obtenerDatosUsuario(usuario)
                .map(usuarioMapper::toUserDatosResponse)
                .orElseThrow(() -> new UsernameNotFoundException("Credenciales invalidas."));
    }

    @Override
    public boolean existeUsuario(String usuario, String correoElectronico) {
        return usuarioRepository.existsByUsuarioOrCorreoElectronico(usuario, correoElectronico);
    }

    @Override
    public UsuarioDto guardarUsuario(UsuarioRegistroRequest usuarioDto) {
        return usuarioMapper.toUsuarioDto(usuarioRepository.save(usuarioMapper.toUsuarioEntity(usuarioDto)));
    }
}
