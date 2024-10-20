package modelos;

import java.util.ArrayList;
import java.util.List;

import servicios.PromedioServicioImp;

public class Materia {
    private MateriaEmum nombre; 
    private List<Double> notas;

    public Materia(MateriaEmum nombre) {
        this.nombre = nombre;
        this.notas = new ArrayList<>();
    }

    public MateriaEmum getNombre() {
        return nombre;
    }

    public void setNombre(MateriaEmum nombre) {
        this.nombre = nombre;
    }

    public List<Double> getNotas() {
        return notas;
    }

    public void agregarNota(double nota) {
        notas.add(nota); // Método para agregar una nota a la materia
    }
    
    public double calcularPromedio() {
    	PromedioServicioImp servicioPromedio = new PromedioServicioImp();
    	return servicioPromedio.calcularPromedio(notas);
    }

	@Override
	public String toString() {
		return "Materia [nombre=" + nombre + ", notas=" + notas + "]";
	}
    
}
