package test;

import datos.Butaca;
import datos.Funcion;
import datos.Teatro;
import negocio.ButacaABM;
import negocio.FuncionABM;
import negocio.ObraTeatralABM;

public class Test2Tema1 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		ButacaABM butacaABM = new ButacaABM();
		FuncionABM funcionABM = new FuncionABM();
		ObraTeatralABM obraTeatralABM = new ObraTeatralABM();
		
		//--------------------------------------------------
		
		System.out.println("4 Traer e imprimir butaca idButaca=1 ");
		
		System.out.println(butacaABM.traerButaca(1));
		
		System.out.println("------------------------------");
		
		//--------------------------------------------------
		
		System.out.println("5 Traer e imprimir butacas libres de Funcion 1");
		
		try {
			
		for(Butaca b: butacaABM.traerButaca(funcionABM.traerFuncion(1), true)) {
			System.out.println(b);
		}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("------------------------------");
	
	//--------------------------------------------------
	
	System.out.println("6 Calcular el total recaudado e imprimir de Funcion 1");
	
	System.out.println(obraTeatralABM.calcularTotalRecaudado(funcionABM.traerFuncion(1)));
	
	System.out.println("------------------------------");

	//--------------------------------------------------
	
	System.out.println("7 Calcular el total recaudado e imprimir de Obra teatral 1");
	
	System.out.println(obraTeatralABM.calcularTotalRecaudado(obraTeatralABM.traerObra(1)));
	
	System.out.println("------------------------------");
	
	//--------------------------------------------------
	
	System.out.println("8 Generar butacas para la funcion con idFuncion: 5. Traer de la base de datos e imprimir la funcion y el plano de butacas");
	Funcion f5 = funcionABM.traerFuncion(5);
	
	Teatro teatro = new Teatro();
	
	teatro.generarPlanoDeButacasBD(f5);
	for (Butaca b : f5.getButacas()) {
		System.out.println(b);
		
	}
	
	}

}
