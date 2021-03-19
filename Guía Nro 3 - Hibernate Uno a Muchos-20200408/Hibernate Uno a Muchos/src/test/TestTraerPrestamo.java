package test;

import java.util.List;

import datos.Cliente;
import datos.Prestamo;
import negocio.ClienteABM;
import negocio.PrestamoABM;

public class TestTraerPrestamo {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		PrestamoABM prestamoABM = new PrestamoABM();
		long idPrestamo =1;
		
		System.out.println("\n--->Traer Prestamo idPrestamo=" + idPrestamo);
				
		Prestamo p = prestamoABM.traerPrestamo(idPrestamo);
		
		System.out.println(p + "\nPertenece a " + p.getCliente());
		// implementar Si este cliente no tiene prestamos otorgados imprima el mensaje
				
		ClienteABM clienteABM = new ClienteABM();
		int dni =14000000;
	    Cliente c = clienteABM.traerClienteDNI(dni);
		
	    System.out.println("--------------------------------");
	    
	    System.out.println("\n--->Traer Prestamos del Cliente=" + c);
		List<Prestamo> prestamos = prestamoABM.traerPrestamo(c);
		// implementar Si este cliente no tiene prestamos otorgados imprima el mensaje
				
		for (Prestamo o : prestamos ) {
			System.out.println( o + "\nPertenece a " + o.getCliente());
				}

	}

}
