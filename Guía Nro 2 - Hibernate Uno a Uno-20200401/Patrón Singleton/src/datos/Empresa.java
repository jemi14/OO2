package datos;

public class Empresa {
	
	private static Empresa instanciaEmpresa;
	protected String nombre;
	protected String email;
	protected Empresa() {
		this.inicializar();
	}
	
	public static Empresa getInstanciaEmpresa() {
		if(instanciaEmpresa== null) {
			instanciaEmpresa= new Empresa();
		}
		return instanciaEmpresa;
	}
	public String getEmail() {
		return email;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre= nombre;
	}
	public void setEmail(String email) {
		this.email= email;
	}
	private void inicializar() { //puede leer la instancia de un archivo xml
		this.setNombre("Soft Argentina");
		this.setEmail("softargentina@unla.edu.ar");
	}
}
