package dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Butaca;
import datos.Funcion;

public class ButacaDao {

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

	// ---------------------------------------------------- 4) + traerButaca(int idButaca): Butaca
	public Butaca traerButaca(int idButaca) throws HibernateException {
		Butaca objeto = null;
		try {
			iniciaOperacion();
			objeto = (Butaca) session.createQuery("from Butaca b where b.idButaca =:idButaca").setParameter("idButaca", idButaca).uniqueResult();
   		Hibernate.initialize(objeto.getFuncion());
   		Hibernate.initialize(objeto.getFuncion().getObraTeatral());
   		
		} finally {
   			session.close();
   		}
   		return objeto;
}
	
	// ---------------------------------------------------- 5) + traerButaca(Funcion f, boolean libre): List<Butaca>
		@SuppressWarnings("unchecked")
		public List<Butaca> traerButaca(Funcion funcion, boolean libre) throws HibernateException {
			List<Butaca> lista = null;
			try {
				iniciaOperacion();
				lista=session.createQuery("from Butaca b where b.funcion =:funcion and b.libre =:libre").setParameter("funcion", funcion).setParameter("libre", libre).list();
				
				for (Butaca b : lista) {
				     Hibernate.initialize(b.getFuncion());
				     Hibernate.initialize(b.getFuncion().getObraTeatral());
				}
			}
			finally {
				session.close();
			}
			return lista;	
		} 
		
		// ----------------------------------------------------
		public int agregarButaca(Butaca objeto) throws HibernateException {
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



}


