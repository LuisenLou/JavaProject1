package utilities;

import java.util.Scanner;

/**Clase para gestion de entrada de datos.
 */
public class DataFromConsole {
	/**
	 * Metodo encargado de entrada de datos.
	 * @param msg Mensaje que pide el dato.
	 * @return String con dato de entrada por consola.
	 */
	public static String getData(String msg) {
		System.out.println("=============================================");
		System.out.println(msg);
		System.out.println("=============================================");
		Scanner entrada = new Scanner (System.in);
		return entrada.nextLine();
	} 
}
