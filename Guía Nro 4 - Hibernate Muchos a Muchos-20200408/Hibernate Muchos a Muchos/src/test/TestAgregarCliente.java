package test;

import java.time.LocalDate;

import negocio.ClienteABM;

public class TestAgregarCliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			ClienteABM cliente = new ClienteABM();
			
			int cliente1 =cliente.agregarCliente("Gekkkll", "kklle", 38968967, LocalDate.of(1993, 01, 23));
			
			System.out.println("Ultimo id cliente agregado----> " + cliente1);
			System.out.println(cliente.traerCliente(cliente1));
			
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}
