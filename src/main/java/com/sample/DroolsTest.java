package com.sample;
import java.time.LocalDateTime;
import org.drools.core.event.DebugAgendaEventListener;
import org.drools.core.event.DebugRuleRuntimeEventListener;
import org.kie.api.KieServices;
import org.kie.api.logger.KieRuntimeLogger;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 * This is a sample class to launch a rule.
 */
public class DroolsTest {

	public final static void main(String[] args) {
		try {
			// load up the knowledge base
			KieServices ks = KieServices.Factory.get();
			KieContainer kContainer = ks.getKieClasspathContainer();
			KieSession kSession = kContainer.newKieSession("ksession-rules");

			kSession.addEventListener(new DebugAgendaEventListener());
			kSession.addEventListener(new DebugRuleRuntimeEventListener());

			// To setup a file based audit logger, uncomment the next line
			KieRuntimeLogger logger = ks.getLoggers().newFileLogger(kSession, ".\\loggeraudit");

			// go !
			Afeccion afeccion1 = new Afeccion("Resfriado común", "Leve",
					"Infección viral del tracto respiratorio superior.");
			Afeccion afeccion2 = new Afeccion("Fractura de hueso", "Grave", "Rotura parcial o total de un hueso.");
			Afeccion afeccion3 = new Afeccion("Gripe", "Moderada",
					"Infección viral que afecta principalmente las vías respiratorias.");
			Afeccion afeccion4 = new Afeccion("Dolor de cabeza", "Leve", "Sensación de dolor o malestar en la cabeza.");

			// Creación de pacientes
			Paciente paciente1 = new Paciente("Juan Perez", 65, afeccion1);
			Paciente paciente2 = new Paciente("María Gómez", 50, afeccion2);
			Paciente paciente3 = new Paciente("CarlosLópez", 27, afeccion3);
			// Creación de turnos para los pacientes
			Turno turno1 = new Turno(paciente1, LocalDateTime.now(), paciente1.getAfeccion(), false);
			Turno turno2 = new Turno(paciente2, LocalDateTime.now(), paciente2.getAfeccion(), true); //emergencia medica
			Turno turno3 = new Turno(paciente3, LocalDateTime.now(), paciente3.getAfeccion(), false);
			Turno turno4 = new Turno(paciente1, LocalDateTime.now(), paciente1.getAfeccion(), true); //emergencia medica

			kSession.insert(turno1);
			kSession.insert(turno2);
			kSession.insert(turno3);
			kSession.insert(turno4);
			kSession.fireAllRules();
			logger.close(); // importante
		} catch (Throwable t) {
			t.printStackTrace();
		}
	}

	public static class Paciente {
		private String nombre;
		private int edad;
		private Afeccion afeccion;

		// Constructor, getters y setters

		public Paciente() {
		}

		public Paciente(String nombre, int edad, Afeccion afeccion) {
			this.nombre = nombre;
			this.edad = edad;
			this.afeccion = afeccion;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public int getEdad() {
			return edad;
		}

		public void setEdad(int edad) {
			this.edad = edad;
		}

		public Afeccion getAfeccion() {
			return afeccion;
		}

		public void setAfeccion(Afeccion afeccion) {
			this.afeccion = afeccion;
		}
	}

	public static class Afeccion {
		private String nombre;
		private String gravedad;
		private String descripcion;

		// Constructor, getters y setters

		public Afeccion() {
		};

		public Afeccion(String nombre, String gravedad, String descripcion) {
			this.nombre = nombre;
			this.gravedad = gravedad;
			this.descripcion = descripcion;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public String getGravedad() {
			return gravedad;
		}

		public void setGravedad(String gravedad) {
			this.gravedad = gravedad;
		}

		public String getDescripcion() {
			return descripcion;
		}

		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}
	}

	public static class Turno {
		private Paciente paciente;
		private LocalDateTime fecha;
		private Afeccion afeccion;
		private boolean emergencia;
		private int prioridad;

		// Constructor, getters y setters

		public Turno() {
		}

		public Turno(Paciente paciente, LocalDateTime fecha, Afeccion afeccion, boolean emergencia) {
			this.paciente = paciente;
			this.fecha = fecha;
			this.afeccion = afeccion;
			this.emergencia = emergencia;
		}

		public Paciente getPaciente() {
			return paciente;
		}

		public void setPaciente(Paciente paciente) {
			this.paciente = paciente;
		}

		public LocalDateTime getFecha() {
			return fecha;
		}

		public void setFecha(LocalDateTime fecha) {
			this.fecha = fecha;
		}

		public Afeccion getAfeccion() {
			return afeccion;
		}

		public void setAfeccion(Afeccion afeccion) {
			this.afeccion = afeccion;
		}

		public boolean isEmergencia() {
			return emergencia;
		}

		public void setEmergencia(boolean emergencia) {
			this.emergencia = emergencia;
		}

		public int getPrioridad() {
			return prioridad;
		}

		public void setPrioridad(int prioridad) {
			this.prioridad = prioridad;
		}
	}

}
