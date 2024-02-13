package es.ifp.programacion.ejercicio.uf5;
import utilities.DataFromConsole;
/**
 * @author luisen
 * Version 5 02/11/2023.
 * Programa principal: Programa encargado de gestionar la creacion de un proyecto consistente en un Cliente , un Jefe de Proyecto y el propio proyecto. El proyecto
 * puede crearse sin Cliente ni Jefe de Proyecto. Los datos basicos como nombre y apellido ademas de DNI de los integrantes no pueden modificarse. Esto se consigue
 * por medio de la eliminacion o no disposicion de los metodos setters que permitirian su modificacion. A eso le añadimos 'final' para evitar
 * definitivamente la posibilidad de algun cambio en estos atributos inmutables.
 * El programa permite la modificacion de los datos tras un menu, ademas de la creacion de varios integrantes del proyecto. 
 * En el programa principal se manejan se manejan excepciones de valores fuera de rango, valores no numericos, logica de fecha incorrecta y DNI/id no encontrado.
 * En la clase factory se resuelve la excepcion de formato de fecha a modo de practica de la siguiente manera: Si formato no numerico la salida de la fecha
 * datara del año , mes y dia exactos en los que se inicia el programa. Manejo mas complejo de la excepciones que en UF04.
 * Se mantiene la estructura por aprendizaje y orden, se desplaza la creacion de objetos fuera del main y se maneja la correccion de datos
 * en el propio main y mediante metodos propios de la clase.
 * Se utilizan clases fuera del paquete del ejercicio para la entrada de datos y el manejo de fechas del paquete 'utilities' creado para poder servirse
 * uno de estos metodos cuando se necesiten y favorecer la reutilizacion. Podria haberse manejado las modificaciones en otra clase tambien se podria haber modularizado mas, 
 * el resultado final es el que a priori bajo mi criterio quedaba mas resuelto. 
 * La coleccion escogida es HashMap por la facilidad que nos aporta a la hora de encontrar datos. La busqueda por clave-valor y el uso de la clave para otorgar ese caracter unico 
 * a cada objeto son motivos por los cuales considere los HashMap una opcion adecuada para el ejercicio.
 * Recursos utilizados: API de Java y el material didactico del curso de programacion de iFP.
 */
