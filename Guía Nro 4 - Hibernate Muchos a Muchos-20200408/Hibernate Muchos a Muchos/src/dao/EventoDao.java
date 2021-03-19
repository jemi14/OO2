package dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import datos.Cliente;
import datos.Evento;

public class EventoDao {
	
	//----
	private static EventoDao instancia;
	
	private static Session session;
	private Transaction tx;
	
	public EventoDao() {}
	
	private void iniciaOperacion()throws HibernateException{
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}
	
	private void manejaExcepcion(HibernateException he)throws HibernateException{
		tx.rollback();
		throw new HibernateException("ERROR en la capa de acceso a datos",he);
	}
	
	//----------------------------- Este es el especial que no esta en el pdf -.-
	public static EventoDao getInstancia() {
		if(instancia == null) {
			instancia = new EventoDao();
		}
		return instancia;
	}
	
	//--------------------------------------
	public Evento traerEvento(long idEvento)throws HibernateException{
		Evento evento = null;
		try {
			iniciaOperacion();
			evento = (Evento)session.get(Evento.class, idEvento);
		}
		finally {
			session.close();
		}
		return evento;
	}
	
	//--------------------------------------
	@SuppressWarnings("unchecked")
	public List<Evento> traerEvento()throws HibernateException{
		List<Evento> eventos = null;
		try {
			iniciaOperacion();
			String hql ="from Evento e order by e.evento asc";
			eventos = session.createQuery(hql).list();
		}
		finally {
			session.close();
		}
		return eventos;
	}
	
	//--------------------------------------
	public int agregar(Evento e)throws HibernateException {
		int id = 0;
		try {
			iniciaOperacion();
			id = Integer.parseInt(session.save(e).toString());
			tx.commit();
		}
		catch(HibernateException he) {
			manejaExcepcion(he);
			throw he;
		}
		finally {
			session.close();
		}
		return id;
	}
	
	//--------------------------------------
	public void actualizar(Evento e)throws HibernateException{
		try {
			iniciaOperacion();
			session.update(e);
			tx.commit();
		}
		catch(HibernateException he) {
			manejaExcepcion(he);
			throw he;
		}
		finally {
			session.close();
		}
	}
	
	//--------------------------------------
	public void eliminar(Evento e)throws HibernateException{
		try {
			iniciaOperacion();
			session.delete(e);
			tx.commit();
		}
		catch(HibernateException he) {
			manejaExcepcion(he);
			throw he;
		}
		finally {
			session.close();
		}
	}
	
	//--------------------------------------
	public Evento traerEventoYClientes(long idEvento)throws HibernateException{
		Evento e = null;
		try {
			iniciaOperacion();
			String hql = "from Evento e where e.idEvento = " + idEvento;
			e = (Evento)session.createQuery(hql).uniqueResult();
			Hibernate.initialize(e.getClientes());
		}
		finally {
			session.close();
		}
		return e;
	}
	
	//--------------------------------------
	public boolean agregarCliente(Evento evento,Cliente cliente)throws HibernateException{
		Evento e = traerEventoYClientes(evento.getIdEvento());
		e.agregar(cliente);
		actualizar(e);
		return true;
	}
	
	//--------------------------------------
	public boolean eliminarCliente(Cliente cliente,Evento evento)throws HibernateException{
		
		
		Evento e = traerEventoYClientes(evento.getIdEvento());
		
		for(Cliente c: e.getClientes()) {
			
			if(c.getIdCliente()==cliente.getIdCliente()) {
				e.eliminar(c);
			
			}
		}
		
		
		
		actualizar(e);
	
		
		return true;
	}

}
