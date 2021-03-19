package test;

import datos.Cliente;
import datos.Prestamo;
import negocio.ClienteABM;

public class TestTraerClienteYPrestamos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		long idCliente =1;
		ClienteABM cliAbm = new ClienteABM();
		
		Cliente c = cliAbm.traerClienteYPrestamos ( idCliente );
		System.out.println("\n---> Traer Cliente y Prestamos idCliente=" + idCliente );
		System.out.println("\n" + c);
		// implementar Si este cliente no tiene prestamos otorgados imprima el mensaje
		for (Prestamo p : c .getPrestamos()) {
			System.out.println( "\n" + p );
		}

	}

}
