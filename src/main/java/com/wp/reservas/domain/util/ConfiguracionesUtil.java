package com.wp.reservas.domain.util;

import com.wp.reservas.domain.models.dto.configuraciones.ParametroDto;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class ConfiguracionesUtil {

    public ParametroDto devolverParametro(ParametroDto parametroDto){
        if (parametroDto.getTipoDato().equals("number")){
            parametroDto.setValorConvertido(Integer.parseInt(parametroDto.getValor()));
        } else if (parametroDto.getTipoDato().equals("boolea")) {
            parametroDto.setValorConvertido(Objects.equals(parametroDto.getValor(), "S"));
        } else {
            parametroDto.setValorConvertido(parametroDto.getValor());
        }
        return parametroDto;
    }

}
