package es.ifp.programacion.ejercicio.uf5;
/**
 * Excepcion que hereda de la clase Exception para entrar en la jerarquia.
 * Excepcion que se da cuando existe valor fuera del rango establecido.
 */
public class NumberOutOfRangeException extends Exception{
	
	/**
	 * Objeto NumberOutOfRangeException cuyo parametro es un mensaje de salida de tipo String.
	 * @param msg Mensaje de error.
	 */
	public NumberOutOfRangeException(String msg) {
		super(msg);
	}
}
