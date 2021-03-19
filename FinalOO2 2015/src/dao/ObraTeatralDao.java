package dao;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import datos.ObraTeatral;

public class ObraTeatralDao {
	
	private static Session session;

	private void iniciaOperacion() throws HibernateException {
	session = HibernateUtil.getSessionFactory().openSession();
	}
	
	// ---------------------------------------------------- 1) + traerObra(int idObraTeatral): ObraTeatral
	 public ObraTeatral traerObra(int idObraTeatral) throws HibernateException {
		ObraTeatral objeto = null;
		try {
			iniciaOperacion();
			objeto = (ObraTeatral) session.createQuery("from ObraTeatral o where o.idObraTeatral =:idObraTeatral").setParameter("idObraTeatral", idObraTeatral).uniqueResult();
   		Hibernate.initialize(objeto.getFunciones());
   		
		} finally {
   			session.close();
   		}
   		return objeto;
} 
}
