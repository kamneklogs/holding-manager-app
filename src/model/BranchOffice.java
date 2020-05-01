package model;

public class BranchOffice {

    private String city;
    private String address;
    private String id;
    private String type;
    private Employee eResponsible;

    private BranchOffice right, left;

    /**
     * @param city
     * @param address
     * @param id
     * @param type
     * @param eResponsible
     */
    public BranchOffice(String city, String address, String id, String type, Employee eResponsible) {
        this.city = city;
        this.address = address;
        this.id = id;
        this.type = type;
        this.eResponsible = eResponsible;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the eResponsible
     */
    public Employee geteResponsible() {
        return eResponsible;
    }

    /**
     * @param eResponsible the eResponsible to set
     */
    public void seteResponsible(Employee eResponsible) {
        this.eResponsible = eResponsible;
    }

    /**
     * @return the right
     */
    public BranchOffice getRight() {
        return right;
    }

    /**
     * @param right the right to set
     */
    public void setRight(BranchOffice right) {
        this.right = right;
    }

    /**
     * @return the left
     */
    public BranchOffice getLeft() {
        return left;
    }

    /**
     * @param left the left to set
     */
    public void setLeft(BranchOffice left) {
        this.left = left;
    }

}