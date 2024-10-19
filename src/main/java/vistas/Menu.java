// En el paquete vistas
package vistas;

import modelos.Alumno;
import modelos.Materia;
import servicios.AlumnoServicio;
import servicios.ArchivosServicio;

public class Menu extends MenuTemplate {
    private AlumnoServicio alumnoServicio;
    private ArchivosServicio archivoServicio;

    public Menu() {
        this.alumnoServicio = new AlumnoServicio();
        this.archivoServicio = new ArchivosServicio();
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
        System.out.println("--- ¡Alumno agregado! ---");
    }

       /**Solicita el RUT del alumno y permite seleccionar la materia a añadir.
       Luego, llama a agregarMateria() en AlumnoServicio, envia la opción 
       seleccionada y el RUT. */
       
    @Override
    public void agregarMateria() {
        System.out.print("Ingresa RUT del alumno: ");
        String rut = leer.nextLine();
        System.out.println("Selecciona una Materia:");
        System.out.println("1. MATEMATICAS\n2. LENGUAJE\n3. CIENCIA\n4. HISTORIA");
        int opcion = leer.nextInt();
        leer.nextLine(); 

        alumnoServicio.agregarMateria(rut, opcion);
        System.out.println("--- ¡Materia agregada! ---");
    }

    @Override
    public void agregarNotaPasoUno() {
        System.out.print("Ingresa RUT del alumno: ");
        String rut = leer.nextLine();
        
        Alumno alumno = alumnoServicio.listarAlumnos().get(rut);
        if (alumno == null) {
            System.out.println("Alumno no encontrado.");
            return;
        }
        
        System.out.println("Alumno tiene las siguientes materias agregadas:");
        for (int i = 0; i < alumno.getMaterias().size(); i++) {
            System.out.println((i + 1) + ". " + alumno.getMaterias().get(i).getNombre());
        }
        
        System.out.print("Seleccionar materia: ");
        int opcion = leer.nextInt();
        leer.nextLine(); 
        
        if (opcion < 1 || opcion > alumno.getMaterias().size()) {
            System.out.println("Opción no válida.");
            return;
        }

        Materia materiaSeleccionada = alumno.getMaterias().get(opcion - 1);
        System.out.print("Ingresar nota: ");
        double nota = leer.nextDouble();
        leer.nextLine(); 
        alumnoServicio.agregarNota(rut, materiaSeleccionada.getNombre(), nota);
        System.out.println("--- ¡Nota agregada! ---");
    }

    @Override
    public void listarAlumnos() {
        alumnoServicio.listarAlumnos().forEach((rut, alumno) -> {
            System.out.println("Alumno: " + alumno);
        });
    }

    @Override
    public void terminarPrograma() {
        System.out.println("Programa finalizado.");
       
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
}

