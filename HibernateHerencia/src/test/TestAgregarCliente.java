package test;

import modelo.PersonaFisica;
import modelo.PersonaJuridica;
import negocio.ClienteAbm;

public class TestAgregarCliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ClienteAbm abmc = ClienteAbm.getInstance();
		try {
			PersonaJuridica p1 = new PersonaJuridica("33333333","Prueba","3333333333");
			PersonaFisica p2 = new PersonaFisica("44444444","Haugg","Rodrigo",44444444);
			int idUltimo = abmc.agregar(p1);
			System.out.println("Id ultimo agregado:" + idUltimo);
			idUltimo = abmc.agregar(p2);
			System.out.println("Id ultimo agregado:" + idUltimo);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		

	}

}
