package Reunion;
import Departamento.Empleado;
import java.time.Instant;
import java.time.Duration;

public class ReunionVirtual extends Reunion {
    private String enlace;

    public ReunionVirtual(Empleado organizador, tipoReunion tipo, String enlace, Duration duracionPrevista, Instant horaPrevista) {
        super(organizador, tipo, duracionPrevista, horaPrevista);
        if (duracionPrevista.isNegative() || duracionPrevista.isZero()) {
            throw new IllegalArgumentException("La duración debe ser mayor que cero.");
        }
        this.enlace = enlace;
    }

    public String getEnlace() {
        return enlace;
    }

    public void setEnlace(String enlace) {
        this.enlace = enlace;
    }

    @Override
    public String toString() {
        return "Reunion Virtual [enlace=" + enlace + ", organizador=" + getOrganizador().getNombre() + "]";
    }
}

