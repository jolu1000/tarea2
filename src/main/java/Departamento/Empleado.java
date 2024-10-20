package Departamento;
import Reunion.Invitable;
import Reunion.Invitacion;
/**
 * La clase Empleado representa a los empleados en una organización.
 * Tiene informacion tal como su ID, apellidos, nombre y correo electrónico.
 * Implementa la interfaz Invitable, lo que permite que el empleado pueda ser invitado a reuniones.
 *
 * @author Benjamin
 * @author Joaquin
 */
public class Empleado implements Invitable {
    private String id;
    private String apellidos;
    private String nombre;
    private String correo;
    /**
     * Constructor de la clase Empleado.
     *
     * @param id El identificador del empleado.
     * @param apellidos Los apellidos del empleado.
     * @param nombre El nombre del empleado.
     * @param correo La dirección de correo electrónico del empleado.
     */
    public Empleado(String id, String apellidos, String nombre, String correo) {
        this.id = id;
        this.apellidos = apellidos;
        this.nombre = nombre;
        this.correo = correo;
    }
    /**
     * Método que invita al empleado a una reunión a través de una invitación.
     *
     * @param invitacion La invitación que se le envía al empleado.
     * @throws IllegalArgumentException Si la invitación, la reunión o el organizador son nulos.
     */
    @Override
    public void invitar(Invitacion invitacion) {
        if (invitacion == null) {
            throw new IllegalArgumentException("La invitación no puede ser nula.");
        }
        if (invitacion.getReunion() == null) {
            throw new IllegalArgumentException("La reunión en la invitación no puede ser nula.");
        }
        if (invitacion.getReunion().getOrganizador() == null) {
            throw new IllegalArgumentException("El organizador de la reunión no puede ser nulo.");
        }
        System.out.println("Invitando al empleado: " + nombre + " " + apellidos);
        System.out.println("Invitación recibida: " + invitacion);
    }
    /**
     * Getter que obtiene el identificador del empleado.
     *
     * @return El identificador del empleado.
     */
    public String getId() {
        return id;
    }
    /**
     * Getter que obtiene el apellido del empleado.
     *
     * @return El apellido del empleado.
     */
    public String getApellidos() {
        return apellidos;
    }
    /**
     * Getter que obtiene el nombre del empleado.
     *
     * @return El nombre del empleado.
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * Getter que obtiene el correo electrónico del empleado.
     *
     * @return El correo electrónico del empleado.
     */
    public String getCorreo() {
        return correo;
    }
    /**
     * Devuelve una representación en cadena del empleado, mostrando su nombre completo,
     * ID y correo electrónico.
     *
     * @return Una cadena que muestra la informacion del empleado.
     */
    @Override
    public String toString() {
        return nombre + " " + apellidos + ", id: " + id + ", correo: " + correo;
    }
}

