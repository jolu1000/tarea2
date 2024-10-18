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

    private Reunion reunion;
    private InformeReunion informeReunion;
    private Empleado organizador;
    private Empleado empleado1;
    private Empleado empleado2;
    private Path tempFile;

    @BeforeEach
    public void setUp() throws IOException {
        // Crear un archivo temporal para almacenar el informe
        tempFile = Files.createTempFile("informe_reunion_", ".txt");

        // Crear un organizador y dos empleados
        organizador = new Empleado("1", "García", "Juan", "juan.garcia@example.com");
        empleado1 = new Empleado("2", "Pérez", "Ana", "ana.perez@example.com");
        empleado2 = new Empleado("3", "López", "Carlos", "carlos.lopez@example.com");

        // Crear una reunión presencial para las pruebas
        reunion = new ReunionPresencial(organizador, tipoReunion.TECNICA, "Sala 101", Duration.ofMinutes(90));

        // Inicializar fecha de la reunión
        reunion.setFecha(new Date());

        reunion.iniciar();
        reunion.finalizar();  // Simulamos que ya terminó

        // Agregar asistencia a la reunión
        reunion.agregarAsistencia(new Asistencia(empleado1, Instant.now()));
        reunion.agregarAsistencia(new Asistencia(empleado2, Instant.now()));

        // Crear el objeto de InformeReunion con la reunión
        informeReunion = new InformeReunion(reunion);
    }

    @AfterEach
    public void tearDown() throws IOException {
        // Eliminar el archivo temporal después de cada prueba
        Files.deleteIfExists(tempFile);
    }

    @Test
    public void testGenerarInforme() throws IOException {
        // Generar el informe
        informeReunion.generar(tempFile.toString()); // Pasar la ruta del archivo temporal

        // Leer el contenido del archivo generado
        String contenidoInforme = Files.readString(tempFile);

        // Imprimir contenido para diagnóstico
        System.out.println("Contenido del informe:\n" + contenidoInforme);

        // Verificar que el archivo contenga la información básica de la reunión
        Assertions.assertTrue(contenidoInforme.contains("Informe de la Reunión"), "Debe contener el encabezado del informe.");
        Assertions.assertTrue(contenidoInforme.contains("Fecha: " + reunion.getFecha()), "Debe contener la fecha de la reunión.");
        Assertions.assertTrue(contenidoInforme.contains("Hora de inicio: " + reunion.getHoraInicio()), "Debe contener la hora de inicio.");
        Assertions.assertTrue(contenidoInforme.contains("Hora de fin: " + reunion.getHoraFin()), "Debe contener la hora de fin.");
        Assertions.assertTrue(contenidoInforme.contains("Duración real: " + reunion.calcularTiempoReal().toMinutes()), "Debe contener la duración real.");
        Assertions.assertTrue(contenidoInforme.contains("Tipo de reunión: " + reunion.getTipo().name()), "Debe contener el tipo de reunión.");
        Assertions.assertTrue(contenidoInforme.contains("Sala de la reunión: Sala 101"), "Debe contener la sala de la reunión.");

        // Verificar que los asistentes estén en el informe
        Assertions.assertTrue(contenidoInforme.contains("Lista de asistentes"), "Debe contener la lista de asistentes.");
        Assertions.assertTrue(contenidoInforme.contains("Ana Pérez"), "Debe listar a Ana Pérez como asistente.");
        Assertions.assertTrue(contenidoInforme.contains("Carlos López"), "Debe listar a Carlos López como asistente.");

        // Verificar si el archivo contiene las notas de la reunión (si las hay)
        Assertions.assertTrue(contenidoInforme.contains("Informe generado con éxito."), "El informe debe indicar que fue generado con éxito.");
    }
}





