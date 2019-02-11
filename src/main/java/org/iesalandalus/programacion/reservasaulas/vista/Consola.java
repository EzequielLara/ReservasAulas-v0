/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iesalandalus.programacion.reservasaulas.vista;
import java.time.LocalDate;
import  org.iesalandalus.programacion.utilidades.Entrada ;
import java.time.format.DateTimeFormatter;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Aula;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Profesor;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Tramo;

/**
 *
 * @author Ezk24
 */
class Consola {
    
    private static final DateTimeFormatter FORMATO_DIA= DateTimeFormatter.ofPattern("dd/MM/aaaa");
    

    private Consola() {
          
    }

    public static void mostrarMenu() {
            mostrarCabecera("Gestión de Reserva de aulas");
            for (Opcion opcion: Opcion.values()) {
                    System.out.println(opcion);
            }
    }

    public static void mostrarCabecera(String mensaje) {
            System.out.printf("%n%s%n", mensaje);
            String cadena = "%0" + mensaje.length() + "d%n";
            System.out.println(String.format(cadena, 0).replace("0", "-"));
    }

    public static int elegirOpcion() {
            int ordinalOpcion;
            do {
                    System.out.print("\nElige una opción: ");
                    ordinalOpcion = Entrada.entero();
            } while (!Opcion.esOrdinalValido(ordinalOpcion));
            return ordinalOpcion;
    }

    public static Aula leerAula(){
    
        Aula aula=new Aula(leerNombreAula());
        return aula;
    }
    
    public static String leerNombreAula(){
    
        String nombreAula = null;
        do{
            System.out.println("Introduce nombre del aula");
            nombreAula=Entrada.cadena();
        }while(nombreAula==null||nombreAula.equals(""));
        
        return nombreAula;
    }
    
    
    public static Profesor leerProfesor(){
        
        System.out.print("Introduce el correo: ");
        String correo = Entrada.cadena();
        System.out.print("Introduce el teléfono: ");
        String telefono = Entrada.cadena();
        Profesor profesor = new Profesor(leerNombreProfesor(),correo,telefono);
        return profesor;
       
    }
    
    public static String leerNombreProfesor(){
    
        String nombreProfesor = null;
        do{
            System.out.println("Introduce nombre del profesor: ");
            nombreProfesor=Entrada.cadena();
        }while(nombreProfesor==null||nombreProfesor.equals(""));
        
        return nombreProfesor;
    }
    
    public static Tramo leerTramo(){
        int numero= 0;
     do{
        System.out.println("Elige tramo horario: 1.Si es por la mañana y 2.Si es por la tarde");
        numero=Entrada.entero();
     }while(numero==1||numero==2);
     
        if(numero==1){
            return Tramo.MANANA;
        }
        if(numero==2){
        
            return Tramo.TARDE;
        }
        return null;
    }
   
    public static LocalDate leerDia(){
     LocalDate fecha=null;
        do{
        System.out.println("Introduce una fecha con formato dd/mm/aaaa: ");
        fecha=LocalDate.parse(Entrada.cadena(), FORMATO_DIA);
       }while(fecha!=null);
        return fecha;
    }
}
