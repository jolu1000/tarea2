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
    // Getter para sala
    public String getSala() {
        return sala;
    }

    // Setter para sala
    public void setSala(String sala) {
        this.sala = sala;
    }

    // Método toString para representar la información de la reunión presencial
    @Override
    public String toString() {
        return "Reunion Presencial [sala=" + sala + ", organizador=" + getOrganizador().getNombre() + "]";
    }
}
