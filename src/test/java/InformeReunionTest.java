import Reunion.InformeReunion;
import Reunion.Reunion;
import Reunion.ReunionPresencial;
import Reunion.ReunionVirtual;
import Reunion.tipoReunion;
import Departamento.Empleado;
import Departamento.Asistencia;
import org.junit.jupiter.api.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;

class InformeReunionTest {
    /**
     * La clase InformeReunionTest muestra la ejecucion de distintos test empleados a los metodos
     * dentro de la clase InformeReunion.
     *
     *  * @author Benjamin
     *  * @author Joaquin
     */
    private Reunion reunion;
    private InformeReunion informeReunion;
    private Empleado organizador;
    private Empleado empleado1;
    private Empleado empleado2;
    private Path tempFile;

    @BeforeEach
    public void setUp() throws IOException {
        tempFile = Files.createTempFile("informe_reunion_", ".txt");
        organizador = new Empleado("1", "García", "Juan", "juan.garcia@example.com");
        empleado1 = new Empleado("2", "Pérez", "Ana", "ana.perez@example.com");
        empleado2 = new Empleado("3", "López", "Carlos", "carlos.lopez@example.com");
        reunion = new ReunionPresencial(organizador, tipoReunion.TECNICA, "Sala 101", Duration.ofMinutes(90), Instant.now());
        reunion.setFecha(new Date());
        reunion.iniciar();
        reunion.finalizar();
        reunion.agregarAsistencia(new Asistencia(empleado1, Instant.now()));
        reunion.agregarAsistencia(new Asistencia(empleado2, Instant.now()));
        informeReunion = new InformeReunion(reunion);
    }

    @AfterEach
    public void tearDown() throws IOException {
        Files.deleteIfExists(tempFile);
    }
    /**
     * Verifica que el informe de la reunión se genera correctamente y contiene la información esperada.
     */
    @Test
    public void testGenerarInforme() throws IOException {
        informeReunion.generar(tempFile.toString());
        String contenidoInforme = Files.readString(tempFile);
        System.out.println("Contenido del informe:\n" + contenidoInforme);
        Assertions.assertTrue(contenidoInforme.contains("Informe de la Reunión"), "Debe contener el encabezado del informe.");
        Assertions.assertTrue(contenidoInforme.contains("Fecha: " + reunion.getFecha()), "Debe contener la fecha de la reunión.");
        Assertions.assertTrue(contenidoInforme.contains("Hora de inicio: " + reunion.getHoraInicio()), "Debe contener la hora de inicio.");
        Assertions.assertTrue(contenidoInforme.contains("Hora de fin: " + reunion.getHoraFin()), "Debe contener la hora de fin.");
        Assertions.assertTrue(contenidoInforme.contains("Duración real: " + reunion.calcularTiempoReal().toMinutes()), "Debe contener la duración real.");
        Assertions.assertTrue(contenidoInforme.contains("Tipo de reunión: " + reunion.getTipo().name()), "Debe contener el tipo de reunión.");
        Assertions.assertTrue(contenidoInforme.contains("Sala de la reunión: Sala 101"), "Debe contener la sala de la reunión.");
        Assertions.assertTrue(contenidoInforme.contains("Lista de asistentes"), "Debe contener la lista de asistentes.");
        Assertions.assertTrue(contenidoInforme.contains("Ana Pérez"), "Debe listar a Ana Pérez como asistente.");
        Assertions.assertTrue(contenidoInforme.contains("Carlos López"), "Debe listar a Carlos López como asistente.");
        Assertions.assertTrue(contenidoInforme.contains("Informe generado con éxito."), "El informe debe indicar que fue generado con éxito.");
    }
}