public class ProgramaPrincipal {

/**
 * Metodo principal del programa principal.
 * @param args 
 */
	public static void main(String[] args) {
	
		//Declaracion de variables.
		Project project;
		String option;
		
		//Entrada de datos.
		try{
			
			project = Factory.projectFactory();
					
		//Salida de datos.
			
		System.out.println(project.toString());	
			
		//Modificar algún dato.
			
			option = DataFromConsole.getData("Si desea corregir algún dato pulse 'S', sino pulse 'N'.");
				if(option.equalsIgnoreCase("S")) {
					changeProject(project);	
				}else if(option.equalsIgnoreCase("N")) {
					System.out.println("No se realizó ningún cambio.");
				}else System.out.println("Opción no contemplada.");
			
		//Salida de datos modificados.
				
		System.out.println(project.toString());			
			
		//Manejo de excepciones.
			
		}catch(NumberOutOfRangeException noof) {
			System.out.println(noof.getMessage());
		}catch(IDException id) {
			System.out.println(id.getMessage());
		}catch(DateLogicException df) {
			System.out.println(df.getMessage());
		}catch(NumberFormatException nf) {
			System.out.println(nf.getMessage());
		}
	}
	
	
	/**
	 * Metodo que permite cambiar atributos accesibles por medio de setters.
	 * @param project Objeto de clase Project.
	 * @throws NumberOutOfRangeException Excepcion por numero fuera del rango valido al usar metodo changedOption.
	 * @throws NumberFormatException Excepcion por valor de entrada no numerico al escribir 'option' y usar metodo changedOption.
	 * @throws IDException Excepcion que se da cuando no se encuentra el DNI/id.
	 */
	
	
		public static void changeProject (Project project) throws IDException,NumberOutOfRangeException, NumberFormatException{
			int option;
		do {
			showMenu();
			try {
			option = Integer.parseInt(DataFromConsole.getData("Introduzca el número para cambiar el dato"));
			
			String search;
			switch (option) {
		
				case 1: search = DataFromConsole.getData("Introduzca el DNI del empleado:");
						if(changedOption(project, search, option) == true) System.out.println("Cambiado número de empleado con DNI: "+ search);
						else 
							throw new IDException ("El DNI aportado no coincide con ninguno en la base de datos.");	
						break;	
				case 2:search = DataFromConsole.getData("Introduzca el DNI del cliente:");
						if(changedOption(project, search, option) == true) System.out.println("Cambiado número de cliente con DNI: "+ search);
						else throw new IDException ("El DNI aportado no coincide con ninguno en la base de datos.");	
						break;	
				case 3: project.setProjectName(DataFromConsole.getData("Introduzca nuevo nombre del proyecto")); break;
				case 4: project.setProjectID(DataFromConsole.getData("Introduzca nuevo ID del proyecto")); break;
				case 5: project.setDescription(DataFromConsole.getData("Introduzca nueva descripción del proyecto")); break;
				case 0: break;
				default: System.out.println("Opción no valida, intente de nuevo.");break;
			}	
			}catch(NumberFormatException nf) {
				throw new NumberFormatException ("Error: Dato incorporado no numérico.");
			}
		}while(option!=0);	
		
	}
		/**
		 * Metodo que realiza lectura de la coleccion, introduce el nuevo valor de numero de empleado y devuelve boolean si accion realizada.
		 * @param project Objeto project del leemos las colecciones que almacenan los objetos.
		 * @param search Parametro con el DNI/id que se busca.
		 * @param option Parametro con el valor necesario para los condicionales.
		 * @return true si se realiza la accion al encontrar el id, false sino se realiza al no encontrar el id.
		 * @throws NumberOutOfRangeException Excepcion que se lanza, sucede cuando el numero de empleado esta fuera de rango.
		 * @throws NumberFormatException Excepcion que se lanza, sucede cuando el formato de entrada no es numerico cuando se establece el numero de empleado.
		 */
		public static boolean changedOption (Project project, String search, int option) throws NumberOutOfRangeException, NumberFormatException{
			int newNum;
		
			if(option == 1) {
				for(String bossID : project.getAllBoss().keySet()){//Uso del bucle for para poder leer y actualizar los datos por clave.
					if(bossID.equalsIgnoreCase(search)){
						Boss boss = project.getAllBoss().get(bossID);
						newNum = Integer.parseInt(DataFromConsole.getData("Introduzca nuevo número de empleado(0-100)"));
						if(newNum < 0 || newNum > 100) throw new NumberOutOfRangeException ("Número de empleado fuera de rango.");
						else {boss.setEmpNum(newNum);
						return true;
						}
					}
				} return false;
			}else if(option == 2) {
				for(String clientID : project.getAllClient().keySet()){
					Client client =  project.getAllClient().get(clientID);
					if(clientID.equalsIgnoreCase(search)) {
						client.setClientID(DataFromConsole.getData("Introduzca nuevo número del cliente"));
						return true;
					}
				}return false;
			}
			return false;
	}
		
		/**
		 * Metodo que muestra menu para modificacion.
		 */
		public static void showMenu() {
			System.out.println("======================================================================");
			System.out.println("Si desea cambiar algún dato pulse el número indicado, sino pulse '0'");
			System.out.println("1. Modificar número del empleado.");
			System.out.println("2. Modificar número del cliente.");
			System.out.println("3. Modificar nombre del proyecto.");
			System.out.println("4. Modificar número del proyecto.");
			System.out.println("5. Modificar descripción del proyecto.");
			System.out.println("0. Salir.");
			System.out.println("======================================================================");
		}
}
	

