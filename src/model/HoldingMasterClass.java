package model;

public class HoldingMasterClass extends Company {

    public final static String NAME = "Seros Group";

    private Company firstCompany;

    public HoldingMasterClass(String name, String nit, Employee myLegarR, Employee firstEmployee,
            Contract firstContract, BranchOffice mainOffice) {
        super(NAME, nit, myLegarR, firstEmployee, firstContract, mainOffice);
    }


    

    

}