package negocio;

import dao.ObraTeatralDao;
import datos.Butaca;
import datos.Funcion;
import datos.ObraTeatral;

public class ObraTeatralABM {
	
	ObraTeatralDao dao = new ObraTeatralDao();
	
	// ----------------------------------------------------  1) + traerObra(int idObraTeatral): ObraTeatral
	public ObraTeatral traerObra(int idObraTeatral) throws Exception {
		ObraTeatral o = dao.traerObra(idObraTeatral);
		if (o == null) {
			throw new Exception("ERROR: No se pudo obtener la obra teatral");
	}
		return o;
	}
	
	// ----------------------------------------------------  6) + calcularTotalRecaudado(Funcion f): double
	public double calcularTotalRecaudado(Funcion f) {
		double resultado=0;
		
		ButacaABM butacaABM = new ButacaABM();
		
		for(Butaca  butaca: butacaABM.traerButaca(f, false)) {
			
			resultado= resultado + butaca.getPrecio();
		}
		return resultado;
	}
	
	// ----------------------------------------------------  6) + calcularTotalRecaudado(ObraTeatral o): double (No me quedo claro... no sé si hay que hacer un tipo sistema como es en oo1)
	public double calcularTotalRecaudado(ObraTeatral o) {
		double resultado=0;
		
		for(Funcion f: o.getFunciones()) {
			resultado= resultado + calcularTotalRecaudado(f);
		}
		return resultado;
	}

}
