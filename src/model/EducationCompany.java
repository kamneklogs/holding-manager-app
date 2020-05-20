package model;

public class EducationCompany extends Company implements EducationTaxRelief{

    /**
     * @param name
     * @param nit
     * @param myLegarR
     * @param firstEmployee
     * @param moneyValue
     * @param employee
     * @param mainOffice
     */
    public EducationCompany(String name, String nit, Employee myLegarR, Employee firstEmployee, double moneyValue,
            Employee employee, BranchOffice mainOffice) {
        super(name, nit, myLegarR, firstEmployee, moneyValue, employee, mainOffice);
    }

	@Override
	public void substractTaxes() {
		// TODO Auto-generated method stub
		
	}

}