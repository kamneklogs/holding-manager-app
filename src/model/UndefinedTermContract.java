package model;

import java.time.LocalDate;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class UndefinedTermContract extends Contract {

	public final static int MAX_RENEWALS = 0;
	public final static LocalDate END_DATE = null;

	public UndefinedTermContract(String id, String description, ArrayList<String> clauses, double amount,
			LocalDate startDate, LocalDate radicationDate) {

		super(id, description, clauses, amount, startDate, END_DATE, radicationDate, MAX_RENEWALS);
	}

}