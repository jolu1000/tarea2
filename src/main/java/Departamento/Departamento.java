package Departamento;
import java.util.ArrayList;
import java.util.List;
import Reunion.Invitable;
import Reunion.Invitacion;

public class Departamento implements Invitable{
    private String nombre;
    private List<Empleado> empleados;

    public Departamento(String nombre) {
        this.nombre = nombre;
        this.empleados = new ArrayList<>();
    }

    @Override
    public void invitar(Invitacion invitacion) {
        if (invitacion == null || invitacion.getReunion() == null) {
            throw new IllegalArgumentException("La invitación o la reunión no pueden ser nulas.");
        }

        Empleado empleadoInvitado = invitacion.getReunion().getOrganizador();
        if (!empleados.contains(empleadoInvitado)) {
            throw new IllegalArgumentException("El empleado " + empleadoInvitado.getNombre() + " no está en el departamento.");
        }

        System.out.println("Enviando invitaciones a todo el departamento: " + nombre);
        for (Empleado empleado : empleados) {
            empleado.invitar(invitacion);
        }
    }

    public void agregarEmpleado(Empleado empleado) {
        if (empleado == null) {
            throw new NullPointerException("No se puede agregar un empleado nulo.");
        }
        if (empleados.contains(empleado)) {
            return;
        }
        empleados.add(empleado);
    }

    public int obtenerCantidadEmpleados() {
        return empleados.size();
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }

    @Override
    public String toString() {
        String resultado = "Departamento: " + nombre + "\n";
        resultado += "Empleados:\n";

        if (empleados.isEmpty()) {
            resultado += "No hay empleados en este departamento.";
        } else {
            for (Empleado empleado : empleados) {
                resultado += empleado.getNombre() + " " + empleado.getApellidos() + "\n";
            }
        }

        return resultado;
    }
}

