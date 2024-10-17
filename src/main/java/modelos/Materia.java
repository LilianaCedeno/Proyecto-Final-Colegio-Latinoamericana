package modelos;

import java.util.ArrayList;
import java.util.List;

public class Materia {
    private MateriaEmum nombre; // Asegúrate de que el nombre sea de tipo MateriaEnum
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

	@Override
	public String toString() {
		return "Materia [nombre=" + nombre + ", notas=" + notas + "]";
	}
    
}
