package es.ifp.programacion.ejercicio.uf5;
/**
 * Excepcion que hereda de la clase Exception para entrar en la jerarquia.
 * Excepcion que se da cuando el DNI no se encuentra.
 *
 */
public class IDException extends Exception{
	
	/**
	 * Objeto IDException cuyo parametro es un mensaje de salida de tipo String.
	 * @param msg Mensaje de error.
	 */
	public IDException(String msg) {
		super(msg);
	}
}
