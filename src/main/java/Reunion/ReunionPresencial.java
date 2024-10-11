package Reunion;

public class ReunionPresencial extends Reunion {
    private String sala;


    public ReunionPresencial(Empleado organizador, tipoReunion tipo, String sala) {
        super(organizador, tipo);
        this.sala = sala;
    }


}
