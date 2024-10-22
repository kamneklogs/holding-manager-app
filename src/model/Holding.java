package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import customExceptions.BranchOfficeAlreadyExistException;
import customExceptions.BranchOfficeNotFoundException;
import customExceptions.ContractAlreadyExistException;
import customExceptions.ContractNotFoundException;
import customExceptions.EmployeeAlreadyExistsException;
import customExceptions.EmployeeNotFoundException;
import customExceptions.ImpossibleToRemoveEmployeeException;

public class Holding {

	public final static String NAME = "Seros Group";
	public final static String PATH = "data/currentData.txt";

	// Basic attributes
	private String name;
	private double value;
	private int totalTCompanies, totalFCompanies, totalECompanies;
	private boolean stateCharge;

	// Companies binary search tree
	private Company firstCompany;

	// Company currently managed by the system
	private Company currentCompany;

	/**
	 * @param n
	 * @param v
	 */
	public Holding(String n, double v) {
		try {
			loadHoldingData();
			loadCompaniesData();
		} catch (FileNotFoundException e) {
			name = n;
			value = v;
			totalTCompanies = 0;
			totalFCompanies = 0;
			totalECompanies = 0;
			try {
				updateSave();
			} catch (IOException e1) {
				// SHOULD NOT GET IN HERE
			}
		} catch (IOException e) {
			// SHOULD NOT GET IN HERE
		} catch (ClassNotFoundException e) {
			// SHOULD NOT GET IN HERE
		}
		stateCharge = true;
	}

	/**
	 * Created holding without saving its information, used only for testing purposes.
	 * @param n
	 * @param v
	 * @param b
	 */
	public Holding(String n, double v, boolean b) {
		name = n;
		value = v;
		totalTCompanies = 0;
		totalFCompanies = 0;
		totalECompanies = 0;

	}

	/**
	 * 
	 * @param c
	 */
	public void addCompany(Company c) {
		if (firstCompany == null) {
			firstCompany = c;

		} else {
			addCompany(firstCompany, c);
		}
		try {
			if (stateCharge) {
				value += c.getValue();
				addNitToFile(c.getNit());
				c.updateSave();
			}
		} catch (IOException e) {
			// SHOULD NOT GET IN HERE
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
			} else {
				addCompany(current.getLeft(), c);
			}
		} else {
			if (current.getRight() == null) {
				current.setRight(c);
				current.getRight().setFather(current);
			} else {
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
		} else if (firstCompany.getNit().equals(nit)) {
			return firstCompany;
		} else {
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
		} else if (current.getNit().equals(nit)) {
			return current;
		} else if (current.getNit().compareTo(nit) > 0) {
			if (current.getLeft() == null) {
				return null;
			} else {
				return searchCompany(current.getLeft(), nit);
			}
		} else {
			if (current.getNit().equals(nit)) {
				return current;
			} else {
				return searchCompany(current.getRight(), nit);
			}
		}
	}

	/**
	 * 
	 * @param nit
	 */
	public void sellCompany(String nit, double value) {
		if (searchCompany(nit) != null) {
			this.value += value - searchCompany(nit).getValue();
			
			Company c = searchCompany(nit);
			removeCompany(c);
			c.deleteSave();
			try {
				removeNitFromFile(nit);
			} catch (IOException e) {
				// SHOULD NOT GET IN HERE
			}
		}

	}

