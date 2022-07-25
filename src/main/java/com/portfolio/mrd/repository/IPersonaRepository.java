
package com.portfolio.mrd.repository;

import com.portfolio.mrd.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IPersonaRepository extends JpaRepository <Persona, Long>{
        
}
