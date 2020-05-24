package model;

public abstract class Report {

    private String content;   
    private boolean toCsv;
    private boolean toTxt;
    private Company company;
    
    public Report(boolean toCsv, boolean toTxt, Company company) {
    	this.toCsv = toCsv;
    	this.toTxt = toTxt;
    	this.company = company;
    }    
    
    public abstract String generateReport();
    
    public void setContent(String content) {
		this.content = content;
	}

	public void setToTxt(boolean toTxt) {
		this.toTxt = toTxt;
	}	

	public String getContent() {
		return content;
	}	

	public boolean isToTxt() {
		return toTxt;
	}

	public Company getCompany() {
		return company;
	}

	public boolean isToCsv() {
		return toCsv;
	}	

}