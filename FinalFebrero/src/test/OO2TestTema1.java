package test;

import java.time.LocalDate;

import datos.Inspeccion;
import negocio.AutomotorABM;
import negocio.InspeccionABM;
import negocio.PersonaABM;

public class OO2TestTema1 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		PersonaABM personaABM = PersonaABM.getInstance();
		AutomotorABM automotorABM = new AutomotorABM();
		InspeccionABM inspeccionABM = new InspeccionABM();
		
		//--------------------------------------------------
		
		System.out.println("1) + traerContribuyente (2) : Contribuyente");
		
		System.out.println(personaABM.traerContribuyente(2));
		
		System.out.println("------------------------------");
		
		//--------------------------------------------------
		
		System.out.println("2) + traerInspector (1) : Inspector");
		
		System.out.println(personaABM.traerInspector(1));
		
		System.out.println("------------------------------");
		
		//--------------------------------------------------
		
		System.out.println("3) + traerAutomotor (LLL444) : Automotor");
		
		System.out.println(automotorABM.traerAutomotor("LLL444"));
		
		System.out.println("------------------------------");
		
		//--------------------------------------------------
		
		System.out.println("4) + traerInspeccion (1) : Inspeccion");
		
		System.out.println(inspeccionABM.traerInspeccion(1));
		
		System.out.println("------------------------------");
		
		//--------------------------------------------------
		
		System.out.println("5) + traerInspeccion (Automotor [idAutomotor=5, dominio=LLL444, modelo=2012, marca=Honda]) : Inspeccion");
		
		try {
			
		for(Inspeccion i: inspeccionABM.traerInspeccion(automotorABM.traerAutomotor("LLL444"))) {
			System.out.println(i);
		}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("------------------------------");
		
		//--------------------------------------------------
		
		System.out.println("6) + traerInspeccion (11/2/2021) : Inspeccion");
		LocalDate fecha = LocalDate.of(2021, 2, 11);
		
		try {
			
		for(Inspeccion i: inspeccionABM.traerInspeccion(fecha)) {
			System.out.println(i);
		}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("------------------------------");
		
		//--------------------------------------------------
		
		System.out.println("7) + traerInspeccion (Inspector [idPersona=1, apellido=Perez, nombres=Juan, dni=11111111,legajo=100] ,11/2/2021) : Inspeccion");
		
		try {
			
		for(Inspeccion i: inspeccionABM.traerInspeccion(personaABM.traerInspector(1), fecha)) {
			System.out.println(i);
		}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("------------------------------");
		
		//--------------------------------------------------
		
		System.out.println("8) + traerInspeccion (13/2/2021 , apto) : Inspeccion");
		
		LocalDate fecha1 = LocalDate.of(2021, 2, 13);
		
		try {
			
		for(Inspeccion i: inspeccionABM.traerInspeccion(fecha1, "apto")) {
			System.out.println(i);
		}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("------------------------------");

	}

}
