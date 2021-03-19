package funciones;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.StringReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class Funciones {
	
/*-----------------------------------------------------------------------------------*/
	//Traer el año GregorianCalendar
	public static int traerAnio(GregorianCalendar f){
		return f.get(Calendar.YEAR);
	} 
	
	//Traer el año 
	public static int traerAnio(LocalDate f){
		return f.getYear();
	}
/*-----------------------------------------------------------------------------------*/	
	//Es Bisiesto
		public static boolean esBisiesto(int anio) {
			int resultado=0;
			int resultado1=0;
			int resultado2=0;
			boolean respuesta=false;
			
			resultado= anio%400;
			resultado1= anio%4;
			resultado2=anio%100;
			
			if((resultado==0) || (resultado1==0 && resultado2!=0)) {
				respuesta=true;
			}
			return respuesta;
		}
/*-----------------------------------------------------------------------------------*/
		//Traer el mes GregorianCalendar
		public static int traerMes(GregorianCalendar f){
			return f.get(Calendar.MONTH)+1;
		}
		
		//Traer el mes
		public static int traerMes(LocalDate f){
			return f.getMonthValue();
		}
		
/*----------------------------------------------------------------------------------*/
		//Traer el dia GregorianCalendar
		public static int traerDia(GregorianCalendar f){	
			return f.get(Calendar.DAY_OF_MONTH);
		}
		
		//Traer el dia 
		public static int traerDia(LocalDate f){	
			return f.getDayOfMonth();
		}
/*----------------------------------------------------------------------------------*/
		//traer la hora con String GregorianCalendar
		public static String traerHoraString(GregorianCalendar f){ 
			//PARA TRAER LA FECHA CORTA + HORA -> JUNTAR CODIGO DE ESTE METODO CON EL DE FECHACORTA
			int hora = f.get(GregorianCalendar.HOUR);
			int minutos = f.get(GregorianCalendar.MINUTE);
			return (hora+":"+minutos); 
		}
		
		//traer la hora con String
		public static String traerHoraString(LocalTime f){ 
			//PARA TRAER LA FECHA CORTA + HORA -> JUNTAR CODIGO DE ESTE METODO CON EL DE FECHACORTA
			int hora = f.getHour();
			int minutos = f.getMinute();
			return (hora+":"+minutos); 
		}
		
		//traer la hora int GregorianCalendar
		public static int traerHora(GregorianCalendar f) {
			return f.get(Calendar.HOUR_OF_DAY);
		}
		
		//traer la hora
		public static int traerHora(LocalDateTime f) {
			return f.getHour();
		}
		
		//Traer hora corta mio
		public String traerHoraCorta(LocalTime hora) {
			String resultado="";
			resultado= hora.getHour()+ ":" + hora.getMinute();
			return resultado;
		}
		
		//Traer minuto GregorianCalendar
		public static int traerMinuto(GregorianCalendar f) {
			return f.get(Calendar.MINUTE);
		}
		
		//Traer minuto
		public static int traerMinuto(LocalDateTime f) {
			return f.getMinute();
		}

		//Traer segundo GregorianCalendar
		public static int traerSegundo(GregorianCalendar f) {
			return f.get(Calendar.SECOND);
		}
		
		//Traer segundo
		public static int traerSegundo(LocalDateTime f) {
			return f.getSecond();
		}
/*----------------------------------------------------------------------------------*/
		//Traer Cantidad de dias de un mes
		public static int traerCantDiasDeUnMes(int anio, int mes)
		{
			int cantDias = 0;
			
			if(mes==1 || mes==3 || mes==5 || mes==7 || mes ==10 || mes== 12) {
				cantDias=31;
			}
			else {
				cantDias=30;
			}
			
			if(mes==2){
				if(anio % 4 == 0 && !(anio % 400 != 0 && anio % 100 == 0)) {
					cantDias=29;
				}
				else {
					cantDias=28;
				}
			}
			return cantDias;
		
		}
		
/*----------------------------------------------------------------------------------*/		
		//Lista de feriados
		private static final ArrayList<LocalDate> lstFeriados = new ArrayList<LocalDate>();	
		
/*----------------------------------------------------------------------------------*/
		//Es fecha Valida
			/*public boolean esFechaValida(LocalDate fecha) {
				boolean resultado=false;
				int diasDelMes=0;
			
			if(fecha.getMonthValue() >= 1 && fecha.getMonthValue() <= 12)
			{
				diasDelMes = traerCantDiasDeUnMes(fecha.getMonthValue(), fecha.getYear());
				
				if(fecha.getDayOfMonth() <= diasDelMes) {
				
				resultado= true;
			}
			}
			return resultado;
			}*/
		
		public static boolean esFechaValida(int anio, int mes, int dia) {
			boolean valido = false;
			int cdias = 0;
			if (0 < anio && anio < 3000) {
				if (1 <= mes && mes <= 12) {
					if (mes == 1 || mes == 3 | mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12) {
						cdias = 31;
					}
					if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {
						cdias = 30;
					}
					if (mes == 2) {
						if (esBisiesto(anio) == true) {
							cdias = 29;
						} else {
							cdias = 28;
						}
					}
					if (1 <= dia && dia <= cdias) {
						valido = true;
					}
				}
			}
			return valido;
		}
/*----------------------------------------------------------------------------------*/
		//Traer fecha GregorianCalendar 
		public static GregorianCalendar traerFechaGC(int anio, int mes, int dia) {
			GregorianCalendar fecha = new GregorianCalendar();
			fecha.set(anio, (mes - 1), dia);
			return (GregorianCalendar) fecha;
		}
		
		
		//Traer fecha
		public static LocalDate traerFecha(int anio, int mes, int dia) {
			LocalDate fecha = LocalDate.of(anio, mes, dia);
			return fecha;
		}

		//Traer fecha GregorianCalendar String
		public static GregorianCalendar traerFechaGC(String fecha) {
			int dia = Integer.parseInt(fecha.substring(0, 2));
			int mes = (Integer.parseInt(fecha.substring(3, 5)) - 1);
			int anio = Integer.parseInt(fecha.substring(6, 10));
			GregorianCalendar f = new GregorianCalendar(anio, mes, dia);
			return f;
		}
		
		
		
		//Traer fecha String
		public static LocalDate traerFecha(String fecha) {
			int dia = Integer.parseInt(fecha.substring(0, 2));
			int mes = (Integer.parseInt(fecha.substring(3, 5)) - 1);
			int anio = Integer.parseInt(fecha.substring(6, 10));
			LocalDate f = LocalDate.of(anio, mes, dia);
			return f;
		}
/*----------------------------------------------------------------------------------*/
		//Traer fecha corta GregorianCalendar
		public static String traerFechaCorta(GregorianCalendar fecha) {
			return traerDia(fecha) + "/" + traerMes(fecha) + "/" + traerAnio(fecha);
		}
		
		//Traer fecha corta
			public static String traerFechaCorta(LocalDate fecha) {
				String resultado="";
				resultado= fecha.getDayOfMonth()+ "/" + fecha.getMonthValue()+ "/" + fecha.getYear();
				return resultado;
			}

/*----------------------------------------------------------------------------------*/
		//Traer fecha corta con hora GregorianCalendar
		public static String traerFechaCortaHora(GregorianCalendar fecha) {
			return traerDia(fecha) + "/" + traerMes(fecha) + "/" + traerAnio(fecha) + " " + traerHora(fecha) + ":"
						+ traerMinuto(fecha) + ":" + traerSegundo(fecha);
		}
		
		//Traer fecha corta con hora
		public static String traerFechaCortaHora(LocalDateTime fecha) {
			return traerDia(fecha.toLocalDate()) + "/" + traerMes(fecha.toLocalDate()) + "/" + traerAnio(fecha.toLocalDate()) + " " + traerHora(fecha) + ":"
					+ traerMinuto(fecha) + ":" + traerSegundo(fecha);
		}
/*----------------------------------------------------------------------------------*/	
		//Traer fecha proximo GregorianCalendat
		public static GregorianCalendar traerFechaProximo(GregorianCalendar fecha, int cantDias) {
			GregorianCalendar proximo = new GregorianCalendar(traerAnio(fecha), traerMes(fecha) - 1, traerDia(fecha));
			proximo.add(Calendar.DAY_OF_MONTH, cantDias);
			return proximo;
		}
		
		//Traer fecha proximo
		public static LocalDate traerFechaProximo(LocalDate fecha, int cantDias) {
			LocalDate proximo = LocalDate.of(traerAnio(fecha), traerMes(fecha), traerDia(fecha));
			proximo.plusDays(cantDias);
			return proximo;
		}	
/*----------------------------------------------------------------------------------*/
		//Es dia habil GregorianCalendar
		public static boolean esDiaHabil(GregorianCalendar fecha) {
			boolean r = true;
			if (fecha.get(Calendar.DAY_OF_WEEK) == 1 || fecha.get(Calendar.DAY_OF_WEEK) == 7)
				r = false;
			return r;
		}	
		
		//Es dia habil
		public static boolean esDiaHabil(LocalDate fecha) {
			boolean resultado=false;
			DayOfWeek diaHabil = fecha.getDayOfWeek();
			if(diaHabil.getValue()<6) {
				resultado= true;
			}
			return resultado;
			}
/*----------------------------------------------------------------------------------*/
			//Traer dia de la semana
			public static String traerDiaDeLaSemana(LocalDate fecha) {
				String resultado="";
				DayOfWeek diaDeLaSemana = fecha.getDayOfWeek();
					if(diaDeLaSemana.getValue()==1) {
						resultado="Lunes";
					}
					if(diaDeLaSemana.getValue()==2) {
						resultado="Martes";
					}
					if(diaDeLaSemana.getValue()==3) {
						resultado="Miercoles";
					}
					if(diaDeLaSemana.getValue()==4) {
						resultado="Jueves";
					}
					if(diaDeLaSemana.getValue()==5) {
						resultado="Viernes";
					}
					if(diaDeLaSemana.getValue()==6) {
						resultado="Sabado";
					}
					if(diaDeLaSemana.getValue()==7) {
						resultado="Domingo";
					}
					return resultado;
			}
/*----------------------------------------------------------------------------------*/
				//Traer mes en letras
			public static String traerMesEnLetras(LocalDate fecha) {
				String resultado="";
				
				if(fecha.getMonthValue()==1) {
					resultado="Enero";
				}
				if(fecha.getMonthValue()==2) {
					resultado="Febrero";
				}
				if(fecha.getMonthValue()==3) {
					resultado="Marzo";
				}
				if(fecha.getMonthValue()==4) {
					resultado="Abril";
				}
				if(fecha.getMonthValue()==5) {
					resultado="Mayo";
				}
				if(fecha.getMonthValue()==6) {
					resultado="Junio";
				}
				if(fecha.getMonthValue()==7) {
					resultado="Julio";
				}
				if(fecha.getMonthValue()==8) {
					resultado="Agosto";
				}
				if(fecha.getMonthValue()==9) {
					resultado="Septiembre";
				}
				if(fecha.getMonthValue()==10) {
					resultado="Octubre";
				}
				if(fecha.getMonthValue()==11) {
					resultado="Noviembre";
				}
				if(fecha.getMonthValue()==12) {
					resultado="Diciembre";
				}
				return resultado;
			}
/*----------------------------------------------------------------------------------*/
			//Traer fecha larga
			public static String traerFechaLarga(LocalDate fecha) {
				String resultado="";
				
				String dia= traerDiaDeLaSemana(fecha);
				String mes= traerMesEnLetras(fecha);
				
				resultado= dia + " " + fecha.getDayOfMonth() + " de " + mes + " " + fecha.getYear();
				
				return resultado;
			}
/*----------------------------------------------------------------------------------*/
			public static boolean sonFechasIguales(LocalDate fecha, LocalDate fecha1) {
				boolean r = false;
				if (Funciones.traerFechaCorta(fecha).equals(Funciones.traerFechaCorta(fecha1))) {
					r = true;
				}
				return r;
			}
/*----------------------------------------------------------------------------------*/
			public static boolean sonHorasIguales(LocalTime hora, LocalTime hora1) {
				boolean r = false;
					if(Funciones.traerHoraString(hora).equals(Funciones.traerHoraString(hora1))) {
						r=true;
					}
					return r;
			}
/*----------------------------------------------------------------------------------*/
			//Aproximar 2 decimal
			public static double aproximar2Decimal(double valor) {
				
				BigDecimal decimal = new BigDecimal(valor);
				decimal = decimal.setScale(2, RoundingMode.HALF_UP);
				
				return decimal.doubleValue();	
			}
/*----------------------------------------------------------------------------------*/
	       //Es numero
			public static boolean esNumero(char c){
				boolean resultado=false;
		
				if(c=='0'||c=='1'|| c=='2'|| c=='3'|| c=='4' || c=='5' || c=='6' || c=='7' || c=='8' || c=='9'){
					resultado=true;
				}
				return resultado;
			}
/*----------------------------------------------------------------------------------*/
			//Es letra
			public static boolean esLetra(char c){
				boolean resultado=false;
				
				if(c=='a' || c=='b' || c=='c' || c=='d' || c=='e' || c=='f' || c=='g' || c=='h' || c=='i' || 
						c=='j' || c=='k' || c=='l' || c=='m' || c=='n' || c=='o' || c=='p' || c=='q' || c=='r' ||
						c=='s' || c=='t' || c=='u' ||c=='v' || c=='w' || c=='y' || c=='z') {
					resultado=true;
				}
				return resultado;
			}
/*----------------------------------------------------------------------------------*/	
			//Es cadena de numeros
			public static boolean esCadenaNros(String cadena) {
				boolean resultado=true;
				int i;
				
				for(i=0; i<cadena.length();i++) {
				
				if(!esNumero(cadena.charAt(i))){
					resultado=false;
				}	
			}
				return resultado;
			}
/*----------------------------------------------------------------------------------*/	
			//Es cadena de letras
			public static boolean esCadenaLetras(String cadena) {
				boolean resultado=true;
				int i;
				
				for(i=0; i<cadena.length(); i++) {
					if(!esLetra(cadena.charAt(i))) {
						resultado= false;
					}
				}
				return resultado;
			}
/*----------------------------------------------------------------------------------*/	
			//Convertir a double
			public static double convertirADouble(int n) {
				return ((double) n);
			}
/*----------------------------------------------------------------------------------*/	
			//Calcular edad
			public  static int calcularEdad( LocalDate nacimiento, LocalDate fhoy){
				int retornoEnEdadEnAnios = 0;

				int difAnyos = fhoy.getYear() - nacimiento.getYear();
				int difMeses = fhoy.getMonthValue() - nacimiento.getMonthValue();
				int difDias = fhoy.getDayOfMonth() - nacimiento.getDayOfMonth();
	
				//Ya tenia el metodo con el cual calculaba ademas de años, los meses y dias
				//de edad, por eso estan comentadas esas variables
				
				if (difAnyos>=1){
				if (difMeses > 0 && difDias >= 0){
				retornoEnEdadEnAnios = difAnyos;
				//meses = difMeses;
				//dias = difDias;
				}
				
				if (difMeses > 0 && difDias < 0){
				retornoEnEdadEnAnios = difAnyos;
				//meses = difMeses-1;
				//dias = 30+difDias;
				}
				
				if (difMeses ==0){
				if (difDias >=0){ 
				retornoEnEdadEnAnios = difAnyos;
				//meses = difMeses;
				//dias = difDias;
				}
				
				if (difDias <0){
				retornoEnEdadEnAnios = difAnyos-1;
				//meses = 11;
				//dias = 30+difDias;
				}
				
				}
				if (difMeses <0 && difDias>0){
				retornoEnEdadEnAnios = difAnyos-1;
				//meses = 12+difMeses;
				//dias = difDias;
				
				}
				if (difMeses <0 && difDias<=0){
				retornoEnEdadEnAnios = difAnyos-1;
				//meses = 12+difMeses+difDias;
				//dias = 30+difDias;
				}
				
				}
				if (difAnyos==0){
				if (difMeses>0 && difDias >=0){
				retornoEnEdadEnAnios = difAnyos;
				// meses = difMeses+difDias;
				//dias = difDias;
				}
				if (difMeses>0 && difDias <0){
				retornoEnEdadEnAnios = difAnyos;
				// meses = difMeses-1;
				//dias = 30+difDias;
				}
				}
				if (difAnyos==0){
				if (difMeses==0 && difDias >=0){
				retornoEnEdadEnAnios = difAnyos;
				//  meses = difMeses;
				// dias = difDias;
				}  
				
				//if (difMeses==0 && difDias <0){
				//  edad= ("Fecha incorrecta");
				//}   
				
				}
				return retornoEnEdadEnAnios;
				}//Cierra calcularEdad
/*----------------------------------------------------------------------------------*/
			//Pasar a string a int
			public static int pasarStringAInt (String cadenaString){
				int resultado = 0;
				resultado= Integer.parseInt(cadenaString);
				return resultado;
			}
/*----------------------------------------------------------------------------------*/
			//Pasar a string a int
			public static String pasarLongAString (long cadenaLong){
				String resultado = "";
				resultado= Long.toString(cadenaLong);
				return resultado;
			}
/*----------------------------------------------------------------------------------*/
			//Pasar String a Vector int
			public static int[] pasarStringAVectorInt(String cadenaString){
		        int tamanioCadenaString = cadenaString.length();
				//Genero el array
				int vector[] = new int [tamanioCadenaString];
				//Recorro mi array y voy guardando caada digito
				for (int i=0; i<tamanioCadenaString; i++){
				      vector[i] = Integer.parseInt(cadenaString.substring(i,i+1));
				      System.out.println (vector[i]);
					  }//Cierra el For   El array va de [0] a [tamanioString -1]
				return vector;
			}
/*----------------------------------------------------------------------------------*/
			//Pasar int a String
			public static String pasarIntAString (int numero){
				String numCadena= String.valueOf(numero);
				return numCadena;
			}		
/*----------------------------------------------------------------------------------*/
			//Es primo
			public static boolean esPrimo(int numero){
				boolean resultado = true;
				int i = 2;
				if (numero==1){
					resultado = false;
				}else if (numero>0){
					while ((resultado)&&(i<=(int)Math.sqrt(numero))){
						if (numero%i==0){
							resultado = false;
						}
						i++;
					}
				}
				return resultado;
			}
/*----------------------------------------------------------------------------------*/
			public static boolean esPrimoMellizo(int primo1, int primo2){
				boolean resultado = false;
				if (esPrimo(primo1) && esPrimo(primo2)){
					if (primo1 > primo2){
						if (primo1 - primo2 == 2){
							resultado = true;
						}
					}else if (primo1 < primo2){
						if (primo2 - primo1 == 2){
							resultado = true;
						}
					}else{
						resultado = false;
					}
				}
					return resultado;
			}			
/*----------------------------------------------------------------------------------*/
//			CLONAR FECHA
			public static LocalDate clonarFecha(LocalDate fecha) {	
				return LocalDate.of(fecha.getYear(), fecha.getMonth(), fecha.getDayOfMonth());
			}
			
/*----------------------------------------------------------------------------------*/
//			CLONAR HORA
			public static LocalTime clonarHora(LocalTime hora) {
				return LocalTime.of(hora.getHour(), hora.getMinute());
			}
			
/*----------------------------------------------------------------------------------*/
			//Distancia entre fechas en dias
			public static int distanciaEntreFechasEnDias(LocalDate d1, LocalDate d2) {
				 
				int diffDays = Period.between(d1, d2).getDays();				
				
				return diffDays;
			}
			
/*----------------------------------------------------------------------------------*/
			//Validar Documento
				public static boolean esDocumentoValido(long dni) {
					boolean valido=true;
					if(String.valueOf(dni).length()>8) {
					valido=false;
					}
					return valido;
			}
/*----------------------------------------------------------------------------------*/
				//Validar Cuit
				public static boolean esCuitValido(long cuit) {
					boolean valido=true;
					if(String.valueOf(cuit).length()>11) {
					valido=false;
					}
					return valido;
			}
				
/*----------------------------------------------------------------------------------*/
				//Cual es la fecha mas antigua
				public static boolean esMasAntigua(LocalDate fechaAntes, LocalDate fechaDespues) {
					boolean esVieja=false;
					
					if(fechaAntes.isBefore(fechaDespues)) {
						esVieja = true;
					}
					
					
					return esVieja;
			}
/*----------------------------------------------------------------------------------*/
				//Validar cuil hombre
				public static boolean validarCuilHombre (String cuil) {
					boolean ok = false;
					if(cuil.length()==13) {
						if(Character.getNumericValue(cuil.charAt(0))==2 && cuil.charAt(2)=='-' && cuil.charAt(11)=='-') {
							int [] arrayInt = {5,4,0,3,2,7,6,5,4,3,2,0,0};
							int v1=0;
							int v2, v3, digito2;
							int i=0;
							while ((i < cuil.length()) && (esNumero(cuil.charAt(i)) || cuil.charAt(i)=='-' )) {
								if (esNumero(cuil.charAt(i))) {
									v1=v1+(arrayInt[i]*Character.getNumericValue(cuil.charAt(i)));
								}
								i++;
							}
							if (i>= cuil.length()) {
								v2=v1 %11;
								if (v2==0) {
									v3=0;
									digito2= 3;
								}
								else {
									if(v2==1) {
										v3 = 9;
										digito2= 3;
									}
									else {
										v3= 11- v2;
										digito2=0;
									}
								}
								if(Character.getNumericValue(cuil.charAt(1))==digito2 && Character.getNumericValue(cuil.charAt(12))==v3) {
									ok = true;
								}
							}
						}
					}
					return ok;
				}
			
/*----------------------------------------------------------------------------------*/
				//Validar cuil mujer
				public static boolean validarCuilMujer (String cuil) {
					boolean ok = false;
					if(cuil.length()==13) {
						if(Character.getNumericValue(cuil.charAt(0))==2 && cuil.charAt(2)=='-' && cuil.charAt(11)=='-') {
							int [] arrayInt = {5,4,0,3,2,7,6,5,4,3,2,0,0};
							int v1=0;
							int v2, v3, digito2;
							int i=0;
							while ((i < cuil.length()) && (esNumero(cuil.charAt(i)) || cuil.charAt(i)=='-' )) {
								if (esNumero(cuil.charAt(i))) {
									v1=v1+(arrayInt[i]*Character.getNumericValue(cuil.charAt(i)));
								}
								i++;
							}
							if (i>= cuil.length()) {
								v2=v1 %11;
								if (v2==0) {
									v3=0;
									digito2= 3;
								}
								else {
									if(v2==1) {
										v3 = 4;
										digito2= 3;
									}
									else {
										v3= 11- v2;
										digito2=7;
									}
								}
								if(Character.getNumericValue(cuil.charAt(1))==digito2 && Character.getNumericValue(cuil.charAt(12))==v3) {
									ok = true;
								}
							}
						}
					}
					return ok;
				}
				
/*----------------------------------------------------------------------------------*/
				public static ArrayList<LocalDate> cargarLstFeriados(){
					try {
						File dirBase = new File("src/funciones/feriados.xml"); 
						String ruta = dirBase.getAbsolutePath();
						BufferedReader br = new BufferedReader(new FileReader(ruta));
						
						String entrada;
						String cadena = "";
						
						while ((entrada = br.readLine()) != null)
							cadena += entrada;
						
						DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
						DocumentBuilder db = dbf.newDocumentBuilder();
						
						InputSource archivo = new InputSource();
						archivo.setCharacterStream(new StringReader(cadena));
						
						Document documento = db.parse(archivo);
						documento.getDocumentElement().normalize();
						
						NodeList nodeLista = documento.getElementsByTagName("feriado");
						
						String[] tags = {"anio", "mes", "dia"};
						
						for (int s = 0; s < nodeLista.getLength(); s++) {
							
							Node nodo = nodeLista.item(s);
							String[] valores = new String[tags.length];
							if (nodo.getNodeType() == Node.ELEMENT_NODE) {
								Element elemento = (Element) nodo;
								for (int i = 0; i < tags.length; i++) {
									NodeList nombreElementoLista = elemento.getElementsByTagName(tags[i]);
									Element nombreElemento = (Element) nombreElementoLista.item(0);
									NodeList nombre = nombreElemento.getChildNodes();
									valores[i] = ((Node) nombre.item(0)).getNodeValue().toString();
								}
								
								int anio= Integer.parseInt(valores[0]);
								int mes= Integer.parseInt(valores[1]);
								int dia = Integer.parseInt(valores[2]); 
								
								LocalDate p= LocalDate.of(anio, mes, dia);
								lstFeriados.add(p);
								}
							}
							br.close();
						} catch (Exception e) {
							System.out.println(e.getMessage());
						}
					return lstFeriados;
				}
				
/*----------------------------------------------------------------------------------*/
				//Traer primer dia habil
				public static LocalDate traerPrimerDiaHabil(LocalDate f){
					int anio = f.getYear();
					int mes  = f.getMonthValue();
					int dia = f.getDayOfMonth();
					
					LocalDate temporal = LocalDate.of(anio, mes, dia);
					temporal.plusDays(1);
				//	while (esHabil(temporal) == false){
					//	temporal.plusDays(1);
					//}
					return temporal;
				} 
				
/*----------------------------------------------------------------------------------*/	
				//habiles del 2021
			/*	public static boolean esHabil(LocalDate f){
					boolean esHabil = true; 
					
					int anio = f.getYear();	
					int mes =  f.getMonthValue();
					int dia = f.getDayOfMonth();
					int i = 0;
					
					for (i= 0; i<lstFeriados.size(); i++){
						if (anio == lstFeriados.get(i).getYear()) {
							if (mes == lstFeriados.get(i).getMonthValue()) {
								if (dia == lstFeriados.get(i).getDayOfMonth()) {
									esHabil = false;
									i = lstFeriados.size();
								}
							}
						}
					}
					if ((f.getDayOfWeek()) || (f.getDayOfWeek().compareTo())) {
							.get(Calendar.DAY_OF_WEEK) == 1) || (f.get(Calendar.DAY_OF_WEEK) == 7)){
						esHabil = false;
					}
					return esHabil;	
				}
				*/
				
			
			
	}



