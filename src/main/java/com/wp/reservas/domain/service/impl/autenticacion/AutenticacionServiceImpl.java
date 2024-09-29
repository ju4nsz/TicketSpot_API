package com.wp.reservas.domain.service.impl.autenticacion;

import com.wp.reservas.domain.models.CustomUserDetails;
import com.wp.reservas.domain.models.dto.configuraciones.MenuDto;
import com.wp.reservas.domain.models.dto.usuarios.UsuarioDatosRequest;
import com.wp.reservas.domain.models.exceptions.HttpGenericException;
import com.wp.reservas.domain.models.request.AutenticacionRequest;
import com.wp.reservas.domain.models.response.AutenticacionResponse;
import com.wp.reservas.domain.models.response.UsuarioDatosResponse;
import com.wp.reservas.domain.service.JwtService;
import com.wp.reservas.domain.service.in.autenticacion.AutenticacionInService;
import com.wp.reservas.domain.service.out.configuraciones.MenuOutService;
import com.wp.reservas.domain.service.out.configuraciones.RolOutService;
import com.wp.reservas.domain.service.out.usuarios.UsuarioOutService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AutenticacionServiceImpl implements AutenticacionInService {

    private final UsuarioOutService usuarioOutService;
    private final MenuOutService menuOutService;
    private final RolOutService rolOutService;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;

    @Override
    public AutenticacionResponse iniciarSesion(AutenticacionRequest autenticacionRequest) {
        UsuarioDatosRequest request = usuarioOutService.obtenerDatosUsuario(autenticacionRequest.getUsuario());

        if (!passwordEncoder.matches(autenticacionRequest.getContrasenia(), request.getContrasenia())){
            throw new HttpGenericException(HttpStatus.BAD_REQUEST, "Lo sentimos, no pudimos validar tus credenciales :(");
        }

        List<MenuDto> menuOpciones = menuOutService.obtenerMenuByIdRol(request.getIdRol());

        List<String> permisos = rolOutService.findPermissionsByRoleId(request.getIdRol());
        List<SimpleGrantedAuthority> authorities = permisos
                                        .stream()
                                        .map(SimpleGrantedAuthority::new)
                                        .toList();

        List<GrantedAuthority> grantedAuthorities = new ArrayList<>(authorities);
        CustomUserDetails customUserDetails = new CustomUserDetails(request.getUsuario(), "", grantedAuthorities);
        List<String> permisosToken = permisos.stream()
                .filter(p -> !p.contains("menu"))
                .toList();
        String jwt = jwtService.generateToken(customUserDetails, permisosToken);
        return AutenticacionBuilder.construirAuthResponse(jwt, request, permisos, menuOpciones);
    }

}
