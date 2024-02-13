package es.ifp.programacion.ejercicio.uf5;


/**
 * Clase Person: Padre.
 */

public abstract class Person {

	//Definicion de atributos:
	
	private final String name;
	private final String surname1;
	private final String surname2;
	private final String iD;
	
	//Constructores:
	/**
	 * Constructor de clase Persona.
	 * @param name Nombre que pasa como parametro.
	 * @param surname1 Apellido que pasa como parametro.
	 * @param surname2 Apellido que pasa como parametro.
	 * @param iD Número de identidad (DNI) que pasa como parametro.
	 */
	public Person(String name, String surname1, String surname2, String iD) {
		
		this.name = name;
		this.surname1 = surname1;
		this.surname2 = surname2;
		this.iD = iD;
	}
	
	//Metodos:
		//Getters unicamente evitando su posible modificacion al buscar ser un dato inmutable.
		//Solo buscamos tener acceso a ellos.
		
	/**Metodo Getter que accede al nombre.
	 * @return name String con informacion del nombre del objeto de clase Persona.
	 */
	public String getName() {
		return name;
	}

	/**Metodo Getter que accede al primer apellido.
	 * @return surname1 String con información del primer apellido del objeto de clase Persona.
	 */
	public String getSurname1() {
		return surname1;
	}

	/**Metodo Getter que accede al segundo apellido.
	 * @return surname2 String con información del segundo apellido del objeto de clase Persona.
	 */
	public String getSurname2() {
		return surname2;
	}

	/**Metodo Getter que accede al DNI.
	 * @return iD  String con información del DNI del objeto de clase Persona.
	 */
	public String getiD() {
		return iD;
	}
	
	/**Metodo toString:
	 * Representacion de datos en cadena legible del objeto que lo implemente.
	 * Acceso por medio de Getters a los atributos del objeto.
	 */
	@Override
	public String toString() {
		return "Nombre: "+ getName()+"\n"+
				"Apellidos: "+ getSurname1() + " "+ getSurname2()+"\n"+
				"DNI: "+ getiD();
	}
	
	/**
	 * Metodo abstracto que por herencia implementaran las subclases.
	 * @return String con rol en las clases hijas. 
	 */
	public abstract String getRol();
	
}


