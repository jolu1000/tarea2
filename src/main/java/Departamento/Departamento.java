package Departamento;
import java.util.ArrayList;
import java.util.List;
import Main.Invitable;

public class Departamento implements Invitable{
    private String nombre;
    private List<Empleado> empleados;

    public Departamento(String nombre) {
        this.nombre = nombre;
        this.empleados = new ArrayList<>();
    }

    @Override
    public void invitar() {
        System.out.println("Enviando invitaciones a todo el departamento: " + nombre);
        for (Empleado empleado : empleados) {
            empleado.invitar(); // Invitar a cada empleado del departamento
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
}

