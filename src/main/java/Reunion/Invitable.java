package Reunion;
/**
 * La interfaz Invitable define el comportamiento que deben implementar las clases que
 * puedan recibir una invitación para una reunión.
 *
 * Las clases que implementan esta interfaz proporcionan su propia implementación
 * del método `invitar`.
 *
 * @author Benjamin
 * @author Joaquin
 */
public interface Invitable {
    /**
     * Invita al objeto a una reunión, utilizando la invitación proporcionada.
     *
     * @param invitacion La invitación a la reunión.
     */
    void invitar(Invitacion invitacion);
}