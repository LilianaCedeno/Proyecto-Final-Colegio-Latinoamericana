package servicios;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import modelos.Alumno;
import modelos.Materia;
import modelos.MateriaEmum;

/**clase  que gestionar las operaciones 
 * relacionadas con el Alumno, como crearlo, agregarle materias,
 *  y obtener su lista.*/
public class AlumnoServicioImp implements AlumnoServicio {
		
	private Map<String, Alumno> listaAlumnos;

	    public AlumnoServicioImp() {
	        this.listaAlumnos = new HashMap<>();
	    }

	    public void crearAlumno(Alumno alumno) {
	        listaAlumnos.put(alumno.getRut(), alumno);
	    }

	    public void agregarMateria(String rut, int opcion) {
	    	
	        Alumno alumno = listaAlumnos.get(rut);
	        
	           	MateriaEmum materiaEnum = obtenerMateriaEnum(opcion);
	           	
	            if (materiaEnum != null) {
	                Materia nuevaMateria = new Materia(materiaEnum);
	                nuevaMateria.setNombre(materiaEnum);
	                alumno.agregarMateria(nuevaMateria);
	            } else {
	            	System.out.println( "\u001B[31m"+"------------------------"+"\u001B[0m");
	                System.out.println( "\u001B[31m"+"-- ¡Opción de Materia no válida! --"+"\u001B[0m");
	                System.out.println( "\u001B[31m"+"------------------------"+"\u001B[0m");
	            }
	     }

	    // Método para agregar una nota a  materia del alumno por RUT debo revisar el funcionamiento
	    //me esta dondo un error.
	    
	    public void agregarNota(String rut, MateriaEmum nombreMateria, double nota) {
	        
	    	
		    	Alumno alumno = listaAlumnos.get(rut);
		        if (alumno != null) {
		        		alumno.agregarNota(nombreMateria, nota); // Se pasa el nombre de la materia y la nota.  // Asigna la nota si es válida
		                return; // aca para salir  del bucle
		                    	
		        } else {
		        	System.out.println( "\u001B[31m"+"------------------------------------------"+"\u001B[0m");
		            System.out.println("\u001B[31m"+"-- El alumno con RUT " + rut + " no existe.--"+"\u001B[0m");
		            System.out.println( "\u001B[31m"+"------------------------------------------"+"\u001B[0m");
		            System.out.println("");
		        }
	        
	    }

	    // esto es  lo que agregue estoy verificando estas loquita.-----------------------------------
	    public boolean existeAlumno(String rut) {
	        return listaAlumnos.containsKey(rut); 
	    }
	    
	    
	  /**Método para obtener una lista de materias de un alumno por su RUT*/
	    
	    public List<Materia> materiasPorAlumno(String rutAlumno) {
	        
	    	
		    	Alumno alumno = listaAlumnos.get(rutAlumno);
		        if (alumno != null) {
		        	 return alumno.getMaterias();
		            
		        } else {
		        	System.out.println( "\u001B[31m"+"------------------------------------------"+"\u001B[0m");
		            System.out.println("\u001B[31m"+"-- ¡RUT no válido, Alumno no encontrado! --"+"\u001B[0m");
		            System.out.println( "\u001B[31m"+"------------------------------------------"+"\u001B[0m");
		            return new ArrayList<>(); // Retonramos una lista vacía si no encuentra el alumno
		        }
		       
	    }

	    /** Método que retorma una lista de los alumnos*/
	    
	    public Map<String, Alumno> listarAlumnos() {
	    	 return listaAlumnos;
	    }


	    /** Método auxiliar para convertir la opción numérica en MateriaEnum*/
	    
	    public MateriaEmum obtenerMateriaEnum(int opcion) {
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
	    
	    public Boolean validarNota(Double n) {
			
	  		if (n >=0.1D && n<= 7) {
	  			return true;

	  		}else{
	  			System.out.println("Las notas deben ser del 0,1 al 7,0");
	  			return false;
	  		}
	  		
	  	}

}
