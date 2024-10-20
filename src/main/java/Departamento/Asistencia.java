package Departamento;
import java.time.Instant;
import Reunion.Retraso;
/**
 * La clase Asistencia representa la asistencia de un empleado a una reunión. Incluye datos
 * del empleado, la hora de llegada y si hubo un retraso.
 *  * @author Benjamin
 *  * @author Joaquin
 */
public class Asistencia {
    private Empleado empleado;
    private Instant horaLlegada;
    private Retraso retraso;
    /**
     * Constructor de la clase Asistencia.
     *
     * @param empleado Indica el empleado que asistio a la reunion.
     * @param horaLlegada Indica la hora de llegada del empleado a la reunion.
     * @throws NullPointerException Se muestra si el empleado o la hora de llegada son nulos.
     */
    public Asistencia(Empleado empleado, Instant horaLlegada) {
        if (empleado == null) {
            throw new NullPointerException("El empleado no puede ser nulo.");
        }
        if (horaLlegada == null) {
            throw new NullPointerException("La hora de llegada no puede ser nula.");
        }
        this.empleado = empleado;
        this.horaLlegada = horaLlegada;
        this.retraso = null;
    }

    /**
     * Getter que obtiene el empleado que asistió.
     *
     * @return El empleado.
     */
    public Empleado getEmpleado() {
        return empleado;
    }
    /**
     * Getter que obtiene la hora de llegada del empleado.
     *
     * @return La hora de llegada.
     */
    public Instant getHoraLlegada() {
        return horaLlegada;
    }
    /**
     * Getter que obtiene el retraso del empleado (si existe).
     *
     * @return El retraso (o null si no hubo retraso).
     */
    public Retraso getRetraso() {
        return retraso;
    }
    /**
     * Setter que establece un retraso para el empleado.
     *
     * @param retraso El retraso del empleado.
     */
    public void setRetraso(Retraso retraso) {
        this.retraso = retraso;
    }
    /**
     * Devuelve una representación en cadena de la asistencia del empleado, incluyendo sus datos,
     * la hora de llegada y si hubo un retraso.
     *
     * @return Una cadena que representa la asistencia del empleado.
     */
    @Override
    public String toString() {
        String resultado = empleado.getNombre() + " " + empleado.getApellidos();
        if (retraso != null) {
            resultado += " (retraso: " + retraso.getHora().toString() + ")";
        }
        return resultado;
    }
}

