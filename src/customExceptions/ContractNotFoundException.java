package customExceptions;

@SuppressWarnings("serial")
public class ContractNotFoundException extends Exception{
	private String id;
	public ContractNotFoundException(String id) {
		this.id = id;
	}
	
	public String getMessage() {
		return "Contract with id " + id + "not found!";
	}	
}
