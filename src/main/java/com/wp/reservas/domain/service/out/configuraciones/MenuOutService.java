package com.wp.reservas.domain.service.out.configuraciones;

import com.wp.reservas.domain.models.dto.configuraciones.MenuDto;

import java.util.List;

public interface MenuOutService {

    List<MenuDto> obtenerMenuByIdRol(Integer idRol);

}
