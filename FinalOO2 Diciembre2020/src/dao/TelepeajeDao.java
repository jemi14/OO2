package dao;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
//import org.hibernate.Transaction;

import datos.Rodado;
import datos.Telepeaje;
import negocio.RodadoABM;

public class TelepeajeDao {

	private static Session session;
	//private Transaction tx;

	private void iniciaOperacion() throws HibernateException {
		session = HibernateUtil.getSessionFactory().openSession();
		//tx = session.beginTransaction();
	}

	/*private void manejaExcepcion(HibernateException he) throws HibernateException {
		tx.rollback();
		throw new HibernateException("ERROR en la capa de acceso a datos", he);
	} */

	// ------------------------------------------------
	/*
	 * public int agregar(Telepeaje objeto) throws HibernateException { int id = 0;
	 * try { iniciaOperacion(); id =
	 * Integer.parseInt(session.save(objeto).toString()); tx.commit(); } catch
	 * (HibernateException he) { manejaExcepcion(he); throw he; } finally {
	 * session.close(); } return id; }
	 */

	// ------------------------------------------------
	/*
	 * public void actualizar(Telepeaje objeto) throws HibernateException { try {
	 * iniciaOperacion(); session.update(objeto); tx.commit(); } catch
	 * (HibernateException he) { manejaExcepcion(he); throw he; } finally {
	 * session.close(); } }
	 */

	// ------------------------------------------------
	/*
	 * public void eliminar(Telepeaje objeto) throws HibernateException { try {
	 * iniciaOperacion(); session.delete(objeto); tx.commit(); } catch
	 * (HibernateException he) { manejaExcepcion(he); throw he; } finally {
	 * session.close(); } }
	 */

	// ------------------------------------------------
	/*public Telepeaje traerTelepeaje(long idTelepeaje) throws HibernateException {
		Telepeaje objeto = null;
		try {
			iniciaOperacion();
			String hql = "from Telepeaje r inner join fetch r.cliente c where r.idRodado = " + idTelepeaje;
			objeto = (Telepeaje) session.createQuery(hql).uniqueResult();
		} finally {
			session.close();
		}
		return objeto;
	} */

	// ---------------------------------------------------- 4) + cerrarCaja(LocalDate fecha) : double // Calcula el total de lo recaudado en telepeajes
	@SuppressWarnings("unchecked")
	public List<Telepeaje> traerTelepeajePorFecha(LocalDate fecha) throws Exception {
		List<Telepeaje> lista = null;
		try {
			iniciaOperacion();
			lista = session.createQuery("from Telepeaje o where o.fecha =:fecha").setParameter("fecha", fecha).list();
			
			for(Telepeaje t: lista) {
				 Hibernate.initialize(t.getRodado());
			     Hibernate.initialize(t.getRodado().getPersona());
			}
   		} finally {
   			session.close();
   		}
   		return lista;
	}
	
	  public double cerrarCaja(LocalDate fecha) throws Exception {
			List<Telepeaje> lista = traerTelepeajePorFecha(fecha);
			
			double total = 0; 
			for (Telepeaje t: lista) {
				total = total + t.getPrecio();
			}
			return total;
		}

	
    // ---------------------------------------------------- 5) + traerTelepeaje(Rodado rodado): List<Telepeaje>
	@SuppressWarnings("unchecked")
	public List<Telepeaje> traerTelepeaje(Rodado rodado) throws HibernateException {
		List<Telepeaje> lista = null;
		try {
			iniciaOperacion();
			lista = session.createQuery("from Telepeaje p where p.rodado =" + rodado.getIdRodado()).list();
			
			for (Telepeaje t : lista) {
			     Hibernate.initialize(t.getRodado());
			     Hibernate.initialize(t.getRodado().getPersona());
			}
		}
		finally {
			session.close();
		}
		return lista;	
	} 
	
	// ------------------------------------------------ 9) + traerTelepeaje (String dominio): List<Telepeaje>
	public List<Telepeaje> traerTelepeaje(String dominio) throws Exception {
		Rodado rodado= new RodadoABM().traerRodado(dominio);
		List<Telepeaje> lista = traerTelepeaje(rodado);
		return lista;
	}

}
