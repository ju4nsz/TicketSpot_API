package com.wp.reservas.persistence.adapter;

import com.wp.reservas.domain.service.out.RolOutService;
import com.wp.reservas.persistence.repository.RolRepository;
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
