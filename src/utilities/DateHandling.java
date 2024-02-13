package utilities;

import java.time.LocalDate;
import es.ifp.programacion.ejercicio.uf5.DateLogicException;

/**Clase para gestion de la logica en torno a las fechas.
 */
public class DateHandling {
	/**
	 * Metodo que establece fecha si entra en rangos de lógica.
	 * @param year Agno escogido.
	 * @param month Mes escogido.
	 * @param day Dia escogido.
	 * @return LocalDate con la fecha escogida si cumple con la logica.
	 * @throws DateLogicException Si no cumple con la logica de los dias y meses lanza excepcion.
	 */
	public static LocalDate getDate(int year, int month, int day) throws DateLogicException {
	    if (day < 1 || day > 31 || month < 1 || month > 12 || (day == 31 && (month == 4 || month == 6 || month == 9 || month == 11)) || (month == 2 && day > 28)) {
	        throw new DateLogicException("Error al introducir fecha.");
	    }

	    return LocalDate.of(year, month, day);
	}
}
