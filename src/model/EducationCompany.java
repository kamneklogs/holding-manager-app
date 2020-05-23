package model;

public class EducationCompany extends Company implements EducationTaxRelief{

	public static final double EDUCATION_TAX_RELIEF = 0.3;
	
    /***
     * 
     * @param name
     * @param nit
     * @param income
     * @param outcome
     * @param taxes
     * @param value
     */
	public EducationCompany (String name, String nit, double income, double outcome, double taxes, double value) {
		super(name, nit, income, outcome, taxes, value);
		substractTaxes();
	}

	@Override
	public void substractTaxes() {
		
		
	}

}