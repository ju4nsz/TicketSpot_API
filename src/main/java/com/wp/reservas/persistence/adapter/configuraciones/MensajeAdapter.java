package com.wp.reservas.persistence.adapter.configuraciones;

import com.wp.reservas.domain.models.dto.configuraciones.MensajeDto;
import com.wp.reservas.domain.service.out.configuraciones.MensajeOutService;
import com.wp.reservas.persistence.entity.configuraciones.MensajeEntity;
import com.wp.reservas.persistence.mapper.configuraciones.MensajeMapper;
import com.wp.reservas.persistence.repository.configuraciones.MensajeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MensajeAdapter implements MensajeOutService {

    private final MensajeRepository mensajeRepository;
    private final MensajeMapper mensajeMapper;

    @Override
    public List<MensajeDto> obtenerMensajesBienvenida(Integer idTipoBienvenida) {
        return mensajeRepository.findByIdTipoMensaje(idTipoBienvenida)
                .stream()
                .map(mensajeMapper::toMensajeDto)
                .toList();
    }
}
