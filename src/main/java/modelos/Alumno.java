package modelos;

import java.util.*;

import interfaces.ILectura;

public class Alumno implements ILectura{
	 	
		private String rut;
	    private String nombre;
	    private String apellido;
	    private String direccion;
	    private List<Materia> materias;

	    public Alumno() {
	        materias = new ArrayList<>(); 
	    }

	    public String getRut() {
	        return rut;
	    }

	    public void setRut(String rut) {
	        this.rut = rut;
	    }

	    public String getNombre() {
	        return nombre;
	    }

	    public void setNombre(String nombre) {
	        this.nombre = nombre;
	    }

	    public String getApellido() {
	        return apellido;
	    }

	    public void setApellido(String apellido) {
	        this.apellido = apellido;
	    }

	    public String getDireccion() {
	        return direccion;
	    }

	    public void setDireccion(String direccion) {
	        this.direccion = direccion;
	    }

	    public List<Materia> getMaterias() {
	        return materias;
	    }

	    public void setMaterias(List<Materia> materias) {
	        this.materias = materias;
	    }

	   
	    public void agregarMateria(Materia materia) {
	        this.materias.add(materia);
	    }
	    
	    
	  // Método para agregar una nota a una materia específica
	    
	   
	    

	@Override
    public String toString() {
        return "Alumno [Rut=: " + rut + 
        		", Nombre: " + nombre + 
        		", apellido=" + apellido + 
        		", direccion=" + direccion + 
        		", materias=" +  materias+
        		"]";
    }
    
}
