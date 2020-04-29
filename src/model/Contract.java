package model;

public class Contract {

	private String name;
	private String startDate;
	private String finishDate;
	private String description;
	private String[] clauses;
	private String amount;
	private Company partA;
	private Employee partB;
	private int actualRenewals;
	private int renewalsLimit;

	/**
	 * @param name
	 * @param startDate
	 * @param finishDate
	 * @param description
	 * @param clauses
	 * @param amount
	 * @param partA
	 * @param partB
	 * @param actualRenewals
	 * @param renewalsLimit
	 */
	public Contract(String name, String startDate, String finishDate, String description, String[] clauses,
			String amount, Company partA, Employee partB, int actualRenewals, int renewalsLimit) {
		this.name = name;
		this.startDate = startDate;
		this.finishDate = finishDate;
		this.description = description;
		this.clauses = clauses;
		this.amount = amount;
		this.partA = partA;
		this.partB = partB;
		this.actualRenewals = actualRenewals;
		this.renewalsLimit = renewalsLimit;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the startDate
	 */
	public String getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the finishDate
	 */
	public String getFinishDate() {
		return finishDate;
	}

	/**
	 * @param finishDate the finishDate to set
	 */
	public void setFinishDate(String finishDate) {
		this.finishDate = finishDate;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the clauses
	 */
	public String[] getClauses() {
		return clauses;
	}

	/**
	 * @param clauses the clauses to set
	 */
	public void setClauses(String[] clauses) {
		this.clauses = clauses;
	}

	/**
	 * @return the amount
	 */
	public String getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(String amount) {
		this.amount = amount;
	}

	/**
	 * @return the partA
	 */
	public Company getPartA() {
		return partA;
	}

	/**
	 * @param partA the partA to set
	 */
	public void setPartA(Company partA) {
		this.partA = partA;
	}

	/**
	 * @return the partB
	 */
	public Employee getPartB() {
		return partB;
	}

	/**
	 * @param partB the partB to set
	 */
	public void setPartB(Employee partB) {
		this.partB = partB;
	}

	/**
	 * @return the actualRenewals
	 */
	public int getActualRenewals() {
		return actualRenewals;
	}

	/**
	 * @param actualRenewals the actualRenewals to set
	 */
	public void setActualRenewals(int actualRenewals) {
		this.actualRenewals = actualRenewals;
	}

	/**
	 * @return the renewalsLimit
	 */
	public int getRenewalsLimit() {
		return renewalsLimit;
	}

	/**
	 * @param renewalsLimit the renewalsLimit to set
	 */
	public void setRenewalsLimit(int renewalsLimit) {
		this.renewalsLimit = renewalsLimit;
	}

	

}