package datos;

import java.util.Set;

public class Rodado {
	
	private int idRodado;
	private Persona persona;
	private String dominio;
	private int categoria;
	private Set<Telepeaje> telepeajes;
	
	
	public Rodado(Persona persona, String dominio, int categoria) {
		super();
		this.persona = persona;
		this.dominio = dominio;
		this.categoria = categoria;
	}

	public Rodado() {
		super();
	}

	public int getIdRodado() {
		return idRodado;
	}

	public void setIdRodado(int idRodado) {
		this.idRodado = idRodado;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public String getDominio() {
		return dominio;
	}

	public void setDominio(String dominio) {
		this.dominio = dominio;
	}

	public int getCategoria() {
		return categoria;
	}

	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}

	public Set<Telepeaje> getTelepeajes() {
		return telepeajes;
		}
	
	public void setTelepeajes(Set<Telepeaje> telepeajes ) {
		this.telepeajes = telepeajes ;
		}

	@Override
	public String toString() {
		return "Rodado [idRodado=" + idRodado + ", persona=" + persona + ", dominio=" + dominio + ", categoria="
				+ categoria + "]";
	}

	
	
	
	
	

}
