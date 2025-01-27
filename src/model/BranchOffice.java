package model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class BranchOffice implements Comparable<BranchOffice>, Serializable {

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
     * @param ids
     * @param type
     * @param responsableEmployee
     */
    public BranchOffice(String city, String address, String id, boolean type, Employee responsableEmployee) {
        this.city = city;
        this.address = address;
        this.id = id;

        if(type){
            this.type = "Principal";
        }else{
            this.type = "Ordinaria";
        }

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
     * @return preOffice
     */
    public BranchOffice getPreOffice() {
        return preOffice;
    }

    /**
     * @param preOffice the new previous office to set
     */
    public void setPreOffice(BranchOffice preOffice) {
        this.preOffice = preOffice;
    }

    /**
     * @return the next office
     */
    public BranchOffice getNextOffice() {
        return nextOffice;
    }

    /**
     * @param nextOffice the next office to set
     */
    public void setNextOffice(BranchOffice nextOffice) {
        this.nextOffice = nextOffice;
    }

    /**
     * 
     */
    public int compareTo(BranchOffice anotherBranchOffice) {
        if (id.compareTo(anotherBranchOffice.id) > 0) {
            return 1;
        } else if (id.compareTo(anotherBranchOffice.id) < 0) {
            return -1;
        } else {
            return 0;
        }
    }
    
    /**
     * 
     * @param eResponsable the new responsable employee
     */
	public void setResponsableEmployee(Employee eResponsable) {
		this.responsableEmployee = eResponsable;
		
	}

}