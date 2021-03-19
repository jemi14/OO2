package negocio;

import java.time.LocalDate;
import java.util.List;

import dao.ClienteDao;
import datos.Cliente;
import datos.Evento;

public class ClienteABM {
	
	//----------
	private static ClienteABM instancia;
	
	private ClienteDao dao = ClienteDao.getInstancia();
	
	
	//---------------------------------------------- No esta en el PDF -.-
	public static ClienteABM getInstancia() {
		if(instancia == null) {
			instancia = new ClienteABM();
		}
		return instancia;
	}
	
	//----------------------------------------------------
	public Cliente traerCliente(long idCliente) throws Exception{
	Cliente c= dao.traerCliente(idCliente);
	if(c==null) {
		throw new Exception("Error no existe el cliente el id: "+ idCliente);
	}
	return c;
	}
	
	//----------------------------------------------------
	public Cliente traerClienteDNI(int dni) throws Exception{
	Cliente c= dao.traerClienteDNI(dni);
	if(c==null) {
		throw new Exception("Error no existe el cliente el dni: "+ dni);
	}
	return c;
	}
	
	//---------------------------------------------------- No estaba en el pdf
	public int agregarCliente(String apellido, String nombre, int dni, LocalDate fechaDeNacimiento) throws Exception{
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
	public void eliminar( long idCliente) throws Exception{ 
	Cliente c= dao.traerCliente(idCliente);
	if(c==null) {
		throw new Exception("No puedo eliminar algo que no existe");
	}
	dao.eliminar(c);
	}
	
	//----------------------------------------------------
	public List<Cliente> traerCliente(){ 
		return dao.traerCliente();
	}
	
	//----------------------------------------------------
	public Cliente traerClienteYEventos(long idCliente) {
		return dao.traerClienteYEventos(idCliente);
	}
 	
	//----------------------------------------------------
	public boolean agregarEvento(Evento evento, Cliente cliente) {
			return dao.agregarEvento(evento, cliente);
		}
	
	//----------------------------------------------------
	public boolean eliminarEvento(Cliente cliente,Evento evento) {
		return dao.eliminarEvento(cliente, evento);
	}
	
	}

