package datos;

import java.util.Set;

public class Inspector extends Persona {
	
	
	private int idInspector;
	private int legajo;
	
	//Relacion lista de inspeccion
	private Set<Inspeccion> inspecciones;
	
	public Inspector( String apellido, String nombres, int dni, int idInspector, int legajo) {
		super(apellido, nombres, dni);
		this.idInspector = idInspector;
		this.legajo = legajo;

	}
	
	public Inspector() {}

	public int getIdInspector() {
		return idInspector;
	}

	public void setIdInspector(int idInspector) {
		this.idInspector = idInspector;
	}

	public int getLegajo() {
		return legajo;
	}

	public void setLegajo(int legajo) {
		this.legajo = legajo;
	}

	public Set<Inspeccion> getInspecciones() {
		return inspecciones;
	}

	public void setInspecciones(Set<Inspeccion> inspecciones) {
		this.inspecciones = inspecciones;
	}

	@Override
	public String toString() {
		return super.toString() + " Inspector [idInspector=" +  this.getIdPersona() + ", legajo=" + legajo + "]";
	}
	
	
	
	
	
	
	
	
	
	
	

}
