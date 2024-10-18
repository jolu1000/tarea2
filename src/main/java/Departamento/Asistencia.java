package Departamento;

import java.time.Instant;
import java.time.Duration;
import Reunion.Retraso;

public class Asistencia {
    private Empleado empleado;
    private Instant horaLlegada;
    private Duration retraso;

    public Asistencia(Empleado empleado, Instant horaLlegada) {
        this.empleado = empleado;
        this.horaLlegada = horaLlegada;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public Instant getHoraLlegada() {
        return horaLlegada;
    }

    public Duration getRetraso() {
        return retraso;
    }

    public void setRetraso(Duration retraso) {
        this.retraso = retraso;
    }
}
