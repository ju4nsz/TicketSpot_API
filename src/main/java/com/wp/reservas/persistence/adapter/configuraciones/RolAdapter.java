package com.wp.reservas.persistence.adapter.configuraciones;

import com.wp.reservas.domain.service.out.configuraciones.RolOutService;
import com.wp.reservas.persistence.repository.configuraciones.RolRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class RolAdapter implements RolOutService {

    private final RolRepository rolRepository;

    @Override
    public List<String> findPermissionsByRoleId(Integer idRol) {
        return rolRepository.obtenerPermisosPorIdRol(idRol);
    }
}
