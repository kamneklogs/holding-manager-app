package customExceptions;

@SuppressWarnings("serial")
public class ImpossibleToRemoveEmployeeException extends Exception {
	
	String message;
	public ImpossibleToRemoveEmployeeException(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}

}
