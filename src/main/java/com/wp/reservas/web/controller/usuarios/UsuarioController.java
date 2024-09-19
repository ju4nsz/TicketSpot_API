package com.wp.reservas.web.controller.usuarios;

import com.wp.reservas.domain.models.dto.UsuarioDto;
import com.wp.reservas.domain.service.in.usuarios.UsuarioInService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioInService usuarioInService;

    @PostMapping("/registrar")
    public ResponseEntity<UsuarioDto> registrarse(@RequestBody @Valid UsuarioDto usuarioDto){
        return ResponseEntity.ok(usuarioInService.registrarse(usuarioDto));
    }
}
