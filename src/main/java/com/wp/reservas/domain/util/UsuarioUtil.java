package com.wp.reservas.domain.util;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

@Component
public class UsuarioUtil {

    public boolean validarFechaNacimiento(LocalDate fechaNacimiento, Integer edadMinima){
        return Period.between(fechaNacimiento,LocalDate.now()).getYears() >= edadMinima;
    }

    public Integer retornarEdad(LocalDate fechaNacimiento){
        return Period.between(fechaNacimiento,LocalDate.now()).getYears();
    }
}
