package test;

import java.time.LocalDate;

import datos.Persona;
import datos.Telepeaje;
import negocio.PersonaABM;
import negocio.RodadoABM;
import negocio.TelepeajeABM;

public class TestOO2 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		PersonaABM personaABM = PersonaABM.getInstance();
		RodadoABM rodadoABM = new RodadoABM();
		TelepeajeABM telepeajeABM = new TelepeajeABM();
		
		//--------------------------------------------------
		
		System.out.println("1 Traer e imprimir todos los objetos Empresa");
		
		try {
			
		for(Persona p: personaABM.traerEmpresa()) {
			System.out.println(p);
		}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("------------------------------");
		
		//--------------------------------------------------
		
		System.out.println("2 Traer e imprimir todos los objetos Abonado");
		
		try {
			
		for(Persona p: personaABM.traerAbonado()) {
			System.out.println(p);
		}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("------------------------------");

		//--------------------------------------------------
		
		System.out.println("3 Traer e imprimir los objetos Abonado con apellido=Gonzalez");
		
		try {
			
		for(Persona p: personaABM.traerAbonado("Gonzalez")) {
			System.out.println(p);
		}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("------------------------------");
		
		//--------------------------------------------------
		
		System.out.println("4 Calcular e imprimir el total de caja para los telepeajes del día=2020-11-01");
	
			LocalDate fecha= LocalDate.of(2020, 11, 01);
			System.out.println(telepeajeABM.cerrarCaja(fecha));
	/*try {
	for(Telepeaje t: telepeajeABM.traerTelepeajePorFecha(fecha)) {
			System.out.println(t);
		}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
	} */
		
		System.out.println("------------------------------");

		//--------------------------------------------------
		
		System.out.println("5 Traer e imprimir rodado dominio=BBB222");
		
		System.out.println(rodadoABM.traerRodado("BBB222"));
		
		System.out.println("------------------------------");

		//--------------------------------------------------
		
		System.out.println("6 Traer e imprimir telepeajes rodado=Rodado [id=2, persona=Abonado [id=3, nroCuenta=364728, apellido=Lopez, nombres=Juan, dni=33333333], dominio=BBB222, categoria=3] y calcular e imprimir el recargo de c/u.");
		
		try {
			
		for(Telepeaje t: telepeajeABM.traerTelepeaje(rodadoABM.traerRodado("BBB222"))) {
			System.out.println(t);
			System.out.println("Recargo: " + t.calcularRecargo(5));
		}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("------------------------------");
		
		//--------------------------------------------------
		
		System.out.println("7 Traer e imprimir abonado con dni=55555555");
		
		System.out.println(personaABM.traerAbonado(55555555));
		
		System.out.println("------------------------------");

		//--------------------------------------------------
		
		System.out.println("8 Traer e imprimir telepeajes del dominio=CCC333");
		
		try {
			
		for(Telepeaje t: telepeajeABM.traerTelepeaje("CCC333")) {
			System.out.println(t);
		}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("------------------------------");
		
	}
}
