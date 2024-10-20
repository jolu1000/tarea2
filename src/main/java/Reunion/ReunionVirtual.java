package Reunion;
import Departamento.Empleado;
import java.time.Instant;
import java.time.Duration;
/**
 * Clase extendida de Reunion que representa una reunión virtual.
 * Incluye información sobre los detalles básicos de una reunión.
 */
public class ReunionVirtual extends Reunion {
    private String enlace;
    /**
     * Constructor de la clase ReunionVirtual.
     *
     * @param organizador El empleado que organiza la reunión.
     * @param tipo El tipo de reunión
     * @param enlace El enlace donde se llevará a cabo la reunión.
     * @param duracionPrevista La duración prevista de la reunión.
     * @param horaPrevista La hora prevista para el inicio de la reunión.
     * @throws IllegalArgumentException si la duración de la reunion es menor o igual a cero.
     */
    public ReunionVirtual(Empleado organizador, tipoReunion tipo, String enlace, Duration duracionPrevista, Instant horaPrevista) {
        super(organizador, tipo, duracionPrevista, horaPrevista);
        if (duracionPrevista.isNegative() || duracionPrevista.isZero()) {
            throw new IllegalArgumentException("La duración debe ser mayor que cero.");
        }
        this.enlace = enlace;
    }
    /**
     * Getter que obtiene el enlace de la reunión virtual.
     *
     * @return La sala donde se llevará a cabo la reunión.
     */
    public String getEnlace() {
        return enlace;
    }
    /**
     * Setter que establece el nuevo enlace de la reunión virtual.
     *
     * @param enlace El nuevo enlace donde se llevará a cabo la reunión.
     */
    public void setEnlace(String enlace) {
        this.enlace = enlace;
    }
    /**
     * Genera una representación en forma de cadena de la reunión virtual,
     * que incluye el enlace y el organizador.
     *
     * @return Una cadena que representa la reunión virtual.
     */
    @Override
    public String toString() {
        return "Reunion Virtual [enlace=" + enlace + ", organizador=" + getOrganizador().getNombre() + "]";
    }
}

