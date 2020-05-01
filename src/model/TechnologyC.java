package model;

public class TechnologyC extends Company implements TechnologyTax {

    /**
     * @param name
     * @param nit
     * @param myLegarR
     * @param firstEmployee
     * @param moneyValue
     * @param employee
     * @param mainOffice
     */
    public TechnologyC(String name, String nit, Employee myLegarR, Employee firstEmployee, double moneyValue,
            Employee employee, BranchOffice mainOffice) {
        super(name, nit, myLegarR, firstEmployee, moneyValue, employee, mainOffice);
    }

    // Subtracts taxes to moneyFund;
    @Override
    public void subtractTaxes() {

    }

}