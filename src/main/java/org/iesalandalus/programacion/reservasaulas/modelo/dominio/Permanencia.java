/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iesalandalus.programacion.reservasaulas.modelo.dominio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

/**
 *
 * @author Ezk24
 */
public class Permanencia {
   
    private LocalDate dia;
    private static final DateTimeFormatter FORMATO_DIA= DateTimeFormatter.ofPattern("dd/mm/aaaa");
    private Tramo tramo;
    
    
    public Permanencia(LocalDate dia, Tramo tramo){
    
        setDia(dia);
        setTramo(tramo);
    
    }
    
    public Permanencia(Permanencia permanencia){
        
        if(permanencia==null){
        
            throw new IllegalArgumentException("Elemento nulo, debe introducir un objeto");
                
        }else{
            
            permanencia =new Permanencia(permanencia.getDia(),permanencia.getTramo());
       
        }
        
        
    }

    public LocalDate getDia() {
        return dia;
    }

    private void setDia(LocalDate dia) {
        if(dia==null){
        
            throw new IllegalArgumentException("introducir dia");
        }else{
            
            this.dia = dia;
        }
    }

    public Tramo getTramo() {
        return tramo;
    }

    private void setTramo(Tramo tramo) {
        
        if(tramo==null){
        
            throw new IllegalArgumentException("introducir tramo");
            
        }else{
            
            this.tramo = tramo;
        }
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 13 * hash + Objects.hashCode(this.dia);
        hash = 13 * hash + Objects.hashCode(this.tramo);
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
        final Permanencia other = (Permanencia) obj;
        if ((!Objects.equals(this.dia, other.dia))||(this.tramo != other.tramo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Permanencia{" + "dia=" + dia + ", tramo=" + tramo + '}';
    }
       
}
