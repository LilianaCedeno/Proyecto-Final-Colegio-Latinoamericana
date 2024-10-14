package servicios;
import java.util.*;
import modelos.Alumno;
import modelos.Materia;
import java.io.*;

public class ArchivosServicio {
    private List<Alumno> alumnosACargar; // Lista para almacenar alumnos temporalmente
    private PromedioServicioImp promediosServicioImp; // Instancia para calcular promedios

    public ArchivosServicio() {
        alumnosACargar = new ArrayList<Alumno>();
        promediosServicioImp = new PromedioServicioImp();
    }

    /**Método para exportar los datos de los alumnos a un archivo
    Este método recibe un mapa de alumnos y una ruta de archivo, luego itera sobre los alumnos 
    y escribe sus datos en el archivo, calculando el promedio de sus notas.*/
    
    public void exportarDatos(Map<String, Alumno> alumnos, String ruta) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ruta))) {
            for (Map.Entry<String, Alumno> entry : alumnos.entrySet()) {
                Alumno alumno = entry.getValue();
                StringBuilder line = new StringBuilder();
                line.append("RUT: ").append(alumno.getRut()).append(", ");
                line.append("Nombre: ").append(alumno.getNombre()).append(", ");
                line.append("Apellido: ").append(alumno.getApellido()).append(", ");
                line.append("Dirección: ").append(alumno.getDireccion()).append(", ");
                line.append("Promedios: ");

                // Calculamps promedio de notas por materia
                for (Materia materia : alumno.getMaterias()) {
                	
                    double promedio = promediosServicioImp.calcularPromedio(materia.getNotas());
                    line.append(materia.getNombre()).append(": ").append(promedio).append(", ");
                }

                writer.write(line.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error al exportar los datos: " + e.getMessage());
        }
    }
}