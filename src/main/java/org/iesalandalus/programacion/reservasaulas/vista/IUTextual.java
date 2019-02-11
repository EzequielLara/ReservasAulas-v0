/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iesalandalus.programacion.reservasaulas.vista;

import javax.naming.OperationNotSupportedException;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Aula;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Permanencia;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Profesor;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Reserva;
import org.iesalandalus.programacion.reservasaulas.modelo2.ModeloReservasAulas;

/**
 *
 * @author Ezk24
 */
public class IUTextual {
    	private static final String ERROR = "ERROR: ----";
	private static final String CORREO_VALIDO="Correo válido";
        private static final String NOMBRE_VALIDO= "Nombre válido";
	private ModeloReservasAulas modelo;

	public IUTextual() {
		modelo = new ModeloReservasAulas();
		Opcion.setVista(this);
	}

	public void comenzar() {
		int ordinalOpcion;
		do {
			Consola.mostrarMenu();
			ordinalOpcion = Consola.elegirOpcion();
			Opcion opcion = Opcion.getOpcionSegunOrdinal(ordinalOpcion);
			opcion.ejecutar();
		} while (ordinalOpcion != Opcion.SALIR.ordinal());
	}
	
	public void salir() {
		System.out.println("Chao Peskao");
	}
	
	public void insertarAula() {
		Consola.mostrarCabecera("Insertar aula");
		try {
			Aula aula = Consola.leerAula();
			modelo.insertarAula(aula);
			System.out.println("Aula insertada correctamente.");
		} catch (OperationNotSupportedException|IllegalArgumentException e) {
			System.out.println(ERROR + e.getMessage());
		}
	}
	
	public void borrarAula() {
		Consola.mostrarCabecera("Borrar cliente");
		try {
			Aula aula = Consola.leerAula();
			modelo.borrarAula(aula);
			System.out.println("Aula borrada correctamente.");
		} catch (OperationNotSupportedException|IllegalArgumentException e) {
			System.out.println(ERROR + e.getMessage());
		}
	}
	
	public void buscarAula() {
		Consola.mostrarCabecera("Buscar aula");
		Aula aula = null;
		try {
			aula = Consola.leerAula();
			aula = modelo.buscarAula(aula);
			if (aula != null) {
				System.out.println("El aula buscada es: " + aula);
			} else {
				System.out.println("No existe ninguna aula con dicho nombre.");
			}
		} catch (IllegalArgumentException e) {
			System.out.println(ERROR + e.getMessage());
		}
	}
	
	public void listarAulas() {
		Consola.mostrarCabecera("Listar aulas");
		String[]aulas = modelo.representarAulas();
		if (aulas.length > 0) {
			for (String aula : aulas) {
				System.out.println(aula);
			}
		} else {
			System.out.println("No hay aulas que listar.");
		}
	}
	public void insertarProfesor() {
		Consola.mostrarCabecera("Insertar profesor");
		try {
			Profesor profesor = Consola.leerProfesor();
			modelo.insertarProfesor(profesor);
                        if (profesor.getNombre()!=null){
			System.out.println(NOMBRE_VALIDO);
                        }
                        if (profesor.getCorreo()!=null){
                            System.out.println(CORREO_VALIDO);}
                        
		} catch (OperationNotSupportedException|IllegalArgumentException e) {
			System.out.println(ERROR + e.getMessage());
		}
	}
	
	public void borrarProfesor() {
		Consola.mostrarCabecera("Borrar cliente");
		try {
			Profesor profesor = Consola.leerProfesor();
			modelo.borrarProfesor(profesor);
			System.out.println("Profesor borrado correctamente.");
		} catch (OperationNotSupportedException|IllegalArgumentException e) {
			System.out.println(ERROR + e.getMessage());
		}
	}
	
