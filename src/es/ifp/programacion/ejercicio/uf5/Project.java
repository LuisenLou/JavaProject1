package es.ifp.programacion.ejercicio.uf5;

import java.time.*;
import java.util.HashMap;

/**Clase Project con metodo que sobrescribe datos finales.
 */
public class Project {
	
	//Atributos:
	
	private String projectID;
	private String projectName;
	private String description;
	
	private LocalDate startDate;
	
	private HashMap<String, Client> allClient;
	private HashMap<String, Boss> allBoss;
	
	
	//Constructores:
	/**
	 * Constructor compuesto por instancias de clase Client y Boss.
	 * @param projectID  Identificacion alfanumerica del proyecto.
	 * @param projectName Nombre del proyecto
	 * @param description Breve descripcion del proyecto.
	 * @param startDate Fecha de inicio del proyecto.
	 */
	public Project(String projectID, String projectName, String description, LocalDate startDate) {
		this.projectID = projectID;
		this.projectName = projectName;
		this.description = description;
		this.startDate = startDate;
		
		this.allClient = new HashMap<String, Client>();
		this.allBoss = new HashMap<String, Boss>();
	}
	
	//Métodos:

	/**Metodo Getter que permite acceder a la identificacion del proyecto.
	 * @return projectID String con el dato alfanumerico de indentificacion del proyecto.
	 */
	public String getProjectID() {
		return projectID;
	}
	/**Metodo Setter que permite modificar la identificacion del proyecto.
	 * @param projectID String con la nueva identificacion del proyecto.
	 */
	public void setProjectID(String projectID) {
		this.projectID = projectID;
	}
	
	
	/**Metodo Getter que permite acceder al nombre del proyecto.
	 * @return projectName String con el nombre del proyecto.
	 */
	public String getProjectName() {
		return projectName;
	}
	/**Metodo Setter que permite modificar el nombre del proyecto.
	 * @param projectName String con el nuevo nombre del proyecto.
	 */
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	
	
	/**Metodo Getter que permite acceder a la descripcion del proyecto.
	 * @return description String con la descrpcion del poyecto.
	 */
	public String getDescription() {
		return description;
	}
	/**Metodo Setter que permite modificar la descripcion del proyecto.
	 * @param description String con la nueva descripcion del proyecto.
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	/**Metodo Getter que permite acceder a la fecha de inicio del proyecto.
	 * @return startDate LocalDateTime con la fecha de inicio del proyecto.
	 */
	public LocalDate getStartDate() {
		return startDate;
	}
	/**Metodo Setter que permite modificar la fecha de inicio del proyecto.
	 * @param startDate LocalDateTime con la nueva fecha de inicio del proyecto.
	 */
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	
	/**Metodo Getter que permite acceder a la coleccion.
	 * @return allClient HashMap de objetos Client.
	 */
	public HashMap<String, Client> getAllClient() {
		return allClient;
    }
	
	/**Metodo Setter que permite modificar el HashMap dataClient.
	 * @param allClient HashMap nuevo con datos diferentes.
	 */
	public void setAllClient(HashMap<String, Client> allClient) {
        this.allClient = allClient;
    }
	
	/**Metodo Getter que permite acceder a la coleccion.
	 * @return allBoss HashMap de objetos Boss.
	 */
	public HashMap<String, Boss> getAllBoss() {
		return allBoss;
    }
	
	/**Metodo Setter que permite modificar la coleccion.
	 * @param allBoss HashMap nuevo con datos diferentes.
	 */
    public void setAllBoss(HashMap<String, Boss> allBoss) {
        this.allBoss = allBoss;
    }

	
	/**Método toString:
	 * Representación de datos en cadena legible del objeto que lo implemente.
	 * Acceso por medio de Getters a los atributos de los objetos contenidos.
	 */
	@Override
	public String toString() {
		String result;
		result = "================================================================"+"\n"+
				"DATOS DEL PROYECTO"+"\n"+
				"================================================================"+"\n"+
				"ID Proyecto: PRO"+ getProjectID()+"\n"+
				"Nombre del proyecto: "+ getProjectName()+"\n"+
				"Descripción: "+ getDescription()+"\n"+
				"Fecha de inicio del proyecto: "+ getStartDate()+"\n"+
				"================================================================"+"\n"+
				"";
				for(Client client : this.allClient.values()) {
					result += client.toString();
				}
				for(Boss boss : this.allBoss.values()) {
					result += boss.toString();
				}
				
				return result;
			
	}
}
