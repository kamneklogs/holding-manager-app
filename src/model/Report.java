package model;

public abstract class Report {

    private String content;
    private boolean toScreen;
    private boolean toCsv;
    private boolean toTxt;
    private Company company;
    
    public Report(boolean toScreen, boolean toCsv, boolean toTxt, Company company) {
    	this.toScreen = toScreen;
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

	public boolean isToScreen() {
		return toScreen;
	}

	public boolean isToCsv() {
		return toCsv;
	}	

}