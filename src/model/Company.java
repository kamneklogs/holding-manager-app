package model;

import customExceptions.ContractAlreadyExistException;
import customExceptions.ContractNotFoundException;
import customExceptions.NotFundBrandOfficeException;

public class Company {

    private String name;
    private String nit;
    private double income;
    private double outcome;
    private double taxes;
    private double value;    
    
    private Employee firstEmployee;//Binary search tree
    private LegalRepresentative legalRepresentative;//Direct relation
   
    private Contract firstContract;//Double linked list
    private BranchOffice firstOffice;//Double linked list
    
    private Company father, left, right;

    /**
     * 
     * @param name
     * @param nit
     * @param income
     * @param outcome
     * @param taxes
     * @param value
     */
    public Company(String name, String nit, double income, double outcome, double taxes, double value) {
        this.name = name;
        this.nit = nit;
        this.income = income;
        this.outcome = outcome;
        this.taxes = taxes;
        this.value = value;
    }    
    
    /**
     * Adds a previously created contract.
     * @param newContract Contract to add.
     * @throws ContractAlreadyExistException 
     */
    public void addContract(Contract newContract) throws ContractAlreadyExistException {

        Contract current;

        if (firstContract == null) {

        	firstContract = newContract;

        } 
        else if(findContract(newContract.getId()) == null) {
        	current = firstContract;

            while (current.getNextContract() != null) {

                current = current.getNextContract();

            }
            
            current.setNextContract(newContract);
            newContract.setPreContract(current);
        }
        else {          
            throw new ContractAlreadyExistException(newContract.getId());           
        }
    }

    /**
     * Remove a contract given its id
     * @param id Contract id
     * @throws ContractNotFoundException 
     */
    public void removeContract(String id) throws ContractNotFoundException {
    	Contract current;
    	if (firstContract == null) {
    		throw new ContractNotFoundException(id);
        } 
        else {
        	current = firstContract;

            while (current.getNextContract() != null && !current.getId().equals(id)) {
                current = current.getNextContract();
            }
            
            if(current.getId().equals(id)) {
            	if(current == firstContract) {
            		firstContract = current.getNextContract();
            		current.setNextContract(null);
            		firstContract.setPreContract(null);
            	}
            	else if(current.getNextContract() == null) {
            		current.getPreContract().setNextContract(null);
            		current.setPreContract(null);
            	}
            	else {
            		current.getPreContract().setNextContract(current.getNextContract());
            		current.getNextContract().setPreContract(current.getPreContract());
            		current.setNextContract(null);
            		current.setPreContract(null);
            	}
            }
            else {
            	throw new ContractNotFoundException(id);
            }           
        }
    }
   
    /**
     * Finds a contract given its id, return null if no contract was found.
     * @param id Contract id
     * @return Found contract, null if not found
     */
    public Contract findContract(String id) {
    	bubbleSortContracts();
    	if(firstContract == null) {
    		return null;
    	}
    	else {
    		int length = 1;
    		Contract current = firstContract;
    		
    		while(current.getNextContract() != null) {
    			length++;
    			current.getNextContract();
    		}
    		
    		int middleLength = length/2;   		
    		
    		Contract middleContract = firstContract;
    		int low = 0;
    		int mid = middleLength;
    		int high = length;    		
    		
    		while(low<=high) {    			
    			mid = (low + high)/2;
    			for (int i = low; i < mid; i++) {
    				middleContract = middleContract.getNextContract();
    			} 
    			
    			if(id.compareTo(middleContract.getId()) == 0) {
    				return middleContract;			
    			}
    			else if(id.compareTo(middleContract.getId()) < 0){
    				high = mid-1;
    			}
    			else {
    				low = mid+1;			
    			}	    			
    		}
    		return null;
    	}    	
	}

    /**
     * Sorts contracts using id as criteria.
     */
    public void bubbleSortContracts() {
    	if(firstContract != null && firstContract.getNextContract() != null) {
	    	boolean exchange = true;
	    	while(exchange) {
	    		exchange = false;
	    		Contract prev = null;
	    		Contract current = firstContract;
	    		Contract next = firstContract.getNextContract();
	    		while(current.getNextContract() != null) {
	    			if(current.compareTo(current.getNextContract()) > 0) {
	    				if(current == firstContract) {
	    					if(next.getNextContract() == null) {
	    						next.setNextContract(current);
	    						next.setPreContract(null);
	    						current.setNextContract(null);
	    						current.setPreContract(next);	    						
	    					}
	    					else {
	    						current.setPreContract(next);
	    						current.setNextContract(next.getNextContract());
	    						next.getNextContract().setPreContract(current);
	    						
	    						next.setNextContract(current);
	    						next.setPreContract(null);	
	    						
	    					}
	    					firstContract = next;
	    				}
	    				else if(next.getNextContract() == null) {
	    					prev.setNextContract(next);
	    					
	    					current.setPreContract(next);
	    					current.setNextContract(null);
	    					
	    					next.setPreContract(prev);
	    					next.setNextContract(current);
	    				}
	    				else{
	    					prev.setNextContract(next);
	    					
	    					current.setPreContract(next);
	    					current.setNextContract(next.getNextContract());
	    					
	    					next.setPreContract(prev);
	    					next.getNextContract().setPreContract(current);
	    					next.setNextContract(current);
	    				}
	    				prev = current;
	    				current = next;
	    				next = next.getNextContract();
	    				
	    				exchange = true;
	    			}
	    		}
	    	}
    	}
    }
    
    
	/*public BranchOffice searchBrandOffice(String id) throws NotFundBrandOfficeException {

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

    }*/    

    public void addEmployee(Employee e) {

        if (firstEmployee == null) {
            firstEmployee = e;
        } else {

            addEmployee(firstEmployee, e);

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

        if (firstEmployee.getId().equals(id)) {
            return firstEmployee;
        }

        return searchEmployee(firstEmployee, id);

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
     * 
     * @return
     */
    public LegalRepresentative getLegalRepresentative() {
        return legalRepresentative;
    }

    /**
     * 
     * @param legalRepresentative
     */
    public void setLegalRepresentative(LegalRepresentative legalRepresentative) {
    	this.legalRepresentative = legalRepresentative;    	
    }

    /**
     * 
     * @return
     */
    public Employee getFirstEmployee() {
        return firstEmployee;
    }

    /**
     * 
     * @param firstEmployee
     */
    public void setFirstEmployee(Employee firstEmployee) {
        this.firstEmployee = firstEmployee;
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
    
    public double getIncome() {
		return income;
	}

	public double getOutcome() {
		return outcome;
	}

	public double getTaxes() {
		return taxes;
	}

	public double getValue() {
		return value;
	}

	public BranchOffice getFirstOffice() {
		return firstOffice;
	}

}