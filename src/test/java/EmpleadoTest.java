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
/**
 * La clase EmpleadoTest muestra la ejecucion de distintos test empleados a los metodos
 * dentro de la clase Empleados.
 *
 *  * @author Benjamin
 *  * @author Joaquin
 */
class EmpleadoTest {
    private Empleado empleado;

    @BeforeEach
    public void setUp() {
        empleado = new Empleado("1", "García", "Juan", "juan.garcia@example.com");
    }

    @AfterEach
    public void tearDown() {
        empleado = null;
    }
    /**
     * Verifica que se obtenga correctamente el ID del empleado.
     */
    @Test
    public void testGetId() {
        Assertions.assertEquals("1", empleado.getId(), "El ID del empleado debe ser '1'");
    }
    /**
     * Verifica que se obtenga correctamente el apellido del empleado.
     */
    @Test
    public void testGetApellidos() {
        Assertions.assertEquals("García", empleado.getApellidos(), "Los apellidos del empleado deben ser 'García'");
    }
    /**
     * Verifica que se obtenga correctamente el nombre del empleado.
     */
    @Test
    public void testGetNombre() {
        Assertions.assertEquals("Juan", empleado.getNombre(), "El nombre del empleado debe ser 'Juan'");
    }
    /**
     * Verifica que se obtenga correctamente el correo del empleado.
     */
    @Test
    public void testGetCorreo() {
        Assertions.assertEquals("juan.garcia@example.com", empleado.getCorreo(), "El correo del empleado debe ser 'juan.garcia@example.com'");
    }
    /**
     * Verifica que el método invitar no lanza excepciones cuando se le pasa una invitación válida.
     */
    @Test
    public void testInvitar() {

        Reunion reunion = new ReunionPresencial(empleado, tipoReunion.TECNICA, "Sala 101", Duration.ofMinutes(90),Instant.now());
        Invitacion invitacion = new Invitacion(Instant.now(), reunion);
        Assertions.assertDoesNotThrow(() -> empleado.invitar(invitacion), "El método invitar no debe lanzar excepción");
    }
    /**
     * Verifica que se lanza una excepcion si se intenta invitar con una invitación nula.
     */
    @Test
    public void testInvitarNullInvitacion() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            empleado.invitar(null);
        }, "Debería lanzar IllegalArgumentException si la invitación es nula.");
    }
    /**
     * Verifica que se lanza una excepcion si la invitación tiene una reunión nula.
     */
    @Test
    public void testInvitarReunionNula() {
        // Crea una invitación con reunión nula
        Invitacion invitacion = new Invitacion(Instant.now(), null);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            empleado.invitar(invitacion);
        }, "Debería lanzar IllegalArgumentException si la reunión en la invitación es nula.");
    }
    /**
     * Verifica que se lanza una excepcion si la reunión no tiene un organizador.
     */
    @Test
    public void testInvitarSinOrganizador() {
        Reunion reunion = new ReunionPresencial(null, tipoReunion.TECNICA, "Sala 101", Duration.ofMinutes(90), Instant.now());
        Invitacion invitacion = new Invitacion(Instant.now(), reunion);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            empleado.invitar(invitacion);
        }, "Debería lanzar IllegalArgumentException si la reunión no tiene un organizador.");
    }
}
