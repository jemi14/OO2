package datos;

import java.time.LocalDate;

import funciones.Funciones;

public class Cliente {
	
	private long idCliente;
	private String apellido;
	private String nombre;
	private int dni;
	private LocalDate fechaDeNacimiento;
	private boolean baja;
	
	public Cliente() { } //siempre hay que implementar el contructor vacio
	
	public Cliente(String apellido, String nombre, int dni,
			LocalDate fechaDeNacimiento) { //nunca va el id en el constructor por ser autoincrementable
			super ();
			this.apellido = apellido;
			this.nombre = nombre;
			this.dni = dni;
			this.fechaDeNacimiento = fechaDeNacimiento;
			this.baja = false ;
			}

	public long getIdCliente() {
		return idCliente;
	}

	protected void setIdCliente(long idCliente) { //siempre va protected, para que no sea modificado
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

	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", apellido=" + apellido + ", nombre=" + nombre + ", dni=" + dni
				+ ", F. de Nacimiento=" + Funciones.traerFechaCorta(fechaDeNacimiento) + ", baja=" + baja + "]";
	}
	
	
	
	
	
	
	
	

}
