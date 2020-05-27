package customExceptions;

@SuppressWarnings("serial")
public class BranchOfficeAlreadyExistException extends Exception {
	private String id;
	/**
	 * 
	 * @param id
	 */
	public BranchOfficeAlreadyExistException(String id) {
		this.id = id;
	}
	
	/**
	 * 
	 */
	public String getMessage() {
		return "La oficina con id " + id + " ya existe!";
	}	
}
