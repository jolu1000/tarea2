package Departamento;

import java.time.Instant;
import Reunion.Retraso;

public class Asistencia {
    private Empleado empleado;
    private Instant horaLlegada;
    private Retraso retraso; // Cambiar de Duration a Retraso

    public Asistencia(Empleado empleado, Instant horaLlegada) {
        if (empleado == null) {
            throw new NullPointerException("El empleado no puede ser nulo.");
        }
        if (horaLlegada == null) {
            throw new NullPointerException("La hora de llegada no puede ser nula.");
        }
        this.empleado = empleado;
        this.horaLlegada = horaLlegada;
        this.retraso = null; // Inicialmente no hay retraso
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public Instant getHoraLlegada() {
        return horaLlegada;
    }

    public Retraso getRetraso() {
        return retraso;
    }

    public void setRetraso(Retraso retraso) {
        this.retraso = retraso; // Ahora se establece un objeto Retraso
    }

    @Override
    public String toString() {
        String resultado = empleado.getNombre() + " " + empleado.getApellidos(); // Nombre completo
        if (retraso != null) {
            resultado += " (retraso: " + retraso.getHora().toString() + ")"; // Mostrar la hora del retraso
        }
        return resultado;
    }
}

