package com.wp.reservas.domain.Util;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
class UsuarioUtilTest {

    @Test
    void retornarEdad() {
        UsuarioUtil usuarioUtil = new UsuarioUtil();
        LocalDate localDate = LocalDate.of(2005, 9, 19);
        Date fechaNacimiento = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        Integer edad= usuarioUtil.retornarEdad(fechaNacimiento);
        System.out.println(edad);
    }
}