package datos;

import java.util.Set;

public class Persona {
	
	private int idPersona;
	private String nroCuenta;
	private Set<Rodado> rodados;
	
	public Persona(String nroCuenta) {
		super();
		this.nroCuenta = nroCuenta;
	}

	public Persona() {
		super();
	}

	public int getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}

	public String getNroCuenta() {
		return nroCuenta;
	}

	public void setNroCuenta(String nroCuenta) {
		this.nroCuenta = nroCuenta;
	}
	
	public Set<Rodado> getRodados() {
		return rodados ;
		}
	
	public void setRodados(Set<Rodado> rodados ) {
		this.rodados = rodados ;
		}

	@Override
	public String toString() {
		return "Persona [idPersona=" + idPersona + ", nroCuenta=" +nroCuenta + "]";
	}
	
	
	
	

}
