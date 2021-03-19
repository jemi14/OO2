package negocio;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.HibernateException;

import dao.InspeccionDao;
import datos.Automotor;
import datos.Inspeccion;
import datos.Inspector;

public class InspeccionABM {
	
	InspeccionDao dao = new InspeccionDao();
	
	// --------------------------------------------------- 4) + traerInspeccion (int idInspeccion) : Inspeccion
	public Inspeccion traerInspeccion(int idInspeccion) throws Exception {
		Inspeccion i = dao.traerInspeccion(idInspeccion);
		if (i == null) {
			throw new Exception("ERROR: No se pudo obtener la inspeccion");
	}
		return i;
	}
	
    // ---------------------------------------------------- 5) + traerInspeccion (Automotor automotor) : Inspeccion
	public List<Inspeccion> traerInspeccion(Automotor automotor) throws HibernateException {
		return dao.traerInspeccion(automotor);
	}
	
	// ---------------------------------------------------- 6) + traerInspeccion (LocalDate fecha) : Inspeccion
	public List<Inspeccion> traerInspeccion(LocalDate fecha) throws Exception {
		return dao.traerInspeccion(fecha);
	}
	
	// ---------------------------------------------------- 7) + traerInspeccion (Inspector inspector, LocalDate fecha) : Inspeccion
	public List<Inspeccion> traerInspeccion(Inspector inspector, LocalDate fecha) throws HibernateException {
		return dao.traerInspeccion(inspector, fecha);
	}
	
	// ---------------------------------------------------- 8) + traerInspeccion (LocalDate fecha, String estado) : Inspeccion
	public List<Inspeccion> traerInspeccion(LocalDate fecha, String estado) throws HibernateException {
		return dao.traerInspeccion(fecha, estado);
	}
}


