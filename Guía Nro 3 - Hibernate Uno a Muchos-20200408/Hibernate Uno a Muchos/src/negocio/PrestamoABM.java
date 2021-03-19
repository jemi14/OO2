package negocio;

import java.time.LocalDate;
import java.util.List;

import dao.PrestamoDao;
import datos.Cliente;
import datos.Prestamo;

public class PrestamoABM {
	
	PrestamoDao dao = new PrestamoDao();

	//----------------------------------------------------
	public Prestamo traerPrestamo(long idPrestamo) throws Exception {
		Prestamo p = dao.traer(idPrestamo);
		if (p == null)
			throw new Exception("ERROR: No se pudo obtener el prestamo");
		return p;
	}
	
	//---------------------------------------------------- No estaba en el pdf
	public List<Prestamo> traerPrestamo(Cliente c ) throws Exception {
	List<Prestamo> lista = null;
	try {
		lista = dao.traer(c);
	} catch(Exception e) {
		throw new Exception("Error: El cliente dado no posee prestamos");
	}
	return lista;
	}
	
	//---------------------------------------------------- No estaba en el pdf
	public int agregar(LocalDate fecha, double monto, double interes, int cantCuotas, Cliente cliente) throws Exception {
		Prestamo p = new Prestamo(fecha, monto, interes, cantCuotas, cliente);
		return dao.agregar(p);
	}
	
	//---------------------------------------------------- No estaba en el pdf
	public void modificar(Prestamo p) throws Exception {
		dao.actualizar(p);
	}
	
	//---------------------------------------------------- No estaba en el pdf
	public void eliminar(long idPrestamo) throws Exception {
		Prestamo p = dao.traer(idPrestamo);
		if(p == null) {
			throw new Exception("No puedo eliminar algo que no existe");
		}
		dao.eliminar(p);
	}

}
