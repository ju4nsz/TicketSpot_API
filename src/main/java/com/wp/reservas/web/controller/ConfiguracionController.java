package com.wp.reservas.web.controller;

import com.wp.reservas.domain.models.response.ConfiguracionResponse;
import com.wp.reservas.domain.service.in.ConfiguracionInService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/configuracion")
public class ConfiguracionController {

    private final ConfiguracionInService configuracionInService;

    @GetMapping
    public ResponseEntity<ConfiguracionResponse> obtenerConfiguraciones(){
        return ResponseEntity.ok(configuracionInService.obtenerConfiguraciones());
    }

}
