
package com.portfolio.mrd.Interface;

import com.portfolio.mrd.model.Persona;
import java.util.List;



public interface IPersonaService {
        //trer una lista de personas
    public List <Persona> getPersona();
    
    //guardar un objeto de tipo perosna
    public void savePersona (Persona pers);
    
    //eliminar
    public void deletePersona (Long id);
    
    //buscar persona por id
    public Persona findPersona (Long id);
    
    
}
