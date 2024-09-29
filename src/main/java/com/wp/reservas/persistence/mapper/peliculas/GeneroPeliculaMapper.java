package com.wp.reservas.persistence.mapper.peliculas;

import com.wp.reservas.domain.models.dto.peliculas.GeneroPeliculaDto;
import com.wp.reservas.persistence.entity.peliculas.GeneroPeliculaEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GeneroPeliculaMapper {

    GeneroPeliculaDto toGeneroPeliculaDto(GeneroPeliculaEntity entity);

}
