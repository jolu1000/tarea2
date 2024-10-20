import Reunion.Nota;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
/**
 * La clase NotaTest muestra la ejecucion de distintos test empleados a los metodos
 * dentro de la clase Nota.
 *
 *  * @author Benjamin
 *  * @author Joaquin
 */
class NotaTest {
    private Nota nota;

    @BeforeEach
    public void setUp() {
        nota = new Nota("Esta es una nota de prueba.");
    }

    @AfterEach
    public void tearDown() {
        nota = null;
    }
    /**
     * Verifica que se obtiene correctamente el contenido de la nota.
     */
    @Test
    public void testGetContenido() {
        assertEquals("Esta es una nota de prueba.", nota.getContenido(), "El contenido debe ser el mismo que se asignó.");
    }
    /**
     * Verifica que se actualiza correctamente el contenido de la nota.
     */
    @Test
    public void testSetContenido() {
        nota.setContenido("Este es un nuevo contenido.");
        assertEquals("Este es un nuevo contenido.", nota.getContenido(), "El contenido debe ser actualizado correctamente.");
    }
    /**
     * Verifica que se lanza una excepción al intentar asignar contenido nulo a la nota.
     */
    @Test
    public void testSetContenidoNulo() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            nota.setContenido(null);
        }, "Debería lanzar NullPointerException si se intenta asignar un contenido nulo.");
    }
    /**
     * Verifica que el contenido de la nota no cambia si se intenta asignar el mismo contenido.
     */
    @Test
    public void testSetContenidoIgualAlAnterior() {
        nota.setContenido("Esta es una nota de prueba.");
        assertEquals("Esta es una nota de prueba.", nota.getContenido(), "El contenido debería seguir siendo el mismo.");
    }
}

