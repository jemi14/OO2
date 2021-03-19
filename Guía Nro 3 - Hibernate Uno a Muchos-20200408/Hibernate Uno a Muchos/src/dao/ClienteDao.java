package dao;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import datos.Cliente;

public class ClienteDao {
	private static Session session;
	private Transaction tx;

	private void iniciaOperacion() throws HibernateException {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}

	private void manejaExcepcion(HibernateException he) throws HibernateException {
		tx.rollback();
		throw new HibernateException("ERROR en la capa de acceso a datos", he);
	}

	// ---------------------------------------------------- PDF +agregarCliente(apellido: String, nombre String, dni: long, fechaDeNacimiento: LocalDate) : int
	public int agregarCliente(Cliente objeto) {
		int id = 0;
		try {
			iniciaOperacion();
			id = Integer.parseInt(session.save(objeto).toString());
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
		return id;
	}

	// ---------------------------------------------------- 
	public void modificar(Cliente objeto) throws HibernateException {
		try {
			iniciaOperacion();
			session.update(objeto);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
	}

	// ----------------------------------------------------
	public void eliminar(Cliente objeto) throws HibernateException {
		try {
			iniciaOperacion();
			session.delete(objeto);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
	}

	// ---------------------------------------------------- PDF +traer(idCliente:long) : cliente
	public Cliente traerCliente(long idCliente) throws HibernateException {
		Cliente objeto = null;
		try {
			iniciaOperacion();
			objeto = (Cliente) session.get(Cliente.class, idCliente);
		} finally {
			session.close();
		}
		return objeto;
	}

	// ---------------------------------------------------- PDF +traerClienteDNI(dni:int) : cliente
	public Cliente traerClienteDNI(long dni) throws HibernateException {
		Cliente objeto = null;
		try {
			iniciaOperacion();
			objeto = (Cliente) session.createQuery("from Cliente c where c.dni=" + dni).uniqueResult();
		} finally {
			session.close();
		}
		return objeto;
	}

	// ---------------------------------------------------- PDF +traerClienteLista() : List<Cliente>
	@SuppressWarnings("unchecked")
	public List<Cliente> traerClienteLista() throws HibernateException {
		List<Cliente> lista = null;
		try {
			iniciaOperacion();
			lista = session.createQuery("from Cliente c order by c.apellido asc, c.nombre asc").list();
		} finally {
			session.close();
		}
		return lista;
	}

	// ----------------------------------------------------
	public Cliente traerClienteYContacto(long idCliente) throws HibernateException {
		Cliente objeto = null;
		try {
			iniciaOperacion();
			String hql = "from Cliente c inner join fetch c.contacto where c.idCliente =" + idCliente;
			objeto = (Cliente) session.createQuery(hql).uniqueResult();
		} finally {
			session.close();
		}
		return objeto;
	}

	// ----------------------------------------------------
	public Cliente traerClienteYPrestamos(long idCliente) throws HibernateException {
		Cliente objeto = null;
		try {
			iniciaOperacion();
			String hql = "from Cliente c where c.idCliente =" + idCliente;
			objeto = (Cliente) session.createQuery(hql).uniqueResult();
			Hibernate.initialize(objeto.getPrestamos());
		} finally {
			session.close();
		}
		return objeto;
	}

}
