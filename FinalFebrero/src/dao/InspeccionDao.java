package dao;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import datos.Automotor;
import datos.Inspeccion;
import datos.Inspector;

public class InspeccionDao {
	
	private static Session session;

	private void iniciaOperacion() throws HibernateException {
		session = HibernateUtil.getSessionFactory().openSession();
	}
	
	// --------------------------------------------------- 4) + traerInspeccion (int idInspeccion) : Inspeccion
	public Inspeccion traerInspeccion(int idInspeccion) {
		Inspeccion objeto = null;
		try {
			iniciaOperacion();
			objeto = (Inspeccion) session.createQuery("from Inspeccion a where a.idInspeccion =" + idInspeccion).uniqueResult();
			Hibernate.initialize(objeto.getAutomotor());
			Hibernate.initialize(objeto.getInspector());
		} finally {
			session.close();
		}
		return objeto;
	}
	
    // ---------------------------------------------------- 5) + traerInspeccion (Automotor automotor) : Inspeccion
	@SuppressWarnings("unchecked")
	public List<Inspeccion> traerInspeccion(Automotor automotor) throws HibernateException {
		List<Inspeccion> lista = null;
		try {
			iniciaOperacion();
			String hql = "from Inspeccion r inner join fetch r.automotor c where c.idAutomotor = " + automotor.getIdAutomotor();
			lista = session.createQuery(hql).list();
			for(Inspeccion t: lista) {
				 Hibernate.initialize(t.getAutomotor());
			     Hibernate.initialize(t.getInspector());
			}
		} finally {
			session.close();
		}
		return lista;
	}
	
	// ---------------------------------------------------- 6) + traerInspeccion (LocalDate fecha) : Inspeccion
	@SuppressWarnings("unchecked")
	public List<Inspeccion> traerInspeccion(LocalDate fecha) throws Exception {
		List<Inspeccion> lista = null;
		try {
			iniciaOperacion();
			lista = session.createQuery("from Inspeccion o where o.fecha =:fecha").setParameter("fecha", fecha).list();
			
			for(Inspeccion t: lista) {
				 Hibernate.initialize(t.getAutomotor());
			     Hibernate.initialize(t.getInspector());
			}
   		} finally {
   			session.close();
   		}
   		return lista;
	}
	
	// ---------------------------------------------------- 7) + traerInspeccion (Inspector inspector, LocalDate fecha) : Inspeccion
	@SuppressWarnings("unchecked")
	public List<Inspeccion> traerInspeccion(Inspector inspector, LocalDate fecha) throws HibernateException {
		List<Inspeccion> lista = null;
		try {
			iniciaOperacion();
			lista=session.createQuery("from Inspeccion b where b.inspector =:inspector and b.fecha =:fecha").setParameter("inspector", inspector).setParameter("fecha", fecha).list();
			
			for (Inspeccion b : lista) {
			     Hibernate.initialize(b.getAutomotor());
			     Hibernate.initialize(b.getInspector());
			}
		}
		finally {
			session.close();
		}
		return lista;	
	} 
	
	// ---------------------------------------------------- 8) + traerInspeccion (LocalDate fecha, String estado) : Inspeccion
	@SuppressWarnings("unchecked")
	public List<Inspeccion> traerInspeccion(LocalDate fecha, String estado) throws HibernateException {
		List<Inspeccion> lista = null;
		try {
			iniciaOperacion();
			lista=session.createQuery("from Inspeccion b where b.fecha =:fecha and b.estado =:estado").setParameter("fecha", fecha).setParameter("estado", estado).list();
			
			for (Inspeccion b : lista) {
			     Hibernate.initialize(b.getAutomotor());
			     Hibernate.initialize(b.getInspector());
			}
		}
		finally {
			session.close();
		}
		return lista;	
	} 
	
	
	
	
	

}
