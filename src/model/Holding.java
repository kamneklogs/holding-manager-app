package model;

import customExceptions.BranchOfficeAlreadyExistException;
import customExceptions.BranchOfficeNotFoundException;
import customExceptions.ContractAlreadyExistException;
import customExceptions.ContractNotFoundException;
import customExceptions.EmployeeAlreadyExistsException;
import customExceptions.EmployeeNotFoundException;

public class Holding {

	public final static String NAME = "Seros Group";
	public final static String PATH = "data/currentData.txt";
	
	// Basic attributes
	private String name;
	private double value;
	private int  totalTCompanies, totalFCompanies,totalECompanies;
	
	// Companies binary search tree
	private Company firstCompany;
	
	// Company currently managed by the system
	private Company currentCompany;	
	
	/**
	 * @param n
	 * @param v
	 */
	public Holding(String n, double v) {
		name = n;
	    value = v;
	}
	
	/**
	 * 
	 * @param c
	 */
	public void addCompany(Company c) {
		if (firstCompany == null) {
			firstCompany = c;
	    } 
		else {	
	    	addCompany(firstCompany, c);	
	    }	
	}
	
	/**
	 * 
	 * @param current
	 * @param c
	 */
	private void addCompany(Company current, Company c) {
		
		if (c.getNit().compareTo(current.getNit()) <= 0) {
			if (current.getLeft() == null) {
		    	current.setLeft(c);
		    	current.getLeft().setFather(current);
		    } 
		    else {
		    	addCompany(current.getLeft(), c);
		    }	
	    } 
	    else {	
	    	if (current.getRight() == null) {
	    		current.setRight(c);
	    		current.getRight().setFather(current);
	    	} 
	    	else {
	    		addCompany(current.getRight(), c);
	    	}
	    }	
	}
	
	/**
	 * 
	 * @param nit
	 * @return
	 */
	public Company searchCompany(String nit) {	
		if (firstCompany == null) {
	    	return null;
	    } 
	    else if (firstCompany.getNit().equals(nit)) {
	    	return firstCompany;
	    }
	    else {
	    	return searchCompany(firstCompany, nit);
	    }	
	}
	
	/**
	 * 
	 * @param current
	 * @param nit
	 * @return
	 */
	private Company searchCompany(Company current, String nit) {	
		if (current == null) {	
			return null;	
	    } 
		else if (current.getNit().equals(nit)) {	
			return current;	
	    } 
		else if (current.getNit().compareTo(nit) > 0) {
			if (current.getLeft() == null) {	
				return null;	
			}
			else {	
				return searchCompany(current.getLeft(), nit);	
	        }	
	    }
		else {	
			if(current.getNit().equals(nit)) {
				return current;	
			}
			else {	
				return searchCompany(current.getRight(), nit);	
			}
	    }	
	}
	
	/**
	 * 
	 * @param nit
	 */
	public void sellCompany(String nit) {		
	    value -= searchCompany(nit).getValue();	
	    removeCompany(searchCompany(nit));	
	}
	
	/**
	 * 
	 * @param toRemove
	 */
	public void removeCompany(Company toRemove) {	
		if (toRemove != null) {	
			if (toRemove.getRight() == null && toRemove.getLeft() == null) {
				if (toRemove.getFather().getLeft() == toRemove) {
					toRemove.getFather().setLeft(null);
				} 
				else {
					toRemove.getFather().setRight(null);
				}
			} 
			else if (toRemove.getRight() == null ^ toRemove.getLeft() == null) {	
				if (toRemove.getRight() != null) {
					if (toRemove.getFather().getRight() == toRemove) {
						toRemove.getRight().setFather(toRemove.getFather());
						toRemove.getFather().setRight(toRemove.getRight());
					} 
					else {
						toRemove.getRight().setFather(toRemove.getFather());
						toRemove.getFather().setLeft(toRemove.getRight());
					}	
				} 
				else {	
					if (toRemove.getFather().getRight() == toRemove) {
						toRemove.getLeft().setFather(toRemove.getFather());
						toRemove.getFather().setRight(toRemove.getLeft());
					}
					else {
						toRemove.getLeft().setFather(toRemove.getFather());
						toRemove.getFather().setLeft(toRemove.getLeft());
					}	
				}	
			} 
			else if (toRemove.getLeft() != null && toRemove.getRight() != null) {
	
		        Company current = toRemove.getLeft();
		
		        while (current.getRight() != null) {		
		        	current = current.getRight();		
		        }
		
		        if (current.getFather().getRight() == current) {
		        	current.getFather().setRight(null);
		        } 
		        else {
		        	current.getFather().setLeft(null);
		        }
		
		        current.setFather(toRemove.getFather());
		        current.setLeft(toRemove.getLeft());
		        current.setRight(toRemove.getRight());
		        current.getRight().setFather(current);
		        current.getLeft().setFather(current);
		
		        if (toRemove.getFather().getRight() == toRemove) {
		        	current.getFather().setRight(current);
		
		        }
		        else {
		        	current.getFather().setLeft(current);
		        }
		
		        current = null;	
			}
	
		}
	
	}
	
	/**
	 * 
	 * @param e
	 * @throws EmployeeAlreadyExistsException 
	 */
	public void addEmployee(Employee e) throws EmployeeAlreadyExistsException {
		currentCompany.addEmployee(e);
	}
	
