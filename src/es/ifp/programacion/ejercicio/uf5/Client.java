package es.ifp.programacion.ejercicio.uf5;

/**
 * Clase Client: Hija. Hereda de la clase Person los atributos y metodos.
 */

public class Client extends Person{

	//Definición de atributos (propios):
	  
	private String clientID;
	
	//Constructores:
	//Con la llamada al padre mediante 'super' heredamos los atributos de la clase padre.
		/**
		 * Constructor de clase Client.
		 * @param name Nombre heredado de clase padre que pasa como parametro.
		 * @param surname1 Apellido heredado de clase padre que pasa como parametro.
		 * @param surname2 Apellido heredado de clase padre que pasa como parametro.
		 * @param iD Número de identidad(DNI)heredado de clase padre que pasa como parametro.
		 * @param clientID Identificacion alfanumerica del cliente.
		 */
	public Client(String name, String surname1, String surname2, String iD, String clientID) {
		super(name, surname1, surname2, iD);
		this.clientID = clientID;
	}
	

	//Metodos:
		/**Metodo Getter que permite acceder a la identificacion del cliente.
		 * @return clientID String con el dato alfanumerico de indentificacion del cliente.
		 */
		public String getClientID() {
			return clientID;
		}


		/**Metodo Setter que permite modificar el dato alfanumerico de identificacion del cliente.
		 * @param newClientID String con el nuevo dato alfanumerico de indentificacion del cliente.
		 */
		public void setClientID(String newClientID) {
			this.clientID = newClientID;
		}
		
		/**Metodo toString:
		 * Representacion de datos en cadena legible del objeto que lo implemente.
		 * Acceso por medio de Getters a los atributos del objeto.
		 * Usamos 'super' para tener acceso al metodo de la clase padre.
		 */
		@Override
		public String toString() {
			return"================================================================"+"\n"+
					"DATOS DEL CLIENTE"+"\n"+
					"================================================================"+"\n"+
					"ROL: "+ this.getRol()+"\n"+
					super.toString()+"\n"+
					"Identificación del cliente: "+ this.getRol()+ getClientID()+"\n"+
					"________________________________________________________________"+"\n"+
					"";
		}
		
		/**
		 * Metodo abstracto de superclase que implementa subclase.
		 * @return String con el valor "CLI"
		 */
		public String getRol() {
			return "CLI";
		}
		
}
