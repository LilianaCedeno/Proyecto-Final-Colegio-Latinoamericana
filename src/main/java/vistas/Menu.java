// En el paquete vistas
package vistas;
import java.util.*;

import modelos.Alumno;
import modelos.Materia;
import servicios.AlumnoServicio;
import servicios.AlumnoServicioImp;
import servicios.ArchivosServicio;

public class Menu extends MenuTemplate {
    private AlumnoServicio alumnoServicio;
    private ArchivosServicio archivoServicio;

    public Menu() {
        alumnoServicio = new AlumnoServicioImp();
        archivoServicio = new ArchivosServicio();
    }

    
    /**toma los datos necesarios del alumno 
     * (RUT, nombre, apellido y dirección) y los pasa a
     *  crearAlumno() de AlumnoServicio para registrar el nuevo alumno.*/
  
       @Override
    public void crearAlumno() {
        Alumno alumno = new Alumno();
        System.out.print("Ingresa RUT: ");
        alumno.setRut(leer.nextLine());
        System.out.print("Ingresa nombre: ");
        alumno.setNombre(leer.nextLine());
        System.out.print("Ingresa apellido: ");
        alumno.setApellido(leer.nextLine());
        System.out.print("Ingresa dirección: ");
        alumno.setDireccion(leer.nextLine());

        alumnoServicio.crearAlumno(alumno);
        System.out.println( "\u001B[32m"+"------------------------"+"\u001B[0m");
        System.out.println( "\u001B[32m"+"¡Alumno agregado!"+"\u001B[0m");
        System.out.println( "\u001B[32m"+"------------------------"+"\u001B[0m");
    }

       /**Solicita el RUT del alumno y permite seleccionar la materia a añadir.
       Luego, llama a agregarMateria() en AlumnoServicio, envia la opción 
       seleccionada y el RUT. */
       
