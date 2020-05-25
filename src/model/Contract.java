package model;

import java.time.LocalDate;
import java.util.ArrayList;

public abstract class Contract implements Comparable<Contract> {

	public static final String[] TYPES = { "Termino fijo", "Termino indefinido", "Obra o labor",
			"Prestacion de servicios", "Aprendizaje", "Ocasional" };

	private String id;
	private String description;
	private double amount;
	private LocalDate startDate;
	private LocalDate finishDate;
	private LocalDate radicationDate;
	private ArrayList<String> clauses;
	private Employee employee;

	private int actualRenewals;
	private int renewalsLimit;

	private Contract preContract, nextContract;

	/**
	 * 
	 * @param id
	 * @param description
	 * @param clauses
	 * @param amount
	 * @param startDate
	 * @param finishDate
	 * @param radicationDate
	 * @param actualRenewals
	 * @param renewalsLimit
	 */
	public Contract(String id, String description, ArrayList<String> clauses, double amount, LocalDate startDate,
			LocalDate finishDate, LocalDate radicationDate, int renewalsLimit) {

		this.id = id;
		this.description = description;
		this.clauses = clauses;
		this.amount = amount;
		this.startDate = startDate;
		this.finishDate = finishDate;
		this.radicationDate = radicationDate;
		actualRenewals = 0;
		this.renewalsLimit = renewalsLimit;

	}

	@Override
	public int compareTo(Contract anotherContract) {
		if (id.compareTo(anotherContract.getId()) > 0) {
			return 1;
		} else if (id.compareTo(anotherContract.getId()) < 0) {
			return -1;
		} else {
			return 0;
		}
	}

	public String getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

	public ArrayList<String> getClauses() {
		return clauses;
	}

	public double getAmount() {
		return amount;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public LocalDate getFinishDate() {
		return finishDate;
	}

	public LocalDate getRadicationDate() {
		return radicationDate;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public int getActualRenewals() {
		return actualRenewals;
	}

	public int getRenewalsLimit() {
		return renewalsLimit;
	}

	public Contract getPreContract() {
		return preContract;
	}

	public Contract getNextContract() {
		return nextContract;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setFinishDate(LocalDate finishDate) {
		this.finishDate = finishDate;
	}

	public void setPreContract(Contract preContract) {
		this.preContract = preContract;
	}

	public void setNextContract(Contract nextContract) {
		this.nextContract = nextContract;
	}

}