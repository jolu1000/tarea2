package Depatramento;

import java.time.Instant;
import Reunion.Retraso;

public class Asistencia {
    private Empleado empleado;
    private Instant horaLlegada;
    private Retraso retraso;

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

    public Retraso getRetraso() {
        return retraso;
    }

    public void setRetraso(Retraso retraso) {
        this.retraso = retraso;
    }
}