    @Override
    public void agregarMateria() {
        System.out.print("Ingresa RUT del alumno: ");
        String rut = leer.nextLine();
        
        // Verificamos si el RUT existe
        if (!alumnoServicio.existeAlumno(rut)) {
        	System.out.println( "\u001B[31m"+"------------------------------------------"+"\u001B[0m");
            System.out.println("\u001B[31m"+"-- ¡RUT no válido, Alumno no encontrado! --"+"\u001B[0m");
            System.out.println( "\u001B[31m"+"------------------------------------------"+"\u001B[0m");
            return; // Salimos del método si el RUT no es válido
        }
        
        /** Si el RUT es válido, muestra las materias disponibles.
         * de igual manera colocamos un do-while por si desea agregarle mas notas al alumno  */
        
        String resp;
        do {
	        System.out.println( "\u001B[33m"+"------------------------"+"\u001B[0m");
	        System.out.println("Selecciona una Materia:");
	        System.out.println( "\u001B[33m"+"------------------------"+"\u001B[0m");
	        System.out.println("1. MATEMATICAS\n2. LENGUAJE\n3. CIENCIA\n4. HISTORIA");
	        System.out.println( "\u001B[33m"+"------------------------"+"\u001B[0m");
	        
	        int opcion = leer.nextInt();
	        leer.nextLine(); 
	
	        // Validar que selecciones una de las 4materias
	        if (opcion < 1 || opcion > 4) {
	        	System.out.println( "\u001B[31m"+"------------------------"+"\u001B[0m");
	            System.out.println( "\u001B[31m"+"-- ¡Opción no válida! --"+"\u001B[0m");
	            System.out.println( "\u001B[31m"+"------------------------"+"\u001B[0m");
	            return; // Sale del método si la opción no es válida
	        }
	
	        // Llama al método para agregar la materia al alumno
	        alumnoServicio.agregarMateria(rut, opcion);
	        System.out.println( "\u001B[32m"+"------------------------"+"\u001B[0m");
	        System.out.println( "\u001B[32m"+"¡Materia agregada!"+"\u001B[0m");
	        System.out.println( "\u001B[32m"+"------------------------"+"\u001B[0m");
	        System.out.println( "\u001B[39m"+"------------------------"+"\u001B[0m");
	        System.out.println( "\u001B[39m"+"¡Desea agregar otra materia? (si - no)"+"\u001B[0m");
	        System.out.println( "\u001B[39m"+"------------------------"+"\u001B[0m");
	        resp= leer.nextLine();
	        
        }while(resp.equalsIgnoreCase("si"));
        
    }

  
    @Override
    public void agregarNotaPasoUno() {
        System.out.print("Ingresa RUT del alumno: ");
        String rut = leer.nextLine();

        // Verifica si el RUT existe en la lista de alumnos
        if (!alumnoServicio.existeAlumno(rut)) {
        	System.out.println( "\u001B[31m"+"------------------------------------------"+"\u001B[0m");
            System.out.println("\u001B[31m"+"-- ¡RUT no válido, Alumno no encontrado! --"+"\u001B[0m");
            System.out.println( "\u001B[31m"+"------------------------------------------"+"\u001B[0m");
            return; // Sale de la opcion de de agragar nota.
        }


        System.out.println("Alumno tiene las siguientes materias:");
        List<Materia> materias = alumnoServicio.materiasPorAlumno(rut);
        System.out.println( "\u001B[33m"+"------------------------"+"\u001B[0m");
        for (int i = 0; i < materias.size(); i++) {
            System.out.println((i + 1) + "- " + materias.get(i).getNombre());
        }
        System.out.println( "\u001B[33m"+"------------------------"+"\u001B[0m");
        System.out.print("Seleccionar materia: ");
        int opcion = leer.nextInt();
        leer.nextLine(); 

        // Verifica que la opción sea válida
        if (opcion < 1 || opcion > materias.size()) {
        	System.out.println( "\u001B[31m"+"------------------------"+"\u001B[0m");
            System.out.println( "\u001B[31m"+"-- ¡Opción no válida! --"+"\u001B[0m");
            System.out.println( "\u001B[31m"+"------------------------"+"\u001B[0m");
            return;
        }
        String r="";
        //while(true) {	
	        do {
	        	try {
	        	    System.out.print("Ingresar nota (0,1 y 7,0)");
			        double nota = leer.nextDouble();
			        	leer.nextLine();
			        	if (alumnoServicio.validarNota(nota)) {
			                // Agrega la nota a la materia correspondiente
					        alumnoServicio.agregarNota(rut, materias.get(opcion - 1).getNombre(), nota);
					        System.out.println( "\u001B[32m"+"------------------------"+"\u001B[0m");
					        System.out.println( "\u001B[32m"+"¡Nota agregada!"+"\u001B[0m");
					        System.out.println( "\u001B[32m"+"------------------------"+"\u001B[0m");
					        System.out.println("Desea agregar otra nota (si - no)");
					        r = leer.nextLine();
					        
			        	} else {
			                System.out.println("Nota en formato incorrecto. Debe estar entre 0,1 y 7,0. Inténtelo nuevamente.");
			            } 
		      }catch (InputMismatchException e) {
			            System.out.println("Entrada no válida. Por favor, ingrese un número decimal.");
			            leer.next(); 
	        	}
  	
	        }while(r.equalsIgnoreCase("si"));
	   
    	
     }

    @Override
    public void listarAlumnos() {
        alumnoServicio.listarAlumnos().forEach((rut, alumno) -> {
            System.out.println("Alumno: " + alumno);
            System.out.println( "\u001B[33m"+"--------------------------------------------------"+"\u001B[0m");
        });
    }

  
    /** Este método solicita la ruta para exportar los datos, 
     * luego llama a exportarDatos()
     *  del servicio ArchivosServicio, usando la lista de alumnos 
     *  para generar un archivo de salida.
     */
    
    @Override
    public void exportarDatos() {
        System.out.print("Ingresa la ruta para exportar datos: ");
        String ruta = leer.nextLine();
        archivoServicio.exportarDatos(alumnoServicio.listarAlumnos(), ruta);
        System.out.println("Datos exportados correctamente.");
    }
    
    @Override
    public void terminarPrograma() {
        System.out.println("Programa finalizado.");
    }
}

