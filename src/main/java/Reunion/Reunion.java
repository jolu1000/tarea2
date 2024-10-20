package Reunion;
import Departamento.Asistencia;
import Departamento.Empleado;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * La clase Reunion representa una reunión que se organiza con un conjunto de empleados.
 * Permite gestionar los detalles de la reunión, incluyendo la asistencia, ausencias, retrasos,
 * y la generación de informes sobre la reunión.
 *
 * @author Benjamin
 * @author Joaquin
 */
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
    /**
     * Constructor de la clase Reunion.
     *
     * @param organizador El empleado que organiza la reunión.
     * @param tipo El tipo de reunión (técnica, marketing, otro).
     * @param duracionPrevista La duración prevista de la reunión.
     * @param horaPrevista La hora prevista de inicio de la reunión.
     */
    public Reunion(Empleado organizador, tipoReunion tipo, Duration duracionPrevista, Instant horaPrevista) {
        this.organizador = organizador;
        this.tipo = tipo;
        this.duracionPrevista = duracionPrevista;
        this.asistencias = new ArrayList<>();
        this.horaPrevista = horaPrevista;
    }
    /**
     * Inicia la reunión registrando la fecha y la hora de inicio.
     */
    public void iniciar() {
        this.fecha = new Date();
        this.horaInicio = Instant.now();
    }

    /**
     * Agrega un empleado a la lista de invitados de la reunión.
     *
     * @param empleado El empleado a agregar como invitado.
     */
    public void agregarInvitado(Empleado empleado) {
        invitados.add(empleado);
    }
    /**
     * Obtiene la lista de empleados que asistieron a la reunión.
     *
     * @return Los asistentes de la reunion.
     */
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
    /**
     * Obtiene la lista de empleados que no asistieron a la reunión.
     *
     * @return Lista de ausentes de la reunion.
     */
    public List<Empleado> obtenerAusencia() {
        List<Empleado> ausentes = new ArrayList<>(invitados); // Todos los invitados inicialmente son ausentes
        for (Asistencia asistencia : asistencias) {
            ausentes.remove(asistencia.getEmpleado()); // Elimina los asistentes de la lista de ausentes
        }
        return ausentes;
    }
    /**
     * Obtiene la lista de empleados que llegaron tarde a la reunión.
     *
     * @return Lista de empleados retrasados.
     */
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
    /**
     * Obtiene el total de asistentes a la reunión.
     *
     * @return Total de asistentes.
     */
    public int obtenerTotalAsistencia() {
        return obtenerAsistencia().size();
    }
    /**
     * Calcula el porcentaje de asistencia a la reunión.
     *
     * @return Porcentaje de asistencia.
     */
    public float obtenerPorcentajeAsistencia() {
        int totalInvitados = invitados.size();
        if (totalInvitados == 0) return 0;
        return (float) obtenerTotalAsistencia() / totalInvitados * 100;
    }
    /**
     * Calcula la duración real de la reunión entre la hora de inicio y la hora de fin.
     *
     * @return Duración total de la reunión.
     */
    public Duration calcularTiempoReal() {
        if (horaInicio != null && horaFin != null) {
            return Duration.between(horaInicio, horaFin);
        } else {
            return Duration.ZERO;
        }
    }
    /**
     * Finaliza la reunión registrando la hora de finalización.
     */
    public void finalizar() {
        this.horaFin = Instant.now();
    }
    /**
     * Agrega un registro de asistencia a la reunión.
     *
     * @param asistencia El registro de asistencia a agregar.
     */
    public void agregarAsistencia(Asistencia asistencia) {
        asistencias.add(asistencia);
    }

    /**
     * Agrega una nota a la reunión.
     *
     * @param nota La nota a agregar.
     */
    public void agregarNota(Nota nota) {
        notas.add(nota);
    }
    /**
     * Genera un informe de la reunión y lo guarda en el archivo especificado.
     *
     * @param rutaArchivo La ruta del archivo donde se generará el informe.
     */
    public void generarInforme(String rutaArchivo) {
        InformeReunion informe = new InformeReunion(this);
        informe.generar(rutaArchivo);
    }
    /**
     * Getters y Setters de las respectivas variables utilizadas en la clase Reunion.
     */
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
    /**
     * Genera una representación en forma de cadena de la reunión,
     * que incluye el organizador, la fecha, la duración prevista
     * y la lista de asistentes.
     *
     * @return Una cadena que representa la reunión con sus respectivos datos.
     */
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




