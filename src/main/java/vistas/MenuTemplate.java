package vistas;
import java.util.Scanner;

public abstract class MenuTemplate{

	public Scanner leer;

    public MenuTemplate() {
    	 leer = new Scanner(System.in);
    }
    
    public abstract void crearAlumno();
    public abstract void agregarMateria();
    public abstract void agregarNotaPasoUno();
    public abstract void listarAlumnos();
    public abstract void terminarPrograma();
    public abstract void exportarDatos();

    public void iniciarMenu() {
        int opcion;
        do {
        	
            System.out.println("1. Crear Alumnos");
            System.out.println("2. Listar Alumnos");
            System.out.println("3. Agregar Materias");
            System.out.println("4. Agregar Notas");
            System.out.println("5. Salir");
            System.out.println("6. Exportar Datos");
            System.out.print("Selecciona una opción: ");
            opcion = leer.nextInt();
            leer.nextLine(); // Consumimos el salto de línea generado por el int.
            
            switch (opcion) {
                case 1:
                	crearAlumno();
                break;
                case 2:
                	listarAlumnos();
                break;
                case 3: 
                	agregarMateria();
                break;
                case 4: 
                	agregarNotaPasoUno();
                	break;
               case 5:
                	terminarPrograma();// enviaré en un metodo la salida del menú
                	break;
                case 6: 
                	exportarDatos();
                	break;
                default: 
                	System.out.println("Opción inválida. Intente de nuevo.");
                	break;
            }
        } while (opcion != 5);
        //leer.close();
    }
}