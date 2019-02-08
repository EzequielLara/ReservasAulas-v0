/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iesalandalus.programacion.reservasaulas.modelo2;

import javax.naming.OperationNotSupportedException;
import org.iesalandalus.programacion.reservasaulas.modelo.dao.Aulas;
import org.iesalandalus.programacion.reservasaulas.modelo.dao.Profesores;
import org.iesalandalus.programacion.reservasaulas.modelo.dao.Reservas;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Aula;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Permanencia;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Profesor;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Reserva;

/**
 *
 * @author Ezk24
 */
public class ModeloReservasAulas {
    private Profesores profesores;
    private Aulas aulas;
    private Reservas reservas;
    
    public ModeloReservasAulas(){   
        
        profesores=new Profesores();
        aulas =new Aulas();
        reservas = new Reservas();
    }
        
    public Aula[] getAulas(){
        return aulas.getAulas();
    }
    
    public int getNumeroAulas(){
        return aulas.getNumAulas();
    }
    
    public String[] representarNumeroAulas(){
        return aulas.representar();
    }
    
    public Aula buscarAula(Aula aula){
        return aulas.buscar(aula);
    }
    
    public void insertarAula(Aula aula) throws OperationNotSupportedException{
        aulas.insertar(aula);
    }
    
    public void borrarAula(Aula aula) throws OperationNotSupportedException{
        aulas.borrar(aula);
    }
    
    public Profesor[] getProfesores(){
        return profesores.getProfesores();
    }
    
    public int getNumeroProfesores(){
        return profesores.getNumProfesores();
    }
    
    public String[] representarNumeroProfesores(){
        return profesores.representar();
    }
    
    public Profesor buscarProfesor(Profesor profesor){
        return profesores.buscar(profesor);
    }
    
    public void insertaProfesor(Profesor profesor) throws OperationNotSupportedException{
        profesores.insertar(profesor);
    }
    
    public void borrarProfesor(Profesor profesor) throws OperationNotSupportedException{
        profesores.borrar(profesor);
    }
    
    public Reserva[] getReservas(){
        return reservas.getReservas();
    }
    
    public int getNumeroReservas(){
        return reservas.getNumReservas();
    }
    
    public String[] representarNumeroReservas(){
        return reservas.representar();
    }
    
    public Reserva buscarReserva(Reserva reserva){
        return reservas.buscar(reserva);
    }
    
    public void realizarReserva(Reserva reserva) throws OperationNotSupportedException{
        reservas.insertar(reserva);
    }
    
    public void anularReserva(Reserva reserva) throws OperationNotSupportedException{
        reservas.borrar(reserva);
    }
    
    public Reserva[] getReservasAulas(Aula aula){
        return reservas.getReservasAula(aula);
    }
    
    public Reserva[] getReservasProfesor(Profesor profesor){
        return reservas.getReservasProfesor(profesor);
    }
    
    public Reserva[] getReservasPermanencia(Permanencia permanencia){
        return reservas.getReservasPermanencia(permanencia);
    }
    
    public boolean consultarDisponibilidad(Aula aula, Permanencia permanencia){
        return reservas.consultarDisponibilidad(aula, permanencia);
    
    }
    
    
}
