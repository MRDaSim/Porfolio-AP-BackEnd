
package com.portfolio.mrd.service;

import com.portfolio.mrd.Interface.IPersonaService;
import com.portfolio.mrd.model.Persona;
import com.portfolio.mrd.repository.IPersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImpPersonaService implements IPersonaService{
    
    
    @Autowired IPersonaRepository ipersonaRepository;
    
    @Override
    public List<Persona> getPersona() {
            List <Persona> persona = ipersonaRepository.findAll();
            return persona;
    }

    @Override
    public void savePersona(Persona pers) {
        ipersonaRepository.save(pers);
    }

    @Override
    public void deletePersona(Long id) {
        ipersonaRepository.deleteById(id);
    }

    @Override
    public Persona findPersona(Long id) {
         Persona pers =  ipersonaRepository.findById(id).orElse(null);
                 return pers;
    }
        
}
