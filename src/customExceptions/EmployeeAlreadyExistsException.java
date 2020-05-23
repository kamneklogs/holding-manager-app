package customExceptions;

@SuppressWarnings("serial")
public class EmployeeAlreadyExistsException extends Exception {
	String id;
	public EmployeeAlreadyExistsException(String id) {
		this.id = id;
	}
	
	public String getMessage() {
		return "Employee with id " + id + " already exists!";
	}
}
