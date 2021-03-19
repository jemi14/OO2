package test;

import datos.Funcion;
import negocio.FuncionABM;
import negocio.ObraTeatralABM;

public class Test1Tema1 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		ObraTeatralABM obraTeatralABM = new ObraTeatralABM();
		FuncionABM funcionABM = new FuncionABM();
		
		//--------------------------------------------------
		
		System.out.println("1 Traer e imprimir obra teatral idObraTeatral=1 ");
		
		System.out.println(obraTeatralABM.traerObra(1));
		
		System.out.println("------------------------------");

		//--------------------------------------------------
		
		System.out.println("2 Traer e imprimir funcion idFuncion=1 ");
		
		System.out.println(funcionABM.traerFuncion(1));
		
		System.out.println("------------------------------");

		//--------------------------------------------------
		
		System.out.println("3 Traer e imprimir funciones para la obra teatral obtenida en el punto 1");
		
		try {
			
		for(Funcion f: funcionABM.traerFuncion(obraTeatralABM.traerObra(1))) {
			System.out.println(f);
		}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("------------------------------");
		
	}

}
