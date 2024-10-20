package pruebasunitarias;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import modelos.Alumno;
import modelos.Materia;
import modelos.MateriaEmum;
import servicios.AlumnoServicioImp;

public class TestAlumnoServicio {

    @InjectMocks
    private AlumnoServicioImp alumnoServicio;  // Instancia real para pruebas

    @Mock
    private AlumnoServicioImp alumnoServicioMock; // Mock para simular comportamiento

    private Materia matematicas;
    private Materia lenguaje;
    private Alumno mapu;

    @Before
    public void setUp() {
    	alumnoServicio = new AlumnoServicioImp();
        MockitoAnnotations.openMocks(this); // Inicializar mocks
        matematicas = new Materia(MateriaEmum.MATEMATICAS);
        lenguaje = new Materia(MateriaEmum.LENGUAJE);
        mapu = new Alumno("111", "Brayan", "Elgueta","calle 1");
        mapu.agregarMateria(matematicas);
        mapu.agregarMateria(lenguaje);
    }

    @Test
    public void testCrearAlumno() {
        alumnoServicio.crearAlumno(mapu);
        assertTrue(alumnoServicio.existeAlumno(mapu.getRut()));
    }


    @Test
    public void agregarMateriaTest() {
        alumnoServicio.crearAlumno(mapu);
        alumnoServicio.agregarMateria(mapu.getRut(), 1); // Agregar matemáticas
        List<Materia> materias = alumnoServicio.materiasPorAlumno(mapu.getRut());
       
        assertEquals(MateriaEmum.MATEMATICAS, materias.get(0).getNombre(), "La materia deberia ser Matematicas");
        assertEquals(MateriaEmum.LENGUAJE, materias.get(1).getNombre(), "La materia deberia ser Lenguaje");
    }

    @Test
    public void materiasPorAlumnosTest() {
        // Usamos el mock para simular la respuesta de materias
        when(alumnoServicioMock.materiasPorAlumno("1.111.111-1")).thenReturn(Arrays.asList(matematicas, lenguaje));

        List<Materia> materias = alumnoServicioMock.materiasPorAlumno("1.111.111-1");
        assertEquals(2, materias.size());
        assertEquals(MateriaEmum.MATEMATICAS, materias.get(0).getNombre());
        assertEquals(MateriaEmum.LENGUAJE, materias.get(1).getNombre());

        verify(alumnoServicioMock).materiasPorAlumno("1.111.111-1");
    }

    @Test
    public void listarAlumnosTest() {
        alumnoServicio.crearAlumno(mapu);
        Map<String, Alumno> alumnos = alumnoServicio.listarAlumnos();
        assertEquals(1, alumnos.size());
        assertEquals(mapu.getRut(), alumnos.get(mapu.getRut()).getRut(), "El rut del alumno debe coincidir");
    }
}