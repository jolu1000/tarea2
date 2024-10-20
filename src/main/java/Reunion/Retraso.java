package Reunion;
import java.time.Instant;
/**
 * La clase Retraso muestra el retraso en la llegada de un empleado a una reunión.
 * Contiene la hora en que el empleado llegó con retraso.
 *
 * @author Benjamin
 * @author Joaquin
 */
public class Retraso {
    private Instant hora;
    /**
     * Constructor de la clase Retraso.
     *
     * @param hora La hora en que el empleado llegó con retraso.
     */
    public Retraso(Instant hora) {
        this.hora = hora;
    }
    /**
     * Getter que obtiene la hora del retraso.
     *
     * @return La hora de llegada del empleado con retraso.
     */
    public Instant getHora() {
        return hora;
    }
    /**
     * Setter que establece una nueva hora de retraso.
     *
     * @param hora La nueva hora del retraso.
     */
    public void setHora(Instant hora) {
        this.hora = hora;
    }
}
