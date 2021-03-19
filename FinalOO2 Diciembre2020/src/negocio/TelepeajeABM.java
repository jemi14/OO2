package negocio;

import java.time.LocalDate;
import java.util.List;

import dao.TelepeajeDao;
import datos.Rodado;
import datos.Telepeaje;

public class TelepeajeABM {
	
	TelepeajeDao dao = new TelepeajeDao();
	
	//----------------------------------------------------
	/*public Telepeaje traerTelepeaje(long idTelepeaje) throws Exception{
	Telepeaje t= dao.traerTelepeaje(idTelepeaje);
	if(t==null) {
		throw new Exception("Error no existe el telepeaje el id: "+ idTelepeaje);
	}
	return t;
	} */
	
	//----------------------------------------------------
	/*public Telepeaje traerTelepeajeFecha(LocalDate fecha) throws Exception{
	Telepeaje t= dao.traerTelepeajeFecha(fecha);
	if(t==null) {
		throw new Exception("Error no existe el telepeaje con esa fecha: "+ fecha);
	}
	return t;
	} */
	
	//----------------------------------------------------
	/*public int agregar(LocalDate fecha, LocalTime hora, double precio, Rodado rodado) throws Exception{
	Telepeaje t= dao.traerClienteDN(dni);
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
	} */
	
	// ---------------------------------------------------- 4) + cerrarCaja(LocalDate fecha) : double // Calcula el total de lo recaudado en telepeajes
	public List<Telepeaje> traerTelepeajePorFecha(LocalDate fecha) throws Exception {
		return dao.traerTelepeajePorFecha(fecha);
	}
	
	public double cerrarCaja(LocalDate fecha) throws Exception {
		return dao.cerrarCaja(fecha);
	}
	
   // ---------------------------------------------------- 5) + traerTelepeaje(Rodado rodado): List<Telepeaje>
	public List<Telepeaje> traerTelepeaje(Rodado rodado){ 
		return dao.traerTelepeaje(rodado);
	} 
	
	// ---------------------------------------------------- 9) + traerTelepeaje (String dominio): List<Telepeaje>
	public List<Telepeaje> traerTelepeaje(String dominio) throws Exception{ 
		return dao.traerTelepeaje(dominio);
	} 
	
	//----------------------------------------------------
 /*	public Cliente traerClienteYPrestamos(long idCliente) {
		return dao.traerClienteYPrestamos(idCliente);
		}
	*/

}
