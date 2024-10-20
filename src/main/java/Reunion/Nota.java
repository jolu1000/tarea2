package Reunion;
/**
 * La clase Nota representa una nota asociada a la reunión.
 * Contiene la información relevante tratada en la reunión.
 *
 * @author Benjamin
 * @author Joaquin
 */
public class Nota {
    private String contenido;
    /**
     * Constructor de la clase Nota.
     *
     * @param contenido El contenido de la nota.
     * @throws NullPointerException Si el contenido es nulo.
     */
    public Nota(String contenido) {
        if (contenido == null) {
            throw new NullPointerException("El contenido no puede ser nulo.");
        }
        this.contenido = contenido;
    }
    /**
     * Getter que obtiene el contenido de la nota.
     *
     * @return El contenido de la nota.
     */
    public String getContenido() {
        return contenido;
    }

    /**
     * Setter que establece el contenido de la nota.
     *
     * @param contenido El nuevo contenido para la nota.
     * @throws NullPointerException Si el nuevo contenido es nulo.
     */
    public void setContenido(String contenido) {
        if (contenido == null) {
            throw new NullPointerException("El contenido no puede ser nulo.");
        }
        this.contenido = contenido;
    }
    /**
     * Retorna una representación en cadena de la nota, incluyendo su contenido.
     *
     * @return Una cadena con la nota.
     */
    @Override
    public String toString() {
        return "Nota de Reunion: " + getContenido();
    }
}