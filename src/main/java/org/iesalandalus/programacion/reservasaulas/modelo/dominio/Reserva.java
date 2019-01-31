/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iesalandalus.programacion.reservasaulas.modelo.dominio;

import java.util.Objects;

/**
 *
 * @author Ezk24
 */
public class Reserva {
    
    private Profesor profesor;
    private Aula aula;
    private Permanencia permanencia;

    public Reserva(Profesor profesor, Aula aula, Permanencia permanencia) {
       
        setPermanencia(permanencia);
        setAula(aula);
        setProfesor(profesor);
    }

    public Reserva(Reserva reserva) {
        
        if(reserva==null){
        
        throw new IllegalArgumentException("La reserva no puede ser nula.");
        
        }
        reserva=new Reserva (reserva.getProfesor(),reserva.getAula(),reserva.getPermanencia());
       /* 
        setPermanencia(reserva.permanencia);
        setAula(reserva.aula);
        setProfesor(reserva.profesor);*/
        
        
    }

    public Permanencia getPermanencia() {
        return permanencia;
    }

    private void setPermanencia(Permanencia permanencia) {
        
       if(permanencia==null){
           throw new IllegalArgumentException("Copiar excepcion setPermanencia.");
       }
       
        this.permanencia = new Permanencia(permanencia.getDia(), permanencia.getTramo());
    }

    public Aula getAula() {
        return aula;
    }

    private void setAula(Aula aula) {
        
       if(aula==null){
           throw new IllegalArgumentException("Copiar excepcion setAula.");
       }
        this.aula = new Aula(aula.getNombre());
    }

    public Profesor getProfesor() {
        return profesor;
    }

    private void setProfesor(Profesor profesor) {
        
        if(profesor==null){
           throw new IllegalArgumentException("Copiar excepcion setProfesor.");
       }
        this.profesor = new Profesor(profesor.getNombre(),profesor.getCorreo(),profesor.getTelefono());
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.permanencia);
        hash = 71 * hash + Objects.hashCode(this.aula);
        hash = 71 * hash + Objects.hashCode(this.profesor);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Reserva other = (Reserva) obj;
        if (!Objects.equals(this.permanencia, other.permanencia)) {
            return false;
        }
        if (!Objects.equals(this.aula, other.aula)) {
            return false;
        }
      
        return true;
    }

    @Override
    public String toString() {
        return "Reserva{" + "profesor=" + profesor + ", aula=" + aula + ", permanencia=" + permanencia + '}';
    }



  
    
    
    
    
    
    
    
}
