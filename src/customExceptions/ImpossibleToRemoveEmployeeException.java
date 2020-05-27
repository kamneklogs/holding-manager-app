package customExceptions;

@SuppressWarnings("serial")
public class ImpossibleToRemoveEmployeeException extends Exception {
	
	String message;
	/**
	 * 
	 * @param message
	 */
	public ImpossibleToRemoveEmployeeException(String message) {
		this.message = message;
	}
	
	/**
	 * 
	 */
	public String getMessage() {
		return message;
	}

}
