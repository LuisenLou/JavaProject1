package es.ifp.programacion.ejercicio.uf5;

/**Clase Boss: Hija. Hereda de la clase Person los atributos y metodos.
 */

public class Boss extends Person{

	//Definicion de atributos (propios):
	
	private int empNum;
		
	//Constructores:
		//Con la llamada al padre mediante 'super' heredamos los atributos de la clase padre.
		/**
		 * Constructor de clase Boss.
		 * @param name Nombre heredado de clase padre que pasa como parametro.
		 * @param surname1 Apellido heredado de clase padre que pasa como parametro.
		 * @param surname2 Apellido heredado de clase padre que pasa como parametro.
		 * @param iD Numero de identidad(DNI)heredado de clase padre que pasa como parametro.
		 * @param empNum Numero de empleado que pasa como parámetro.
		 * @throws NumberOutOfRangeException Entrada de numero fuera de rango valido.
		 * @throws NumberFormatException Entrada de numero de empleado en formato no numerico.
		 */
	public Boss (String name, String surname1, String surname2, String iD, int empNum) throws NumberOutOfRangeException, NumberFormatException {
		super(name, surname1, surname2,iD);
		try{
			if(empNum<0 || empNum>100)  throw new NumberOutOfRangeException ("Número de empleado fuera de rango.");
			else this.empNum = empNum;
		}catch(NumberFormatException nf) {
			throw new NumberFormatException ("Error: Dato incorporado no numérico.");
		}
	}
		
	//Métodos:
		
	/**Metodo Getter que permite acceder al numero del empleado.
	 *@return empNum int con el valor del numero de empleado del objeto de la clase Boss.
	 */
	public int getEmpNum() {
		return empNum;
	}

	/**Metodo Setter que permite modificar el numero del empleado.
	 * @param newEmpNum int con el nuevo valor del numero de empleado del objeto de la clase Boss.
	 * @throws NumberOutOfRangeException Excepcion si dato fuera de rango.
	 * @throws NumberFormatException Excepcion si dato no numerico.
	 */
	public void setEmpNum(int newEmpNum)throws NumberOutOfRangeException, NumberFormatException {
			try{
				if(empNum<0 || empNum>100)  throw new NumberOutOfRangeException ("Número de empleado fuera de rango.");
				this.empNum = newEmpNum;
			}catch(NumberFormatException nf) {
				throw new NumberFormatException ("Error: Dato incorporado no numérico.");
			}
	}
	
	/**Metodo toString:
	 * Representacion de datos en cadena legible del objeto que lo implemente.
	 * Acceso por medio de Getters a los atributos del objeto.
	 * Usamos 'super' para tener acceso al metodo de la clase padre.
	 */
	@Override
	public String toString(){
			try {
				return "================================================================"+"\n"+
						"DATOS DEL JP"+"\n"+
						"================================================================"+"\n"+
						"ROL: "+ this.getRol()+"\n"+
						super.toString()+"\n"+
						"Número de empleado: "+ this.getRol()+getEmpNum()+"\n"+
						"________________________________________________________________"+"\n"+
						"";
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return "======================================================"+"\n"+
						"DATOS DEL JP"+"\n"+
						"================================================================"+"\n"+
						"ROL: "+ this.getRol()+"\n"+
						super.toString()+"\n"+
						"Número de empleado incorrecto."+"\n"+
						"________________________________________________________________"+"\n"+
						"";
			}
	}
	
	/**
	 * Metodo abstracto de superclase que implementa subclase.
	 * @return String con el valor "JP"
	 */
	public String getRol() {
		return "JP";
	}
	
}
