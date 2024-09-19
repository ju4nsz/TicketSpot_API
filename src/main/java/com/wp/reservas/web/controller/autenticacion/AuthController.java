package com.wp.reservas.web.controller.autenticacion;

import com.wp.reservas.domain.models.request.AutenticacionRequest;
import com.wp.reservas.domain.models.response.AutenticacionResponse;
import com.wp.reservas.domain.service.in.autenticacion.AutenticacionInService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/autenticacion")
public class AuthController {

    private final AutenticacionInService autenticacionInService;

    @PostMapping("/iniciar-sesion")
    public ResponseEntity<AutenticacionResponse> iniciarSesion(@RequestBody @Valid AutenticacionRequest request){
        return ResponseEntity.ok(autenticacionInService.iniciarSesion(request));
    }

}
