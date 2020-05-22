package model;

public class ContractReportDetailed extends Report {
	private String id;
	
    public ContractReportDetailed(boolean toTxt, Company company, String id) {
        super(toTxt,company);  
        this.id = id;
    }    

	@Override
	public void generateReport() {		
		
	}
}