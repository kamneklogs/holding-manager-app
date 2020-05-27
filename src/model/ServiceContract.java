package model;

import java.time.LocalDate;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class ServiceContract extends Contract {

	public static int MAX_RENEWALS = 1;

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
	public ServiceContract(String id, String description, ArrayList<String> clauses, double amount, LocalDate startDate,
			LocalDate finishDate, LocalDate radicationDate) {

		super(id, description, clauses, amount, startDate, finishDate, radicationDate, MAX_RENEWALS);

	}

}