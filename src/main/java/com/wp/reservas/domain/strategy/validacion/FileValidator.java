package com.wp.reservas.domain.strategy.validacion;

public interface FileValidator {

    boolean validarExtension(ExtensionesTipos tipo, String filename);

}
