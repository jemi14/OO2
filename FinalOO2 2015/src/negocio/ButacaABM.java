package negocio;

import java.util.List;

import org.hibernate.HibernateException;

import dao.ButacaDao;
import datos.Butaca;
import datos.Funcion;

public class ButacaABM {
	
	ButacaDao dao = new ButacaDao();
	
	// ----------------------------------------------------  4) + traerButaca(int idButaca): Butaca
	public Butaca traerButaca(int idButaca) throws Exception {
		Butaca b = dao.traerButaca(idButaca);
		if (b == null) {
			throw new Exception("ERROR: No se pudo obtener la butaca");
	}
		return b;
	}
	
	// ---------------------------------------------------- 5) + traerButaca(Funcion f, boolean libre): List<Butaca>
	public List<Butaca> traerButaca(Funcion funcion, boolean libre) throws HibernateException {
		return dao.traerButaca(funcion, libre);
	}
	
	// ----------------------------------------------------
	public int agregarButaca(String butaca, double precio,boolean libre,  Funcion funcion) throws Exception{
		
	Butaca b= new Butaca(butaca, precio,libre,  funcion);
	
	return dao.agregarButaca(b);
	}
}
