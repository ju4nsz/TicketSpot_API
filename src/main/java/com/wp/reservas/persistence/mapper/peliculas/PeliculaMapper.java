package com.wp.reservas.persistence.mapper.peliculas;

import com.wp.reservas.domain.models.dto.peliculas.PeliculaDto;
import com.wp.reservas.persistence.entity.peliculas.PeliculaEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PeliculaMapper {

    PeliculaDto toPeliculaDto(PeliculaEntity entity);
    PeliculaEntity toPeliculaEntity(PeliculaDto dto);

}
