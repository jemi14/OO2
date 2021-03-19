package test;

import java.util.List;

import datos.Cliente;
import negocio.ClienteABM;

public class TestTraerTodosLosClientes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ClienteABM abm= new ClienteABM();
		List<Cliente> lstClientes = abm.traerCliente();
		
		System.out.println(lstClientes);
	}

}
