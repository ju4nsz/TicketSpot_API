package com.wp.reservas.domain.service.impl;

import com.wp.reservas.domain.models.consts.DatosGenerales;
import com.wp.reservas.domain.models.response.ConfiguracionResponse;
import com.wp.reservas.domain.service.in.ConfiguracionInService;
import com.wp.reservas.domain.service.out.configuraciones.GeneroPersonasOutService;
import com.wp.reservas.domain.service.out.configuraciones.MensajeOutService;
import com.wp.reservas.domain.service.out.configuraciones.ParametroOutService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ConfiguracionServiceImpl implements ConfiguracionInService {

    private final MensajeOutService mensajeOutService;
    private final GeneroPersonasOutService generoPersonasOutService;
    private final ParametroOutService parametroOutService;

    @Override
    public ConfiguracionResponse obtenerConfiguraciones() {
        return ConfiguracionResponse.builder()
                .generosPersonas(generoPersonasOutService.obtenerGeneros())
                .mensajesBienvenida(mensajeOutService.obtenerMensajesBienvenida(DatosGenerales.ID_TIPO_BIENVENIDA))
                .edadMinima(Integer.parseInt(parametroOutService.obtenerParametro(DatosGenerales.CLAVE_P_EDAD_MINIMA).getValor()))
                .build();
    }

}
