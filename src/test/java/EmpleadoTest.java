import Departamento.Empleado;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import Reunion.Reunion;
import Reunion.ReunionPresencial;
import Reunion.tipoReunion;
import Reunion.Invitacion;
import java.time.Duration;
import java.time.Instant;

class EmpleadoTest {
    private Empleado empleado;

    @BeforeEach
    public void setUp() {
        // Inicializar un nuevo empleado antes de cada prueba
        empleado = new Empleado("1", "García", "Juan", "juan.garcia@example.com");
    }

    @AfterEach
    public void tearDown() {
        // Limpiar la referencia al empleado después de cada prueba
        empleado = null;
    }

    @Test
    public void testGetId() {
        Assertions.assertEquals("1", empleado.getId(), "El ID del empleado debe ser '1'");
    }

    @Test
    public void testGetApellidos() {
        Assertions.assertEquals("García", empleado.getApellidos(), "Los apellidos del empleado deben ser 'García'");
    }

    @Test
    public void testGetNombre() {
        Assertions.assertEquals("Juan", empleado.getNombre(), "El nombre del empleado debe ser 'Juan'");
    }

    @Test
    public void testGetCorreo() {
        Assertions.assertEquals("juan.garcia@example.com", empleado.getCorreo(), "El correo del empleado debe ser 'juan.garcia@example.com'");
    }

    @Test
    public void testInvitar() {

        Reunion reunion = new ReunionPresencial(empleado, tipoReunion.TECNICA, "Sala 101", Duration.ofMinutes(90),Instant.now());
        Invitacion invitacion = new Invitacion(Instant.now(), reunion);

        // Capturamos la salida en consola para verificarla
        Assertions.assertDoesNotThrow(() -> empleado.invitar(invitacion), "El método invitar no debe lanzar excepción");
    }

    @Test
    public void testInvitarNullInvitacion() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            empleado.invitar(null);
        }, "Debería lanzar IllegalArgumentException si la invitación es nula.");
    }

    @Test
    public void testInvitarReunionNula() {
        // Crea una invitación con reunión nula
        Invitacion invitacion = new Invitacion(Instant.now(), null);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            empleado.invitar(invitacion);
        }, "Debería lanzar IllegalArgumentException si la reunión en la invitación es nula.");
    }

    @Test
    public void testInvitarSinOrganizador() {
        // Crea una reunión donde el organizador es nulo
        Reunion reunion = new ReunionPresencial(null, tipoReunion.TECNICA, "Sala 101", Duration.ofMinutes(90), Instant.now());
        Invitacion invitacion = new Invitacion(Instant.now(), reunion);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            empleado.invitar(invitacion);
        }, "Debería lanzar IllegalArgumentException si la reunión no tiene un organizador.");
    }
}
