import Reunion.Nota;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

    @Test
    public void testGetContenido() {
        assertEquals("Esta es una nota de prueba.", nota.getContenido(), "El contenido debe ser el mismo que se asignó.");
    }

    @Test
    public void testSetContenido() {
        nota.setContenido("Este es un nuevo contenido.");
        assertEquals("Este es un nuevo contenido.", nota.getContenido(), "El contenido debe ser actualizado correctamente.");
    }

    @Test
    public void testSetContenidoNulo() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            nota.setContenido(null);
        }, "Debería lanzar NullPointerException si se intenta asignar un contenido nulo.");
    }

    @Test
    public void testSetContenidoIgualAlAnterior() {
        nota.setContenido("Esta es una nota de prueba.");
        assertEquals("Esta es una nota de prueba.", nota.getContenido(), "El contenido debería seguir siendo el mismo.");
    }
}