	/**
	 * 
	 * @param bO
	 * @throws BranchOfficeAlreadyExistException 
	 */
	public void addBranchOffice(BranchOffice bO) throws BranchOfficeAlreadyExistException {
		currentCompany.addBranchOffice(bO);
	}
	
	/**
	 * 
	 * @param c
	 * @throws ContractAlreadyExistException 
	 */
	public void addContract(Contract c) throws ContractAlreadyExistException {
		currentCompany.addContract(c);
	}
	
	/**
	 * 
	 * @return
	 */
	public Employee findEmployee(String id) {
		return currentCompany.findEmployee(id);
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public Contract findContract(String id) {
		return currentCompany.findContract(id);
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public BranchOffice findBranchOffice(String id) {
		return currentCompany.findBranchOffice(id);
	}
	
	/**
	 * 
	 * @param id
	 * @throws EmployeeNotFoundException 
	 */
	public void removeEmployee(String id) throws EmployeeNotFoundException {
		currentCompany.removeEmployee(id);
	}
	
	/**
	 * 
	 * @param id
	 * @throws ContractNotFoundException 
	 */
	public void removeContract(String id) throws ContractNotFoundException {
		currentCompany.removeContract(id);
	}	
	
	/**
	 * 
	 * @param id
	 * @throws BranchOfficeNotFoundException 
	 */
	public void removeBranchOffice(String id) throws BranchOfficeNotFoundException {
		currentCompany.removeBranchOffice(id);
	}
	
	/**
	 * 
	 * @param toScreen
	 * @param toCsv
	 * @param toTxt
	 * @return
	 */
	public String generateEconomicReport(boolean toScreen, boolean toCsv, boolean toTxt){
		return new EconomicReport(toCsv, toTxt, currentCompany).generateReport();
	}
	
	/**
	 * 
	 * @param toScreen
	 * @param toCsv
	 * @param toTxt
	 * @return
	 */
	public String generateBranchOfficesReport(boolean toScreen, boolean toCsv, boolean toTxt) {
		return new BranchOfficesReport(toCsv, toTxt, currentCompany).generateReport();
	}
	
	/**
	 * 
	 * @param toScreen
	 * @param toCsv
	 * @param toTxt
	 * @return
	 */
	public String generateContractReportGeneral(boolean toScreen, boolean toCsv, boolean toTxt) {
		return new ContractReportGeneral(toCsv, toTxt, currentCompany).generateReport();
	}
	
	/**
	 * 
	 * @param toScreen
	 * @param toCsv
	 * @param toTxt
	 * @return
	 */
	public String generateEmployeeReportGeneral(boolean toScreen, boolean toCsv, boolean toTxt) {
		return new EmployeeReportGeneral(toCsv, toTxt, currentCompany).generateReport();
	}
	
	/**
	 * 
	 * @param toScreen
	 * @param toCsv
	 * @param toTxt
	 * @param id
	 * @return
	 */
	public String generateEmployeeReportDetailed(boolean toScreen, boolean toCsv, boolean toTxt, String id) {
		return new EmployeeReportDetailed(toCsv, toTxt, currentCompany, id).generateReport();
	}
	
	/**
	 * 
	 * @param toScreen
	 * @param toCsv
	 * @param toTxt
	 * @param id
	 * @return
	 */
	public String generateContractReportDetailed(boolean toScreen, boolean toCsv, boolean toTxt, String id) {
		return new ContractReportDetailed(toCsv, toTxt, currentCompany, id).generateReport();
	}
	
	
	/**
	 * 
	 */
	public void insertionSortBranchOffices() {
		currentCompany.insertionSortBranchOffices();
	}
	
	/**
	 * 
	 */
	public void bubbleSortContracts() {
		currentCompany.bubbleSortContracts();
	}
	
	/**
	 * 
	 */
	public void selectionSortBranchOffices() {
		currentCompany.selectionSortBranchOffices();
	}
	
	/**
	 * 
	 */
	public void loadAttributesFromTxtFile() {
		//PENDING IMPLEMENTATION
	}
	
	/**
	 * 
	 */
	public void loadRelationsFromFile() {
		//PENDING IMPLEMENTATION
	}
	
	/**
	 * 
	 * @return
	 */
	public Company getCurrentCompany() {
		return currentCompany;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * 
	 * @return
	 */
	public double getValue() {
		return value;
	}
	
	/**
	 * 
	 * @return
	 */
	public Company getFirstCompany() {
		return firstCompany;
	}
	
	/**
	 * 
	 * @param currentCompany
	 */
	public void setCurrentCompany(Company currentCompany) {
		this.currentCompany = currentCompany;
	}

	public int getTotalTCompanies() {
		return totalTCompanies;
	}

	public void setTotalTCompanies(int totalTCompanies) {
		this.totalTCompanies = totalTCompanies;
	}

	public int getTotalFCompanies() {
		return totalFCompanies;
	}

	public void setTotalFCompanies(int totalFCompanies) {
		this.totalFCompanies = totalFCompanies;
	}

	public int getTotalECompanies() {
		return totalECompanies;
	}

	public void setTotalECompanies(int totalECompanies) {
		this.totalECompanies = totalECompanies;
	}
}