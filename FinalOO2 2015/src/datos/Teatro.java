package datos;

import negocio.ButacaABM;

public class Teatro {
	
	private Butaca[][] sala = new Butaca[8][10];

	public Teatro(Butaca[][] sala) {
		super();
		this.sala = sala;
	}

	public Teatro() {
		super();
	}

	public Butaca[][] getSala() {
		return sala;
	}

	public void setSala(Butaca[][] sala) {
		this.sala = sala;
	}
	
	public void generarPlanoDeButacasBD(Funcion funcion) throws Exception {
		
		ButacaABM butacaABM = new ButacaABM();
		
		//recorro las filas
		for (int f = 0; f<8; f++) {
			
			//recorro las butacas
			for(int b =0; b <10; b++) {
				
				//filas 1 y 2
				if((f+1)==1 || (f+1)==2) {
					
					if(b!=9) {
					butacaABM.agregarButaca("F0"+(f+1)+"B0"+(b+1), 250, true, funcion);
					}
					else {  
						butacaABM.agregarButaca("F0"+(f+1)+"B"+(b+1), 250, true, funcion); 
					}
				}
				
				//filas 3 y 4
				if((f+1)==3 || (f+1)==4) {
					
					if(b!=9) {
					butacaABM.agregarButaca("F0"+(f+1)+"B0"+(b+1), 200, true, funcion);
					}
					else {  
						butacaABM.agregarButaca("F0"+(f+1)+"B"+(b+1), 200, true, funcion); 
						}
				}
				
				//filas 5 y 6
				if((f+1)==5 || (f+1)==6) {
					
					if(b!=9) {
					butacaABM.agregarButaca("F0"+(f+1)+"B0"+(b+1), 150, true, funcion);
					}
					else {  
						butacaABM.agregarButaca("F0"+(f+1)+"B"+(b+1), 150, true, funcion); 
					}
				}
				
				//filas 7 y 8
				if((f+1)==7 || (f+1)==8) {
					
					if(b!=9) {
					butacaABM.agregarButaca("F0"+(f+1)+"B0"+(b+1), 100, true, funcion);
					}
					else {  
						butacaABM.agregarButaca("F0"+(f+1)+"B"+(b+1), 100, true, funcion); 
						}
				}
					
			}
			
			
		}
		
		
	}

}
