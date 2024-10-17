package com.wp.reservas.persistence.mapper.peliculas;

import com.wp.reservas.domain.models.dto.peliculas.PeliculaFotoDto;
import com.wp.reservas.persistence.entity.peliculas.PeliculaFotoEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PeliculaFotoMapper {

    PeliculaFotoEntity toEntity(PeliculaFotoDto dto);

    PeliculaFotoDto toDto(PeliculaFotoEntity entity);

}
