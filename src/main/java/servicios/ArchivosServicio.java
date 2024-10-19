package servicios;
import java.util.*;

import modelos.Alumno;
import modelos.Materia;
import java.io.*;

public class ArchivosServicio {


    /**Método para exportar los datos de los alumnos a un archivo
    Este método recibe un mapa de alumnos y una ruta de archivo, luego itera sobre los alumnos 
    y escribe sus datos en el archivo, calculando el promedio de sus notas.*/
    
    public void exportarDatos(Map<String, Alumno> alumnos, String ruta) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ruta))) {

            writer.write("---------- PROMEDIOS ----------");
            writer.newLine();
            writer.newLine();

            for (Alumno alumno : alumnos.values()) {
                writer.write("Alumno: " + alumno.getRut() + " - " + alumno.getNombre() + " " + alumno.getApellido());
                writer.newLine();

                for (Materia materia : alumno.getMaterias()) {
                    List<Double> notas = materia.getNotas();
                    StringBuilder notasStr = new StringBuilder();

                    for (int i = 0; i < notas.size(); i++) {
                        notasStr.append(notas.get(i));
                        if (i < notas.size() - 1) {
                            notasStr.append(", ");
                        }
                    }

                    writer.write("Materia: " + materia.getNombre() + ", Notas: " + notasStr.toString() + ", Promedio: " + materia.calcularPromedio());
                    writer.newLine();
                }
                writer.newLine();
            }
            writer.write("------------------------------------------");
            System.out.println("Datos exportados correctamente a " + ruta);
        } catch (IOException e) {
            System.out.println("Error al exportar los datos: " + e.getMessage());
        }
    }
}