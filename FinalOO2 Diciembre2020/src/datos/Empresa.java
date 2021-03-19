package datos;

public class Empresa extends Persona {

	private int idEmpresa;
	private String razonSocial;

	public Empresa(String nroCuenta, String razonSocial) {
		super(nroCuenta);
		this.razonSocial = razonSocial;
	}

	public Empresa() {
	}
	
	public int getIdEmpresa() {
		return idEmpresa;
	}

	protected void setIdEmpresa(int idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	@Override
	public String toString() {
		return super.toString() + " Empresa [idEmpresa=" + this.getIdPersona() + ", nroCuenta=" + this.getNroCuenta() + ", razonSocial=" + razonSocial + "]";
	}

	
	
	
	
	
	
	
}
