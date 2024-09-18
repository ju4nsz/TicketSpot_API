package com.wp.reservas.domain.service.out;

import java.util.List;

public interface RolOutService {

    List<String> findPermissionsByRoleId(Integer idRol);

}
