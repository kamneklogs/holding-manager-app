package customExceptions;

@SuppressWarnings("serial")
public class EmployeeNotFoundException extends Exception {
	private String id;
	public EmployeeNotFoundException(String id) {
		this.id = id;
	}
	
	public String getMessage() {
		return "Employee with id " + id + " not found!";
	}
}
