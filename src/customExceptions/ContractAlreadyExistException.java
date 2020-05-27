package customExceptions;

@SuppressWarnings("serial")
public class ContractAlreadyExistException extends Exception {
	private String id;
	
	/**
	 * 
	 * @param id
	 */
	public ContractAlreadyExistException(String id) {
		this.id = id;
	}
	
	/**
	 * 
	 */
	public String getMessage() {
		return "El contrato con id " + id + " ya existe!";
	}	
}
