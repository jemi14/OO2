package test;

import negocio.ClienteABM;

public class TestEliminarCliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			ClienteABM clienteABM = new ClienteABM();
			
		
			
			clienteABM.eliminar(4);
			
			
		}
		catch(Exception e) {
			System.out.println(e.getMessage());

	}

}
}
