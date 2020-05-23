package customExceptions;

@SuppressWarnings("serial")
public class BranchOfficeNotFoundException extends Exception {
	private String id;
	public BranchOfficeNotFoundException(String id) {
		this.id = id;
	}
	
	public String getMessage() {
		return "Branch office with id " + id + " not found!";
	}	
}
