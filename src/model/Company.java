package model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Random;
import customExceptions.BranchOfficeAlreadyExistException;
import customExceptions.BranchOfficeNotFoundException;
import customExceptions.ContractAlreadyExistException;
import customExceptions.ContractNotFoundException;
import customExceptions.EmployeeAlreadyExistsException;
import customExceptions.EmployeeNotFoundException;
import customExceptions.ImpossibleToRemoveEmployeeException;

public class Company {

	private String name;
	private String nit;
	private double income;
	private double outcome;
	private double taxes;
	private double value;
	
	private Employee firstEmployee;// Binary search tree
	private LegalRepresentative legalRepresentative;// Direct relation

	private Contract firstContract;// Double linked list
	private BranchOffice firstBranchOffice;// Double linked list

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
		
		new File("data/companies").mkdir();		
		new File("data/companies/" + nit).mkdir();		
		
		try {
			updateSave();
		} 
		catch (FileNotFoundException e) {
			//SHOULD NOT GET IN HERE
		} 
		catch (IOException e) {
			//SHOULD NOT GET IN HERE
		}		
	}

	/**
	 * Adds a previously created contract.
	 * 
	 * @param newContract Contract to add.
	 * @throws ContractAlreadyExistException
	 */
	public void addContract(Contract newContract) throws ContractAlreadyExistException {

		Contract current;

		if (firstContract == null) {

			firstContract = newContract;

		} else if (findContract(newContract.getId()) == null) {
			
			current = firstContract;

			while (current.getNextContract() != null) {				
				current = current.getNextContract();

			}

			current.setNextContract(newContract);
			newContract.setPreContract(current);
		} else {
			throw new ContractAlreadyExistException(newContract.getId());
		}
	}

	/**
	 * Remove a contract given its id
	 * 
	 * @param id Contract id
	 * @throws ContractNotFoundException
	 */
	public void removeContract(String id) throws ContractNotFoundException {
		Contract current;
		if (firstContract == null) {
			throw new ContractNotFoundException(id);
		} else {
			current = firstContract;

			while (current.getNextContract() != null && !current.getId().equals(id)) {
				current = current.getNextContract();
			}

			if (current.getId().equals(id)) {
				if (current == firstContract) {
					if(firstContract.getNextContract() == null) {
						firstContract = null;
					}
					else {
						firstContract = current.getNextContract();
						current.setNextContract(null);
						firstContract.setPreContract(null);
					}						
				} else if (current.getNextContract() == null) {
					current.getPreContract().setNextContract(null);
					current.setPreContract(null);
				} else {
					current.getPreContract().setNextContract(current.getNextContract());
					current.getNextContract().setPreContract(current.getPreContract());
					current.setNextContract(null);
					current.setPreContract(null);
				}
			} else {
				throw new ContractNotFoundException(id);
			}
		}
	}

	/**
	 * Finds a contract given its id, return null if no contract was found.
	 * 
	 * @param id Contract id
	 * @return Found contract, null if not found
	 */
	public Contract findContract(String id) {
		
		bubbleSortContracts();		
		
		if (firstContract == null) {			
			return null;
		} else {
			Contract start = firstContract;
			
			Contract end = firstContract;						
			while(end.getNextContract() != null) {
				end = end.getNextContract();
			}		
			
			while(start != null && end != null && start.compareTo(end) <= 0) {
				Contract middle = getMiddleContract(start,end);
				if(id.compareTo(middle.getId()) < 0) {
					end = middle.getPreContract();
				}
				else if(id.compareTo(middle.getId()) > 0) {
					start = middle.getNextContract();
				}
				else {
					return middle;
				}					
			}
			return null;
		}
	}
	
	private Contract getMiddleContract(Contract start, Contract end) {		
		if(start != null && start.getNextContract() != null) {
			
			//Find list length
			int length;
			Contract current = start;

			for (length = 1; current != end ; length++) {
				current = current.getNextContract();
			}
			
			//Gets element in the middle
			int halfLength = length/2; 
			current = start;
			for (int i = 0; i < halfLength; i++) {
				current = current.getNextContract();
			}
			
			return current;			
		}
		else if(start.getNextContract() == null) {
			return start;
		}
		else {
			return null;
		}		
	}
	/**
	 * Sorts contracts using id as criteria.
	 */
	public void bubbleSortContracts() {
		
		if (firstContract != null && firstContract.getNextContract() != null) {			
			boolean exchange = true;
			while (exchange) {					
				exchange = false;
				Contract prev = null;
				Contract current = firstContract;
				Contract next = firstContract.getNextContract();
				while (current.getNextContract() != null) {					
					if (current.compareTo(current.getNextContract()) > 0) {						
						if (current == firstContract) {
							if (next.getNextContract() == null) {
								next.setNextContract(current);
								next.setPreContract(null);
								current.setNextContract(null);
								current.setPreContract(next);
							} else {
								current.setPreContract(next);
								current.setNextContract(next.getNextContract());
								next.getNextContract().setPreContract(current);

								next.setNextContract(current);
								next.setPreContract(null);

							}
							firstContract = next;
						} else if (next.getNextContract() == null) {
							prev.setNextContract(next);

							current.setPreContract(next);
							current.setNextContract(null);

							next.setPreContract(prev);
							next.setNextContract(current);
						} else {
							prev.setNextContract(next);

							current.setPreContract(next);
							current.setNextContract(next.getNextContract());

							next.setPreContract(prev);
							next.getNextContract().setPreContract(current);
							next.setNextContract(current);
						}
						exchange = true;
					}
					prev = current;
					current = next;
					next = next.getNextContract();
				}
			}
		}
	}

	/**
	 * 
	 * @param newBranchOffice
	 * @throws BranchOfficeAlreadyExistException
	 */
	public void addBranchOffice(BranchOffice newBranchOffice) throws BranchOfficeAlreadyExistException {

		BranchOffice current;

		if (firstBranchOffice == null) {
			
			firstBranchOffice = newBranchOffice;

		} else if (findBranchOffice(newBranchOffice.getId()) == null) {
			
			current = firstBranchOffice;

			while (current.getNextOffice() != null) {
				
				current = current.getNextOffice();

			}

			current.setNextOffice(newBranchOffice);
			newBranchOffice.setPreOffice(current);
		} else {
			
			throw new BranchOfficeAlreadyExistException(newBranchOffice.getId());
		}
		
	}

	/**
	 * 
	 * @param id
	 * @throws BracnhOfficeNotFoundException
	 */
	public void removeBranchOffice(String id) throws BranchOfficeNotFoundException {
		BranchOffice current;
		if (firstBranchOffice == null) {
			throw new BranchOfficeNotFoundException(id);
		} else {
			current = firstBranchOffice;

			while (current.getNextOffice() != null && !current.getId().equals(id)) {
				current = current.getNextOffice();
			}

			if (current.getId().equals(id)) {
				if (current == firstBranchOffice) {
					if(firstBranchOffice.getNextOffice() == null) {
						firstBranchOffice = null;
					}
					else {
						firstBranchOffice = current.getNextOffice();
						current.setNextOffice(null);
						firstBranchOffice.setPreOffice(null);
					}					
				} else if (current.getNextOffice() == null) {
					current.getPreOffice().setNextOffice(null);
					current.setPreOffice(null);
				} else {
					current.getPreOffice().setNextOffice(current.getNextOffice());
					current.getNextOffice().setPreOffice(current.getPreOffice());
					current.setNextOffice(null);
					current.setPreOffice(null);
				}
			} else {
				throw new BranchOfficeNotFoundException(id);
			}
		}
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	public BranchOffice findBranchOffice(String id) {
		
		if (new Random().nextInt() > 0) {
			insertionSortBranchOffices();
		} else {
			selectionSortBranchOffices();
		}
		
		if (firstBranchOffice == null) {			
			return null;
		} 
		else {
			BranchOffice start = firstBranchOffice;
			
			BranchOffice end = firstBranchOffice;						
			while(end.getNextOffice() != null) {
				end = end.getNextOffice();
			}		
			
			while(start != null && end != null && start.compareTo(end) <= 0) {
				BranchOffice middle = getMiddleBranchOffice(start,end);
				if(id.compareTo(middle.getId()) < 0) {
					end = middle.getPreOffice();
				}
				else if(id.compareTo(middle.getId()) > 0) {
					start = middle.getNextOffice();
				}
				else {
					return middle;
				}					
			}
			return null;
		}
	}
	
	/**
	 * 
	 * @param start
	 * @param end
	 * @return
	 */
	private BranchOffice getMiddleBranchOffice(BranchOffice start, BranchOffice end) {		
		if(start != null && start.getNextOffice() != null) {
			
			//Find list length
			int length;
			BranchOffice current = start;

			for (length = 1; current != end ; length++) {
				current = current.getNextOffice();
			}
			
			//Gets element in the middle
			int halfLength = length/2; 
			current = start;
			for (int i = 0; i < halfLength; i++) {
				current = current.getNextOffice();
			}
			
			return current;			
		}
		else if(start.getNextOffice() == null) {
			return start;
		}
		else {
			return null;
		}		
	}
	
	
	/**
	 * 
	 */
	public void insertionSortBranchOffices() {
		if (firstBranchOffice != null && firstBranchOffice.getNextOffice() != null) {
			BranchOffice current = firstBranchOffice;
			while (current != null) {				
				BranchOffice toInsert = current;
				BranchOffice next = current.getNextOffice();
				BranchOffice temp = current;
				
				while (temp.getPreOffice() != null && toInsert.compareTo(temp.getPreOffice()) < 0) {					
					temp = temp.getPreOffice();
				}
				if(toInsert != firstBranchOffice && temp != current) {
					if (temp == firstBranchOffice) {
						if (toInsert.getNextOffice() == null) {
							toInsert.getPreOffice().setNextOffice(null);
						}
						else {
							toInsert.getPreOffice().setNextOffice(toInsert.getNextOffice());
							toInsert.getNextOffice().setPreOffice(toInsert.getPreOffice());												
						}
						toInsert.setPreOffice(null);
						toInsert.setNextOffice(firstBranchOffice);
						firstBranchOffice.setPreOffice(toInsert);
	
						firstBranchOffice = toInsert;
					}
					else {
						if (toInsert.getNextOffice() == null) {
							toInsert.getPreOffice().setNextOffice(null);
						}
						else {						
							toInsert.getPreOffice().setNextOffice(toInsert.getNextOffice());
							toInsert.getNextOffice().setPreOffice(toInsert.getPreOffice());
							
						}
						toInsert.setPreOffice(temp.getPreOffice());
						toInsert.setNextOffice(temp);
						temp.setPreOffice(toInsert);
						toInsert.getPreOffice().setNextOffice(toInsert);
					}
				}
				current = next;
			}
		}
	}

	/**
	 * 
	 */
	public void selectionSortBranchOffices() {		
		if (firstBranchOffice != null && firstBranchOffice.getNextOffice() != null) {
			BranchOffice current = firstBranchOffice;
			while (current.getNextOffice() != null) {				
				BranchOffice min = current;
				BranchOffice temp = current;			
				
				while (temp != null) {					
					if (temp.compareTo(min) < 0) {
						min = temp;
					}
					temp = temp.getNextOffice();					
				}

				if (min != current) {					
					if (min.getNextOffice() == null) {					
						if (current == firstBranchOffice && current.getNextOffice() != min) {
							current.getNextOffice().setPreOffice(min);
							min.getPreOffice().setNextOffice(current);

							min.setNextOffice(current.getNextOffice());
							current.setPreOffice(min.getPreOffice());

							min.setPreOffice(null);
							current.setNextOffice(null);	
							firstBranchOffice = min;
						} 
						else if(current == firstBranchOffice && current.getNextOffice() == min) {
							current.setPreOffice(min);
							min.setNextOffice(current);

							min.setPreOffice(null);
							current.setNextOffice(null);
							firstBranchOffice = min;
						}
						else if(current != firstBranchOffice && current.getNextOffice() == min) {
							min.setPreOffice(current.getPreOffice());
							current.getPreOffice().setNextOffice(min);
							current.setPreOffice(min);
							min.setNextOffice(current);							
							current.setNextOffice(null);						
						}	
						else {
							current.getPreOffice().setNextOffice(min);
							current.getNextOffice().setPreOffice(min);
							min.getPreOffice().setNextOffice(current);

							min.setNextOffice(current.getNextOffice());
							min.setPreOffice(current.getPreOffice());
							current.setPreOffice(min.getPreOffice());

							current.setNextOffice(null);
						}
					} 
					else {
						if (current == firstBranchOffice && current.getNextOffice() != min) {
							current.getNextOffice().setPreOffice(min);
							min.getPreOffice().setNextOffice(current);
							min.getNextOffice().setPreOffice(current);
							
							BranchOffice minNextOffice = min.getNextOffice();
							min.setNextOffice(current.getNextOffice());
							current.setNextOffice(minNextOffice);
							
							BranchOffice minPreOffice = min.getPreOffice();
							min.setPreOffice(null);
							current.setPreOffice(minPreOffice);		
							firstBranchOffice = min;
						} 
						else if(current == firstBranchOffice && current.getNextOffice() == min) {
							BranchOffice preOfficeCurrent = current.getPreOffice();
							BranchOffice nextOfficeMin = min.getNextOffice();
							
							preOfficeCurrent.setNextOffice(min);
							nextOfficeMin.setPreOffice(current);
							
							current.setPreOffice(min);
							current.setNextOffice(nextOfficeMin);
							min.setNextOffice(current);
							min.setPreOffice(preOfficeCurrent);		
							firstBranchOffice = min;
						}
						else if(current != firstBranchOffice && current.getNextOffice() == min) {
							BranchOffice preOfficeCurrent = current.getPreOffice();
							BranchOffice nextOfficeMin = min.getNextOffice();
							
							preOfficeCurrent.setNextOffice(min);
							nextOfficeMin.setPreOffice(current);
							
							current.setPreOffice(min);
							current.setNextOffice(nextOfficeMin);
							min.setNextOffice(current);
							min.setPreOffice(preOfficeCurrent);	
						}
						else {
							current.getPreOffice().setNextOffice(min);
							current.getNextOffice().setPreOffice(min);
							min.getPreOffice().setNextOffice(current);
							min.getNextOffice().setPreOffice(current);
	
							BranchOffice minNextOffice = min.getNextOffice();
							min.setNextOffice(current.getNextOffice());
							current.setNextOffice(minNextOffice);
	
							BranchOffice minPreOffice = min.getPreOffice();
							min.setPreOffice(current.getPreOffice());
							current.setPreOffice(minPreOffice);
						}
					}					
				}
				current = min.getNextOffice();
			}
		}
	}

	/**
	 * 
	 * @param e
	 * @throws EmployeeAlreadyExistsException
	 */
	public void addEmployee(Employee e) throws EmployeeAlreadyExistsException {

		if (firstEmployee == null) {
			firstEmployee = e;
		} else if (findEmployee(e.getId()) == null) {
			addEmployee(firstEmployee, e);
		} else {
			throw new EmployeeAlreadyExistsException(e.getId());
		}

	}

	/**
	 * 
	 * @param current
	 * @param e
	 */
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

	/**
	 * 
	 * @param id
	 * @throws ImpossibleToRemoveEmployeeException 
	 */
	public void removeEmployee(String id) throws EmployeeNotFoundException, ImpossibleToRemoveEmployeeException {

		Employee toRemove = findEmployee(id);

		if(toRemove == firstEmployee) {
			throw new ImpossibleToRemoveEmployeeException("El empleado que ha intentado remover es el representante legal, no puede ser removido!");
		}
		if (toRemove != null) {

			if (toRemove.getRight() == null && toRemove.getLeft() == null) {
				if(toRemove == firstEmployee) {
					firstEmployee = null;
				}
				else {
					if (toRemove.getFather().getLeft() == toRemove) {
						toRemove.getFather().setLeft(null);
					} else {
						toRemove.getFather().setRight(null);
					}
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
				} 
				else {
					current.getFather().setLeft(current);
				}

				current = null;

			}

		} else {
			throw new EmployeeNotFoundException(id);
		}

	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	public Employee findEmployee(String id) {
		if (firstEmployee == null) {
			return null;
		}
		else if (firstEmployee.getId().equals(id)) {
			return firstEmployee;
		}
		else {
			return findEmployee(firstEmployee, id);
		}

	}

	/**
	 * 
	 * @param current
	 * @param id
	 * @return
	 */
	private Employee findEmployee(Employee current, String id) {

		if (current.getId().equals(id)) {
			return current;
		}
		else if (current.getId().compareTo(id) > 0) {
			
			if (current.getLeft() == null) {
				return null;
			}
			else {
				return findEmployee(current.getLeft(), id);
			}			
		}
		else {
			if (current.getRight() == null) {
				return null;
			} 
			else {
				return findEmployee(current.getRight(), id);
			}
		}
	}

	/**
	 * 
	 * @return
	 */
	public Company getFather() {
		return father;
	}

	/**
	 * 
	 * @param father
	 */

	public void setFather(Company father) {
		this.father = father;
	}

	/**
	 * 
	 * @return
	 */

	public Company getLeft() {
		return left;
	}

	/**
	 * 
	 * @param left
	 */

	public void setLeft(Company left) {
		this.left = left;
	}

	/**
	 * 
	 * @return
	 */

	public Company getRight() {
		return right;
	}

	/**
	 * 
	 * @param right
	 */

	public void setRight(Company right) {
		this.right = right;
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

	public String getNit() {
		return nit;
	}

	/**
	 * 
	 * @return
	 */

	public double getIncome() {
		return income;
	}

	/**
	 * 
	 * @return
	 */

	public double getOutcome() {
		return outcome;
	}

	/**
	 * 
	 * @return
	 */

	public double getTaxes() {
		return taxes;
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

	public Employee getFirstEmployee() {
		return firstEmployee;
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
	 * @return
	 */

	public Contract getFirstContract() {
		return firstContract;
	}

	/**
	 * 
	 * @return
	 */

	public BranchOffice getFirstBranchOffice() {
		return firstBranchOffice;
	}
	
	public ArrayList<BranchOffice> branchOfficesToArrayList(){
		ArrayList<BranchOffice> offices = new ArrayList<>();
		BranchOffice current = firstBranchOffice;
		
		if(current != null) {
			while(current != null) {
				offices.add(current);
				current = current.getNextOffice();
			}
		}	
		
		return offices;
	}

	public ArrayList<Employee> employeesToArrayList() {
		return employeesToArrayListRecursive(firstEmployee, new ArrayList<Employee>());
	}
	
	private ArrayList<Employee> employeesToArrayListRecursive(Employee employee, ArrayList<Employee> employeesList) {
		if(employee == null) {
			return employeesList;
		}
		else {
			employeesList.add(employee);
			employeesList = employeesToArrayListRecursive(employee.getLeft(), employeesList);
			employeesList = employeesToArrayListRecursive(employee.getRight(), employeesList);	
			return employeesList;
		}		
	}

	public ArrayList<Contract> contractsToArrayList() {
		ArrayList<Contract> contracts = new ArrayList<>();
		Contract current = firstContract;
		
		if(current != null) {
			while(current != null) {
				contracts.add(current);
				current = current.getNextContract();
			}
		}
		return contracts;
	}

	public void setIncome(double income) {
		this.income = income;
	}

	public void setOutcome(double outcome) {
		this.outcome = outcome;
	}

	public void setTaxes(double taxes) {
		this.taxes = taxes;
	}
	
	public void updateSave() throws FileNotFoundException, IOException {		
		BufferedWriter bw = new BufferedWriter(new FileWriter("data/companies/" + nit +"/attributes.txt"));
		bw.write(name + "\n" + nit + "\n" + income + "\n" + outcome + "\n" + taxes + "\n" + value);
		bw.close();
		
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("data/companies/" + nit +"/employees.dat"));
		oos.writeObject(firstEmployee);
		oos.close();		
		
		oos = new ObjectOutputStream(new FileOutputStream("data/companies/" + nit +"/contracts.dat"));
		oos.writeObject(firstContract);
		oos.close();
		
		oos = new ObjectOutputStream(new FileOutputStream("data/companies/" + nit +"/branch_offices.dat"));
		oos.writeObject(firstBranchOffice);
		oos.close();
	}

	public void setFirstEmployee(Employee firstEmployee) {
		this.firstEmployee = firstEmployee;		
	}

	public void setLegalRepresentative(LegalRepresentative legalRepresentative) {
		this.legalRepresentative = legalRepresentative;		
	}

	public void setFirstBranchOffice(BranchOffice firstBranchOffice) {
		this.firstBranchOffice = firstBranchOffice;		
	}

	public void setFirstContract(Contract firstContract) {
		this.firstContract = firstContract;
	}

	public void deleteSave() {
		File file = new File("data/companies/" + nit + "/attributes.txt");
		file.delete();
		
		file = new File("data/companies/" + nit +"/employees.dat");
		file.delete();
		
		file = new File("data/companies/" + nit +"/contracts.dat");
		file.delete();
		
		file = new File("data/companies/" + nit +"/branch_offices.dat");
		file.delete();
		
		file = new File("data/companies/" + nit);
		file.delete();
	}
	
}