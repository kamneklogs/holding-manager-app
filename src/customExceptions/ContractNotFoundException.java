package customExceptions;

@SuppressWarnings("serial")
public class ContractNotFoundException extends Exception{
	private String id;
	
	/**
	 * 
	 * @param id
	 */
	public ContractNotFoundException(String id) {
		this.id = id;
	}
	
	/**
	 * 
	 */
	public String getMessage() {
		return "El contrato con id " + id + " no ha sido encontrado!";
	}	
}
