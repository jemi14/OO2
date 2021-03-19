package test;

import datos.Cliente;
import negocio.ClienteABM;

public class TestEliminarCliente {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		ClienteABM abm= new ClienteABM();
		
		//--------------------------------------
		
		Cliente c = abm.traerCliente(35000000);
		System.out.println(c);
		
		System.out.println("------------------------");
		//--------------------------------------
		
		try {
		abm.eliminar(c.getIdCliente());
		}
		catch (Exception e) {
			System.out.println("Exception "+ e.getMessage());
		}
		
		System.out.println("------------------------");
		//--------------------------------------
		try {
		c = abm.traerCliente(35000000);
		}
		catch (Exception e) {
			System.out.println("Exception "+ e.getMessage());
		}
	}

}