	/**
	 * 
	 * @param toRemove
	 */
	public void removeCompany(Company toRemove) {
		
		if (toRemove != null) {
			if (toRemove.getRight() == null && toRemove.getLeft() == null) {
				if (toRemove == firstCompany) {
					firstCompany = null;
					currentCompany = null;
				} else {
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

				Company current = toRemove.getLeft();

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

				if (toRemove.getFather() != null) {
					if (toRemove.getFather().getRight() == toRemove) {
						current.getFather().setRight(current);

					} else {
						current.getFather().setLeft(current);
					}
				}

				current = null;
			}

			if (toRemove == currentCompany) {
				currentCompany = null;
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
	 * @throws ImpossibleToRemoveEmployeeException 
	 */
	public void removeEmployee(String id) throws EmployeeNotFoundException, ImpossibleToRemoveEmployeeException {
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
	public String generateEconomicReport(boolean toCsv, boolean toTxt) {
		return new EconomicReport(toCsv, toTxt, currentCompany).generateReport();
	}

	/**
	 * 
	 * @param toScreen
	 * @param toCsv
	 * @param toTxt
	 * @return
	 */
	public String generateBranchOfficesReport(boolean toCsv, boolean toTxt) {
		return new BranchOfficesReport(toCsv, toTxt, currentCompany).generateReport();
	}

	/**
	 * 
	 * @return
	 */
	public ArrayList<BranchOffice> getCurrentCompanyOffices() {
		return currentCompany.branchOfficesToArrayList();
	}

	/**
	 * 
	 * @param toScreen
	 * @param toCsv
	 * @param toTxt
	 * @return
	 */
	public String generateContractReportGeneral(boolean toCsv, boolean toTxt) {
		return new ContractReportGeneral(toCsv, toTxt, currentCompany).generateReport();
	}

	/**
	 * 
	 * @param toScreen
	 * @param toCsv
	 * @param toTxt
	 * @return
	 */
	public String generateEmployeeReportGeneral(boolean toCsv, boolean toTxt) {
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
	 * @return
	 */
	public ArrayList<Employee> getCurrentCompanyEmployees() {
		return currentCompany.employeesToArrayList();
	}

	/**
	 * 
	 * @return
	 */
	public ArrayList<Contract> getCurrentCompanyContracts() {
		return currentCompany.contractsToArrayList();
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
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @throws NumberFormatException
	 * 
	 */
	public void loadCompaniesData() throws IOException, ClassNotFoundException {
		BufferedReader br = new BufferedReader(new FileReader("data/companiesNIT.txt"));

		String line = br.readLine();
		while (line != null) {
			String nit = line;

			BufferedReader br2 = new BufferedReader(new FileReader("data/companies/" + nit + "/attributes.txt"));

			String name = br2.readLine();
			
			nit = br2.readLine();
			
			double income = Double.parseDouble(br2.readLine());
			double outcome = Double.parseDouble(br2.readLine());
			double taxes = Double.parseDouble(br2.readLine());
			double value = Double.parseDouble(br2.readLine());
			int type = Integer.parseInt(br2.readLine());
			br2.close();

			Company c;

			if (type == EducationCompany.TYPE_ID) {
				c = new EducationCompany(name, nit, income, outcome, taxes, value);
			} else if (type == FoodCompany.TYPE_ID) {
				c = new FoodCompany(name, nit, income, outcome, taxes, value);
			} else {
				c = new TechnologyCompany(name, nit, income, outcome, taxes, value);
			}

			ObjectInputStream ois = new ObjectInputStream(
					new FileInputStream("data/companies/" + nit + "/employees.dat"));
			Employee firstEmployee = (Employee) ois.readObject();
			LegalRepresentative legalRepresentative = (LegalRepresentative) firstEmployee;
			ois.close();

			ois = new ObjectInputStream(new FileInputStream("data/companies/" + nit + "/contracts.dat"));
			Contract firstContract = (Contract) ois.readObject();
			ois.close();

			ois = new ObjectInputStream(new FileInputStream("data/companies/" + nit + "/branch_offices.dat"));
			BranchOffice firstBranchOffice = (BranchOffice) ois.readObject();
			ois.close();

			c.setFirstEmployee(firstEmployee);
			c.setLegalRepresentative(legalRepresentative);

			BranchOffice current = firstBranchOffice;

			while (current != null) {
				String id = current.geteResponsible().getId();
				Employee eResponsable = c.findEmployee(id);
				current.setResponsableEmployee(eResponsable);
				current = current.getNextOffice();
			}
			c.setFirstBranchOffice(firstBranchOffice);

			Contract currentContract = firstContract;

			while (currentContract != null) {
				String id = currentContract.getEmployee().getId();
				Employee employee = c.findEmployee(id);
				employee.setContract(currentContract);
				currentContract.setEmployee(employee);

				currentContract = currentContract.getNextContract();
			}
			c.setFirstContract(firstContract);

			addCompany(c);

			line = br.readLine();
		}
		br.close();
	}

	/**
	 * @throws IOException
	 * @throws FileNotFouncdException
	 * 
	 */
	private void loadHoldingData() throws FileNotFoundException, IOException {
		BufferedReader br = new BufferedReader(new FileReader("data/holding.txt"));
		name = br.readLine();
		value = Double.parseDouble(br.readLine());
		totalTCompanies = Integer.parseInt(br.readLine());
		totalFCompanies = Integer.parseInt(br.readLine());
		totalECompanies = Integer.parseInt(br.readLine());
		br.close();
	}

	/**
	 * 
	 * @throws IOException
	 */
	public void updateSave() throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter("data/holding.txt"));
		bw.write(name + "\n" + value + "\n" + totalTCompanies + "\n" + totalFCompanies + "\n" + totalECompanies);
		bw.close();

		File file = new File("data/companiesNIT.txt");
		if (!file.exists()) {
			file.createNewFile();
		}
		if (currentCompany != null) {
			currentCompany.updateSave();
		}
	}

	/**
	 * 
	 * @param nit
	 * @throws IOException
	 */
	private void addNitToFile(String nit) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("data/companiesNIT.txt"));
		ArrayList<String> nits = new ArrayList<>();
		String line = br.readLine();
		while (line != null) {
			nits.add(line);
			line = br.readLine();
		}
		nits.add(nit);

		BufferedWriter bw = new BufferedWriter(new FileWriter("data/companiesNIT.txt"));
		for (int i = 0; i < nits.size(); i++) {
			bw.write(nits.get(i));
			bw.newLine();
		}

		bw.close();
		br.close();
	}

	/**
	 * 
	 * @param nit
	 * @throws IOException
	 */
	private void removeNitFromFile(String nit) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("data/companiesNIT.txt"));
		ArrayList<String> nits = new ArrayList<>();
		String line = br.readLine();
		while (line != null) {
			nits.add(line);
			line = br.readLine();
		}
		nits.remove(nit);

		BufferedWriter bw = new BufferedWriter(new FileWriter("data/companiesNIT.txt"));
		for (int i = 0; i < nits.size(); i++) {
			bw.write(nits.get(i));
			bw.newLine();
		}

		bw.close();
		br.close();
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

	/**
	 * 
	 * @return
	 */
	public int getTotalTCompanies() {
		return totalTCompanies;
	}

	/**
	 * 
	 * @param totalTCompanies
	 */
	public void setTotalTCompanies(int totalTCompanies) {
		this.totalTCompanies = totalTCompanies;
	}
	/**
	 * 
	 * @return
	 */
	public int getTotalFCompanies() {
		return totalFCompanies;
	}

	/**
	 * 
	 * @param totalFCompanies
	 */
	public void setTotalFCompanies(int totalFCompanies) {
		this.totalFCompanies = totalFCompanies;
	}

	/**
	 * 
	 * @return
	 */
	public int getTotalECompanies() {
		return totalECompanies;
	}

	/**
	 * 
	 * @param totalECompanies
	 */
	public void setTotalECompanies(int totalECompanies) {
		this.totalECompanies = totalECompanies;
	}

	/**
	 * 
	 * @return
	 */
	public boolean isStateCharge() {
		return stateCharge;
	}

}