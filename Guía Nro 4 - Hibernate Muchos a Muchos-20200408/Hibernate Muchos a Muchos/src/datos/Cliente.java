package datos;

import java.time.LocalDate;
import java.util.Set;

import funciones.Funciones;

public class Cliente {
	
	private long idCliente;
	private String apellido;
	private String nombre;
	private int dni;
	private LocalDate fechaDeNacimiento;
	private boolean baja;
	private Set<Evento> eventos;
	
	public Cliente() {
		super();
	}

	public Cliente(String apellido, String nombre, int dni, LocalDate fechaDeNacimiento, boolean baja) {
		super();
		this.apellido = apellido;
		this.nombre = nombre;
		this.dni = dni;
		this.fechaDeNacimiento = fechaDeNacimiento;
		this.baja = false;
	}
	
	public Cliente(String apellido, String nombre, int dni, LocalDate fechaDeNacimiento) {
		super();
		this.apellido = apellido;
		this.nombre = nombre;
		this.dni = dni;
		this.fechaDeNacimiento = fechaDeNacimiento;
	}

	public long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(long idCliente) {
		this.idCliente = idCliente;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public LocalDate getFechaDeNacimiento() {
		return fechaDeNacimiento;
	}

	public void setFechaDeNacimiento(LocalDate fechaDeNacimiento) {
		this.fechaDeNacimiento = fechaDeNacimiento;
	}

	public boolean isBaja() {
		return baja;
	}

	public void setBaja(boolean baja) {
		this.baja = baja;
	}

	public Set<Evento> getEventos() {
		return eventos ;
		}
	
	public void setEventos(Set<Evento> eventos ) {
		this.eventos = eventos ;
		}
	
	//----------------------------------------------------
	public boolean equals(Cliente c){
		return this.dni == c.getDni();
	}
	
	//----------------------------------------------------
	public boolean agregar(Evento evento){
		return eventos.add(evento);
	}
	
	//----------------------------------------------------
	public boolean eliminar(Evento evento){
		return eventos.remove(evento);
	}

	
	@Override
	public String toString() {
		return "idCliente=" + idCliente + ", apellido=" + apellido + ", nombre=" + nombre + ", DNI=" + dni
				+ ", F. de Nacimiento:" + Funciones.traerFechaCorta(fechaDeNacimiento) + " " + baja;
	}
	
	
	
	
	
	
}
