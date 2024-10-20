import Reunion.Reunion;
import Reunion.Invitacion;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.Instant;
import static org.junit.jupiter.api.Assertions.assertEquals;


class InvitacionTest {

    private Instant horaInvitacion;
    private Reunion reunion; // Se puede usar un objeto mock o una instancia real si es necesaria
    private Invitacion invitacion;

    @BeforeEach
    public void setUp() {
        // Definir la hora de la invitación
        horaInvitacion = Instant.now();

        // Crear una instancia de Reunion (puedes usar un mock si es necesario)
        reunion = new Reunion(null, null, null, null) {
            @Override
            public void iniciar() {
                // Implementación vacía para pruebas
            }

            @Override
            public void finalizar() {
                // Implementación vacía para pruebas
            }
        };

        // Crear una instancia de Reunion.Invitacion
        invitacion = new Invitacion(horaInvitacion, reunion);
    }

    @Test
    public void testCrearInvitacion() {
        // Verificar que la hora de la invitación sea la correcta
        assertEquals(horaInvitacion, invitacion.getHora(), "La hora de la invitación debe ser la misma que se asignó.");
    }

    @Test
    public void testSetHora() {
        // Cambiar la hora de la invitación
        Instant nuevaHora = Instant.now().plusSeconds(3600); // Hora de la invitación en 1 hora
        invitacion.setHora(nuevaHora);

        // Verificar que la nueva hora se haya establecido correctamente
        assertEquals(nuevaHora, invitacion.getHora(), "La hora de la invitación debe ser la nueva hora asignada.");
    }
}
