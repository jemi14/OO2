package negocio;

import dao.ContactoDao;
import datos.Cliente;
import datos.Contacto;

public class ContactoABM {
	
	ContactoDao dao = new ContactoDao();
	
	public Contacto traer( long idContacto ) {
		Contacto c = dao.traer( idContacto );
		return c ;
		}
	
	public int agregar(String email , String movil , String fijo , Cliente cliente ) {
		Contacto c = new Contacto( email , movil , fijo , cliente );
		return dao.agregar( c );
	}
	
	public void modificar(Contacto c ) {
		dao .actualizar( c );
		}
	
	public void eliminar( long idContacto ) {
		Contacto c = dao .traer( idContacto );
		dao .eliminar( c );
		}
	
	
	

}
