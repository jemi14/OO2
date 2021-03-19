package datos;

public class Persona {
	
	
	private int idPersona;
	private String apellido;
	private String nombres;
	private int dni;
	
	@Override
	public String toString() {
		return "Persona [idPersona=" + idPersona + ", apellido=" + apellido + ", nombres=" + nombres + ", dni=" + dni
				+ "]";
	}
	public int getIdPersona() {
		return idPersona;
	}
	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}
	public Persona(int idPersona, String apellido, String nombres, int dni) {
		super();
		this.idPersona = idPersona;
		this.apellido = apellido;
		this.nombres = nombres;
		this.dni = dni;
	}
	
	
	public Persona( String apellido, String nombres, int dni) {
		super();
		
		this.apellido = apellido;
		this.nombres = nombres;
		this.dni = dni;
	}
	
	
	public Persona() {};
	
	
	

}
