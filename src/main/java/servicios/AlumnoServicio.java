// En el paquete servicios
package servicios;

import modelos.Alumno;
import modelos.Materia;
import modelos.MateriaEmum;

import java.util.*;

/**Esta clase se encargará de gestionar las operaciones 
 * relacionadas con el objeto Alumno, como crearlo, agregarle materias,
 *  y obtener su lista.*/

public class AlumnoServicio {
	
    private Map<String, Alumno> listaAlumnos;

    public AlumnoServicio() {
        this.listaAlumnos = new HashMap<>();
    }

    public void crearAlumno(Alumno alumno) {
        listaAlumnos.put(alumno.getRut(), alumno);
    }

    public void agregarMateria(String rut, int opcion) {
        Alumno alumno = listaAlumnos.get(rut);
        if (alumno != null) {
        	MateriaEmum materiaEnum = obtenerMateriaEnum(opcion);
            if (materiaEnum != null) {
                Materia nuevaMateria = new Materia(materiaEnum);
                nuevaMateria.setNombre(materiaEnum);
                alumno.agregarMateria(nuevaMateria);
            } else {
                System.out.println("Opción de materia no válida.");
            }
        } else {
            System.out.println("Alumno no encontrado.");
        }
    }

    // Método para agregar una nota a  materia del alumno por RUT debo revisar el funcionamiento
    //me esta dondo un erro.
    
    public void agregarNota(String rut, MateriaEmum nombreMateria, double nota) {
        
    	Alumno alumno = listaAlumnos.get(rut);
        if (alumno != null) {
        	alumno.agregarNota(nombreMateria, nota); // Se pasa el nombre de la materia
        } else {
            System.out.println("El alumno con RUT " + rut + " no existe.");
        }
    }

  /**Método para obtener una lista de materias de un alumno por su RUT*/
    
    public List<Materia> materiasPorAlumno(String rutAlumno) {
        
    	Alumno alumno = listaAlumnos.get(rutAlumno);
        if (alumno != null) {
            return alumno.getMaterias();
        } else {
            System.out.println("Alumno no encontrado.");
            return new ArrayList<>(); // Retonramos una lista vacía si no encuentra el alumno
        }
    }

    /** Método para listar todos los alumnos*/
    
    public Map<String, Alumno> listarAlumnos() {
        return listaAlumnos;
    }


    /** Método auxiliar para convertir la opción numérica en MateriaEnum*/
    
    private MateriaEmum obtenerMateriaEnum(int opcion) {
        switch (opcion) {
            case 1:
                return MateriaEmum.MATEMATICAS;
            case 2:
                return MateriaEmum.LENGUAJE;
            case 3:
                return MateriaEmum.CIENCIA;
            case 4:
                return MateriaEmum.HISTORIA;
            default:
                return null;
        }
    }
}
