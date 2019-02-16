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
    	private static final String ERROR = "ERROR: ---- ";
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
                        System.out.println("\nElige una opcion");
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
		Consola.mostrarCabecera("Borrar aula");
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
		Consola.mostrarCabecera("Borrar profesor");
                String nombreProfesor=Consola.leerNombreProfesor();
                Profesor profesor=null;
		try {
                        profesor = new Profesor(nombreProfesor,"dfsd@gmail.com");
			modelo.borrarProfesor(profesor);
			System.out.println("Profesor borrado correctamente.");
		} catch (OperationNotSupportedException|IllegalArgumentException e) {
			System.out.println(ERROR + e.getMessage());
		}
	}
	
	public void buscarProfesor() {
		Consola.mostrarCabecera("Buscar profesor");
		String nombreProfe = Consola.leerNombreProfesor();
                
		try {
			Profesor profesor= new Profesor(nombreProfe,"fdsa@gmail.com");
                        Profesor profesor2=modelo.buscarProfesor(profesor);
			if ( profesor2 == null) {
                            System.out.println("No existe ninguna profesor con dicho nombre.");
                        } else {
                            System.out.println("El profesor buscado es: " + profesor);
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
		Reserva reserva = null;
                Consola.mostrarCabecera("Realizar reserva");
                String nombreProfe=Consola.leerNombreProfesor();
                
                    Profesor profesorReserva = modelo.buscarProfesor(new Profesor(nombreProfe,"profe@bvh.com"));
                    if(profesorReserva==null){
                        System.out.println("Nombre de profesor no válido");
                        comenzar();
                    }else{
                         reserva=leerReserva(profesorReserva);
                    }        
		try{
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
                String nombreProfesor=Consola.leerNombreProfesor();
                Profesor profesor = new Profesor(nombreProfesor,"ddsl@lkd.com");
		try {
			Reserva reserva = leerReserva(profesor);
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
                            if(reserva!=null){
                            System.out.println(reserva);
			}
                        }
		} else {
			System.out.println("No hay reservas que listar.");
		}
	}
        public void listarReservasProfesor() {
            Consola.mostrarCabecera("Listar reservas profesor");
            Profesor profesor = new Profesor(Consola.leerNombreProfesor(),"profe@gsdd.com");
               
            Reserva[]reservasProfesor = modelo.getReservasProfesor(profesor);
            if (reservasProfesor.length > 0) {
                    for (Reserva reserva : reservasProfesor) {
                        if(reserva!=null){
                            System.out.println(reserva);
                        }
                    }    
            } else {
                    System.out.println("No hay reservas que listar.");
            }
                    
             
         }
                            
                            
                
	
        
        public void listarReservasPermanencia() {
		Consola.mostrarCabecera("Listar reservas profesor");
                Permanencia permanenciaReserva=new Permanencia(Consola.leerDia(),Consola.leerTramo());
		Reserva[] reservasPermanencia = modelo.getReservasPermanencia(permanenciaReserva);
                
		if (reservasPermanencia.length > 0) {
			for (Reserva reserva : reservasPermanencia) {
                            if(reserva!=null){
     
				System.out.println(reserva);
                            }
                        }
		}else{
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

