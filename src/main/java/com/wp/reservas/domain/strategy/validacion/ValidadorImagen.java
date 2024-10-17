package com.wp.reservas.domain.strategy.validacion;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ValidadorImagen implements FileValidator{

    private static final List<String> VALID_EXTENSIONS = List.of("jpg", "jpeg", "png");

    @Override
    public boolean validarExtension(ExtensionesTipos tipo, String filename) {
        return VALID_EXTENSIONS.contains(getFileExtension(filename));
    }

    private String getFileExtension(String filename) {
        return filename.substring(filename.lastIndexOf(".") + 1).toLowerCase();
    }

}
