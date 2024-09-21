package com.wp.reservas.domain.util;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

@Component
public class UsuarioUtil {

    public boolean validarFechaNacimiento(Date fechaNacimiento, Integer edadMinima){

        LocalDate fechaNacimientoLocalDate = fechaNacimiento.toInstant()
                                        .atZone(ZoneId.systemDefault())
                                        .toLocalDate();

        return Period.between(fechaNacimientoLocalDate,LocalDate.now()).getYears() >= edadMinima;
    }

    public Integer retornarEdad(Date fechaNacimiento){

        LocalDate fechaNacimientoLocalDate = fechaNacimiento.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();

        return Period.between(fechaNacimientoLocalDate,LocalDate.now()).getYears();
    }
}
