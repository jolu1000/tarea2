package Reunion;
import java.time.Instant;
/**
 * La clase Invitación representa una invitación a una reunión.
 * Contiene la hora de la invitacion y la reunión a la que está asociada.
 *
 * @author Benjamin
 * @author Joaquin
 */
public class Invitacion {
    private Instant hora;
    private Reunion reunion;
    /**
     * Constructor de la clase Invitación.
     *
     * @param hora La hora de la invitacion.
     * @param reunion La reunión a la que está vinculada la invitación.
     */
    public Invitacion(Instant hora, Reunion reunion) {
        this.hora = hora;
        this.reunion = reunion;
    }
    /**
     * Getter que obtiene la hora.
     *
     * @return La hora de inicio.
     */
    public Instant getHora() {
        return hora;
    }
    /**
     * Getter que obtiene la reunión asociada a la invitación.
     *
     * @return La reunión asociada.
     */
    public Reunion getReunion() {
        return reunion;
    }
    /**
     * Setter que establece la hora de invitacion de la reunion.
     *
     * @param hora La nueva hora.
     */
    public void setHora(Instant hora) {
        this.hora = hora;
    }
    /**
     * Retorna una representación en cadena de la invitación, incluyendo la hora de invitacion la reunión.
     *
     * @return Una cadena representando la invitación.
     */
    @Override
    public String toString() {
        return "Invitación a la reunión a las " + hora;
    }
}
