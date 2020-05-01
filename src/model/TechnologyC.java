package model;

public class TechnologyC extends Company implements TechnologyTax{

    public TechnologyC(String name, String nit, Employee myLegarR, Employee firstEmployee, Contract firstContract,
            BranchOffice mainOffice) {
        super(name, nit, myLegarR, firstEmployee, firstContract, mainOffice);
        
    }

    //Subtracts taxes to moneyFund;
    @Override
    public void subtractTaxes() {
    

    }
}