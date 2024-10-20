package Reunion;
import Departamento.Empleado;
import java.time.Instant;
import java.time.Duration;


public class ReunionPresencial extends Reunion {
    private String sala;


    public ReunionPresencial(Empleado organizador, tipoReunion tipo, String sala, Duration duracion, Instant horaPrevista) {
        super(organizador, tipo, duracion, horaPrevista);
        if (duracion.isNegative() || duracion.isZero()) {
            throw new IllegalArgumentException("La duración debe ser mayor que cero.");
        }
        this.sala = sala;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    @Override
    public String toString() {
        return "Reunion Presencial [sala=" + sala + ", organizador=" + getOrganizador().getNombre() + "]";
    }
}
