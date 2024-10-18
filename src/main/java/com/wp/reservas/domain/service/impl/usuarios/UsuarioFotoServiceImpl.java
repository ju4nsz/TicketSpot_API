package com.wp.reservas.domain.service.impl.usuarios;

import com.wp.reservas.domain.Util.ArchivoUtil;
import com.wp.reservas.domain.models.exceptions.HttpGenericException;
import com.wp.reservas.domain.models.request.usuarios.UsuarioFotoRequest;
import com.wp.reservas.domain.models.response.GenericResponse;
import com.wp.reservas.domain.service.in.usuarios.UsuarioFotoInService;
import com.wp.reservas.domain.service.out.usuarios.UsuarioFotoOutService;
import com.wp.reservas.domain.service.out.usuarios.UsuarioOutService;
import com.wp.reservas.domain.strategy.validacion.ExtensionesTipos;
import com.wp.reservas.domain.strategy.validacion.FileValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.antlr.v4.runtime.misc.Triple;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@Slf4j
@RequiredArgsConstructor
public class UsuarioFotoServiceImpl implements UsuarioFotoInService {

    private final UsuarioOutService usuarioOutService;
    private final FileValidator fileValidator;
    private final ArchivoUtil archivoUtil;
    private final UsuarioFotoOutService usuarioFotoOutService;

    @Override
    public GenericResponse subir(UsuarioFotoRequest request) {

        log.info("Validando que el usuario con id {} exista...", request.getIdUsuario());

        if (!usuarioOutService.existeUsuario(request.getIdUsuario())) {
            throw new HttpGenericException(HttpStatus.BAD_REQUEST, "¡Lo sentimos! No pudimos encontrar el usuario que enviaste");
        }

        log.info("Validando extensiones y tamaño de la foto del usuario con id {}...", request.getIdUsuario());
        validarArchivo(request.getFoto());

        log.info("Guardando foto del usuario con id {}", request.getIdUsuario());
        guardarFoto(request.getFoto(), request.getIdUsuario());

        return GenericResponse.ok(true,"¡Lo logramos! guardamos la foto del usuario con exito :)");
    }

    private void validarArchivo(MultipartFile foto) {

        if (!fileValidator.validarExtension(ExtensionesTipos.IMG, foto.getOriginalFilename())) {
            throw new HttpGenericException(HttpStatus.BAD_REQUEST, "¡Lo sentimos! Deben ser imágenes válidas para poder cargarlas :/");
        }

        if ((foto.getSize() / 1024) > 2048) {
            throw new HttpGenericException(HttpStatus.BAD_REQUEST, "¡Lo sentimos! El tamaño de las imagénes debe ser menor o igual a " + (2048 / 1024) + "MB para poder cargarlas :/");
        }



    }
    private void guardarFoto(MultipartFile foto, Integer idUsuario) {

        byte[] bytes;
        try {
            bytes = foto.getBytes();
        } catch (IOException e) {
            throw new HttpGenericException(HttpStatus.INTERNAL_SERVER_ERROR, "¡Lo sentimos! Ha ocurrido un error guardando la foto ;/");
        }

        log.info("Guardando foto...{}", foto.getOriginalFilename());

        Triple<String, String, String> respuesta = archivoUtil.subirArchivo(bytes, idUsuario.toString(), foto.getOriginalFilename(), "Usuarios");

        log.info("Guardando informacion de la foto en base de datos...");

        usuarioFotoOutService.subir(UsuarioBuilder.construirDtoFoto(idUsuario, respuesta.b, respuesta.a));
    }
}
