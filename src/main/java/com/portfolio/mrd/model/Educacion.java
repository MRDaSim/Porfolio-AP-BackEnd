
package com.portfolio.mrd.model;



import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
public class Educacion {
    @Id
    @GeneratedValue(strategy  = GenerationType.IDENTITY)
    private int id;
    private String nombreEdu;
    private String descripcionEdu;
    
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(iso = ISO.DATE)
    @Column (name = "inicio_de_actividad")
    @NotNull
    private Date inicioDeActividad;
    @Column (name = "fin_de_actividad")
    @NotNull
    private Date finDeActividad;

    public Educacion() {
    }

    public Educacion(String nombreEdu, String descripcionEdu) {
        this.nombreEdu = nombreEdu;
        this.descripcionEdu = descripcionEdu;
        
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreEdu() {
        return nombreEdu;
    }

    public void setNombreEdu(String nombreEdu) {
        this.nombreEdu = nombreEdu;
    }

    public String getDescripcionEdu() {
        return descripcionEdu;
    }

    public void setDescripcionEdu(String descripcionEdu) {
        this.descripcionEdu = descripcionEdu;
    }

    public Date getInicioDeActividad() {
        return inicioDeActividad;
    }

    public void setInicioDeActividad(Date inicioDeActividad) {
        this.inicioDeActividad = inicioDeActividad;
    }

    public Date getFinDeActividad() {
        return finDeActividad;
    }

    public void setFinDeActividad(Date finDeActividad) {
        this.finDeActividad = finDeActividad;
    }
    
    
    
}

