package datos;

import java.time.LocalDate;

public class Inspeccion {
	
	
	public int idInspeccion;
	public LocalDate fecha;
	public boolean estadoPagado;
	public String estado;
	
	
	//Relaciones... 1 inspector y un automotor
	public Inspector inspector;
	public Automotor automotor;
	@Override
	public String toString() {
		return "Inspeccion [idInspeccion=" + idInspeccion + ", fecha=" + fecha + ", estadoPagado=" + estadoPagado
				+ ", estado=" + estado + ", inspector=" + inspector + "]";
	}
	public int getIdInspeccion() {
		return idInspeccion;
	}
	public void setIdInspeccion(int idInspeccion) {
		this.idInspeccion = idInspeccion;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public boolean isEstadoPagado() {
		return estadoPagado;
	}
	public void setEstadoPagado(boolean estadoPagado) {
		this.estadoPagado = estadoPagado;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Inspector getInspector() {
		return inspector;
	}
	public void setInspector(Inspector inspector) {
		this.inspector = inspector;
	}
	public Automotor getAutomotor() {
		return automotor;
	}
	public void setAutomotor(Automotor automotor) {
		this.automotor = automotor;
	}
	public Inspeccion(int idInspeccion, LocalDate fecha, boolean estadoPagado, String estado, Inspector inspector,
			Automotor automotor) {
		super();
		this.idInspeccion = idInspeccion;
		this.fecha = fecha;
		this.estadoPagado = estadoPagado;
		this.estado = estado;
		this.inspector = inspector;
		this.automotor = automotor;
	}
	
	
	
	public Inspeccion( LocalDate fecha, boolean estadoPagado, String estado, Inspector inspector,
			Automotor automotor) {
		super();
		
		this.fecha = fecha;
		this.estadoPagado = estadoPagado;
		this.estado = estado;
		this.inspector = inspector;
		this.automotor = automotor;
	}
	
	
	public Inspeccion( LocalDate fecha, boolean estadoPagado, String estado) {
		super();
	
		this.fecha = fecha;
		this.estadoPagado = estadoPagado;
		this.estado = estado;
	
	}
	
	
	public Inspeccion(int idInspeccion, LocalDate fecha, boolean estadoPagado, String estado) {
		super();
		this.idInspeccion = idInspeccion;
		this.fecha = fecha;
		this.estadoPagado = estadoPagado;
		this.estado = estado;
	
	}
	
	
	public Inspeccion() {};
	
	
	
	
	

}
