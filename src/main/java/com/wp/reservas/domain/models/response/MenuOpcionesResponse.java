package com.wp.reservas.domain.models.response;

import com.wp.reservas.domain.models.dto.configuraciones.MenuOpcionesDto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class MenuOpcionesResponse {

    private List<MenuOpcionesDto> menuOpcionesDtos;

}
