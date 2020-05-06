package model;

public class Holding {

    public final static String NAME = "Seros Group";
    public final static String PATH = "data/currentData.txt";

    //Basic attributes
    private String name;
    private double value;
    
    //Companies binary search tree
    private Company firstCompany;
    
    //Company currently managed by the system
    private Company currentCompany;

    /**
     * @param name
     * @param nit
     * @param myLegarR
     * @param firstEmployee
     * @param moneyValue
     * @param employee
     * @param mainOffice
     * @param company
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
    	
    }
    
    /**
     * 
     * @param nit
     */
    public void sellCompany(String nit) {
    	
    }
    
    /**
     * 
     * @param nit
     */
    public void removeCompany(String nit) {
    	
    }
    
    /**
     * 
     * @param e
     */
    public void addEmployee(Employee e) {
    	
    }
    
    /**
     * 
     * @param bO
     */
    public void addBranchOffice(BranchOffice bO) {
    	
    }
    /**
     * 
     * @param c
     */
    public void addContract(Contract c) {
    	
    }
    
    /**
     * 
     * @return
     */
    public Employee findEmployee(String id) {
    	return null;
    }
    
    /**
     * 
     * @param id
     * @return
     */
    public Contract findContract(String id) {
		return null;    	
    }
    
    /**
     * 
     * @param id
     * @return
     */
    public BranchOffice findBranchOffice(String id) {
		return null;    	
    }
    /**
     * 
     * @param id
     */
    public void removeEmployee(String id) {
    	
    }
    
    /**
     * 
     * @param id
     */
    public void removeContract(String id) {
    	
    }
    
    /**
     * 
     * @param id
     */
	public void removeBranchOffice(String id) {
	
	}
	
	/**
	 * 
	 * @param txt
	 * @param type
	 * @return
	 */
	public String generateReport(boolean txt, String type) {
		return "";		
	}
	
	/**
	 * 
	 */
	public void insertionSortBranchOffices() {
		
	}
	
	/**
	 * 
	 */
	public void bubbleSortContracts() {
		
	}
	
	/**
	 * 
	 */
	public void selectionSortBranchOffices() {
		
	}
	
	/**
	 * 
	 */
	public void loadAttributesFromTxtFile() {
		
	}
	
	/**
	 * 
	 */
	public void loadRelationsFromFile() {
		
	}
}