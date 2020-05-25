package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class UndefinedTermContract extends Contract {
	
	public final static int MAX_RENEWALS = 0;
	public final static LocalDate END_DATE = null;
	
	public UndefinedTermContract(String name, String id, String description, ArrayList<String> clauses, double amount,
			LocalDate startDate, LocalDate radicationDate, Company company, Employee employee) {
		
		super(name, id, description, clauses, amount, startDate, END_DATE, radicationDate, company, employee,
				MAX_RENEWALS);		
	}

    
}