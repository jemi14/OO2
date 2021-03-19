package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Contribuyente;
import datos.Inspector;
import datos.Persona;

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
	
	// --------------------------------------------------- 1) + traerContribuyente (int idPersona) : Contribuyente
	public Contribuyente traerContribuyente(int idPersona) {
		Persona objeto = null;
		Contribuyente c = new Contribuyente();
		try {
			iniciaOperacion();
			objeto = (Persona) session.createQuery("from Persona a where a.idPersona =" + idPersona).uniqueResult();
			
			if( objeto instanceof Contribuyente) {
				c = (Contribuyente) objeto;
			}
		} finally {
			session.close();
		}
		return c;
	}
	
	// --------------------------------------------------- 2) + traerInspector (int idPersona) : Inspector
	public Inspector traerInspector(int idPersona) {
		Persona objeto = null;
		Inspector i = new Inspector();
		try {
			iniciaOperacion();
			objeto = (Persona) session.createQuery("from Persona a where a.idPersona =" + idPersona).uniqueResult();
			
			if(objeto instanceof Inspector) {
				i = (Inspector) objeto;
			}
			
		} finally {
			session.close();
		}
		return i;
	}
	



}
