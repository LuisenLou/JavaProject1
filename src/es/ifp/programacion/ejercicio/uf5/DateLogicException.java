package es.ifp.programacion.ejercicio.uf5;
/**
 * Excepcion que hereda de la clase Exception para entrar en la jerarquia.
 * Excepcion cuando fecha fuera de logica del calendario.
 *
 */
public class DateLogicException extends Exception {
	
	/**
	 * Objeto DateLogicException cuyo parametro es un mensaje de salida de tipo String.
	 * @param msg Mensaje de error.
	 */
	public DateLogicException(String msg) {
		super(msg);
	}
}