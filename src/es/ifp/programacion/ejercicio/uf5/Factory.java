package es.ifp.programacion.ejercicio.uf5;

import java.time.LocalDate;
import java.util.HashMap;

import utilities.DataFromConsole;
import utilities.DateHandling;

/**
 * Clase Factory encargada de la creacion de objetos.
 */
public class Factory {

	/**
	 * Metodo de creacion de fechas.
	 * @return startDate Fecha en formato YY/MM/DD.
	 * @throws NumberFormatException nfd Excepcion por valor de entrada no numerico. Si error en formato numerico la fecha que se expresará sera la actual.
	 * @throws DateLogicException df Excepcion si no se cumple la logica de fecha en los dias y meses. En caso de fecha fuera del rango de logica lanzamos mensaje de error y propagamos.
	 */
	public static LocalDate dateFactory() throws NumberFormatException, DateLogicException {
		int day;
		int month;
		int year;
		LocalDate startDate;
		try {
			year = Integer.parseInt(DataFromConsole.getData("Introduzca el año: "));
			day = Integer.parseInt(DataFromConsole.getData("Introduzca el día: "));
			month = Integer.parseInt(DataFromConsole.getData("Introduzca el mes: "));
			startDate = DateHandling.getDate(year,month,day);
	 	
			return startDate;
	 	
		}catch (NumberFormatException nfd) {
			return LocalDate.now();
		}catch (DateLogicException df) {
			throw new DateLogicException ("Error al introducir fecha.");
		}
	}
	
	/**
	 * Metodo que crea el objeto Cliente.
	 * @return Client objeto Cliente.
	 */
	public static Client clientFactory() {
		String nameInput;
		String surname1Input;
		String surname2Input;
		String idInput;
		String cliNum;
		
		nameInput = DataFromConsole.getData("Introduzca el nombre del cliente: ");
		surname1Input = DataFromConsole.getData("Introduzca el primer apellido del cliente: ");
		surname2Input = DataFromConsole.getData("Introduzca el segundo apellido del cliente: ");
		idInput = DataFromConsole.getData("Introduzca el DNI del cliente: ");
		cliNum = DataFromConsole.getData("Introduzca el número del cliente: ");
		
	//Instanciamos objeto de clase Client el cual será el cliente del proyecto.
		return new Client(nameInput,surname1Input,surname2Input,idInput,cliNum);
	
	}
	
	/**
	 * Metodo que crea el objeto Boss.
	 * @return Boss objeto Boss.
	 * @throws NumberOutOfRangeException Excepcion si numero de empleado fuera de rango para establecer numero de empleado.
	 * @throws NumberFormatException Excepcion por valor de entrada no numerico en numero de empleado.
	 */
	public static Boss bossFactory() throws NumberOutOfRangeException, NumberFormatException{
		
		String nameInput;
		String surname1Input;
		String surname2Input;
		String idInput;
		int empNum;
		try {	
			nameInput = DataFromConsole.getData("Introduzca el nombre del empleado: ");
			surname1Input = DataFromConsole.getData("Introduzca el primer apellido del empleado: ");
			surname2Input = DataFromConsole.getData("Introduzca el segundo apellido del empleado: ");
			idInput = DataFromConsole.getData("Introduzca el DNI del empleado: ");
			empNum = Integer.parseInt(DataFromConsole.getData("Introduzca el número de empleado(0-100): "));
			while(empNum<0 || empNum>100) {
				empNum = Integer.parseInt(DataFromConsole.getData("Dato erróneo. Introduzca el número de empleado(0-100): "));
		}
		
	//Instanciamos objeto de clase Boss el cual será el jefe del proyecto.
		return new Boss(nameInput,surname1Input,surname2Input,idInput,empNum);
	
		}catch (NumberFormatException nf) {
			throw new NumberFormatException ("Error: Dato incorporado no numérico.");
		}
	}
	
	/**
	 * Metodo que crea el objeto Project.
	 * @return Project objeto Project con atributos y HashMap completos.
	 * @throws NumberOutOfRangeException Excepcion si numero de empleado fuera de rango al usar el metodo 'bossFactory' para establecer nuevo numero de empleado.
	 * @throws DateLogicException Excepcion si fecha fuera de la logica al usar el método 'dateFactory' para establecer fecha.
	 * @throws NumberFormatException Excepcion si el formato de entrada no es un valor numerico al introducir fechas o numero de empleado.
	 */
	public static Project projectFactory() throws NumberOutOfRangeException, NumberFormatException, DateLogicException{
		String description;
		String proNum;
		String proName;
		LocalDate startDate;
		Client client;
		Boss boss;
		Project project;
		
		proName = DataFromConsole.getData("Introduzca el nombre del proyecto: ");
		proNum = DataFromConsole.getData("Introduzca el número del proyecto: ");
		description = DataFromConsole.getData("Introduzca una breve descripción del proyecto: ");
		
		startDate = dateFactory();
		
		HashMap<String, Client> allClient = new HashMap<String, Client>();
		
		HashMap<String, Boss> allBoss = new HashMap<String, Boss>();
		
		String option;

		    do {
		        option = DataFromConsole.getData("¿Desea introducir un cliente (C) o un jefe de proyecto (J)? (Pulse N para continuar): ");
		        if (option.equalsIgnoreCase("C")) {
		        	client = clientFactory();
		            allClient.put(client.getiD(), client);
		        } else if (option.equalsIgnoreCase("J")) {
		        	boss = bossFactory();
		            allBoss.put(boss.getiD(),boss);
		        } else if(option.equalsIgnoreCase("N")){
		        } else System.out.println("Opción no válida.");      
		    } while (!option.equalsIgnoreCase("N"));
		    
		
		//Instanciamos objeto de clase Project el cual será el proyecto e incorporamos las colecciones al proyecto.
		project = new Project(proNum,proName,description,startDate);
		project.setAllClient(allClient);
		project.setAllBoss(allBoss);
		   
		return project;
		
	}
	
}
