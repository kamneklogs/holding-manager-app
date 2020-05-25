package model;

public class FoodCompany extends Company implements FoodTaxRelief {
	
	public static final double FOOD_TAX_RELIEF = 0.1;

    /**
     * 
     * @param name
     * @param nit
     * @param income
     * @param outcome
     * @param taxes
     * @param value
     */
	public FoodCompany(String name, String nit, double income, double outcome, double taxes, double value) {
		super(name, nit, income, outcome, taxes, value);
		substractTaxes();
	}

	@Override
	public void substractTaxes() {
		setTaxes(getTaxes()*(1-FOOD_TAX_RELIEF));			
	}

}