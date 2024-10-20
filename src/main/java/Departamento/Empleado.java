package Departamento;
import Reunion.Invitable;
import Reunion.Invitacion;

public class Empleado implements Invitable {
    private String id;
    private String apellidos;
    private String nombre;
    private String correo;

    public Empleado(String id, String apellidos, String nombre, String correo) {
        this.id = id;
        this.apellidos = apellidos;
        this.nombre = nombre;
        this.correo = correo;
    }

    @Override
    public void invitar(Invitacion invitacion) {
        System.out.println("Invitando al empleado: " + nombre + " " + apellidos);
        System.out.println("Invitación recibida: " + invitacion);
    }

    public String getId() {
        return id;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }

    @Override
    public String toString() {
        return nombre + " " + apellidos + ", id: " + id + ", correo: " + correo;
    }
}

