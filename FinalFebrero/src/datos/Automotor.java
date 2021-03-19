package datos;

import java.util.Set;

public class Automotor {
	
	
		public int idAutomotor;
		public String dominio;
		public int modelo;
		public String marca;
		
		//relaciones --1 contribuyente ---- lista de inspeccion (no está mapeado)
		public Contribuyente contribuyente;
		public Set<Inspeccion> inspecciones;

		public Automotor( String dominio, int modelo, String marca, Contribuyente contribuyente) {
			super();
			this.dominio = dominio;
			this.modelo = modelo;
			this.marca = marca;
			this.contribuyente = contribuyente;
			
		}
		
		public Automotor( String dominio, int modelo, String marca) {
			super();
			
			this.dominio = dominio;
			this.modelo = modelo;
			this.marca = marca;
		}

		public int getIdAutomotor() {
			return idAutomotor;
		}



		public void setIdAutomotor(int idAutomotor) {
			this.idAutomotor = idAutomotor;
		}




		public String getDominio() {
			return dominio;
		}




		public void setDominio(String dominio) {
			this.dominio = dominio;
		}




		public int getModelo() {
			return modelo;
		}




		public void setModelo(int modelo) {
			this.modelo = modelo;
		}




		public String getMarca() {
			return marca;
		}




		public void setMarca(String marca) {
			this.marca = marca;
		}




		public Contribuyente getContribuyente() {
			return contribuyente;
		}




		public void setContribuyente(Contribuyente contribuyente) {
			this.contribuyente = contribuyente;
		}




		public Set<Inspeccion> getInspecciones() {
			return inspecciones;
		}




		public void setInspecciones(Set<Inspeccion> inspecciones) {
			this.inspecciones = inspecciones;
		}




		public Automotor() {}
		
		
		
		
		
		
		@Override
		public String toString() {
			return "Automotor [idAutomotor=" + idAutomotor + ", dominio=" + dominio + ", modelo=" + modelo + ", marca="
					+ marca + ", contribuyente=" + contribuyente + "]";
		}
		
		
		
		
		
		
		
		
	

}
