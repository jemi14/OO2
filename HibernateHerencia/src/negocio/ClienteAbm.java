package negocio;

import java.util.List;
import dao.ClienteDao;

import modelo.Cliente;

public class ClienteAbm {

	private static ClienteAbm instancia = null; // Patrón Singleton

	protected ClienteAbm() {
	}

	public static ClienteAbm getInstance() {
		if (instancia == null)
			instancia = new ClienteAbm();
		return instancia;
	}

	public Cliente traer(int idCliente) {
		return ClienteDao.getInstance().traer(idCliente);
	}

	public List<Cliente> traer() {
		return ClienteDao.getInstance().traer();
	}
	
	public int agregar(Cliente c)throws Exception{
		return ClienteDao.getInstance().agregar(c);
	}

}
