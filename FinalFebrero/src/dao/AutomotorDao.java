package dao;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import datos.Automotor;

public class AutomotorDao {
	
	private static Session session;

	private void iniciaOperacion() throws HibernateException {
		session = HibernateUtil.getSessionFactory().openSession();
	}
	
	// ---------------------------------------------------- 3) + traerAutomotor (String dominio) : Automotor
	public Automotor traerAutomotor(String dominio) throws HibernateException {
		Automotor objeto = null;
		try {
			iniciaOperacion();
			objeto = (Automotor) session.createQuery("from Automotor o where o.dominio =:dominio").setParameter("dominio", dominio).uniqueResult();
			Hibernate.initialize(objeto.getContribuyente());
			Hibernate.initialize(objeto.getInspecciones());
   		} finally {
   			session.close();
   		}
   		return objeto;
	}


}
