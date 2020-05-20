package model;

public class FoodCompany extends Company implements FoodTaxRelief {

    /**
	 * @param name
	 * @param nit
	 * @param myLegarR
	 * @param firstEmployee
	 * @param moneyValue
	 * @param employee
	 * @param mainOffice
	 */
	public FoodCompany(String name, String nit, Employee myLegarR, Employee firstEmployee, double moneyValue,
			Employee employee, BranchOffice mainOffice) {
		super(name, nit, myLegarR, firstEmployee, moneyValue, employee, mainOffice);
	}

	@Override
	public void substractTaxes() {
		// TODO Auto-generated method stub
		
	}

}