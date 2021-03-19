package negocio;
import java.time.LocalDate;
import java.util.List;

import dao.ClienteDao;
import datos.Cliente;

public class ClienteABM {
	
	ClienteDao dao = new ClienteDao();
	
	//----------------------------------------------------
	public Cliente traerCliente(long idCliente) throws Exception{
	Cliente c= dao.traerCliente(idCliente);
	// implementar si c es null lanzar Exception
	if(c==null) {
		throw new Exception("Error no existe el cliente el id: "+ idCliente);
	}
	return c;
	}
	
	//----------------------------------------------------
	public Cliente traerClienteDNI(int dni) throws Exception{
	Cliente c= dao.traerClienteDNI(dni);
	// implementar si c es null lanzar Exception
	if(c==null) {
		throw new Exception("Error no existe el cliente el dni: "+ dni);
	}
	return c;
	}
	
	//----------------------------------------------------
	public int agregar(String apellido, String nombre, int dni,
	LocalDate fechaDeNacimiento) throws Exception{
	// consultar si existe un cliente con el mismo dni , si existe arrojar la Excepcion
	Cliente c= dao.traerClienteDNI(dni);
	if(c!=null) {
		throw new Exception("Ya existe el cliente");
	} 
	else {
		c= new Cliente(apellido, nombre, dni,fechaDeNacimiento);
	}
	return dao .agregar(c);
	}
	
	//----------------------------------------------------
	public void modificar(Cliente c) throws Exception{
	/* implementar antes de actualizar que no exista un cliente
	con el mismo documento a modificar
	y con el mismo id, lanzar la Exception */
		boolean modificar = true;
		
	Cliente existeCliente= dao.traerClienteDNI(c.getDni());
	if(existeCliente!=null && existeCliente.getIdCliente()!=c.getIdCliente()) {
		modificar= false;
		throw new Exception("El cliente existe, no se puede modificar porque ya hay otro con ese DNI");
	}
	
	if(modificar==true) {
		dao.actualizar(c);
	}
	}
	
	//----------------------------------------------------
	public void eliminar( long idCliente) throws Exception{ /*en este caso es física en gral. no se se
	aplicaría este caso de uso, si se hiciera habría que validar que el cliente no tenga
	dependencias*/
	Cliente c= dao.traerCliente(idCliente);
	// Implementar que si es null que arroje la excepción la Excepción
	if(c==null) {
		throw new Exception("No puedo eliminar algo que no existe");
	}
	dao.eliminar(c);
	}
	
	//----------------------------------------------------
	public List<Cliente> traerCliente(){ 
		return dao .traerCliente();
	}
	}

