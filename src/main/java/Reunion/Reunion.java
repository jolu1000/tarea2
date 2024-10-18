package Reunion;

import Departamento.Asistencia;
import Departamento.Empleado;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
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

    private Empleado organizador;
    private List<Empleado> invitados = new ArrayList<>();
    private List<Asistencia> asistencias = new ArrayList<>();
    private tipoReunion tipo;
    private List<Nota> notas = new ArrayList<>();

    // Constructor
    public Reunion(Empleado organizador, tipoReunion tipo, Duration duracionPrevista) {
        this.organizador = organizador;
        this.tipo = tipo;
        this.duracionPrevista = duracionPrevista;
        this.asistencias = new ArrayList<>();
    }

    public void iniciar() {
        this.fecha = new Date(); // Fecha actual
        this.horaInicio = Instant.now();
    }

    public void agregarInvitado(Empleado empleado) {
        invitados.add(empleado);
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

    // Método para agregar asistencia
    public void agregarAsistencia(Asistencia asistencia) {
        asistencias.add(asistencia);
    }

    // Método para agregar una nota
    public void agregarNota(Nota nota) {
        notas.add(nota);
    }

    // Método para generar el informe de la reunión
    public void generarInforme(String rutaArchivo) {
        InformeReunion informe = new InformeReunion(this);
        informe.generar(rutaArchivo); // Pasar la ruta del archivo aquí
    }

    // Getters para acceder a los datos necesarios para el informe
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
}



