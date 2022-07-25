
package com.portfolio.mrd.security.repository;

import com.portfolio.mrd.security.entity.Rol;
import com.portfolio.mrd.security.enums.RolNombre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRolRepository extends JpaRepository<Rol, Integer>{
        Optional <Rol> findByRolNombre(RolNombre rolNombre);
}
