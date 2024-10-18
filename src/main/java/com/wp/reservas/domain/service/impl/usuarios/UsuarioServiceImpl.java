package com.wp.reservas.domain.service.impl.usuarios;

import com.wp.reservas.domain.service.out.configuraciones.ParametroOutService;
import com.wp.reservas.domain.util.UsuarioUtil;
import com.wp.reservas.domain.models.consts.DatosGenerales;
import com.wp.reservas.domain.models.dto.usuarios.UsuarioDto;
import com.wp.reservas.domain.models.exceptions.HttpGenericException;
import com.wp.reservas.domain.models.request.usuarios.UsuarioRegistroRequest;
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

    @Override
    public UsuarioDto registrarse(UsuarioRegistroRequest usuarioDto) {

        log.info("Validando si el usuario {} existe...", usuarioDto.getUsuario());
        if (usuarioOutService.existeUsuario(usuarioDto.getUsuario(), usuarioDto.getCorreoElectronico())){
            throw new HttpGenericException(HttpStatus.BAD_REQUEST, "¡Lo sentimos! Ya existe alguien con ese correo electrónico o usuario, podrías intentar con otro :)");
        }

        log.info("Validando si el género recibio existe, género recibido: {}", usuarioDto.getIdGenero());
        if(!generoPersonasOutService.existeGeneroPersona(usuarioDto.getIdGenero())){
            log.error("Género no encontrado... {}", usuarioDto.getIdGenero());
            throw new HttpGenericException(HttpStatus.NOT_FOUND, "¡Lo sentimos! No encontramos el género seleccionado en nuestros datos :/");
        }

        log.info("Obteniendo el parámetro de edad mínima para el registro del usuario...");
        Integer edadMinima = Integer.parseInt(parametroOutService.obtenerParametro(DatosGenerales.CLAVE_P_EDAD_MINIMA).getValor());
        log.info("Parámetro de edad mínima: {}", edadMinima);

        log.info("Validando la edad del usuario contra la edad mínima requerida...");
        if(!usuarioUtil.validarFechaNacimiento(usuarioDto.getFechaNacimiento(), edadMinima)){
            throw new HttpGenericException(HttpStatus.NOT_ACCEPTABLE,
                    "¡Lo sentimos! Para poder ingresar a nuestra app, debes ser mayor de " + edadMinima + " años :/");
        }

        usuarioDto.setIdRol(DatosGenerales.ID_ROL_USUARIO);
        usuarioDto.setEdad(usuarioUtil.retornarEdad(usuarioDto.getFechaNacimiento()));
        usuarioDto.setContrasenia(passwordEncoder.encode(usuarioDto.getContrasenia()));

        return usuarioOutService.guardarUsuario(usuarioDto);
    }
}
