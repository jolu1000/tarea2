package Reunion;

public class ReunionVirtual extends Reunion {
    private String enlace;


    public ReunionVirtual(Empleado organizador, tipoReunion tipo, String enlace) {
        super(organizador, tipo);
        this.enlace = enlace;
    }


}

