package negocio;

import java.util.List;

import dao.EventoDao;
import datos.Cliente;
import datos.Evento;

public class EventoABM {
	
	//----------
	private static EventoABM instancia;
	
	private EventoDao dao = EventoDao.getInstancia();
	
	
	//---------------------------------------------- No esta en el PDF -.-
		public static EventoABM getInstancia() {
			if(instancia == null) {
				instancia = new EventoABM();
			}
			return instancia;
		}
	
	//----------------------------------------------------
	public Evento traerEvento(long idEvento) throws Exception{
	Evento e= dao.traerEvento(idEvento);
	if(e==null) {
		throw new Exception("Error no existe el evento el id: "+ idEvento);
	}
	return e;
	}
	
	//----------------------------------------------------
	public int agregarEvento(Evento e) {
		return dao.agregar(e);
	}
	
	//----------------------------------------------------
	public void modificar(Evento e) {
		dao.actualizar(e);
	}
	
	//----------------------------------------------------
	public void eliminar(Evento e) {
		dao.eliminar(e);
	}
	
	//----------------------------------------------------
	public List<Evento> traerEvento(){ 
		return dao.traerEvento();
	}
	
	//----------------------------------------------------
	public Evento traerEventosYCliente(long idEvento) {
		return dao.traerEventoYClientes(idEvento);
	}
 	
	//----------------------------------------------------
	public boolean agregarCliente(Evento evento, Cliente cliente) {
		return dao.agregarCliente(evento, cliente);
	}
	
	//----------------------------------------------------
	public boolean eliminarCliente( Cliente cliente, Evento evento) {
		return dao.eliminarCliente(cliente, evento);
	}
	

}
