package com.wp.reservas.domain.service.impl.usuarios;

import com.wp.reservas.domain.models.dto.configuraciones.ParametroDto;
import com.wp.reservas.domain.service.out.configuraciones.ParametroOutService;
import com.wp.reservas.domain.util.ConfiguracionesUtil;
import com.wp.reservas.domain.util.UsuarioUtil;
import com.wp.reservas.domain.models.consts.DatosGenerales;
import com.wp.reservas.domain.models.dto.usuarios.UsuarioDto;
import com.wp.reservas.domain.models.exceptions.HttpGenericException;
import com.wp.reservas.domain.models.request.UsuarioRegistroRequest;
import com.wp.reservas.domain.service.in.usuarios.UsuarioInService;
import com.wp.reservas.domain.service.out.configuraciones.GeneroPersonasOutService;
import com.wp.reservas.domain.service.out.usuarios.UsuarioOutService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioInService {

    private final UsuarioOutService usuarioOutService;
    private final GeneroPersonasOutService generoPersonasOutService;
    private final UsuarioUtil usuarioUtil;
    private final PasswordEncoder passwordEncoder;
    private final ParametroOutService parametroOutService;
    private final ConfiguracionesUtil configuracionesUtil;

    @Override
    public UsuarioDto registrarse(UsuarioRegistroRequest usuarioDto) {

        log.info("Validando si el usuario {} existe...", usuarioDto.getUsuario());
        if (usuarioOutService.existeUsuario(usuarioDto.getUsuario(), usuarioDto.getCorreoElectronico())){
            throw new HttpGenericException(HttpStatus.BAD_REQUEST, "¡Lo sentimos! Ya existe alguien con ese correo electrónico o usuario, podrías intentar con otro :)");
        }

        if(!generoPersonasOutService.existeGeneroPersona(usuarioDto.getIdGenero())){
            throw new HttpGenericException(HttpStatus.NOT_FOUND, "¡Lo sentimos! No encontramos el género seleccionado en nuestros datos :/");
        }

        // ParametroDto parametroEdadMinima = parametroOutService.obtenerParametro(DatosGenerales.CLAVE_P_EDAD_MINIMA);
        // parametroEdadMinima = configuracionesUtil.devolverParametro(parametroEdadMinima);

        if(!usuarioUtil.validarFechaNacimiento(usuarioDto.getFechaNacimiento(), 16)){
            throw new HttpGenericException(HttpStatus.BAD_REQUEST,
                    "¡Lo sentimos! Para poder ingresar a nuestra app, debes ser mayor de " + 16 + " años :/");
        }

        usuarioDto.setIdRol(DatosGenerales.ID_ROL_USUARIO);
        usuarioDto.setEdad(usuarioUtil.retornarEdad(usuarioDto.getFechaNacimiento()));
        usuarioDto.setContrasenia(passwordEncoder.encode(usuarioDto.getContrasenia()));

        return usuarioOutService.guardarUsuario(usuarioDto);
    }
}
