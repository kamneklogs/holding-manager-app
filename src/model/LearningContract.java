package model;

import java.time.LocalDate;
import java.util.ArrayList;


public class LearningContract extends Contract {
	
	public static int MAX_RENEWALS = 1;
	
	public LearningContract(String name, String id, String description, ArrayList<String> clauses, double amount,
			LocalDate startDate, LocalDate finishDate, LocalDate radicationDate, Company company, Employee employee) {
		super(name, id, description, clauses, amount, startDate, finishDate, radicationDate, company, employee,
				MAX_RENEWALS);
		
	}    
}