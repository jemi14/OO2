package negocio;

import dao.PersonaDao;
import datos.Contribuyente;
import datos.Inspector;

public class PersonaABM {
	
	private static PersonaABM instancia = null; // Patrón Singleton

	protected PersonaABM() {
	}

	// ----------------------------------------------------
	public static PersonaABM getInstance() {
		if (instancia == null)
			instancia = new PersonaABM();
		return instancia;
	}

	// ---------------------------------------------------  1) + traerContribuyente (int idPersona) : Contribuyente
	public Contribuyente traerContribuyente(int idPersona) {
		return PersonaDao.getInstance().traerContribuyente(idPersona); 
		}
	
	// --------------------------------------------------- 2) + traerInspector (int idPersona) : Inspector
	public Inspector traerInspector(int idPersona) {
		return PersonaDao.getInstance().traerInspector(idPersona);
	}


}
