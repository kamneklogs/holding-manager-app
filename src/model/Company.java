package model;

import java.util.ArrayList;

public class Company {

    private String name;
    private String nit;
    private Employee myLegarR;
    private Employee firstEmployee;
    private Contract firstContract;
    private BranchOffice mainOffice;
    private ArrayList<BranchOffice> myBranchOffices;

    /**
     * @param name
     * @param nit
     * @param myLegarR
     * @param firstEmployee
     * @param firstContract
     * @param mainOffice
     * @param mBranchOffices
     */
    public Company(String name, String nit, Employee myLegarR, Employee firstEmployee, Contract firstContract,
            BranchOffice mainOffice) {
        this.name = name;
        this.nit = nit;
        this.myLegarR = myLegarR;
        this.firstEmployee = firstEmployee;
        this.firstContract = firstContract;
        this.mainOffice = mainOffice;
        myBranchOffices = new ArrayList<BranchOffice>();
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the nit
     */
    public String getNit() {
        return nit;
    }

    /**
     * @param nit the nit to set
     */
    public void setNit(String nit) {
        this.nit = nit;
    }

    /**
     * @return the myLegarR
     */
    public Employee getMyLegarR() {
        return myLegarR;
    }

    /**
     * @param myLegarR the myLegarR to set
     */
    public void setMyLegarR(Employee myLegarR) {
        this.myLegarR = myLegarR;
    }

    /**
     * @return the firstEmployee
     */
    public Employee getFirstEmployee() {
        return firstEmployee;
    }

    /**
     * @param firstEmployee the firstEmployee to set
     */
    public void setFirstEmployee(Employee firstEmployee) {
        this.firstEmployee = firstEmployee;
    }

    /**
     * @return the firstContract
     */
    public Contract getFirstContract() {
        return firstContract;
    }

    /**
     * @param firstContract the firstContract to set
     */
    public void setFirstContract(Contract firstContract) {
        this.firstContract = firstContract;
    }

    /**
     * @return the mainOffice
     */
    public BranchOffice getMainOffice() {
        return mainOffice;
    }

    /**
     * @param mainOffice the mainOffice to set
     */
    public void setMainOffice(BranchOffice mainOffice) {
        this.mainOffice = mainOffice;
    }

    /**
     * @return the mBranchOffices
     */
    public ArrayList<BranchOffice> getMyBranchOffices() {
        return myBranchOffices;
    }

    /**
     * @param mBranchOffices the mBranchOffices to set
     */
    public void setMyBranchOffices(ArrayList<BranchOffice> myBranchOffices) {
        this.myBranchOffices = myBranchOffices;
    }

}