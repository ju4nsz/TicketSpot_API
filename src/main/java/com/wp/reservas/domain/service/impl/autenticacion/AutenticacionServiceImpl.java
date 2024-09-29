package com.wp.reservas.domain.service.impl.autenticacion;

import com.wp.reservas.domain.models.CustomUserDetails;
import com.wp.reservas.domain.models.dto.configuraciones.MenuDto;
import com.wp.reservas.domain.models.dto.configuraciones.MenuOpcionesDto;
import com.wp.reservas.domain.models.dto.usuarios.UsuarioDatosRequest;
import com.wp.reservas.domain.models.exceptions.HttpGenericException;
import com.wp.reservas.domain.models.request.AutenticacionRequest;
import com.wp.reservas.domain.models.response.AutenticacionResponse;
import com.wp.reservas.domain.models.response.MenuOpcionesResponse;
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
import java.util.Collections;
import java.util.List;
import java.util.Map;
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

        if (!passwordEncoder.matches(autenticacionRequest.getContrasenia(), request.getContrasenia())) {
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
        return AutenticacionBuilder.construirAuthResponse(jwt, request, permisos, MenuOpcionesResponse.builder().menuOpcionesDtos(retornarMenu(menuOpciones)).build());
    }

    private List<MenuOpcionesDto> retornarMenu(List<MenuDto> menus) {

        // Agrupar los menús hijos por su idPadre
        Map<Integer, List<MenuDto>> hijosAgrupadosPorPadre = menus.stream()
                .filter(menu -> menu.getIdPadre() != null)
                .collect(Collectors.groupingBy(MenuDto::getIdPadre));

        // Obtener los menús raíz (padres sin idPadre)
        List<MenuDto> padres = menus.stream()
                .filter(menu -> menu.getIdPadre() == null)
                .toList();

        // Crear la lista final de menús con la jerarquía
        return padres.stream()
                .map(padre -> asignarHijosRecursivamente(new MenuOpcionesDto(padre, new ArrayList<>()), hijosAgrupadosPorPadre))
                .toList();
    }

    private MenuOpcionesDto asignarHijosRecursivamente(MenuOpcionesDto menu, Map<Integer, List<MenuDto>> hijosAgrupadosPorPadre) {
        // Obtener los hijos directos del menú actual
        List<MenuDto> hijos = hijosAgrupadosPorPadre.get(menu.getPadre().getId());

        // Si hay hijos, asignarlos recursivamente
        if (hijos != null && !hijos.isEmpty()) {
            List<MenuOpcionesDto> listaHijos = hijos.stream()
                    .map(hijo -> asignarHijosRecursivamente(new MenuOpcionesDto(hijo, new ArrayList<>()), hijosAgrupadosPorPadre))
                    .toList();

            // Asignar los hijos al menú actual
            menu.setHijos(listaHijos);
        }

        // Devolver el menú con sus hijos asignados
        return menu;
    }

}