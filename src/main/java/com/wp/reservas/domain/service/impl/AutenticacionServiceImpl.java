package com.wp.reservas.domain.service.impl;

import com.wp.reservas.domain.models.CustomUserDetails;
import com.wp.reservas.domain.models.dto.UsuarioDatosRequest;
import com.wp.reservas.domain.models.request.AutenticacionRequest;
import com.wp.reservas.domain.models.response.AutenticacionResponse;
import com.wp.reservas.domain.models.response.UsuarioDatosResponse;
import com.wp.reservas.domain.service.JwtService;
import com.wp.reservas.domain.service.in.AutenticacionInService;
import com.wp.reservas.domain.service.out.RolOutService;
import com.wp.reservas.domain.service.out.UsuarioOutService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AutenticacionServiceImpl implements AutenticacionInService {

    private final UsuarioOutService usuarioOutService;
    private final RolOutService rolOutService;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;

    @Override
    public AutenticacionResponse iniciarSesion(AutenticacionRequest autenticacionRequest) {

        UsuarioDatosRequest request = usuarioOutService.obtenerDatosUsuario(autenticacionRequest.getUsuario());

        if (!passwordEncoder.matches(autenticacionRequest.getContrasenia(), request.getContrasenia())){
            throw new RuntimeException("Credenciales inválidas.");
        }

        List<String> permisos = rolOutService.findPermissionsByRoleId(request.getIdRol());
        List<SimpleGrantedAuthority> authorities = permisos
                                        .stream()
                                        .map(SimpleGrantedAuthority::new)
                                        .collect(Collectors.toList());

        List<GrantedAuthority> grantedAuthorities = new ArrayList<>(authorities);
        CustomUserDetails customUserDetails = new CustomUserDetails(request.getUsuario(), "", grantedAuthorities);
        String jwt = jwtService.generateToken(customUserDetails, permisos);

        return AutenticacionResponse.builder()
                .accessToken(jwt)
                .usuarioDatosResponse(UsuarioDatosResponse.builder()
                        .usuario(request.getUsuario())
                        .permisos(permisos)
                        .build())
                .build();
    }



}
