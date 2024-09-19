package com.wp.reservas.domain.service.impl.usuarios;

import com.wp.reservas.domain.Util.UsuarioUtil;
import com.wp.reservas.domain.models.consts.DatosGenerales;
import com.wp.reservas.domain.models.dto.UsuarioDto;
import com.wp.reservas.domain.service.in.usuarios.UsuarioInService;
import com.wp.reservas.domain.service.out.GeneroPersonasOutService;
import com.wp.reservas.domain.service.out.UsuarioOutService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioInService {

    private final UsuarioOutService usuarioOutService;
    private final GeneroPersonasOutService generoPersonasOutService;
    private final UsuarioUtil usuarioUtil;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UsuarioDto registrarse(UsuarioDto usuarioDto) {

        usuarioOutService.buscarUsuario(usuarioDto.getUsuario(),usuarioDto.getCorreoElectronico());

        if(!generoPersonasOutService.existeGeneroPersona(usuarioDto.getId())){
            throw new RuntimeException("Género no encontrado.");
        }

        if(!usuarioUtil.validarFechaNacimiento(usuarioDto.getFechaNacimiento(), DatosGenerales.EDAD_MINIMA)){
            throw new RuntimeException("Para poder registrarse, la edad debe ser mayor a la requerida");
        }

        usuarioDto.setIdRol(DatosGenerales.ID_ROL_USUARIO);
        usuarioDto.setEdad(usuarioUtil.retornarEdad(usuarioDto.getFechaNacimiento()));
        usuarioDto.setContrasenia(passwordEncoder.encode(usuarioDto.getContrasenia()));

        return usuarioOutService.guardarUsuario(usuarioDto);
    }
}
