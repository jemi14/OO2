package negocio;

import dao.RodadoDao;
import datos.Rodado;

public class RodadoABM {

	RodadoDao dao = new RodadoDao();

	// ----------------------------------------------------  5) + traerRodado(String dominio): Rodado
	public Rodado traerRodado(String dominio) throws Exception {
		Rodado r = dao.traerRodado(dominio);
		if (r == null) {
			throw new Exception("ERROR: No se pudo obtener el rodado");
	}
		return r;
	}

	// -----------------------------------------------------
	/*
	 * public List<Rodado> traerRodado(Telepeaje t) throws Exception { List<Rodado>
	 * lista = null; try { lista = dao.traer(t); } catch(Exception e) { throw new
	 * Exception("Error: El telepeaje dado no posee rodado"); } return lista; }
	 */

	// ----------------------------------------------------
	/*
	 * public int agregar(Persona persona, String dominio, int categoria) throws
	 * Exception { Rodado r = new Rodado(persona, dominio, categoria); return
	 * dao.agregar(r); }
	 */

	// ----------------------------------------------------
	/*
	 * public void modificar(Rodado r) throws Exception { dao.actualizar(r); }
	 */

	// ----------------------------------------------------
	/*
	 * public void eliminar(long idRodado) throws Exception { Rodado r =
	 * dao.traer(idRodado); if(r == null) { throw new
	 * Exception("No puedo eliminar algo que no existe"); } dao.eliminar(r); }
	 */

}
