package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Abonado;
import datos.Empresa;

public class PersonaDao {
	private static Session session;
	private Transaction tx;
	private static PersonaDao instancia = null; // Patrón Singleton

	protected PersonaDao() {
	}

	public static PersonaDao getInstance() {
		if (instancia == null)
			instancia = new PersonaDao();
		return instancia;
	}

	protected void iniciaOperacion() throws HibernateException {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}

	protected void manejaExcepcion(HibernateException he) throws HibernateException {
		tx.rollback();
		throw new HibernateException("ERROR en la capa de acceso a datos", he);
	}

	// -------------------------------------------
	/*public Persona traer(int idPersona) {
		Persona objeto = null;
		try {
			iniciaOperacion();
			objeto = (Persona) session.createQuery("from Persona c where c.idPersona =" + idPersona).uniqueResult();
		} finally {
			session.close();
		}
		return objeto;
	}*/

	// ------------------------------------------
	/*
	 * public int agregar(Persona p) { int id = 0; try { iniciaOperacion(); id =
	 * Integer.parseInt(session.save(p).toString()); tx.commit(); } catch
	 * (HibernateException he) { manejaExcepcion(he); throw he; } finally {
	 * session.close(); } return id; }
	 */

	// ---------------------------------------------------- 1) + traerEmpresa(): List<Empresa>
	@SuppressWarnings("unchecked")
	public List<Empresa> traerEmpresa() throws HibernateException {
		List<Empresa> lista = null;
		try {
			iniciaOperacion();
			lista = session.createQuery("from Empresa").list();
		} finally {
			session.close();
		}
		return lista;
	}

	// ---------------------------------------------------- 2) + traerAbonado(): List<Abonado>
	@SuppressWarnings("unchecked")
	public List<Abonado> traerAbonado() throws HibernateException {
		List<Abonado> lista = null;
		try {
			iniciaOperacion();
			lista = session.createQuery("from Abonado").list();
		} finally {
			session.close();
		}
		return lista;
	}

	// ---------------------------------------------------- 3) + traerAbonado(String apellido): List<Abonado>
	@SuppressWarnings("unchecked")
	public List<Abonado> traerAbonado(String apellido) throws HibernateException {
		List<Abonado> lista = null;
		try {
			iniciaOperacion();
			String hql = "from Abonado a where a.apellido =:apellido";
			lista = session.createQuery(hql).setParameter("apellido", apellido).list();
		} finally {
			session.close();
		}
		return lista;
	}
	
	// --------------------------------------------------- 8) + traerAbonado(long dni): Abonado
	public Abonado traerAbonado(long dni) {
		Abonado objeto = null;
		try {
			iniciaOperacion();
			objeto = (Abonado) session.createQuery("from Abonado a where a.dni =" + dni).uniqueResult();
		} finally {
			session.close();
		}
		return objeto;
	}

}
