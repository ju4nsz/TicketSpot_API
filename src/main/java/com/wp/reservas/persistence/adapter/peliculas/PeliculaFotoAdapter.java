package com.wp.reservas.persistence.adapter.peliculas;

import com.wp.reservas.domain.models.dto.peliculas.PeliculaFotoDto;
import com.wp.reservas.domain.service.out.peliculas.PeliculaFotoOutService;
import com.wp.reservas.persistence.mapper.peliculas.PeliculaFotoMapper;
import com.wp.reservas.persistence.repository.peliculas.PeliculaFotoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class PeliculaFotoAdapter implements PeliculaFotoOutService {

    private final PeliculaFotoRepository repository;
    private final PeliculaFotoMapper mapper;

    @Override
    public Integer obtenerCantidadFotosPorPelicula(Integer idPelicula) {
        return repository.countByIdPelicula(idPelicula);
    }

    @Override
    public PeliculaFotoDto guardar(PeliculaFotoDto peliculaFotoDto) {
        return mapper.toDto(repository.save(mapper.toEntity(peliculaFotoDto)));
    }
}
