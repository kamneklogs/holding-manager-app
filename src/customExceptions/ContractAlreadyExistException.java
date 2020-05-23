package customExceptions;

@SuppressWarnings("serial")
public class ContractAlreadyExistException extends Exception {
	private String id;
	public ContractAlreadyExistException(String id) {
		this.id = id;
	}
	
	public String getMessage() {
		return "Contract with id " + id + "already exists!";
	}	
}
