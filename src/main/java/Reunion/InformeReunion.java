package Reunion;
import Departamento.Empleado;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import Departamento.Asistencia;

public class InformeReunion {

    private Reunion reunion;

    public InformeReunion(Reunion reunion) {
        this.reunion = reunion;
    }

    public void generar(String rutaArchivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo))) {
            writer.write("Informe de la Reunión\n");

            if (reunion.getFecha() != null) {
                writer.write("Fecha: " + reunion.getFecha().toString() + "\n");
            } else {
                writer.write("Fecha: No especificada\n");
            }

            // Escribir la hora de inicio y fin
            writer.write("Hora de inicio: " + reunion.getHoraInicio() + "\n");
            writer.write("Hora de fin: " + reunion.getHoraFin() + "\n");

            Duration duracionReal = reunion.calcularTiempoReal();
            writer.write("Duración real: " + duracionReal.toMinutes() + " minutos\n");

            writer.write("Tipo de reunión: " + reunion.getTipo().name() + "\n");

            if (reunion instanceof ReunionVirtual) {
                writer.write("Enlace de la reunión: " + ((ReunionVirtual) reunion).getEnlace() + "\n");
            } else if (reunion instanceof ReunionPresencial) {
                writer.write("Sala de la reunión: " + ((ReunionPresencial) reunion).getSala() + "\n");
            }

            writer.write("Lista de asistentes:\n");
            for (Asistencia asistencia : reunion.getAsistencias()) {
                Empleado empleado = asistencia.getEmpleado();
                writer.write("- " + empleado.getNombre() + " " + empleado.getApellidos() + "\n");
            }

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

