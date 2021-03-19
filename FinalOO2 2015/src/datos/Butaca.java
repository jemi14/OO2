package datos;

public class Butaca {
	
	private int idButaca;
	private String butaca;
	private double precio;
	private boolean libre;
	private Funcion funcion;
	
	public Butaca() {
		super();
	}

	public Butaca(String butaca, double precio, boolean libre, Funcion funcion) {
		super();
		this.butaca = butaca;
		this.precio = precio;
		this.libre = libre;
		this.funcion = funcion;
	}

	public int getIdButaca() {
		return idButaca;
	}

	public void setIdButaca(int idButaca) {
		this.idButaca = idButaca;
	}

	public String getButaca() {
		return butaca;
	}

	public void setButaca(String butaca) {
		this.butaca = butaca;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public boolean isLibre() {
		return libre;
	}

	public void setLibre(boolean libre) {
		this.libre = libre;
	}

	public Funcion getFuncion() {
		return funcion;
	}

	public void setFuncion(Funcion funcion) {
		this.funcion = funcion;
	}

	@Override
	public String toString() {
		return "Butaca [idButaca=" + idButaca + ", butaca=" + butaca + ", precio=" + precio + ", libre=" + libre
				+ ", funcion=" + funcion + "]";
	}

	
	
	
	

}
