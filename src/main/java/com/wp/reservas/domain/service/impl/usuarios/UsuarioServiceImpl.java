package com.wp.reservas.domain.service.impl.usuarios;

import com.wp.reservas.domain.Util.UsuarioUtil;
import com.wp.reservas.domain.models.consts.DatosGenerales;
import com.wp.reservas.domain.models.dto.UsuarioDto;
import com.wp.reservas.domain.models.exceptions.HttpGenericException;
import com.wp.reservas.domain.models.request.UsuarioRegistroRequest;
import com.wp.reservas.domain.service.in.usuarios.UsuarioInService;
import com.wp.reservas.domain.service.out.GeneroPersonasOutService;
import com.wp.reservas.domain.service.out.UsuarioOutService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpStatusCodeException;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioInService {

    private final UsuarioOutService usuarioOutService;
    private final GeneroPersonasOutService generoPersonasOutService;
    private final UsuarioUtil usuarioUtil;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UsuarioDto registrarse(UsuarioRegistroRequest usuarioDto) {

        if (usuarioOutService.existeUsuario(usuarioDto.getUsuario(), usuarioDto.getCorreoElectronico())){
            throw new HttpGenericException(HttpStatus.BAD_REQUEST, "¡Lo sentimos! Ya existe alguien con ese correo electrónico o usuario, podrías intentar con otro :)");
        }

        if(!generoPersonasOutService.existeGeneroPersona(usuarioDto.getIdGenero())){
            throw new HttpGenericException(HttpStatus.NOT_FOUND, "¡Lo sentimos! No encontramos el género seleccionado en nuestros datos");
        }

        if(!usuarioUtil.validarFechaNacimiento(usuarioDto.getFechaNacimiento(), DatosGenerales.EDAD_MINIMA)){
            throw new HttpGenericException(HttpStatus.BAD_REQUEST,
                    "¡Lo sentimos! Para poder ingresar a nuestr app, debes ser mayor de " + DatosGenerales.EDAD_MINIMA + " años :/");
        }

        usuarioDto.setIdRol(DatosGenerales.ID_ROL_USUARIO);
        usuarioDto.setEdad(usuarioUtil.retornarEdad(usuarioDto.getFechaNacimiento()));
        usuarioDto.setContrasenia(passwordEncoder.encode(usuarioDto.getContrasenia()));

        return usuarioOutService.guardarUsuario(usuarioDto);
    }
}
