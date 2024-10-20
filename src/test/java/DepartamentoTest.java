import Departamento.Departamento;
import Departamento.Empleado;
import Reunion.Invitacion;
import Reunion.Reunion;
import Reunion.ReunionVirtual;
import Reunion.tipoReunion;
import java.time.Duration;
import java.time.Instant;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
/**
 * La clase DepartamentoTest muestra la ejecucion de distintos test empleados a los metodos
 * dentro de la clase Departamento.
 *
 *  * @author Benjamin
 *  * @author Joaquin
 */
class DepartamentoTest {

    private Departamento departamento;
    private Empleado empleado1;
    private Empleado empleado2;

    @BeforeEach
    public void setUp() {
        departamento = new Departamento("Recursos Humanos");
        empleado1 = new Empleado("1", "García", "Juan", "juan.garcia@example.com");
        empleado2 = new Empleado("2", "Pérez", "Ana", "ana.perez@example.com");
    }
    /**
     * Verifica que se pueden agregar empleados al departamento y que el conteo de empleados se actualiza correctamente.
     */
    @Test
    public void testAgregarEmpleado() {
        assertEquals(0, departamento.obtenerCantidadEmpleados(), "La cantidad de empleados debe ser 0.");
        departamento.agregarEmpleado(empleado1);
        assertEquals(1, departamento.obtenerCantidadEmpleados(), "La cantidad de empleados debe ser 1 después de agregar uno.");
        departamento.agregarEmpleado(empleado2);
        assertEquals(2, departamento.obtenerCantidadEmpleados(), "La cantidad de empleados debe ser 2 después de agregar otro.");
    }
    /**
     * Comprueba que al invitar a los empleados mediante una invitación, no se lanza ninguna excepción.
     */
    @Test
    public void testInvitar() {
        departamento.agregarEmpleado(empleado1);
        departamento.agregarEmpleado(empleado2);

        Reunion reunion = new ReunionVirtual(empleado1, tipoReunion.TECNICA, "https://zoom.us/j/1234567890", Duration.ofMinutes(90), Instant.now());
        Invitacion invitacion = new Invitacion(Instant.now(), reunion);
        Assertions.assertDoesNotThrow(() -> departamento.invitar(invitacion), "No debería lanzar excepciones al invitar a los empleados.");
    }
    /**
     * Asegura que se lanza una excepción al intentar agregar un empleado nulo al departamento.
     */
    @Test
    public void testAgregarEmpleadoNulo() {
        assertThrows(NullPointerException.class, () -> {
            departamento.agregarEmpleado(null);
        }, "Debería lanzar NullPointerException si se intenta agregar un empleado nulo.");
    }
    /**
     * Verifica que se lanza una excepción al intentar invitar a una reunión cuando no hay empleados en el departamento.
     */
    @Test
    public void testInvitarSinEmpleados() {
        Reunion reunion = new ReunionVirtual(empleado1, tipoReunion.TECNICA, "https://zoom.us/j/1234567890", Duration.ofMinutes(90), Instant.now());
        Invitacion invitacion = new Invitacion(Instant.now(), reunion);

        assertThrows(IllegalArgumentException.class, () -> {
            departamento.invitar(invitacion);
        }, "Debería lanzar IllegalStateException si no hay empleados en el departamento para invitar.");
    }
    /**
     * Comprueba que se lanza una excepción al intentar invitar a un empleado que no está en el departamento.
     */
    @Test
    public void testInvitarEmpleadoNoExistente() {
        departamento.agregarEmpleado(empleado1); // Solo agregar empleado1

        Reunion reunion = new ReunionVirtual(empleado2, tipoReunion.TECNICA, "https://zoom.us/j/1234567890", Duration.ofMinutes(90), Instant.now());
        Invitacion invitacion = new Invitacion(Instant.now(), reunion);

        assertThrows(IllegalArgumentException.class, () -> {
            departamento.invitar(invitacion);
        }, "Debería lanzar IllegalArgumentException si se intenta invitar a un empleado que no está en el departamento.");
    }

    /**
     * Verifica que al intentar agregar un empleado duplicado, el conteo de empleados no aumenta.
     */
    @Test
    public void testAgregarEmpleadoDuplicado() {
        departamento.agregarEmpleado(empleado1);
        assertEquals(1, departamento.obtenerCantidadEmpleados(), "La cantidad de empleados debe ser 1.");

        departamento.agregarEmpleado(empleado1);
        assertEquals(1, departamento.obtenerCantidadEmpleados(), "La cantidad de empleados no debe aumentar al agregar un empleado duplicado.");
    }
}
