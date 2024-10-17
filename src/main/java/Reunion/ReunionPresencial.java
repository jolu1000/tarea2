package Reunion;
import Departamento.Empleado;

public class ReunionPresencial extends Reunion {
    private String sala;


    public ReunionPresencial(Empleado organizador, tipoReunion tipo, String sala) {
        super(organizador, tipo);
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
