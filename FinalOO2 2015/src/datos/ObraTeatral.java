package datos;

import java.util.Set;

public class ObraTeatral {
	
	private int idObraTeatral;
	private String obraTeatral;
	private Set<Funcion> funciones;
	
	public ObraTeatral() {
		super();
	}

	public ObraTeatral(String obraTeatral) {
		super();
		this.obraTeatral = obraTeatral;
	}

	public int getIdObraTeatral() {
		return idObraTeatral;
	}

	public void setIdObraTeatral(int idObraTeatral) {
		this.idObraTeatral = idObraTeatral;
	}

	public String getObraTeatral() {
		return obraTeatral;
	}

	public void setObraTeatral(String obraTeatral) {
		this.obraTeatral = obraTeatral;
	}

	public Set<Funcion> getFunciones() {
		return funciones;
	}

	public void setFunciones(Set<Funcion> funciones) {
		this.funciones = funciones;
	}

	@Override
	public String toString() {
		return "ObraTeatral [idObraTeatral=" + idObraTeatral + ", obraTeatral=" + obraTeatral + "]";
	}
	
	

	
	
	

}
