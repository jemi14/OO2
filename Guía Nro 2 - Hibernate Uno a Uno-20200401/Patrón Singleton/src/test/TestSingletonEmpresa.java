package test;

import datos.Empresa;

public class TestSingletonEmpresa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Objeto empresa");
		Empresa empresa= Empresa.getInstanciaEmpresa();
		System.out.println(empresa.getNombre());
		System.out.println(empresa.getEmail());
		
		System.out.println("------------------------");
		
		System.out.println("Objeto empresa1");
		Empresa empresa1= Empresa.getInstanciaEmpresa();
		System.out.println(empresa1.getNombre());
		System.out.println(empresa1.getEmail());
		
		System.out.println("------------------------");
		
		System.out.println("empresa.equals(empresa1)="+empresa.equals(empresa1));
		
	}

}
