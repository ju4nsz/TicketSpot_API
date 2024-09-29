package com.wp.reservas.persistence.adapter.configuraciones;

import com.wp.reservas.domain.models.dto.configuraciones.MenuDto;
import com.wp.reservas.domain.service.out.configuraciones.MenuOutService;
import com.wp.reservas.persistence.mapper.configuraciones.MenuMapper;
import com.wp.reservas.persistence.repository.configuraciones.MenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MenuAdapter implements MenuOutService {

    private final MenuRepository menuRepository;
    private final MenuMapper menuMapper;

    @Override
    public List<MenuDto> obtenerMenuByIdRol(Integer idRol) {
        return menuRepository.obtenerMenuByIdRol(idRol)
                .stream()
                .map(menuMapper::toMenuDto)
                .toList();
    }

}
