
package com.portfolio.mrd.controller;

import com.portfolio.mrd.dto.DtoEducacion;
import com.portfolio.mrd.model.Educacion;
import com.portfolio.mrd.security.controller.Mensaje;
import com.portfolio.mrd.service.SEducacion;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("educ")
@CrossOrigin (origins = "http://localhost:4200")
public class CEducacion {
        
    @Autowired
    SEducacion sEducacion;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Educacion>> list() {
            List<Educacion> list = sEducacion.list();
            return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @PostMapping ("/create")
    public ResponseEntity<?> create (@RequestBody DtoEducacion dtoEdu) {
            if (StringUtils.isBlank(dtoEdu.getNombreEdu())) {
                    return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
            }
            
            if (sEducacion.existsByNombreEdu(dtoEdu.getNombreEdu())) {
                    return new ResponseEntity(new Mensaje("Esta Educacion ya fue cargada"), HttpStatus.BAD_REQUEST);
            }
            
            Educacion educacion = new Educacion(dtoEdu.getNombreEdu(), dtoEdu.getDescripcionEdu());
            sEducacion.save(educacion);
            
            return new ResponseEntity(new Mensaje("Educacion agregada"), HttpStatus.OK);
            
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoEducacion dtoEdu) {
        //Validamos si existe el id
        if (!sEducacion.existsById(id)) {
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
        }

        //Conpara nombre de experiencias
        if (sEducacion.existsByNombreEdu(dtoEdu.getNombreEdu()) && sEducacion.getByNombreEdu(dtoEdu.getNombreEdu()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Esa experiencia ya existe"), HttpStatus.BAD_REQUEST);
        }
        //No puede estar vasio
        if (StringUtils.isBlank(dtoEdu.getNombreEdu())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        Educacion educacion = sEducacion.getOne(id).get();
        educacion.setNombreEdu(dtoEdu.getNombreEdu());
        educacion.setDescripcionEdu((dtoEdu.getDescripcionEdu()));

        sEducacion.save(educacion);
        return new ResponseEntity(new Mensaje("Experiencia actualisada"), HttpStatus.OK);

    }
    
     @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        //validamos si existe el id
        if (!sEducacion.existsById(id)) {
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.OK);
        }

        sEducacion.delete(id);

        return new ResponseEntity(new Mensaje("Experiencia eliminada"), HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Educacion> getById(@PathVariable("id") int id) {
        if (!sEducacion.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        Educacion experiencia = sEducacion.getOne(id).get();
        return new ResponseEntity(experiencia, HttpStatus.OK);
    }    
    
}
