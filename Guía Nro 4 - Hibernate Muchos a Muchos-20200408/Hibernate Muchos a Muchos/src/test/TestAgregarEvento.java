package test;

import java.time.LocalDate;
import java.time.LocalTime;

import datos.Evento;
import negocio.EventoABM;

public class TestAgregarEvento {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			EventoABM evento = new EventoABM();
			
			Evento evento1= new Evento("Teatroiiuih", LocalDate.of(2015, 03, 23), LocalTime.of(23, 15));
			
			int prueba= evento.agregarEvento(evento1);

			System.out.println("Ultimo id evento agregado----> " + prueba);
			System.out.println(evento.traerEvento(prueba));
			
		}
		catch(Exception e) {
			System.out.println(e.getMessage());

	}

}
}
