package pruebasunitarias;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.assertEquals;
import servicios.PromedioServicioImp;

import java.util.*;

@DisplayName("Tests para la clase Calcular promedio")
public class TestPromedioServicioImp {

	 @Test
	    public void calcularPromedioTest() {
		 
	        PromedioServicioImp promedioServicio = new PromedioServicioImp();
	        
	        List<Double> notas = new ArrayList<>();
	        notas.add(5.0);
	        notas.add(6.0);
	        notas.add(7.0);
 
	      
	        double promedioEsperado = (5.0 + 6.0 + 7.0) / 3;
	        
	        // Comprobar que el promedio calculado es correcto
	        assertEquals(promedioEsperado, promedioServicio.calcularPromedio(notas), 0.001);
	    }
	
}
