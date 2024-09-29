package com.wp.reservas.domain.models.dto.configuraciones;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class MenuOpcionesDto {

    private MenuDto padre;
    private List<MenuOpcionesDto> hijos;

}
