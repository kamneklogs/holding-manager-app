package model;

public class ServiceC extends Contract {

    public ServiceC(String name, String startDate, String finishDate, String description, String[] clauses,
            String amount, Company partA, Employee partB, int actualRenewals, int renewalsLimit) {
        super(name, startDate, finishDate, description, clauses, amount, partA, partB, actualRenewals, renewalsLimit);
        
    }
}