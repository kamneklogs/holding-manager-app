package customExceptions;

@SuppressWarnings("serial")
public class EmployeeNotFoundException extends Exception {
	private String id;
	
	/**
	 * 
	 * @param id
	 */
	public EmployeeNotFoundException(String id) {
		this.id = id;
	}
		
	/**
	 * 
	 */
	public String getMessage() {
		return "El empleado con id " + id + " no ha sido encontrado!";
	}
}
