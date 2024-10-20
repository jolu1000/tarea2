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

class DepartamentoTest {

    private Departamento departamento;
    private Empleado empleado1;
    private Empleado empleado2;

    @BeforeEach
    public void setUp() {
        // Crear un departamento
        departamento = new Departamento("Recursos Humanos");

        // Crear empleados para agregar al departamento
        empleado1 = new Empleado("1", "García", "Juan", "juan.garcia@example.com");
        empleado2 = new Empleado("2", "Pérez", "Ana", "ana.perez@example.com");
    }

    @Test
    public void testAgregarEmpleado() {
        // Verificar que inicialmente la cantidad de empleados sea 0
        assertEquals(0, departamento.obtenerCantidadEmpleados(), "La cantidad de empleados debe ser 0.");

        // Agregar un empleado
        departamento.agregarEmpleado(empleado1);
        assertEquals(1, departamento.obtenerCantidadEmpleados(), "La cantidad de empleados debe ser 1 después de agregar uno.");

        // Agregar otro empleado
        departamento.agregarEmpleado(empleado2);
        assertEquals(2, departamento.obtenerCantidadEmpleados(), "La cantidad de empleados debe ser 2 después de agregar otro.");
    }

    @Test
    public void testInvitar() {
        // Agregar empleados al departamento
        departamento.agregarEmpleado(empleado1);
        departamento.agregarEmpleado(empleado2);

        Reunion reunion = new ReunionVirtual(empleado1, tipoReunion.TECNICA, "https://zoom.us/j/1234567890", Duration.ofMinutes(90), Instant.now());
        Invitacion invitacion = new Invitacion(Instant.now(), reunion);

        // Aquí puedes usar un sistema de captura de salida (Output Stream) para verificar la salida del método invitar()
        // Para simplificar, simplemente verificamos que no hay excepciones en la llamada
        Assertions.assertDoesNotThrow(() -> departamento.invitar(invitacion), "No debería lanzar excepciones al invitar a los empleados.");
    }

    @Test
    public void testAgregarEmpleadoNulo() {
        assertThrows(NullPointerException.class, () -> {
            departamento.agregarEmpleado(null);
        }, "Debería lanzar NullPointerException si se intenta agregar un empleado nulo.");
    }

    @Test
    public void testInvitarSinEmpleados() {
        Reunion reunion = new ReunionVirtual(empleado1, tipoReunion.TECNICA, "https://zoom.us/j/1234567890", Duration.ofMinutes(90), Instant.now());
        Invitacion invitacion = new Invitacion(Instant.now(), reunion);

        assertThrows(IllegalArgumentException.class, () -> {
            departamento.invitar(invitacion);
        }, "Debería lanzar IllegalStateException si no hay empleados en el departamento para invitar.");
    }

    @Test
    public void testInvitarEmpleadoNoExistente() {
        departamento.agregarEmpleado(empleado1); // Solo agregar empleado1

        Reunion reunion = new ReunionVirtual(empleado2, tipoReunion.TECNICA, "https://zoom.us/j/1234567890", Duration.ofMinutes(90), Instant.now());
        Invitacion invitacion = new Invitacion(Instant.now(), reunion);

        assertThrows(IllegalArgumentException.class, () -> {
            departamento.invitar(invitacion);
        }, "Debería lanzar IllegalArgumentException si se intenta invitar a un empleado que no está en el departamento.");
    }

    @Test
    public void testAgregarEmpleadoDuplicado() {
        departamento.agregarEmpleado(empleado1);
        assertEquals(1, departamento.obtenerCantidadEmpleados(), "La cantidad de empleados debe ser 1.");

        departamento.agregarEmpleado(empleado1); // Agregar el mismo empleado nuevamente
        assertEquals(1, departamento.obtenerCantidadEmpleados(), "La cantidad de empleados no debe aumentar al agregar un empleado duplicado.");
    }


}
