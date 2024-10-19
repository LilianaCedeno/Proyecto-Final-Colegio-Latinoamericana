
package servicios;

import java.util.List;
import java.util.Map;

import modelos.Alumno;
import modelos.Materia;
import modelos.MateriaEmum;

public interface AlumnoServicio {
	

	 public void agregarMateria(String rut, int opcion);
	 
	 public void agregarNota(String rut, MateriaEmum nombreMateria, double nota);
	 
	 public List<Materia> materiasPorAlumno(String rutAlumno);
	 
	 public Map<String, Alumno> listarAlumnos();
	 
	 public void crearAlumno(Alumno alumno);
	 
	 public boolean existeAlumno(String rut);
	 
	 public Boolean validarNota(Double n);
	 

}
