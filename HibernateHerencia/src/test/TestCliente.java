package test;

import modelo.Cliente;
import negocio.ClienteAbm;

public class TestCliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int idCliente =1;
		System.out.println("+ traer(" + idCliente + ")" );
		System.out.println(ClienteAbm.getInstance().traer(idCliente));
		
		idCliente =2;
		System.out.println( "\n+ traer(" + idCliente + ")" );
		System.out.println(ClienteAbm.getInstance().traer(idCliente));
		System.out.println( "\n+ traer()" );
		
		for (Cliente c : ClienteAbm.getInstance().traer()) {
		System.out .println(c);
		}
		}


}
