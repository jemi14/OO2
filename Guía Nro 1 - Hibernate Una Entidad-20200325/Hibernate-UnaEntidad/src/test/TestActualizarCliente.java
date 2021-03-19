package test;

import datos.Cliente;
import negocio.ClienteABM;

public class TestActualizarCliente {
	public static void main(String[] args) throws Exception {
		
		ClienteABM abm = new ClienteABM();
		
		long id=4;
		
		// traer el obj a modificar por id
		Cliente c=abm.traerCliente(id);
		
		System. out .println( "Cliente a Modificar -->" +c);
		
		System.out.println("---------------------------");
		// modificar por set los atributos
		c.setDni(38684098);
		
		//modifica en la base de datos
		abm.modificar(c); //update del objeto
		
		System.out.println("---------------------------");
		// traer el obj a modificar por dni
		int dni=38684098;
		
		Cliente cModif=abm.traerClienteDNI(dni);
		System. out .println( "Cliente Modificado -->" +cModif);
		}

}