	public void buscarProfesor() {
		Consola.mostrarCabecera("Buscar profesor");
		Profesor profesor = null;
		try {
			profesor = Consola.leerProfesor();
			profesor = modelo.buscarProfesor(profesor);
			if (profesor != null) {
				System.out.println("El profesor buscado es: " + profesor);
			} else {
				System.out.println("No existe ninguna profesor con dicho nombre.");
			}
		} catch (IllegalArgumentException e) {
			System.out.println(ERROR + e.getMessage());
		}
	}
	
	public void listarProfesores() {
		Consola.mostrarCabecera("Listar profesores");
		String[]profesores = modelo.representarProfesores();
		if (profesores.length > 0) {
			for (String profesor : profesores) {
				System.out.println(profesor);
			}
		} else {
			System.out.println("No hay profesores que listar.");
		}
	}

        public void realizarReserva()  {
		Consola.mostrarCabecera("Insertar reserva");
		try {
			Reserva reserva = leerReserva(Consola.leerProfesor());
			modelo.realizarReserva(reserva);
			System.out.println("Reserva realizada correctamente.");
		} catch (OperationNotSupportedException|IllegalArgumentException e) {
			System.out.println(ERROR + e.getMessage());
		}
	}
        
        private Reserva leerReserva(Profesor profesor){
            
            Aula aula = Consola.leerAula();
            Permanencia permanencia = new Permanencia(Consola.leerDia(), Consola.leerTramo());
            return new Reserva(profesor, aula, permanencia);
          
        }
	
	public void anularReserva() {
            
		Consola.mostrarCabecera("Borrar cliente");
		try {
			Reserva reserva = leerReserva(Consola.leerProfesor());
			modelo.anularReserva(reserva);
			System.out.println("Reserva anulada correctamente.");
		} catch (OperationNotSupportedException|IllegalArgumentException e) {
			System.out.println(ERROR + e.getMessage());
		}
	}
	
	
	
	public void listarReservas() {
		Consola.mostrarCabecera("Listar reservas");
		String[]reservas = modelo.representarReservas();
		if (reservas.length > 0) {
			for (String reserva : reservas) {
				System.out.println(reserva);
			}
		} else {
			System.out.println("No hay reservas que listar.");
		}
	}
        
        public void listarReservasAula() {
		Consola.mostrarCabecera("Listar reservas aula");
                Aula aula = Consola.leerAula();
		Reserva[]reservasAula = modelo.getReservasAula(aula);
		if (reservasAula.length > 0) {
			for (Reserva reserva : reservasAula) {
				System.out.println(reserva);
			}
		} else {
			System.out.println("No hay reservas que listar.");
		}
	}
        public void listarReservasProfesor() {
		Consola.mostrarCabecera("Listar reservas profesor");
                Profesor profesor = Consola.leerProfesor();
		Reserva[]reservasProfesor = modelo.getReservasProfesor(profesor);
		if (reservasProfesor.length > 0) {
			for (Reserva reserva : reservasProfesor) {
				System.out.println(reserva);
			}
		} else {
			System.out.println("No hay reservas que listar.");
		}
	}
        
        public void listarReservasPermanencia() {
		Consola.mostrarCabecera("Listar reservas profesor");
                Permanencia permanencia = new Permanencia(Consola.leerDia(), Consola.leerTramo());
		Reserva[] reservasPermanencia = modelo.getReservasPermanencia(permanencia);
		if (reservasPermanencia.length > 0) {
			for (Reserva reserva : reservasPermanencia) {
				System.out.println(reserva);
			}
		} else {
			System.out.println("No hay reservas que listar.");
		}
	}
        
        public void consultarDisponibilidad(){
            Permanencia permanencia=new Permanencia(Consola.leerDia(),Consola.leerTramo());
            boolean aulaTramoDisponible= modelo.consultarDisponibilidad(Consola.leerAula(),permanencia);
            
            if(aulaTramoDisponible==true){
                
                System.out.println("Aula disponible");
            }else{
                System.out.println("Aula no disponible");
            }
        
        }    
}

