package com.wp.reservas.web.controller.usuarios;

import com.wp.reservas.domain.models.request.usuarios.UsuarioFotoRequest;
import com.wp.reservas.domain.models.response.GenericResponse;
import com.wp.reservas.domain.service.in.usuarios.UsuarioFotoInService;
import com.wp.reservas.domain.service.in.usuarios.UsuarioInService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/usuario-foto")
@RequiredArgsConstructor
public class UsuarioFotoController {

    private final UsuarioFotoInService usuarioFotoInService;

    @PostMapping
    public ResponseEntity<GenericResponse> subirFotoUsuario(@ModelAttribute  UsuarioFotoRequest request){
        return ResponseEntity.ok(usuarioFotoInService.subir(request));
    }
}
