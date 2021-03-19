package negocio;

import java.util.List;

import dao.PersonaDao;
import datos.Abonado;
import datos.Empresa;

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

	// ----------------------------------------------------
	/*  public Persona traer(int idPersona) { return
	  PersonaDao.getInstance().traer(idPersona); } */
	 
	// ----------------------------------------------------
	/*
	 * public List<Empresa> traerEmpresa() { return
	 * PersonaDao.getInstance().traerEmpresa(); }
	 */

	// ---------------------------------------------------- 1) + traerEmpresa(): List<Empresa>
	public List<Empresa> traerEmpresa() {
		return PersonaDao.getInstance().traerEmpresa();
	}

	// ---------------------------------------------------- 2) + traerAbonado(): List<Abonado>
	public List<Abonado> traerAbonado() {
		return PersonaDao.getInstance().traerAbonado();
	}

	// ---------------------------------------------------- 3) + traerAbonado(String apellido): List<Abonado> 
	public List<Abonado> traerAbonado(String apellido) {
		return PersonaDao.getInstance().traerAbonado(apellido);
	}
	
	// --------------------------------------------------- 8) + traerAbonado(long dni): Abonado
	  public Abonado traerAbonado(long dni) { return
	  PersonaDao.getInstance().traerAbonado(dni); }

	// ----------------------------------------------------
	/*
	 * public int agregar(Persona p) throws Exception { return
	 * PersonaDao.getInstance().agregar(p); }
	 */

}
