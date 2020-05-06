package model;

import java.util.ArrayList;

public class Employee {

    private String name;
    private String id;
    private String residenceAddress;
    private String numberPhone;
    private String jobTitle;
    private double salary;

    // Seven days = new array[7]
    private double[] workingHours;
    private ArrayList<String> socialBenefits;
    private Contract myContract;
    private Employee right, left, father;

    /**
     * @param name
     * @param id
     * @param residenceAddress
     * @param numberPhone
     * @param jobTitle
     * @param salary
     * @param workingHours
     * @param socialBenefits
     * @param myContract
     */
    public Employee(String name, String id, String residenceAddress, String numberPhone, String jobTitle, double salary,
            double[] workingHours, ArrayList<String> socialBenefits, Contract myContract) {
        this.name = name;
        this.id = id;
        this.residenceAddress = residenceAddress;
        this.numberPhone = numberPhone;
        this.jobTitle = jobTitle;
        this.salary = salary;
        this.workingHours = workingHours;
        this.socialBenefits = socialBenefits;
        this.myContract = myContract;
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
     * @return the residenceAddress
     */
    public String getResidenceAddress() {
        return residenceAddress;
    }

    /**
     * @param residenceAddress the residenceAddress to set
     */
    public void setResidenceAddress(String residenceAddress) {
        this.residenceAddress = residenceAddress;
    }

    /**
     * @return the numberPhone
     */
    public String getNumberPhone() {
        return numberPhone;
    }

    /**
     * @param numberPhone the numberPhone to set
     */
    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    /**
     * @return the jobTitle
     */
    public String getJobTitle() {
        return jobTitle;
    }

    /**
     * @param jobTitle the jobTitle to set
     */
    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    /**
     * @return the salary
     */
    public double getSalary() {
        return salary;
    }

    /**
     * @param salary the salary to set
     */
    public void setSalary(double salary) {
        this.salary = salary;
    }

    /**
     * @return the workingHours
     */
    public double[] getWorkingHours() {
        return workingHours;
    }

    /**
     * @param workingHours the workingHours to set
     */
    public void setWorkingHours(double[] workingHours) {
        this.workingHours = workingHours;
    }

    /**
     * @return the socialBenefits
     */
    public ArrayList<String> getSocialBenefits() {
        return socialBenefits;
    }

    /**
     * @param socialBenefits the socialBenefits to set
     */
    public void setSocialBenefits(ArrayList<String> socialBenefits) {
        this.socialBenefits = socialBenefits;
    }

    /**
     * @return the myContract
     */
    public Contract getMyContract() {
        return myContract;
    }

    /**
     * @param myContract the myContract to set
     */
    public void setMyContract(Contract myContract) {
        this.myContract = myContract;
    }

    /**
     * @return the right
     */
    public Employee getRight() {
        return right;
    }

    /**
     * @param right the right to set
     */
    public void setRight(Employee right) {
        this.right = right;
    }

    /**
     * @return the left
     */
    public Employee getLeft() {
        return left;
    }

    /**
     * @param left the left to set
     */
    public void setLeft(Employee left) {
        this.left = left;
    }

    /**
     * @return the father
     */
    public Employee getFather() {
        return father;
    }

    /**
     * @param father the father to set
     */
    public void setFather(Employee father) {
        this.father = father;
    }

}