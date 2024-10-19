import Departamento.Departamento;
import Departamento.Empleado;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

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

        // Aquí puedes usar un sistema de captura de salida (Output Stream) para verificar la salida del método invitar()
        // Para simplificar, simplemente verificamos que no hay excepciones en la llamada
        Assertions.assertDoesNotThrow(() -> departamento.invitar(), "No debería lanzar excepciones al invitar a los empleados.");
    }
}
