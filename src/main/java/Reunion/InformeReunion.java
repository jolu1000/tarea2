package Reunion;
import Departamento.Empleado;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import Departamento.Asistencia;
/**
 * La clase InformeReunion se encarga de generar un informe detallado sobre una reunión específica.
 * El informe se escribe en un archivo de texto y contiene información clave sobre la reunión,
 * como la fecha, la hora de inicio y fin, el tipo de reunión, la lista de asistentes,
 * y las notas relevantes.
 *
 * @author Benjamin
 * @author Joaquin
 */
public class InformeReunion {
    private Reunion reunion;
    /**
     * Constructor de la clase InformeReunion.
     *
     * @param reunion La reunión de la cual se generará el informe.
     */
    public InformeReunion(Reunion reunion) {
        this.reunion = reunion;
    }

    /**
     * Genera un informe sobre la reunión y lo guarda en el archivo especificado.
     *
     * @param rutaArchivo La ruta del archivo donde se guardará el informe.
     */
    public void generar(String rutaArchivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo))) {
            writer.write("Informe de la Reunión\n");
            // Escribe la fecha de la reunión.
            if (reunion.getFecha() != null) {
                writer.write("Fecha: " + reunion.getFecha().toString() + "\n");
            } else {
                writer.write("Fecha: No especificada\n");
            }

            // Escribe la hora de inicio y fin.
            writer.write("Hora de inicio: " + reunion.getHoraInicio() + "\n");
            writer.write("Hora de fin: " + reunion.getHoraFin() + "\n");

            //Escribe la duracion de la reunion.
            Duration duracionReal = reunion.calcularTiempoReal();
            writer.write("Duración real: " + duracionReal.toMinutes() + " minutos\n");

            //Escribe el tipo de reunion.
            writer.write("Tipo de reunión: " + reunion.getTipo().name() + "\n");

            //Escribe la sala (si la reunion fue presencial) o el enlace (si la reunion fue virtual)
            if (reunion instanceof ReunionVirtual) {
                writer.write("Enlace de la reunión: " + ((ReunionVirtual) reunion).getEnlace() + "\n");
            } else if (reunion instanceof ReunionPresencial) {
                writer.write("Sala de la reunión: " + ((ReunionPresencial) reunion).getSala() + "\n");
            }
            //Escribe la lista de los asistentes de la reunion.
            writer.write("Lista de asistentes:\n");
            for (Asistencia asistencia : reunion.getAsistencias()) {
                Empleado empleado = asistencia.getEmpleado();
                writer.write("- " + empleado.getNombre() + " " + empleado.getApellidos() + "\n");
            }
            //Esbribe la nota de la reunion.
            writer.write("Notas de la reunión:\n");
            for (Nota nota : reunion.getNotas()) {
                writer.write("- " + nota.getContenido() + "\n");
            }

            writer.write("Informe generado con éxito.\n");

        } catch (IOException e) {
            System.out.println("Error al generar el informe: " + e.getMessage());
        }
    }
}

