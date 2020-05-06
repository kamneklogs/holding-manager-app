package model;

import customExceptions.NotFundBrandOfficeException;

public class Company {

    private String name;
    private String nit;
    private Employee myLegarR;
    private double moneyValue;

    // binary three archS
    private Employee employee;

    // linked list arch
    private Contract firstContract;
    private BranchOffice mainOffice;
    private Company right, left, father;

    /**
     * @param name
     * @param nit
     * @param myLegarR
     * @param firstEmployee
     * @param mainOffice
     */
    public Company(String name, String nit, Employee myLegarR, Employee firstEmployee, double moneyValue,
            Employee employee, BranchOffice mainOffice) {
        this.name = name;
        this.nit = nit;
        this.myLegarR = myLegarR;
        this.moneyValue = moneyValue;
        this.employee = employee;
        this.mainOffice = mainOffice;
    }

    public void addContract(Contract newContract) {

        if (getLastContract() == null) {

            firstContract = newContract;

        } else {

            getLastContract().setNextContract(newContract);

        }

    }

    public Contract getLastContract() {

        Contract current;

        if (firstContract == null) {

            return null;

        } else {

            current = firstContract;

            while (current.getNextContract() != null) {

                current = current.getNextContract();

            }
        }

        return current;

    }

    public BranchOffice searchBrandOffice(String id) throws NotFundBrandOfficeException {

        BranchOffice bO;

        if (mainOffice == null) {

            throw new NotFundBrandOfficeException();

        }

        if (mainOffice.getId().equals(id)) {

            bO = mainOffice;

        } else {

            if (searchBrandOffice(mainOffice, id) != null) {

                bO = searchBrandOffice(mainOffice, id);

            } else {

                throw new NotFundBrandOfficeException();

            }

        }

        return bO;
    }

    private BranchOffice searchBrandOffice(BranchOffice current, String id) {

        if (current == null) {

            return null;

        } else if (current.getId().equals(id)) {

            return current;

        } else if (current.getId().compareTo(id) > 0) {

            if (current.getLeft() == null) {

                return null;

            } else {

                return searchBrandOffice(current.getLeft(), id);

            }

        } else {

            if (current.getAddress().equals(id)) {

                return current;

            } else {

                return searchBrandOffice(current.getRight(), id);

            }
        }

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
     * @return the nit
     */
    public String getNit() {
        return nit;
    }

    /**
     * @param nit the nit to set
     */
    public void setNit(String nit) {
        this.nit = nit;
    }

    /**
     * @return the myLegarR
     */
    public Employee getMyLegarR() {
        return myLegarR;
    }

    /**
     * @param myLegarR the myLegarR to set
     */
    public void setMyLegarR(Employee myLegarR) {
        this.myLegarR = myLegarR;
    }

    /**
     * @return the employee
     */
    public Employee getEmployee() {
        return employee;
    }

    /**
     * @param employee the employee to set
     */
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    /**
     * @return the firstContract
     */
    public Contract getFirstContract() {
        return firstContract;
    }

    /**
     * @param firstContract the firstContract to set
     */
    public void setFirstContract(Contract firstContract) {
        this.firstContract = firstContract;
    }

    /**
     * @return the mainOffice
     */
    public BranchOffice getMainOffice() {
        return mainOffice;
    }

    /**
     * @param mainOffice the mainOffice to set
     */
    public void setMainOffice(BranchOffice mainOffice) {
        this.mainOffice = mainOffice;
    }

    public void addEmployee(Employee e) {

        if (employee == null) {
            employee = e;
        } else {

            addEmployee(employee, e);

        }

    }

    private void addEmployee(Employee current, Employee e) {

        if (e.getId().compareTo(current.getId()) <= 0) {
            if (current.getLeft() == null) {
                current.setLeft(e);
                current.getLeft().setFather(current);
            } else {
                addEmployee(current.getLeft(), e);
            }

        } else {

            if (current.getRight() == null) {
                current.setRight(e);
                current.getRight().setFather(current);
            } else {
                addEmployee(current.getRight(), e);
            }
        }

    }

    public Employee searchEmployee(String id) {

        if (employee.getId().equals(id)) {
            return employee;
        }

        return searchEmployee(employee, id);

    }

    private Employee searchEmployee(Employee current, String id) {

        if (current == null) {

            return null;

        } else if (current.getId().equals(id)) {

            return current;

        } else if (current.getId().compareTo(id) > 0) {

            if (current.getLeft() == null) {

                return null;

            } else {

                return searchEmployee(current.getLeft(), id);

            }

        } else {

            if (current.getId().equals(id)) {

                return current;

            } else {

                return searchEmployee(current.getRight(), id);

            }
        }

    }

    public void removeEmployee(String id) {

        Employee toRemove = searchEmployee(id);

        if (toRemove != null) {

            if (toRemove.getRight() == null && toRemove.getLeft() == null) {
                if (toRemove.getFather().getLeft() == toRemove) {
                    toRemove.getFather().setLeft(null);
                } else {
                    toRemove.getFather().setRight(null);
                }
            } else if (toRemove.getRight() == null ^ toRemove.getLeft() == null) {

                if (toRemove.getRight() != null) {
                    if (toRemove.getFather().getRight() == toRemove) {
                        toRemove.getRight().setFather(toRemove.getFather());
                        toRemove.getFather().setRight(toRemove.getRight());
                    } else {
                        toRemove.getRight().setFather(toRemove.getFather());
                        toRemove.getFather().setLeft(toRemove.getRight());
                    }

                } else {

                    if (toRemove.getFather().getRight() == toRemove) {
                        toRemove.getLeft().setFather(toRemove.getFather());
                        toRemove.getFather().setRight(toRemove.getLeft());
                    } else {
                        toRemove.getLeft().setFather(toRemove.getFather());
                        toRemove.getFather().setLeft(toRemove.getLeft());
                    }

                }

            } else if (toRemove.getLeft() != null && toRemove.getRight() != null) {

                Employee current = toRemove.getLeft();

                while (current.getRight() != null) {

                    current = current.getRight();

                }

                if (current.getFather().getRight() == current) {
                    current.getFather().setRight(null);

                } else {
                    current.getFather().setLeft(null);
                }

                current.setFather(toRemove.getFather());
                current.setLeft(toRemove.getLeft());
                current.setRight(toRemove.getRight());
                current.getRight().setFather(current);
                current.getLeft().setFather(current);

                if (toRemove.getFather().getRight() == toRemove) {
                    current.getFather().setRight(current);

                } else {
                    current.getFather().setLeft(current);
                }

                current = null;

            }

        }

    }

    public String employeesList() {
        return "";
    }

    public String generateReport(Company c) {
        return "";
    }

    public String generateReport(Employee e) {
        return "";
    }

    public String generateReport(Contract c) {
        return "";
    }

    /**
     * @return the moneyValue
     */
    public double getMoneyValue() {
        return moneyValue;
    }

    /**
     * @param moneyValue the moneyValue to set
     */
    public void setMoneyValue(double moneyValue) {
        this.moneyValue = moneyValue;
    }

    /**
     * @return the right
     */
    public Company getRight() {
        return right;
    }

    /**
     * @param right the right to set
     */
    public void setRight(Company right) {
        this.right = right;
    }

    /**
     * @return the left
     */
    public Company getLeft() {
        return left;
    }

    /**
     * @param left the left to set
     */
    public void setLeft(Company left) {
        this.left = left;
    }

    /**
     * @return the father
     */
    public Company getFather() {
        return father;
    }

    /**
     * @param father the father to set
     */
    public void setFather(Company father) {
        this.father = father;
    }

}