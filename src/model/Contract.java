package model;

import java.time.LocalDate;
import java.util.ArrayList;

import javafx.scene.image.Image;

public abstract class Contract implements Comparable<Contract> {

	private String name;
	private String id;
	private String description;
	private ArrayList<String> clauses;
	private double amount;
	private LocalDate startDate;
	private LocalDate finishDate;
	private LocalDate radicationDate;
	
	private Company company;
	private Employee employee;
	
	private int actualRenewals;
	private int renewalsLimit;
	private Image[] signatures;
	
	private Contract preContract, nextContract;
	
	/**
	 * 
	 * @param name
	 * @param id
	 * @param description
	 * @param clauses
	 * @param amount
	 * @param startDate
	 * @param finishDate
	 * @param radicationDate
	 * @param company
	 * @param employee
	 * @param actualRenewals
	 * @param renewalsLimit
	 * @param signatures
	 */
	public Contract(String name, String id, String description, ArrayList<String> clauses, double amount,
			LocalDate startDate, LocalDate finishDate, LocalDate radicationDate, Company company, Employee employee,
			int renewalsLimit, Image[] signatures) {
		this.name = name;
		this.id = id;
		this.description = description;
		this.clauses = clauses;
		this.amount = amount;
		this.startDate = startDate;
		this.finishDate = finishDate;
		this.radicationDate = radicationDate;
		this.company = company;
		this.employee = employee;
		actualRenewals = 0;
		this.renewalsLimit = renewalsLimit;
		this.signatures = signatures;		
	}

		
	@Override
	public int compareTo(Contract anotherContract) {
		if(id.compareTo(anotherContract.getId()) > 0) {
			return 1;
		}
		else if (id.compareTo(anotherContract.getId()) < 0) {
			return -1;
		}
		else {
			return 0;
		}		
	}


	public String getName() {
		return name;
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


	public Company getCompany() {
		return company;
	}


	public Employee getEmployee() {
		return employee;
	}


	public int getActualRenewals() {
		return actualRenewals;
	}


	public int getRenewalsLimit() {
		return renewalsLimit;
	}


	public Image[] getSignatures() {
		return signatures;
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


	public void setSignatures(Image[] signatures) {
		this.signatures = signatures;
	}


	public void setPreContract(Contract preContract) {
		this.preContract = preContract;
	}


	public void setNextContract(Contract nextContract) {
		this.nextContract = nextContract;
	}

}