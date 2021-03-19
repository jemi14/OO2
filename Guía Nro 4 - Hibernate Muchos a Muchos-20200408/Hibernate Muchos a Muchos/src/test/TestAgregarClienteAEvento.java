package test;

import negocio.ClienteABM;
import negocio.EventoABM;

public class TestAgregarClienteAEvento {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			ClienteABM clienteABM = ClienteABM.getInstancia();
			EventoABM eventoABM = EventoABM.getInstancia();
			
			
			eventoABM.agregarCliente(eventoABM.traerEvento(3), clienteABM.traerClienteDNI(34568967));
			
		
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
