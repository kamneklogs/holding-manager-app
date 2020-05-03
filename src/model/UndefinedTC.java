package model;

public class UndefinedTC extends Contract {

    public UndefinedTC(String name, String startDate, String finishDate, String description, String[] clauses,
            String amount, Company partA, Employee partB, int actualRenewals, int renewalsLimit) {
        super(name, startDate, finishDate, description, clauses, amount, partA, partB, actualRenewals, renewalsLimit);
        
    }
}