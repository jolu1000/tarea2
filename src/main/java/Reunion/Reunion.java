package Reunion;
import java.util.Date;
import java.time.Instant;
import java.time.Duration;
import java.util.List;
import java.util.ArrayList;
import Depatramento.Empleado;
import Depatramento.Asistencia;






abstract public class Reunion {

    private Date fecha;
    private Instant horaPrevista;
    private Duration duracionPrevista;
    private Instant horaFin;
    private Instant horaInicio;

    private Empleado organizador;
    private List<Asistencia> asistencias = new ArrayList<>();
    private tipoReunion tipo;


    public Reunion(Empleado organizador, tipoReunion tipo) {
        this.organizador = organizador;
        this.tipo = tipo;
    }


    public List<Empleado> obtenerAsistencia() {
        List<Empleado> asistentes = new ArrayList<>();
        for (Asistencia asistencia : asistencias) {
            if (asistencia.getRetraso() == null) {
                asistentes.add(asistencia.getEmpleado());
            }
        }
        return asistentes;
    }

    public List<Empleado> obtenerAusencia() {

        return new ArrayList<>();
    }

    public List<Empleado> obtenerRetraso() {
        List<Empleado> retrasados = new ArrayList<>();
        for (Asistencia asistencia : asistencias) {
            if (asistencia.getRetraso() != null) {  // Si el empleado tiene un retraso registrado
                retrasados.add(asistencia.getEmpleado());
            }
        }
        return retrasados;
    }

    public int obtenerTotalAsistencia() {
        return obtenerAsistencia().size();
    }

    public float obtenerPorcentajeAsistencia() {
        int totalInvitados = asistencias.size();
        if (totalInvitados == 0) return 0;
        return (float) obtenerTotalAsistencia() / totalInvitados * 100;
    }

    public Duration calcularTiempoReal() {
        if (horaInicio != null && horaFin != null) {
            return Duration.between(horaInicio, horaFin);
        } else {
            return Duration.ZERO;
        }
    }

    public void iniciar() {
        this.horaInicio = Instant.now();
    }

    public void finalizar() {
        this.horaFin = Instant.now();
    }


    public void agregarAsistencia(Asistencia asistencia) {
        asistencias.add(asistencia);
    }

    public List<Asistencia> getAsistencias() {
        return asistencias;
    }

    // Getters y Setters para el organizador y el tipo
    public Empleado getOrganizador() {
        return organizador;
    }

    public void setOrganizador(Empleado organizador) {
        this.organizador = organizador;
    }

    public tipoReunion getTipo() {
        return tipo;
    }

    public void setTipo(tipoReunion tipo) {
        this.tipo = tipo;
    }


}

