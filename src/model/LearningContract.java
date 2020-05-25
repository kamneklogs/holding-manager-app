package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class LearningContract extends Contract {

	public static int MAX_RENEWALS = 1;

	public LearningContract(String id, String description, ArrayList<String> clauses, double amount,
			LocalDate startDate, LocalDate finishDate, LocalDate radicationDate) {
		super(id, description, clauses, amount, startDate, finishDate, radicationDate, MAX_RENEWALS);

	}
}