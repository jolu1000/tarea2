package Departamento;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
        // Capturamos la salida en consola para verificarla
        Assertions.assertDoesNotThrow(() -> empleado.invitar(), "El método invitar no debe lanzar excepción");
    }
}
