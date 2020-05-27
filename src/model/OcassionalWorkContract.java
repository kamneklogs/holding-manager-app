package model;

import java.time.LocalDate;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class OcassionalWorkContract extends Contract {

	public static final int MAX_RENEWALS = 2;

	/**
	 * 
	 * @param id
	 * @param description
	 * @param clauses
	 * @param amount
	 * @param startDate
	 * @param finishDate
	 * @param radicationDate
	 */
	public OcassionalWorkContract(String id, String description, ArrayList<String> clauses, double amount,
			LocalDate startDate, LocalDate finishDate, LocalDate radicationDate) {

		super(id, description, clauses, amount, startDate, finishDate, radicationDate, MAX_RENEWALS);

	}

}
