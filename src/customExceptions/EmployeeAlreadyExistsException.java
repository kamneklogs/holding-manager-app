package customExceptions;

@SuppressWarnings("serial")
public class EmployeeAlreadyExistsException extends Exception {
	String id;
	public EmployeeAlreadyExistsException(String id) {
		this.id = id;
	}
	
	public String getMessage() {
		return "El empleado con id " + id + " ya existe!";
	}
}
