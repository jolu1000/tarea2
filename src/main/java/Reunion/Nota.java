package Reunion;
import Departamento.Empleado;
import Departamento.Asistencia;


public class Nota {
    private String contenido;

    public Nota(String contenido) {
        this.contenido = contenido;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    @Override
    public String toString() {
        return "Nota de Reunion: " + getContenido();
    }
}