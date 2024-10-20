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
        System.out.println("Enviando invitaciones a todo el departamento: " + nombre);
        for (Empleado empleado : empleados) {
            empleado.invitar(invitacion); // Invitar a cada empleado del departamento
        }
    }

    public void agregarEmpleado(Empleado empleado) {
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
                resultado += empleado.getNombre() + " " + empleado.getApellidos() + "\n"; // Asumiendo que Empleado tiene getNombre() y getApellidos()
            }
        }

        return resultado;
    }
}

