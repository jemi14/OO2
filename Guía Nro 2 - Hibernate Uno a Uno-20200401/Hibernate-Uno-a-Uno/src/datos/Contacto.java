package datos;

public class Contacto {
	
	private long idContacto;
	private String email;
	private String movil;
	private String fijo;
	private Cliente cliente;
	
	public Contacto() {
		super();
	}

	public Contacto(String email, String movil, String fijo, Cliente cliente) {
		super();
		this.email = email;
		this.movil = movil;
		this.fijo = fijo;
		this.cliente = cliente;
	}

	public long getIdContacto() {
		return idContacto;
	}

	public void setIdContacto(long idContacto) {
		this.idContacto = idContacto;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMovil() {
		return movil;
	}

	public void setMovil(String movil) {
		this.movil = movil;
	}

	public String getFijo() {
		return fijo;
	}

	public void setFijo(String fijo) {
		this.fijo = fijo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return  "Email=" + email + ", movil=" + movil + ", fijo=" + fijo;
	}
	
	
	

}
