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
        empleado = new Empleado("1", "García", "Juan", "juan.garcia@example.com");
        horaLlegada = Instant.now();
        asistencia = new Asistencia(empleado, horaLlegada);
    }

    @Test
    public void testCrearAsistencia() {
        assertEquals(empleado, asistencia.getEmpleado(), "El empleado debe ser el mismo que se asignó.");
        assertEquals(horaLlegada, asistencia.getHoraLlegada(), "La hora de llegada debe ser la misma que se asignó.");
    }

    @Test
    public void testRetraso() {
        assertNull(asistencia.getRetraso(), "El retraso debe ser nulo al inicio.");
        Instant horaRetraso = Instant.now().plusSeconds(600);
        Retraso retraso = new Retraso(horaRetraso);
        asistencia.setRetraso(retraso);
        assertEquals(retraso, asistencia.getRetraso(), "El retraso debe ser el que se asignó.");
    }

    @Test
    public void testCrearAsistenciaEmpleadoNulo() {
        assertThrows(NullPointerException.class, () -> {
            asistencia = new Asistencia(null, horaLlegada);
        }, "Debería lanzar NullPointerException si el empleado es nulo.");
    }

    @Test
    public void testCrearAsistenciaHoraNula() {
        assertThrows(NullPointerException.class, () -> {
            asistencia = new Asistencia(empleado, null);
        }, "Debería lanzar NullPointerException si la hora de llegada es nula.");
    }
}
