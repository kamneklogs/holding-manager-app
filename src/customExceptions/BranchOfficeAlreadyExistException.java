package customExceptions;

@SuppressWarnings("serial")
public class BranchOfficeAlreadyExistException extends Exception {
	private String id;
	public BranchOfficeAlreadyExistException(String id) {
		this.id = id;
	}
	
	public String getMessage() {
		return "Branch office with id " + id + " already exists!";
	}	
}
