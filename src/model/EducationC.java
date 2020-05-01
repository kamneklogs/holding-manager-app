package model;

public class EducationC extends Company {

    /**
     * @param name
     * @param nit
     * @param myLegarR
     * @param firstEmployee
     * @param moneyValue
     * @param employee
     * @param mainOffice
     */
    public EducationC(String name, String nit, Employee myLegarR, Employee firstEmployee, double moneyValue,
            Employee employee, BranchOffice mainOffice) {
        super(name, nit, myLegarR, firstEmployee, moneyValue, employee, mainOffice);
    }

}