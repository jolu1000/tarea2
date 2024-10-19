import Reunion.Nota;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NotaTest {
    private Nota nota;

    @BeforeEach
    public void setUp() {
        // Inicializar un nuevo objeto Nota antes de cada prueba
        nota = new Nota("Esta es una nota de prueba.");
    }

    @AfterEach
    public void tearDown() {
        // Limpiar la referencia al objeto Nota después de cada prueba
        nota = null;
    }

    @Test
    public void testGetContenido() {
        // Verificar que el contenido inicial sea el correcto
        assertEquals("Esta es una nota de prueba.", nota.getContenido(), "El contenido debe ser el mismo que se asignó.");
    }

    @Test
    public void testSetContenido() {
        // Cambiar el contenido de la nota
        nota.setContenido("Este es un nuevo contenido.");

        // Verificar que el nuevo contenido sea el correcto
        assertEquals("Este es un nuevo contenido.", nota.getContenido(), "El contenido debe ser actualizado correctamente.");
    }
}

