package model;



public class Company {

    private String name;
    private String nit;
    private Employee myLegarR;

    // binary three archS
    private Employee employee;

    // linked list arch
    private Contract firstContract;
    private BranchOffice mainOffice;

    /**
     * @param name
     * @param nit
     * @param myLegarR
     * @param employee
     * @param firstContract
     * @param mainOffice
     */
    public Company(String name, String nit, Employee myLegarR, Employee employee, Contract firstContract,
            BranchOffice mainOffice) {
        this.name = name;
        this.nit = nit;
        this.myLegarR = myLegarR;
        this.employee = employee;
        this.firstContract = firstContract;
        this.mainOffice = mainOffice;
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
     * @return the employee
     */
    public Employee getEmployee() {
        return employee;
    }

    /**
     * @param employee the employee to set
     */
    public void setEmployee(Employee employee) {
        this.employee = employee;
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

    public void addEmployee(Employee e) {

    }

    public void removeEmployee(String id) {

    }

    public String employeesList() {
        return "";
    }

    // more info!!
    public void createContract() {

    }

    public String generateReport(Company c) {
        return "";
    }

    public String generateReport(Employee e) {
        return "";
    }

    public String generateReport(Contract c) {
        return "";
    }

}