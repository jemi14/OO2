package test;

import negocio.EventoABM;

public class TestEliminarEvento {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			EventoABM evento = new EventoABM();
			
			evento.eliminar(evento.traerEvento(4));
		}
		catch(Exception e) {
			System.out.println(e.getMessage());

	}

}
}
