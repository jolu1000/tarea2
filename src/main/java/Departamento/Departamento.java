package Departamento;
import java.util.ArrayList;
import java.util.List;
import Reunion.Invitable;
import Reunion.Invitacion;
/**
 * La clase Departamento representa un departamento de la empresa que contiene una lista de empleados.
 * Cada departamento recibe invitaciones para reuniones y se encarga de enviarlas
 * a todos sus empleados.
 *
 * @author Benjamin
 * @author Joaquin
 */
public class Departamento implements Invitable{
    private String nombre;
    private List<Empleado> empleados;
    /**
     * Constructor de la clase Departamento.
     *
     * @param nombre El nombre del departamento.
     */
    public Departamento(String nombre) {
        this.nombre = nombre;
        this.empleados = new ArrayList<>(); // Inicializa la lista de empleados como una lista vacía.
    }
    /**
     * Envía una invitación a todos los empleados del departamento
     *
     * @param invitacion La invitación a la reunión.
     * @throws IllegalArgumentException Si la invitación o la reunión son nulas, o si el organizador
     *                                  no pertenece al departamento.
     */
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
    /**
     * Agrega un empleado a la lista de empleados del departamento.
     *
     * @param empleado El empleado a agregar.
     * @throws NullPointerException Si el empleado es nulo.
     */
    public void agregarEmpleado(Empleado empleado) {
        if (empleado == null) {
            throw new NullPointerException("No se puede agregar un empleado nulo.");
        }
        if (empleados.contains(empleado)) {
            return;
        }
        empleados.add(empleado);
    }
    /**
     * Obtiene la cantidad total de empleados en el departamento.
     *
     * @return El total de empleados.
     */
    public int obtenerCantidadEmpleados() {
        return empleados.size();
    }
    /**
     * Getter que obtiene el nombre del departamento.
     *
     * @return El nombre del departamento.
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * Setter que stablece el nombre del departamento.
     *
     * @param nombre El nuevo nombre del departamento.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * Getter que obtiene la lista de empleados del departamento.
     *
     * @return La lista de empleados del departamento.
     */
    public List<Empleado> getEmpleados() {
        return empleados;
    }
    /**
     * Devuelve una representación en cadena del departamento, incluyendo su nombre y
     * la lista de empleados.
     *
     * @return Una cadena que muestra el nombre del departamento y sus empleados.
     */
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

