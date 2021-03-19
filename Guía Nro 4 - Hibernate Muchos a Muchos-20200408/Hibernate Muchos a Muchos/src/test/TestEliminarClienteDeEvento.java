package test;

import negocio.ClienteABM;
import negocio.EventoABM;

public class TestEliminarClienteDeEvento {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			
			
			ClienteABM clienteABM = new ClienteABM();
			EventoABM eventoABM = new EventoABM();
			
			
			
			eventoABM.eliminarCliente(clienteABM.traerCliente(5), eventoABM.traerEvento(5));
			
			
		}
		catch(Exception e) {
			System.out.println(e.getMessage());

	}

}
}
