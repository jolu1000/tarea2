package Main;
import Reunion.Reunion;

import java.time.Instant;

public class Invitacion {
    private Instant hora;

    public Invitacion(Instant hora, Reunion reunion) {
        this.hora = hora;
    }

    // Getter para la hora de la invitación
    public Instant getHora() {
        return hora;
    }

    // Setter para la hora de la invitación
    public void setHora(Instant hora) {
        this.hora = hora;
    }
}