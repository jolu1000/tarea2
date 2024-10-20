package Reunion;
import java.time.Instant;

public class Invitacion {
    private Instant hora;
    private Reunion reunion;

    public Invitacion(Instant hora, Reunion reunion) {
        this.hora = hora;
        this.reunion = reunion;
    }

    public Instant getHora() {
        return hora;
    }

    public Reunion getReunion() {
        return reunion;
    }


    @Override
    public String toString() {
        return "Invitación a la reunión a las " + hora;
    }

    public void setHora(Instant hora) {
        this.hora = hora;
    }
}
