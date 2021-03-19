package test;

import java.time.LocalDate;

import datos.Cliente;
import negocio.ClienteABM;

public class Test {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		ClienteABM clienteABM = new ClienteABM();
		
		//--------------------------------------------------
		
		System.out.println("+traer(idCliente:long) : cliente");
		
		System.out.println(clienteABM.traerCliente(1));
		
		System.out.println("------------------------------");
		
		//--------------------------------------------------
		
		System.out.println("+traerClienteDNI(dni:int) : cliente");
		
		System.out.println(clienteABM.traerClienteDNI(14000000));
		
		System.out.println("------------------------------");
		
		//--------------------------------------------------
		
		System.out.println("+traerClienteLista() : List<Cliente>");
		
		try {
			
		for(Cliente c: clienteABM.traerClienteLista()) {
			System.out.println(c);
		}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("------------------------------");
		
		//--------------------------------------------------
		
		System.out.println("+agregarCliente(apellido: String, nombre String, dni: long, fechaDeNacimiento: LocalDate) : int");
		
		LocalDate fecha= LocalDate.of(1998, 02, 25);
		
		System.out.println(clienteABM.agregarCliente("Simpson", "Homero", 12345678, fecha));
		
		System.out.println("------------------------------");
		
	}

}
