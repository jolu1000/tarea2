package Reunion;
import Departamento.Asistencia;
import Departamento.Empleado;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

abstract public class Reunion {
    private Date fecha;
    private Duration duracionPrevista;
    private Instant horaInicio;
    private Instant horaFin;
    private Instant horaPrevista;

    private Empleado organizador;
    private List<Empleado> invitados = new ArrayList<>();
    private List<Asistencia> asistencias = new ArrayList<>();
    private tipoReunion tipo;
    private List<Nota> notas = new ArrayList<>();

    // Constructor
    public Reunion(Empleado organizador, tipoReunion tipo, Duration duracionPrevista, Instant horaPrevista) {
        this.organizador = organizador;
        this.tipo = tipo;
        this.duracionPrevista = duracionPrevista;
        this.asistencias = new ArrayList<>();
        this.horaPrevista = horaPrevista;
    }

    public void iniciar() {
        this.fecha = new Date();
        this.horaInicio = Instant.now();
    }

    public void agregarInvitado(Empleado empleado) {
        invitados.add(empleado);
    }

    public List<Empleado> obtenerAsistencia() {
        List<Empleado> asistentes = new ArrayList<>();
        for (Asistencia asistencia : asistencias) {
            Empleado empleado = asistencia.getEmpleado();
            if (empleado == null) {
                throw new IllegalArgumentException("El empleado no puede ser nulo en la lista de asistencias.");
            }
            asistentes.add(empleado);
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
            // Considerar retrasados solo a los que llegaron después de la hora prevista
            if (asistencia.getHoraLlegada().isAfter(horaPrevista)) {
                retrasados.add(asistencia.getEmpleado());
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

    public void finalizar() {
        this.horaFin = Instant.now();
    }

    public void agregarAsistencia(Asistencia asistencia) {
        asistencias.add(asistencia);
    }

    public void agregarNota(Nota nota) {
        notas.add(nota);
    }

    public void generarInforme(String rutaArchivo) {
        InformeReunion informe = new InformeReunion(this);
        informe.generar(rutaArchivo);
    }

    public Date getFecha() {
        return fecha;
    }

    public Instant getHoraInicio() {
        return horaInicio;
    }

    public Instant getHoraFin() {
        return horaFin;
    }

    public Duration getDuracionPrevista() {
        return duracionPrevista;
    }

    public tipoReunion getTipo() {
        return tipo;
    }

    public List<Empleado> getInvitados() {
        return invitados;
    }

    public List<Asistencia> getAsistencias() {
        return asistencias;
    }

    public List<Nota> getNotas() {
        return notas;
    }

    public Empleado getOrganizador() {
        return organizador;
    }

    public void setOrganizador(Empleado organizador) {
        this.organizador = organizador;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setDuracionPrevista(Duration duracionPrevista) {
        this.duracionPrevista = duracionPrevista;
    }

    public void setTipo(tipoReunion tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        String resultado = "Reunión organizada por " + organizador.toString() +
                "; fecha: " + fecha +
                "; duración prevista: " + duracionPrevista.toHours() + " horas" +
                "; asistentes: ";
        for (Asistencia asistencia : asistencias) {
            resultado += asistencia.toString() + "; ";
        }
        return resultado;
    }
}




