package Biblioteca;

import java.io.*;
import java.util.Scanner;

class Biblioteca {
  public static void main (String args[]) {
    System.out.println("BIBLIOTECA");

    int opc;
    char usuario;
     Scanner lector = new Scanner(System.in);
    do {
       System.out.println();
       System.out.println("1. Ingresar usuario.");
       System.out.println("2. Actializar usuario.");
       System.out.println("3. Eliminar usuario.");
       System.out.println("4. Buscar usuario.");
       System.out.println("5. Salir");
       do {
          System.out.println("Digite una opción: ");
           opc = lector.nextInt();
         } while ((opc < 0) ||
		  (opc > 7));
         System.out.println();
         if (opc == 1)
            ingresarUsuario();
         else if (opc == 2)
            actualizarUsuario();
         else if (opc == 3)
            eliminarUsuario();
         else if (opc == 4)
            Usuario.buscarUsuario();
         
    } while (opc != 0);
   }

  private static void ingresarUsuario() {
    System.out.println("Ingresar usuario.");

   char nombre, apellido, nacimiento, cedula, direccion, telefono, areas;
   
          System.out.println("Nombre: ");
        String nombre = Terminal.nextstring();
        
        System.out.println("Apellido: ");
        String apellido = Terminal.nextstring();
        
        System.out.println("Fecha de nacimiento: ");
        String nacimiento = Terminal.nextstring();
        
        System.out.println("Cedula: ");
        String cedula = Terminal.nextstring();
        
        System.out.println("Dirección: ");
        String direccion = Terminal.nextstring();
        
        System.out.println("Telefono: ");
        String telefono = Terminal.nextstring();
        
        System.out.println("Areas favoritas: ");
        String areas = Terminal.nextstring();
        
    new Usuario(nombre,apellido,nacimiento,cedula,direccion,telefono,areas);
  }

  private static void actualizarUsuario() {
    System.out.println("Actualización de usuario.");

    char usuario;
    Usuario usuario;

    usuario = Terminal.nextstring("Nombre: ");
    
    Usuario.actualizarUsuario();
   
  }

  private static void eliminarUsuario() {
    System.out.println("Eliminar usuario.");

    char nombre;

    nombre = Terminal.leeEntero("Nombre: ");

     
    Usuario.elimoinarUsuario(nombre);
  }

  private static void buscarUsuario() {
    String nombreUsuario;
    File accesoUsuario;

    System.out.println("Buscar un usuario.");

  do { 
       System.out.println("Indique el nombre del usuario: ");
       nombreUsuario = Terminal.leeCadena("Nombre: ");

       accesoUsuario = new File(nombreUsuario);

       if (!accesoUsuario.exists()) 
          System.out.println("El usuario " + nombreUsuario +
                   " no existe. " );
    } while (!accesoUsuario.exists());

     try {
       FileInputStream canalUsuario =
                  new FileInputStream(accesoUsuario);

       Usuario.iniciaAreas();   

       int totalAreas = Fichero.leeInt(canalFichero,
                                        "TOTAl REAS:");

       for (int area=1; area <= totalAreas; area++)
         Area.recuperarAreas(canalFichero);   

       canalFichero.close();
     } catch (IOException excepcion) {
       System.out.println("Error abriendo el fichero " +
                   nombreFichero);
       excepcion.printStackTrace();
     }
  }

}