package com.wp.reservas.persistence.adapter.configuraciones;

import com.wp.reservas.domain.models.dto.configuraciones.MenuDto;
import com.wp.reservas.domain.service.out.configuraciones.MenuOutService;
import com.wp.reservas.persistence.mapper.configuraciones.MenuMapper;
import com.wp.reservas.persistence.projection.MenuProjection;
import com.wp.reservas.persistence.repository.configuraciones.MenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class MenuAdapter implements MenuOutService {

    private final MenuRepository menuRepository;
    private final MenuMapper menuMapper;


    @Override
    public List<MenuDto> obtenerMenuByIdRol(Integer idRol) {

        List<MenuProjection> menus = menuRepository.obtenerMenuByIdRol(idRol);

        List<MenuDto> padres = menus.stream()
                .filter(mp -> mp.getIdPadre() == null)
                .map(menuMapper::toMenuDto)
                .toList();

        List<MenuDto> hijos = menus.stream()
                .filter(mp -> mp.getIdPadre() != null)
                .map(menuMapper::toMenuDto)
                .toList();

        Map<Integer, List<MenuDto>> hijosAgrupadosPorPadre =   hijos.stream()
                .collect(Collectors.groupingBy(MenuDto::getIdPadre));

        System.out.println(hijosAgrupadosPorPadre.keySet());
        System.out.println(hijosAgrupadosPorPadre.values());

        return null;
    }
}
