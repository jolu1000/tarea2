import Departamento.Asistencia;
import Departamento.Empleado;
import Reunion.Retraso;
import org.junit.jupiter.api.*;
import java.time.Instant;
import static org.junit.jupiter.api.Assertions.*;

class AsistenciaTest {

    private Empleado empleado;
    private Asistencia asistencia;
    private Instant horaLlegada;

    @BeforeEach
    public void setUp() {
        // Crear un empleado para las pruebas
        empleado = new Empleado("1", "García", "Juan", "juan.garcia@example.com");

        // Definir la hora de llegada
        horaLlegada = Instant.now();

        // Crear una instancia de Asistencia
        asistencia = new Asistencia(empleado, horaLlegada);
    }

    @Test
    public void testCrearAsistencia() {
        // Verificar que el empleado se haya asignado correctamente
        assertEquals(empleado, asistencia.getEmpleado(), "El empleado debe ser el mismo que se asignó.");

        // Verificar que la hora de llegada sea la correcta
        assertEquals(horaLlegada, asistencia.getHoraLlegada(), "La hora de llegada debe ser la misma que se asignó.");
    }

    @Test
    public void testRetraso() {
        // Inicialmente, el retraso debe ser nulo
        assertNull(asistencia.getRetraso(), "El retraso debe ser nulo al inicio.");

        // Establecer un retraso
        Instant horaRetraso = Instant.now().plusSeconds(600); // 10 minutos de retraso
        Retraso retraso = new Retraso(horaRetraso);
        asistencia.setRetraso(retraso);

        // Verificar que el retraso se haya establecido correctamente
        assertEquals(retraso, asistencia.getRetraso(), "El retraso debe ser el que se asignó.");
    }
}
