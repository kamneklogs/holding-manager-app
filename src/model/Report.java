package model;

public abstract class Report {

    private String content;   
    private boolean toCsv;
    private boolean toTxt;
    private Company company;
    
    /**
     * 
     * @param toCsv
     * @param toTxt
     * @param company
     */
    public Report(boolean toCsv, boolean toTxt, Company company) {
    	this.toCsv = toCsv;
    	this.toTxt = toTxt;
    	this.company = company;
    }    
    
    /**
     * 
     * @return
     */
    public abstract String generateReport();
    
    /**
     * 
     * @param content
     */
    public void setContent(String content) {
		this.content = content;
	}
    
    /**
     * 
     * @param toTxt
     */
	public void setToTxt(boolean toTxt) {
		this.toTxt = toTxt;
	}	

	/**
	 * 
	 * @return
	 */
	public String getContent() {
		return content;
	}	

	/**
	 * 
	 * @return
	 */
	public boolean isToTxt() {
		return toTxt;
	}

	/**
	 * 
	 * @return
	 */
	public Company getCompany() {
		return company;
	}

	/**
	 * 
	 * @return
	 */
	public boolean isToCsv() {
		return toCsv;
	}	

}