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
        	System.out.println( "\u001B[34m"+"----------------------------"+"\u001B[0m");
            System.out.println( "\u001B[34m"+"--Colegio Latinoamericano--"+"\u001B[0m");
            System.out.println( "\u001B[34m"+"----------------------------"+"\u001B[0m");
        	
            System.out.println("1. Crear Alumnos");
            System.out.println("2. Listar Alumnos");
            System.out.println("3. Agregar Materias");
            System.out.println("4. Agregar Notas");
            System.out.println("5. Salir");
            System.out.println("6. Exportar Datos");
            System.out.println( "\u001B[34m"+"----------------------------"+"\u001B[0m");
            System.out.println("Selecciona una opción: ");
            System.out.println( "\u001B[34m"+"----------------------------"+"\u001B[0m");
            opcion = leer.nextInt();
            leer.nextLine(); 
            
            switch (opcion) {
                case 1:
                	System.out.println( "\u001B[34m"+"Llenando informacion del alumno"+"\u001B[0m");
                	System.out.println( "\u001B[34m"+"----------------------------"+"\u001B[0m");
                	crearAlumno();
                break;
                case 2:
                	System.out.println( "\u001B[34m"+"Lista de Alumnos"+"\u001B[0m");
                	System.out.println( "\u001B[34m"+"-----------------"+"\u001B[0m");
                	listarAlumnos();
                break;
                case 3: 
                	System.out.println( "\u001B[34m"+"Agregar materias a un Alumno."+"\u001B[0m");
                	System.out.println( "\u001B[34m"+"------------------------------"+"\u001B[0m");
                	agregarMateria();
                break;
                case 4: 
                	System.out.println( "\u001B[34m"+"Agregando notas a un Alumnos"+"\u001B[0m");
                	System.out.println( "\u001B[34m"+"-----------------"+"\u001B[0m");
                	agregarNotaPasoUno();
                	break;
               case 5:
                	terminarPrograma();
                	break;
                case 6: 
                	System.out.println( "\u001B[34m"+"Exportando Datos a Archivo txt"+"\u001B[0m");
                	System.out.println( "\u001B[34m"+"------------------------------"+"\u001B[0m");
                	exportarDatos();
                	break;
                default: 
                	System.out.println("Opción inválida. Intente de nuevo.");
                	break;
            }
        } while (opcion != 5);
        
    }
}