package test;

import datos.Cliente;
import negocio.ClienteABM;
import negocio.ContactoABM;

public class TestAgregarContacto {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		ClienteABM abmCliente = new ClienteABM();
		long idCliente =1;
		Cliente cliente = abmCliente.traerCliente(idCliente);
		System.out.println(cliente);
		ContactoABM abmContacto = new ContactoABM();
		abmContacto.agregar( "ajaramillo@unla.edu.ar" , "11-1111-1111" , "011-1111-1111" , cliente );

	}

}
