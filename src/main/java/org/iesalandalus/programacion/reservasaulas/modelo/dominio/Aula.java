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
public class Aula {
    
    private String nombre;

    public Aula(String nombre){
        
      setNombre(nombre);
    
    } 
    public Aula(Aula aula){
    
         if (aula==null){
       
         throw new IllegalArgumentException("No se puede copiar un aula nula.");   
            }else{
        
                setNombre(aula.getNombre());
            }
       
    }     
    
       

    public String getNombre() {
        return nombre;
    }

    private void setNombre(String nombre){
        
        if(nombre==null){
            
            throw new IllegalArgumentException("El nombre del aula no puede ser nulo.");
            
        }
        
       if(nombre.equals("")){
            
           throw new IllegalArgumentException("El nombre del aula no puede estar vacío.");
            
        }
       
        this.nombre=nombre;
             
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.nombre);
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
        final Aula other = (Aula) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return true;
    }

  
    

   

    @Override
    public String toString() {
        return  "[nombre=" + nombre + ']';
    }
    
    
    
    
    
    
    
}
