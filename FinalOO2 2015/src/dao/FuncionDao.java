package dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import datos.Funcion;
import datos.ObraTeatral;

public class FuncionDao {
	
	private static Session session;

	private void iniciaOperacion() throws HibernateException {
	session = HibernateUtil.getSessionFactory().openSession();
	}
	
	// ---------------------------------------------------- 2) + traerFuncion(int idFuncion): Funcion
	public Funcion traerFuncion(int idFuncion) throws HibernateException {
		Funcion objeto = null;
		try {
			iniciaOperacion();
			objeto = (Funcion) session.createQuery("from Funcion f where f.idFuncion =:idFuncion").setParameter("idFuncion", idFuncion).uniqueResult();
			Hibernate.initialize(objeto.getObraTeatral());
			Hibernate.initialize(objeto.getButacas());
   		} finally {
   			session.close();
   		}
   		return objeto;
}
	
	// ---------------------------------------------------- 3) + traerFuncion(ObraTeatral o): Funcion... es una lista
	@SuppressWarnings("unchecked")
	public List<Funcion> traerFuncion(ObraTeatral o) throws HibernateException {
		List<Funcion> lista = null;
		try {
			iniciaOperacion();
			lista = session.createQuery("from Funcion f where f.obraTeatral =" + o.getIdObraTeatral()).list();
			
			for (Funcion f : lista) {
			     Hibernate.initialize(f.getObraTeatral());
			     Hibernate.initialize(f.getButacas());
			}
		}
		finally {
			session.close();
		}
		return lista;	
	}
	
	
	
}

