package model;

public class TechnologyCompany extends Company implements TechnologyTaxRelief {

    /**
     * @param name
     * @param nit
     * @param myLegarR
     * @param firstEmployee
     * @param moneyValue
     * @param employee
     * @param mainOffice
     */
    public TechnologyCompany(String name, String nit, Employee myLegarR, Employee firstEmployee, double moneyValue,
            Employee employee, BranchOffice mainOffice) {
        super(name, nit, myLegarR, firstEmployee, moneyValue, employee, mainOffice);
    }

    // Subtracts taxes to moneyFund;
    @Override
    public void subtractTaxes() {

    }

}