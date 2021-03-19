package datos;

import java.time.LocalDate;
import java.time.LocalTime;

import funciones.Funciones;

public class Telepeaje {
	
	private int idTelepeaje;
	private LocalDate fecha;
	private LocalTime hora;
	private double precio;
	private Rodado rodado;

	public Telepeaje(LocalDate fecha, LocalTime hora, double precio, Rodado rodado) {
		super();
		this.fecha = fecha;
		this.hora = hora;
		this.precio = precio;
		this.rodado = rodado;
	}

	public Telepeaje() {
		super();
	}

	public int getIdTelepeaje() {
		return idTelepeaje;
	}

	public void setIdTelepeaje(int idTelepeaje) {
		this.idTelepeaje = idTelepeaje;
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

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public Rodado getRodado() {
		return rodado;
	}

	public void setRodado(Rodado rodado) {
		this.rodado = rodado;
	}

	@Override
	public String toString() {
		return "Telepeaje [idTelepeaje=" + idTelepeaje + ", fecha=" + fecha + ", hora=" + hora + ", precio=" + precio
				+ ", rodado=" + rodado + "]";
	}
	
	public double calcularRecargo(double porcentajeRecargo) {
		LocalTime hora1= LocalTime.of(7, 0, 0);
		LocalTime hora2= LocalTime.of(11, 0, 0);
		LocalTime hora3= LocalTime.of(17, 0, 0);
		LocalTime hora4= LocalTime.of(19, 0, 0);
		
		double resultado=0;
		
		if(Funciones.esDiaHabil(fecha)) {
		
		if((hora.isAfter(hora1) && hora.isBefore(hora2)) || (hora.isAfter(hora3) && hora.isBefore(hora4))) {
			resultado= porcentajeRecargo*precio/100;
		}
		}
		return resultado;
	}

}
