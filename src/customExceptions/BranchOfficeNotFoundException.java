package customExceptions;

@SuppressWarnings("serial")
public class BranchOfficeNotFoundException extends Exception {
	private String id;
	
	/**
	 * 
	 * @param id
	 */
	public BranchOfficeNotFoundException(String id) {
		this.id = id;
	}
	
	/**
	 * 
	 */
	public String getMessage() {
		return "La oficina con id  " + id + " no ha sido encontrado!";
	}	
}
