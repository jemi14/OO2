package negocio;

import dao.AutomotorDao;
import datos.Automotor;

public class AutomotorABM {
	
	AutomotorDao dao = new AutomotorDao();
	
	// ---------------------------------------------------- 3) + traerAutomotor (String dominio) : Automotor
	public Automotor traerAutomotor(String dominio) throws Exception {
		Automotor a = dao.traerAutomotor(dominio);
		if (a == null) {
			throw new Exception("ERROR: No se pudo obtener el automotor");
	}
		return a;
	}
		

}

