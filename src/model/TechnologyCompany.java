package model;

public class TechnologyCompany extends Company implements TechnologyTaxRelief {

	public static final double TECHNOLOGY_TAX_RELIEF = 0.3;
	
    /**
     * 
     * @param name
     * @param nit
     * @param income
     * @param outcome
     * @param taxes
     * @param value
     */
	public TechnologyCompany (String name, String nit, double income, double outcome, double taxes, double value) {
		super(name, nit, income, outcome, taxes, value);
		substractTaxes();
	}
    
    @Override
    public void substractTaxes() {
    	setTaxes(getTaxes()*(1-TECHNOLOGY_TAX_RELIEF));		
    }

}