import Reunion.Reunion;
import Reunion.Invitacion;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.Instant;
import static org.junit.jupiter.api.Assertions.assertEquals;
/**
 * La clase InvitacionTest muestra la ejecucion de distintos test empleados a los metodos
 * dentro de la clase Invitacion.
 *
 *  * @author Benjamin
 *  * @author Joaquin
 */
class InvitacionTest {

    private Instant horaInvitacion;
    private Reunion reunion;
    private Invitacion invitacion;

    @BeforeEach
    public void setUp() {
        horaInvitacion = Instant.now();
        reunion = new Reunion(null, null, null, null) {
            @Override
            public void iniciar() {
            }

            @Override
            public void finalizar() {
            }
        };
        invitacion = new Invitacion(horaInvitacion, reunion);
    }
    /**
     * Verifica que se crea correctamente una invitación con la hora asignada.
     */
    @Test
    public void testCrearInvitacion() {
        assertEquals(horaInvitacion, invitacion.getHora(), "La hora de la invitación debe ser la misma que se asignó.");
    }
    /**
     * Verifica que se actualiza correctamente la hora de la invitacion.
     */
    @Test
    public void testSetHora() {
        Instant nuevaHora = Instant.now().plusSeconds(3600);
        invitacion.setHora(nuevaHora);
        assertEquals(nuevaHora, invitacion.getHora(), "La hora de la invitación debe ser la nueva hora asignada.");
    }
    /**
     * Verifica que se crea correctamente una invitación con una hora futura.
     */
    @Test
    public void testCrearInvitacionConHoraFutura() {
        Instant futuraHora = Instant.now().plusSeconds(7200);
        Invitacion invitacionFutura = new Invitacion(futuraHora, reunion);
        assertEquals(futuraHora, invitacionFutura.getHora(), "La hora de la invitación debe ser la misma que se asignó.");
    }
    /**
     * Verifica que se crea correctamente una invitación con una hora pasada.
     */
    @Test
    public void testCrearInvitacionConHoraPasada() {
        Instant pasadaHora = Instant.now().minusSeconds(7200);
        Invitacion invitacionPasada = new Invitacion(pasadaHora, reunion);
        assertEquals(pasadaHora, invitacionPasada.getHora(), "La hora de la invitación debe ser la misma que se asignó.");
    }
}
