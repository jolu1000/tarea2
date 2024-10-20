package Reunion;

public class Nota {
    private String contenido;

    public Nota(String contenido) {
        this.contenido = contenido;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        if (contenido == null) {
            throw new NullPointerException("El contenido no puede ser nulo.");
        }
        this.contenido = contenido;
    }

    @Override
    public String toString() {
        return "Nota de Reunion: " + getContenido();
    }
}