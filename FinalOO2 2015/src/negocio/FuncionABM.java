package negocio;

import java.util.List;

import org.hibernate.HibernateException;

import dao.FuncionDao;
import datos.Funcion;
import datos.ObraTeatral;

public class FuncionABM {
	
	FuncionDao dao = new FuncionDao();
	
	// ----------------------------------------------------  2) + traerFuncion(int idFuncion): Funcion
	public Funcion traerFuncion(int idFuncion) throws Exception {
		Funcion f = dao.traerFuncion(idFuncion);
		if (f == null) {
			throw new Exception("ERROR: No se pudo obtener la funcion");
	}
		return f;
	}
	
	// ---------------------------------------------------- 3) + traerFuncion(ObraTeatral o): Funcion... es una lista
	public List<Funcion> traerFuncion(ObraTeatral o) throws HibernateException {
		return dao.traerFuncion(o);
	}

}
