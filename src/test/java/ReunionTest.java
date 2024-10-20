import Reunion.Reunion;
import Reunion.ReunionPresencial;
import Reunion.tipoReunion;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.time.Duration;
import java.time.Instant;
import Departamento.Empleado;
import Departamento.Asistencia;
/**
 * La clase ReunionTest muestra la ejecucion de distintos test empleados a los metodos
 * dentro de la clase Reunion.
 *
 *  * @author Benjamin
 *  * @author Joaquin
 */
class ReunionTest {
    private Reunion reunion;
    private Empleado organizador;
    private Empleado empleado1;
    private Empleado empleado2;

    @BeforeEach
    public void setUp(){
        organizador = new Empleado("1", "García", "Juan", "juan.garcia@example.com");
        reunion = new ReunionPresencial(organizador, tipoReunion.TECNICA, "Sala 101", Duration.ofMinutes(90), Instant.now());
        empleado1 = new Empleado("2", "Pérez", "Ana", "ana.perez@example.com");
        empleado2 = new Empleado("3", "López", "Carlos", "carlos.lopez@example.com");
    }

    @AfterEach
    public void tearDown() {
        reunion = null;
        organizador = null;
        empleado1 = null;
        empleado2 = null;
    }
    /**
     * Verifica que se inicializa correctamente una reunión con los atributos esperados.
     */
    @Test
    public void testInicializacion(){
        Assertions.assertNotNull(reunion.getOrganizador());
        Assertions.assertEquals(90, reunion.getDuracionPrevista().toMinutes());
        Assertions.assertEquals(0, reunion.getAsistencias().size());;
    }
    /**
     * Verifica que se puede agregar correctamente la asistencia de un empleado a la reunión.
     */
    @Test
    public void testAgregarAsistencia() {
        Instant horaPrevista = Instant.now();
        Asistencia asistencia = new Asistencia(empleado1, horaPrevista);
        reunion.agregarAsistencia(asistencia);

        Assertions.assertEquals(1, reunion.getAsistencias().size());
        Assertions.assertEquals(empleado1, reunion.obtenerAsistencia().get(0));
    }

    /**
     * Verifica que se obtienen correctamente las ausencias de los empleados.
     */
    @Test
    public void testObtenerAusencia() {
        reunion.getInvitados().add(empleado1);
        reunion.getInvitados().add(empleado2);

        Assertions.assertEquals(2, reunion.obtenerAusencia().size()); // Ambos son ausentes al principio

        Instant horaPrevista = Instant.now();;
        Asistencia asistencia = new Asistencia(empleado1, horaPrevista);
        reunion.agregarAsistencia(asistencia);

        Assertions.assertEquals(1, reunion.obtenerAusencia().size()); // Solo empleado2 es ausente
    }
    /**
     * Verifica que se obtienen correctamente los retrasos de los empleados.
     */
    @Test
    public void testObtenerRetraso() {
        Instant horaPrevista = Instant.now().minusSeconds(10); // Hora prevista hace 10 segundos
        reunion = new ReunionPresencial(organizador, tipoReunion.TECNICA, "Sala 101", Duration.ofMinutes(90), horaPrevista); // Usar hora prevista

        Instant horaLlegada = Instant.now(); // Hora actual (empleado llega tarde)
        Asistencia asistencia = new Asistencia(empleado1, horaLlegada);
        reunion.agregarAsistencia(asistencia);

        Assertions.assertEquals(1, reunion.obtenerRetraso().size()); // Debería haber 1 empleado retrasado
        Assertions.assertEquals(empleado1, reunion.obtenerRetraso().get(0));
    }
    /**
     * Verifica que se cuenta correctamente el total de asistencias en la reunión.
     */
    @Test
    public void testObtenerTotalAsistencia() {
        reunion.agregarAsistencia(new Asistencia(empleado1, Instant.now()));
        reunion.agregarAsistencia(new Asistencia(empleado2, Instant.now()));

        Assertions.assertEquals(2, reunion.obtenerTotalAsistencia());
    }
    /**
     * Verifica que se obtiene correctamente el porcentaje de asistencia.
     */
    @Test
    public void testObtenerPorcentajeAsistencia() {
        reunion.getInvitados().add(empleado1);
        reunion.getInvitados().add(empleado2);

        reunion.agregarAsistencia(new Asistencia(empleado1, Instant.now()));

        Assertions.assertEquals(50.0, reunion.obtenerPorcentajeAsistencia(), 0.01);
    }
    /**
     * Verifica que se calcula correctamente el tiempo total de la reunión.
     */
    @Test
    public void testCalcularTiempoReal() {
        reunion.iniciar();
        Instant horaInicio = reunion.getHoraInicio();
        try {
            Thread.sleep(1000); // 1 segundo
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        reunion.finalizar();

        Duration tiempoReal = reunion.calcularTiempoReal();
        Assertions.assertTrue(tiempoReal.toMillis() >= 1000); // Debe ser al menos 1 segundo
    }
    /**
     * Verifica que se lanza una excepción al intentar obtener asistencia cuando hay un empleado nulo.
     */
    @Test
    public void testObtenerAsistenciaConEmpleadoNulo() {
        Asistencia asistenciaNula = new Asistencia(null, Instant.now());
        reunion.agregarAsistencia(asistenciaNula);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            reunion.obtenerAsistencia();
        });
    }
    /**
     * Verifica que se lanza una excepción al intentar crear una reunión con duración negativa.
     */
    @Test
    public void testReunionConDuracionNegativa() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new ReunionPresencial(organizador, tipoReunion.TECNICA, "Sala 101", Duration.ofMinutes(-30), Instant.now());
        }, "No debería permitir la creación de una reunión con duración negativa");
    }
    /**
     * Verifica que se lanza una excepción al intentar crear una reunión con duración cero.
     */
    @Test
    public void testReunionConDuracionCero() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new ReunionPresencial(organizador, tipoReunion.TECNICA, "Sala 101", Duration.ZERO, Instant.now());
        }, "No debería permitir la creación de una reunión con duración cero");
    }
    /**
     * Verifica que no hay retrasos si el empleado llega justo a tiempo.
     */
    @Test
    public void testObtenerRetrasoJustoATiempo() {
        Instant horaPrevista = Instant.now(); // Hora prevista
        reunion = new ReunionPresencial(organizador, tipoReunion.TECNICA, "Sala 101", Duration.ofMinutes(90), horaPrevista);

        // Usar la misma hora para la llegada
        Asistencia asistencia = new Asistencia(empleado1, horaPrevista);
        reunion.agregarAsistencia(asistencia);

        Assertions.assertEquals(0, reunion.obtenerRetraso().size(), "No debería haber retrasos si el empleado llegó a tiempo");
    }
}