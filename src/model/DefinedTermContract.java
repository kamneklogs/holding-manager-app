package model;

import java.time.LocalDate;
import java.util.ArrayList;

import javafx.scene.image.Image;

public class DefinedTermContract extends Contract {

	public static final int MAX_RENEWALS = 1;
	
	public DefinedTermContract(String name, String id, String description, ArrayList<String> clauses, double amount,
			LocalDate startDate, LocalDate finishDate, LocalDate radicationDate, Company company, Employee employee,
			Image[] signatures) {
		
		super(name, id, description, clauses, amount, startDate, finishDate, radicationDate, company, employee,
				MAX_RENEWALS, signatures);
		
	}

}