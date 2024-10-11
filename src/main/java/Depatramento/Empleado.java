package Depatramento;
import Reunion.tipoReunion;
public class Empleado {
    private String id;
    private String apellidos;
    private String nombres;
    private String correo;


    public Empleado(String id, String apellidos, String nombres, String correo) {
        this.id = id;
        this.apellidos = apellidos;
        this.nombres = nombres;
        this.correo = correo;
    }

    public String getId() {
        return id;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getNombres() {
        return nombres;
    }

    public String getCorreo() {
        return correo;
    }
}
