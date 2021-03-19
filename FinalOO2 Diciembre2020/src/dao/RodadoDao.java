package dao;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import datos.Rodado;

public class RodadoDao {

	private static Session session;

	private void iniciaOperacion() throws HibernateException {
		session = HibernateUtil.getSessionFactory().openSession();
	}

	// ------------------------------------------------
	/*
	 * public int agregar(Rodado objeto) throws HibernateException { int id = 0; try
	 * { iniciaOperacion(); id = Integer.parseInt(session.save(objeto).toString());
	 * tx.commit(); } catch (HibernateException he) { manejaExcepcion(he); throw he;
	 * } finally { session.close(); } return id; }
	 */

	// ------------------------------------------------
	/*
	 * public void actualizar(Rodado objeto) throws HibernateException { try {
	 * iniciaOperacion(); session.update(objeto); tx.commit(); } catch
	 * (HibernateException he) { manejaExcepcion(he); throw he; } finally {
	 * session.close(); } }
	 */

	// ------------------------------------------------
	/*
	 * public void eliminar(Rodado objeto) throws HibernateException { try {
	 * iniciaOperacion(); session.delete(objeto); tx.commit(); } catch
	 * (HibernateException he) { manejaExcepcion(he); throw he; } finally {
	 * session.close(); } }
	 */

	// ---------------------------------------------------- 5) + traerRodado(String dominio): Rodado
	public Rodado traerRodado(String dominio) throws HibernateException {
		Rodado objeto = null;
		try {
			iniciaOperacion();
			objeto = (Rodado) session.createQuery("from Rodado o where o.dominio =:dominio").setParameter("dominio", dominio).uniqueResult();
			Hibernate.initialize(objeto.getPersona());
   		} finally {
   			session.close();
   		}
   		return objeto;
	}

	// ------------------------------------------------
	/*
	 * @SuppressWarnings("unchecked") public List<Rodado> traer(Telepeaje t) throws
	 * HibernateException { List<Rodado> lista = null; try { iniciaOperacion();
	 * String hql =
	 * "from Rodado r inner join fetch r.telepeaje c where c.idTelepeaje = " +
	 * t.getIdTelepeaje(); lista = session.createQuery(hql).list(); } finally {
	 * session.close(); } return lista; }
	 */

}
