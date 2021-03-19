package datos;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;

public class Funcion {
	
	private int idFuncion;
	private LocalDate fecha;
	private LocalTime hora;
	private ObraTeatral obraTeatral;
	private Set<Butaca> butacas;
	
	public Funcion() {
		super();
	}

	public Funcion(LocalDate fecha, LocalTime hora, ObraTeatral obraTeatral) {
		super();
		this.fecha = fecha;
		this.hora = hora;
		this.obraTeatral = obraTeatral;
	}

	public int getIdFuncion() {
		return idFuncion;
	}

	public void setIdFuncion(int idFuncion) {
		this.idFuncion = idFuncion;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public LocalTime getHora() {
		return hora;
	}

	public void setHora(LocalTime hora) {
		this.hora = hora;
	}

	public ObraTeatral getObraTeatral() {
		return obraTeatral;
	}

	public void setObraTeatral(ObraTeatral obraTeatral) {
		this.obraTeatral = obraTeatral;
	}

	public Set<Butaca> getButacas() {
		return butacas;
	}

	public void setButacas(Set<Butaca> butacas) {
		this.butacas = butacas;
	}

	@Override
	public String toString() {
		return "Funcion [idFuncion=" + idFuncion + ", fecha=" + fecha + ", hora=" + hora + ", obraTeatral="
				+ obraTeatral + "]";
	}

	
	
	

}
