package Reunion;
import java.util.Date;
import java.time.Instant;
import java.time.Duration;
import java.util.List;
import java.util.ArrayList;
import Departamento.Asistencia;
import Departamento.Empleado;

abstract public class Reunion {

    private Date fecha;
    private Duration duracionPrevista;
    private Instant horaInicio;
    private Instant horaFin;

    private Empleado organizador;
    private List<Empleado> invitados = new ArrayList<>();
    private List<Asistencia> asistencias = new ArrayList<>();
    private tipoReunion tipo;
    private List<Nota> notas = new ArrayList<>();


    public Reunion(Empleado organizador, tipoReunion tipo, Duration duracionPrevista) {
        this.organizador = organizador;
        this.tipo = tipo;
        this.duracionPrevista = duracionPrevista;
    }

    public List<Empleado> obtenerAsistencia() {
        List<Empleado> asistentes = new ArrayList<>();
        for (Asistencia asistencia : asistencias) {
            asistentes.add(asistencia.getEmpleado());
        }
        return asistentes;
    }

    public List<Empleado> obtenerAusencia() {
        List<Empleado> ausentes = new ArrayList<>(invitados); // Todos los invitados inicialmente son ausentes
        for (Asistencia asistencia : asistencias) {
            ausentes.remove(asistencia.getEmpleado()); // Elimina los asistentes de la lista de ausentes
        }
        return ausentes;
    }

    public List<Empleado> obtenerRetraso() {
        List<Empleado> retrasados = new ArrayList<>();
        for (Asistencia asistencia : asistencias) {
            Duration retraso = asistencia.getRetraso();
            if (retraso != null && !retraso.isZero() && !retraso.isNegative()) {  // Verifica que haya un retraso positivo
                retrasados.add(asistencia.getEmpleado());  // Añade solo al empleado con retraso
            }
        }
        return retrasados;
    }

    public int obtenerTotalAsistencia() {
        return obtenerAsistencia().size();
    }

    public float obtenerPorcentajeAsistencia() {
        int totalInvitados = invitados.size();
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

    public Duration getDuracionPrevista() {
        return duracionPrevista;
    }

    public void setDuracionPrevista(Duration duracionPrevista) {
        this.duracionPrevista = duracionPrevista;
    }
    public void agregarNota(Nota nota) {
        notas.add(nota);
    }
    public List<Nota> obtenerNotas() {
        return notas;
    }
}

