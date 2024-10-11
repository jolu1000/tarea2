package Depatramento;
import Reunion.tipoReunion;
import java.util.ArrayList;
import java.util.List;

public class Departamento {
    private String nombre;
    private List<Empleado> empleados;

    public Departamento(String nombre) {
        this.nombre = nombre;
        this.empleados = new ArrayList<>();
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

