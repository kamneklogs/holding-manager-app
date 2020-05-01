package model;

public class HoldingMasterClass extends Company {

    public final static String NAME = "Seros Group";
    public final static String PATH = "data/currentData.txt";

    // binary tree arch
    private Company company;

    /**
     * @param name
     * @param nit
     * @param myLegarR
     * @param employee
     * @param firstContract
     * @param mainOffice
     * @param company
     */
    public HoldingMasterClass(String name, String nit, Employee myLegarR, Employee employee, Contract firstContract,
            BranchOffice mainOffice, Company company) {
        super(name, nit, myLegarR, employee, firstContract, mainOffice);
        this.company = company;

        
    }

    /**
     * @return the company
     */
    public Company getCompany() {
        return company;
    }

    /**
     * @param company the company to set
     */
    public void setCompany(Company company) {
        this.company = company;
    }

    private void loadCurrentState() {

    }

    public void addCompany(Company c){

    }

    public void sellCompany(String nit){

    }

    public void removeCompany(String nit){

    }

}