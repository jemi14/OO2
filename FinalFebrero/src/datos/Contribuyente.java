package datos;

import java.util.Set;

public class Contribuyente extends Persona {
	
		public int idContribuyente;
		public boolean esExcento;
		
		//Relacion, lista de Automotores
		public Set<Automotor> automotores;
	
		public Contribuyente(String apellido, String nombres, int dni, int idContribuyente,
				boolean esExcento) {
			super( apellido, nombres, dni);
			this.idContribuyente = idContribuyente;
			this.esExcento = esExcento;
		}
		
		public Contribuyente() {};

		public int getIdContribuyente() {
			return idContribuyente;
		}

		public void setIdContribuyente(int idContribuyente) {
			this.idContribuyente = idContribuyente;
		}

		public boolean isEsExcento() {
			return esExcento;
		}

		public void setEsExcento(boolean esExcento) {
			this.esExcento = esExcento;
		}

		public Set<Automotor> getAutomotores() {
			return automotores;
		}

		public void setAutomotores(Set<Automotor> automotores) {
			this.automotores = automotores;
		}
		
		@Override
		public String toString() {
			return super.toString() + " Contribuyente [idContribuyente=" + this.getIdPersona() + ", esExcento=" + esExcento + "]";
		}
		
		
		
		
	
	

}
