package test;

import java.time.LocalDate;
import negocio.ClienteABM;

public class TestAgregarCliente {
	public static void main(String[] args) throws Exception {
		
		String apellido= "Benitez" ;
		String nombre= "Lucas" ;
		int documento=35000000;
		LocalDate fechaDeNacimiento= LocalDate.of(1994, 01, 14); // tu fecha de nacimiento
		
		ClienteABM abm= new ClienteABM();
		
		//--------------------------------------
		
		try {
		long ultimoIdCliente = abm.agregar(apellido, nombre, documento, fechaDeNacimiento);
		}
		catch (Exception e) {
			System.out.println("Exception "+ e.getMessage());
		}
		
	}

}
