package model;

public class BranchOffice {
	
	public static final String MAIN = "Main Office";
	public static final String SECONDARY = "Secondary Office";
	
    private String city;
    private String address;
    private String id;
    private String type;
    private Employee responsableEmployee;

    private BranchOffice preOffice, nextOffice;

    /**
     * @param city
     * @param address
     * @param id
     * @param type
     * @param responsableEmployee
     */
    public BranchOffice(String city, String address, String id, String type, Employee responsableEmployee) {
        this.city = city;
        this.address = address;
        this.id = id;
        this.type = type;
        this.responsableEmployee = responsableEmployee;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }
    
    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }
    
    /**
     * @return the eResponsible
     */
    public Employee geteResponsible() {
        return responsableEmployee;
    }

    /**
     * @return the right
     */
    public BranchOffice getPreOffice() {
        return preOffice;
    }

    /**
     * @param right the right to set
     */
    public void setPreOffice(BranchOffice right) {
        this.preOffice = right;
    }

    /**
     * @return the left
     */
    public BranchOffice getNextOffice() {
        return nextOffice;
    }

    /**
     * @param left the left to set
     */
    public void setNextOffice(BranchOffice left) {
        this.nextOffice = left;
    }

}