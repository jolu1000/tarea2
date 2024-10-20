package Reunion;
import Departamento.Empleado;
import java.time.Instant;
import java.time.Duration;
/**
 * Clase extendida de Reunion que representa una reunión presencial.
 * Incluye información sobre los detalles básicos de una reunión.
 */
public class ReunionPresencial extends Reunion {
    private String sala;
    /**
     * Constructor de la clase ReunionPresencial.
     *
     * @param organizador  El empleado que organiza la reunión.
     * @param tipo        El tipo de reunión
     * @param sala        La sala donde se llevará a cabo la reunión.
     * @param duracion    La duración prevista de la reunión.
     * @param horaPrevista La hora prevista para el inicio de la reunión.
     * @throws IllegalArgumentException si la duración de la reunion es menor o igual a cero.
     */
    public ReunionPresencial(Empleado organizador, tipoReunion tipo, String sala, Duration duracion, Instant horaPrevista) {
        super(organizador, tipo, duracion, horaPrevista);
        if (duracion.isNegative() || duracion.isZero()) {
            throw new IllegalArgumentException("La duración debe ser mayor que cero.");
        }
        this.sala = sala;
    }
    /**
     * Getter que obtiene la sala de la reunión presencial.
     *
     * @return La sala donde se llevará a cabo la reunión.
     */
    public String getSala() {
        return sala;
    }
    /**
     * Setter que establece la nueva sala de la reunión presencial.
     *
     * @param sala La nueva sala donde se llevará a cabo la reunión.
     */
    public void setSala(String sala) {
        this.sala = sala;
    }
    /**
     * Genera una representación en forma de cadena de la reunión presencial,
     * que incluye la sala y el organizador.
     *
     * @return Una cadena que representa la reunión presencial.
     */
    @Override
    public String toString() {
        return "Reunion Presencial [sala=" + sala + ", organizador=" + getOrganizador().getNombre() + "]";
    }
}
