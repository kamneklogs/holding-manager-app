package model;

public class EmployeeReportDetailed extends Report {
	
	private String id;

    public EmployeeReportDetailed(boolean toTxt, Company company, String id) {
    	super(toTxt,company);           
    	this.id = id;
    }
    
	@Override
	public void generateReport() {
		// TODO Auto-generated method stub
		
	}
}