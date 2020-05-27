package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

@SuppressWarnings("serial")
public abstract class Contract implements Comparable<Contract>, Serializable {

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
	/**
	 * 
	 */
	public int compareTo(Contract anotherContract) {
		if (id.compareTo(anotherContract.getId()) > 0) {
			return 1;
		} else if (id.compareTo(anotherContract.getId()) < 0) {
			return -1;
		} else {
			return 0;
		}
	}
	
	/**
	 * 
	 * @return
	 */
	public String getId() {
		return id;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * 
	 * @return
	 */
	public ArrayList<String> getClauses() {
		return clauses;
	}

	/**
	 * 
	 * @return
	 */
	public double getAmount() {
		return amount;
	}

	/**
	 * 
	 * @return
	 */
	public LocalDate getStartDate() {
		return startDate;
	}

	/**
	 * 
	 * @return
	 */
	public LocalDate getFinishDate() {
		return finishDate;
	}

	/**
	 * 
	 * @return
	 */
	public LocalDate getRadicationDate() {
		return radicationDate;
	}

	/**
	 * 
	 * @return
	 */
	public Employee getEmployee() {
		return employee;
	}

	/**
	 * 
	 * @param employee
	 */
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	/**
	 * 
	 * @return
	 */
	public int getActualRenewals() {
		return actualRenewals;
	}

	/**
	 * 
	 * @return
	 */
	public int getRenewalsLimit() {
		return renewalsLimit;
	}

	/**
	 * 
	 * @return
	 */
	public Contract getPreContract() {
		return preContract;
	}

	/**
	 * 
	 * @return
	 */
	public Contract getNextContract() {
		return nextContract;
	}

	/**
	 * 
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * 
	 * @param finishDate
	 */
	public void setFinishDate(LocalDate finishDate) {
		this.finishDate = finishDate;
	}

	/**
	 * 
	 * @param preContract
	 */
	public void setPreContract(Contract preContract) {
		this.preContract = preContract;
	}

	/**
	 * 
	 * @param nextContract
	 */
	public void setNextContract(Contract nextContract) {
		this.nextContract = nextContract;
	}

}