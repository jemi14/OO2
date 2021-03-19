package negocio;

import java.time.LocalDate;
import java.util.List;

import dao.ClienteDao;
import datos.Cliente;

public class ClienteABM {
	
	ClienteDao dao = new ClienteDao();
	
	//---------------------------------------------------- PDF +traerCliente(idCliente:long) : cliente
	public Cliente traerCliente(long idCliente) throws Exception{
	Cliente c= dao.traerCliente(idCliente);
	if(c==null) {
		throw new Exception("Error no existe el cliente el id: "+ idCliente);
	}
	return c;
	}
	
	//---------------------------------------------------- PDF +traerClienteDNI(dni:int) : cliente
	public Cliente traerClienteDNI(int dni) throws Exception{
	Cliente c= dao.traerClienteDNI(dni);
	if(c==null) {
		throw new Exception("Error no existe el cliente el dni: "+ dni);
	}
	return c;
	}
	
	//----------------------------------------------------
	//Este no estaba en el pdf
	public Cliente traerClienteYContacto(long idCliente)throws Exception {
		Cliente c = dao.traerClienteYContacto(idCliente);
		if(c == null)throw new Exception("El cliente que esta buscando no existe. ID: " + idCliente);
		return c;
	}
	
	//----------------------------------------------------  PDF +agregarCliente(apellido: String, nombre String, dni: long, fechaDeNacimiento: LocalDate) : int
	public int agregarCliente(String apellido, String nombre, int dni, LocalDate fechaDeNacimiento) throws Exception{
	Cliente c= dao.traerClienteDNI(dni);
	if(c!=null) {
		throw new Exception("Ya existe el cliente");
	} 
	else {
		c= new Cliente(apellido, nombre, dni,fechaDeNacimiento);
	}
	return dao.agregarCliente(c);
	} 
	
	//----------------------------------------------------
	public void modificar(Cliente c) throws Exception{
	boolean modificar = true;
	Cliente existeCliente= dao.traerClienteDNI(c.getDni());
	if(existeCliente!=null && existeCliente.getIdCliente()!=c.getIdCliente()) {
		modificar= false;
		throw new Exception("El cliente existe, no se puede modificar porque ya hay otro con ese DNI");
	}
	if(modificar==true) {
		dao.modificar(c);
	}
	}
	
	//----------------------------------------------------
	public void eliminar( long idCliente) throws Exception{ 
	Cliente c= dao.traerCliente(idCliente);
	if(c==null) {
		throw new Exception("No puedo eliminar algo que no existe");
	}
	dao.eliminar(c);
	}
	
	//---------------------------------------------------- PDF +traerClienteLista() : List<Cliente>
	public List<Cliente> traerClienteLista(){ 
		return dao.traerClienteLista();
	}
	
	//----------------------------------------------------
	public Cliente traerClienteYPrestamos(long idCliente) {
		return dao.traerClienteYPrestamos(idCliente);
		}
	
	}

