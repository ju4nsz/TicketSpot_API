package com.wp.reservas.persistence.mapper.configuraciones;

import com.wp.reservas.domain.models.dto.configuraciones.MensajeDto;
import com.wp.reservas.persistence.entity.configuraciones.MensajeEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MensajeMapper {

    MensajeDto toMensajeDto(MensajeEntity mensajeEntity);

}
