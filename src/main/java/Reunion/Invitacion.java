package Reunion;

import java.time.Instant;

public class Invitacion {
    private Instant hora;

    public Invitacion(Instant hora, Reunion reunion) {
        this.hora = hora;
    }

    public Instant getHora() {
        return hora;
    }

    public void setHora(Instant hora) {
        this.hora = hora;
    }

    @Override
    public String toString() {
        return "Invitación a la reunión a las " + hora;
    }
}