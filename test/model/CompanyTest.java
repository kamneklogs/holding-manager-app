package model;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

import customExceptions.BranchOfficeAlreadyExistException;
import customExceptions.BranchOfficeNotFoundException;
//import customExceptions.BranchOfficeNotFoundException;
import customExceptions.ContractAlreadyExistException;
import customExceptions.ContractNotFoundException;
import customExceptions.EmployeeAlreadyExistsException;
import customExceptions.EmployeeNotFoundException;
import customExceptions.ImpossibleToRemoveEmployeeException;

class CompanyTest {

private Company company;
	
	//As contract is abstract a contract of any type is created.

	public void setUpContracts1(){
		company = new Company(null, null, 0, 0, 0, 0);
	}
	
	public void setUpContracts2(){
		company = new Company(null, null, 0, 0, 0, 0);
		try {
			company.addContract(new DefinedTermContract("C1234", null, null, 0, null, null, null));
		} catch (ContractAlreadyExistException e) {			
			e.printStackTrace();
		}
	}
	
	public void setUpContracts3(){
		company = new Company(null, null, 0, 0, 0, 0);
		try {
			company.addContract(new DefinedTermContract("C1234", null, null, 0, null, null, null));
			company.addContract(new DefinedTermContract("C2598", null, null, 0, null, null, null));
		} catch (ContractAlreadyExistException e) {			
			e.printStackTrace();
		}
	}

	public void setUpContracts4(){
		company = new Company(null, null, 0, 0, 0, 0);
		try {
			company.addContract(new DefinedTermContract("C1234", null, null, 0, null, null, null));
			company.addContract(new DefinedTermContract("C2598", null, null, 0, null, null, null));
			company.addContract(new DefinedTermContract("C0000", null, null, 0, null, null, null));
			company.addContract(new DefinedTermContract("C1111", null, null, 0, null, null, null));
		} catch (ContractAlreadyExistException e) {			
			e.printStackTrace();
		}
	}

	public void setUpContracts5(){	
		company = new Company(null, null, 0, 0, 0, 0);
		try {			
			company.addContract(new DefinedTermContract("C2598", null, null, 0, null, null, null));
			company.addContract(new DefinedTermContract("C1234", null, null, 0, null, null, null));
		} catch (ContractAlreadyExistException e) {			
			e.printStackTrace();
		}
	}
	
	public void setUpEmployees1(){
		company = new Company(null, null, 0, 0, 0, 0);
	}
	
	public void setUpEmployees2(){
		company = new Company(null, null, 0, 0, 0, 0);
		try {
			company.addEmployee(new Employee("Juan","1234", null, null, null,0, 0, null));
		} catch (EmployeeAlreadyExistsException e) {
			e.printStackTrace();
		}
	}

	public void setUpEmployees3(){
		company = new Company(null, null, 0, 0, 0, 0);
		try {
			company.addEmployee(new Employee("Juan","1234", null, null, null,0, 0, null));
			company.addEmployee(new Employee("Federico","2598", null, null, null,0, 0, null));
		} catch (EmployeeAlreadyExistsException e) {
			e.printStackTrace();
		}
	}

	public void setUpEmployees4(){
		company = new Company(null, null, 0, 0, 0, 0);
		try {
			company.addEmployee(new Employee("Juan","1234", null, null, null,0, 0, null));
			company.addEmployee(new Employee("Federico","2598", null, null, null,0, 0, null));
			company.addEmployee(new Employee("Camila","0000", null, null, null,0, 0, null));
			company.addEmployee(new Employee("Ana","1111", null, null, null,0, 0, null));
		} catch (EmployeeAlreadyExistsException e) {
			e.printStackTrace();
		}
	}

	public void setUpBranchOffices1() {
		company = new Company(null, null, 0, 0, 0, 0);		
	}
	
	public void setUpBranchOffices2() {
		company = new Company(null, null, 0, 0, 0, 0);
		try {
			company.addBranchOffice(new BranchOffice(null, null, "O1234", false, null));
		} catch (BranchOfficeAlreadyExistException e) {			
			e.printStackTrace();
		}
	}
	
	public void setUpBranchOffices3() {
		company = new Company(null, null, 0, 0, 0, 0);
		try {
			company.addBranchOffice(new BranchOffice(null, null, "O1234", false, null));
			company.addBranchOffice(new BranchOffice(null, null, "O2598", false, null));
		} catch (BranchOfficeAlreadyExistException e) {			
			e.printStackTrace();
		}
	}
	
	public void setUpBranchOffices4() {
		company = new Company(null, null, 0, 0, 0, 0);
		try {
			company.addBranchOffice(new BranchOffice(null, null, "O1234", false, null));
			company.addBranchOffice(new BranchOffice(null, null, "O2598", false, null));
			company.addBranchOffice(new BranchOffice(null, null, "O0000", false, null));
			company.addBranchOffice(new BranchOffice(null, null, "O1111", false, null));
		} catch (BranchOfficeAlreadyExistException e) {			
			e.printStackTrace();
		}
	}

	public void setUpBranchOffices5() {
		company = new Company(null, null, 0, 0, 0, 0);
		try {
			company.addBranchOffice(new BranchOffice(null, null, "O2598", false, null));
			company.addBranchOffice(new BranchOffice(null, null, "O1234", false, null));
		} catch (BranchOfficeAlreadyExistException e) {			
			e.printStackTrace();
		}
	}
	
	@Test
	void testAddEmployee1() {
		setUpEmployees1();
		try {
			company.addEmployee(new Employee("Camilo","2222", null, null, null,0, 0, null));
		} catch (EmployeeAlreadyExistsException e) {
			fail("Unexcepted Exception");
		}
		assertEquals("2222",company.getFirstEmployee().getId());
		
	}
	@Test
	void testAddEmployee2() {
		setUpEmployees2();
		try {
			company.addEmployee(new Employee("Camilo","2222", null, null, null,0, 0, null));
		} catch (EmployeeAlreadyExistsException e) {
			fail("Unexcepted Exception");
		}
		assertEquals("1234",company.getFirstEmployee().getId());
		assertEquals("2222",company.getFirstEmployee().getRight().getId());
	}
	@Test
	void testAddEmployee3() {
		setUpEmployees3();
		try {
			company.addEmployee(new Employee("Camilo","2222", null, null, null,0, 0, null));
		} catch (EmployeeAlreadyExistsException e) {
			fail("Unexcepted Exception");
		}
		assertEquals("1234",company.getFirstEmployee().getId());
		assertEquals("2598",company.getFirstEmployee().getRight().getId());
		assertEquals("2222",company.getFirstEmployee().getRight().getLeft().getId());
	}
	@Test
	void testAddEmployee4() {
		setUpEmployees4();
		try {
			company.addEmployee(new Employee("Camilo","2222", null, null, null,0, 0, null));
		} catch (EmployeeAlreadyExistsException e) {
			fail("Unexcepted Exception");
		}
		assertEquals("1234",company.getFirstEmployee().getId());
		assertEquals("0000",company.getFirstEmployee().getLeft().getId());
		assertEquals("1111",company.getFirstEmployee().getLeft().getRight().getId());
		assertEquals("2598",company.getFirstEmployee().getRight().getId());
		assertEquals("2222",company.getFirstEmployee().getRight().getLeft().getId());
	}
	@Test
	void testAddEmployee5() {
		setUpEmployees4();
		try {
			company.addEmployee(new Employee("Camilo","1125", null, null, null,0, 0, null));
		} catch (EmployeeAlreadyExistsException e) {
			fail("Unexcepted Exception");
		}
		assertEquals("1234",company.getFirstEmployee().getId());
		assertEquals("0000",company.getFirstEmployee().getLeft().getId());
		assertEquals("1111",company.getFirstEmployee().getLeft().getRight().getId());
		assertEquals("2598",company.getFirstEmployee().getRight().getId());
		assertEquals("1125",company.getFirstEmployee().getLeft().getRight().getRight().getId());
	}
	
	@Test
	void testFindEmployee1() {
		setUpEmployees1();
		Employee e = company.findEmployee("2222");
		assertNull(e);
	}
	@Test
	void testFindEmployee2() {
		setUpEmployees2();
		Employee e = company.findEmployee("2222");
		assertNull(e);
	}
	@Test
	void testFindEmployee3() {
		setUpEmployees2();
		Employee e = company.findEmployee("1234");
		assertEquals("1234",e.getId());
	}
	@Test
	void testFindEmployee4() {
		setUpEmployees3();
		Employee e = company.findEmployee("2222");
		assertNull(e);
	}
	@Test
	void testFindEmployee5() {
		setUpEmployees3();
		Employee e = company.findEmployee("2598");
		assertEquals("2598",e.getId());
	}
	@Test
	void testFindEmployee6() {
		setUpEmployees4();
		Employee e = company.findEmployee("2222");
		assertNull(e);
	}
	@Test
	void testFindEmployee7() {
		setUpEmployees4();
		Employee e = company.findEmployee("0000");
		assertEquals("0000",e.getId());
	}
	
	@Test
	void testRemoveEmployee1() {
		setUpEmployees1();
		try {
			company.removeEmployee("2222");
			fail("Exception Expected");
		} catch (EmployeeNotFoundException e) {
			
		} catch (ImpossibleToRemoveEmployeeException e) {
			fail("UnexpectedException");
		}
		assertNull(company.getFirstEmployee());
	}
	@Test
	void testRemoveEmployee2() {
		setUpEmployees2();
		try {
			company.removeEmployee("2222");
			fail("Exception Expected");
		} catch (EmployeeNotFoundException e) {
			
		} catch (ImpossibleToRemoveEmployeeException e) {
			fail("UnexpectedException");
		}
		assertEquals("1234",company.getFirstEmployee().getId());
	}
	@Test
	void testRemoveEmployee3() {
		setUpEmployees2();
		try {
			company.removeEmployee("1234");			
		} catch (EmployeeNotFoundException e) {
			fail("Unexpected exception");
		} catch (ImpossibleToRemoveEmployeeException e) {
			assertTrue(true);
		}		
	}
	@Test
	void testRemoveEmployee4() {
		setUpEmployees3();
		try {
			company.removeEmployee("2222");
			fail("Exception Expected");
		} catch (EmployeeNotFoundException e) {
			
		} catch (ImpossibleToRemoveEmployeeException e) {
			fail("UnexpectedException");
		}
		assertEquals("1234",company.getFirstEmployee().getId());
	}
	@Test
	void testRemoveEmployee5() {
		setUpEmployees3();
		try {
			company.removeEmployee("2222");		
			fail("Expected exception");
		} catch (EmployeeNotFoundException e) {
			
		} catch (ImpossibleToRemoveEmployeeException e) {
			fail("UnexpectedException");
		}
		assertEquals("1234",company.getFirstEmployee().getId());
	}
	@Test
	void testRemoveEmployee6() {
		setUpEmployees4();
		try {
			company.removeEmployee("2222");
			fail("Exception Expected");
		} catch (EmployeeNotFoundException e) {
			
		} catch (ImpossibleToRemoveEmployeeException e) {
			fail("UnexpectedException");
		}
		assertEquals("1234",company.getFirstEmployee().getId());
	}
	
	@Test
	void testRemoveEmployee7() {
		setUpEmployees4();
		try {
			company.removeEmployee("1111");
		} catch (EmployeeNotFoundException e) {
			fail("Unexpected exception");
		} catch (ImpossibleToRemoveEmployeeException e) {
			fail("UnexpectedException");
		}
		assertEquals("1234",company.getFirstEmployee().getId());
		assertEquals("2598",company.getFirstEmployee().getRight().getId());
		assertEquals("0000",company.getFirstEmployee().getLeft().getId());
		assertNull(company.getFirstEmployee().getLeft().getRight());
	}
	
	@Test
	void testRemoveEmployee8() {
		setUpEmployees4();
		try {
			company.removeEmployee("0000");
		} catch (EmployeeNotFoundException e) {
			fail("Unexpected exception");
		} catch (ImpossibleToRemoveEmployeeException e) {
			fail("UnexpectedException");
		}
		assertEquals("1234",company.getFirstEmployee().getId());
		assertEquals("2598",company.getFirstEmployee().getRight().getId());
		assertEquals("1111",company.getFirstEmployee().getLeft().getId());
		assertNull(company.getFirstEmployee().getLeft().getRight());
		assertNull(company.getFirstEmployee().getLeft().getLeft());
	}		
	
	@Test
	void testAddContract1() {
		setUpContracts1();
		try {
			company.addContract(new DefinedTermContract("C2222", null, null, 0, null, null, null));
		} catch (ContractAlreadyExistException e) {
			fail("Unexpected exception");
		}
		assertEquals("C2222",company.getFirstContract().getId());
	}
	
	@Test
	void testAddContract2() {
		setUpContracts2();
		try {
			company.addContract(new DefinedTermContract("C2222", null, null, 0, null, null, null));
		} catch (ContractAlreadyExistException e) {
			fail("Unexpected exception");
		}
		assertEquals("C2222",company.getFirstContract().getNextContract().getId());
	}
	
	@Test
	void testAddContract3() {
		setUpContracts3();		
		try {
			company.addContract(new DefinedTermContract("C2222", null, null, 0, null, null, null));
		} catch (ContractAlreadyExistException e) {
			fail("Unexpected exception");
		}
		assertEquals("C2222",company.getFirstContract().getNextContract().getNextContract().getId());
	}
	
	@Test
	void testAddContract4() {
		setUpContracts4();
		try {
			company.addContract(new DefinedTermContract("C2222", null, null, 0, null, null, null));
		} catch (ContractAlreadyExistException e) {
			fail("Unexpected exception");
		}
		assertEquals("C2222",company.getFirstContract().getNextContract().getNextContract().getNextContract().getNextContract().getId());
	}
	
	@Test
	void testFindContract1() {
		setUpContracts1();
		Contract c = company.findContract("C2222");
		assertNull(c);
	}
	
	@Test
	void testFindContract2() {
		setUpContracts2();
		Contract c = company.findContract("C2222");
		assertNull(c);
	}
	
	@Test
	void testFindContract3() {
		setUpContracts2();
		Contract c = company.findContract("C1234");
		assertEquals("C1234",c.getId());
	}
	
	@Test
	void testFindContract4() {
		setUpContracts3();
		Contract c = company.findContract("C2222");
		assertNull(c);
	}
	
	@Test
	void testFindContract5() {
		setUpContracts3();
		Contract c = company.findContract("C2598");
		assertEquals("C2598",c.getId());		
	}
	
	@Test
	void testFindContract6() {
		setUpContracts3();
		Contract c = company.findContract("C1234");
		assertEquals("C1234",c.getId());		
	}
	
	@Test
	void testFindContract7() {
		setUpContracts4();
		Contract c = company.findContract("C2222");
		assertNull(c);
	}
	
	@Test
	void testFindContract8() {
		setUpContracts4();
		Contract c = company.findContract("C0000");
		assertEquals("C0000",c.getId());
	}
	
	@Test
	void testFindContract9() {
		setUpContracts4();
		Contract c = company.findContract("C1111");
		assertEquals("C1111",c.getId());
	}
	
	@Test
	void testFindContract10() {
		setUpContracts4();
		Contract c = company.findContract("C1234");
		assertEquals("C1234",c.getId());
	}
	
	@Test
	void testFindContract11() {
		setUpContracts4();
		Contract c = company.findContract("C2598");
		assertEquals("C2598",c.getId());
	}	
	
	@Test
	void testRemoveContract1() {
		setUpContracts1();
		try {
			company.removeContract("2222");
			fail("Expected exception");
		} catch (ContractNotFoundException e) {
			
		}		
		assertNull(company.getFirstContract());
	}
	
	@Test
	void testRemoveContract2() {
		setUpContracts2();
		try {
			company.removeContract("C2222");
			fail("Expected exception");
		} catch (ContractNotFoundException e) {
			
		}		
		assertEquals("C1234",company.getFirstContract().getId());
	}
	
	@Test
	void testRemoveContract3() {
		setUpContracts2();
		try {
			company.removeContract("C1234");			
		} catch (ContractNotFoundException e) {
			fail("Unexpected exception");
		}		
		assertNull(company.getFirstContract());
	}
	
	@Test
	void testRemoveContract4() {
		setUpContracts3();
		try {
			company.removeContract("C2222");	
			fail("Expected exception");
		} catch (ContractNotFoundException e) {
			
		}		
		assertEquals("C1234",company.getFirstContract().getId());
		assertEquals("C2598",company.getFirstContract().getNextContract().getId());
	}
	
	@Test
	void testRemoveContract5() {
		setUpContracts3();
		try {
			company.removeContract("C1234");				
		} catch (ContractNotFoundException e) {
			fail("Unexpected exception");
		}		
		assertEquals("C2598",company.getFirstContract().getId());
		assertNull(company.getFirstContract().getNextContract());
	}
	
	@Test
	void testRemoveContract6() {
		setUpContracts4();
		try {
			company.removeContract("C2222");	
			fail("Expected exception");
		} catch (ContractNotFoundException e) {
			
		}		
		assertEquals("C0000",company.getFirstContract().getId());			
		assertEquals("C1234",company.getFirstContract().getNextContract().getId());
		assertEquals("C2598",company.getFirstContract().getNextContract().getNextContract().getId());	
		assertEquals("C1111",company.getFirstContract().getNextContract().getNextContract().getNextContract().getId());	
		assertNull(company.getFirstContract().getNextContract().getNextContract().getNextContract().getNextContract());
	}
	
	@Test
	void testRemoveContract7() {
		setUpContracts4();
		try {
			company.removeContract("C1111");				
		} catch (ContractNotFoundException e) {
			fail("Unexpected exception");
		}		
		assertEquals("C0000",company.getFirstContract().getId());	
		assertEquals("C1234",company.getFirstContract().getNextContract().getId());
		assertEquals("C2598",company.getFirstContract().getNextContract().getNextContract().getId());	
		assertNull(company.getFirstContract().getNextContract().getNextContract().getNextContract());
	}
	
	@Test
	void testRemoveContract8() {
		setUpContracts4();
		try {
			company.removeContract("C1234");				
		} catch (ContractNotFoundException e) {
			fail("Unexpected exception");
		}		
		assertEquals("C0000",company.getFirstContract().getId());	
		assertEquals("C2598",company.getFirstContract().getNextContract().getId());
		assertEquals("C1111",company.getFirstContract().getNextContract().getNextContract().getId());	
		assertNull(company.getFirstContract().getNextContract().getNextContract().getNextContract());
	}
	
	@Test
	void testAddBranchOffice1() {
		setUpBranchOffices1();
		try {
			company.addBranchOffice(new BranchOffice(null, null, "O2222", false, null));
		} catch (BranchOfficeAlreadyExistException e) {
			fail("Unexpected Exception");
		}
		assertEquals("O2222",company.getFirstBranchOffice().getId());
	}
	
	@Test
	void testAddBranchOffice2() {
		setUpBranchOffices2();
		try {
			company.addBranchOffice(new BranchOffice(null, null, "O2222", false, null));
		} catch (BranchOfficeAlreadyExistException e) {
			fail("Unexpected Exception");
		}
		assertEquals("O2222",company.getFirstBranchOffice().getNextOffice().getId());
	}
	
	@Test
	void testAddBranchOffice3() {
		setUpBranchOffices3();
		try {
			company.addBranchOffice(new BranchOffice(null, null, "O2222", false, null));
		} catch (BranchOfficeAlreadyExistException e) {
			fail("Unexpected Exception");
		}
		assertEquals("O2222",company.getFirstBranchOffice().getNextOffice().getNextOffice().getId());
	}
	
	@Test
	void testAddBranchOffice4() {
		setUpBranchOffices4();
		try {
			company.addBranchOffice(new BranchOffice(null, null, "O2222", false, null));
		} catch (BranchOfficeAlreadyExistException e) {
			fail("Unexpected Exception");
		}
		assertEquals("O2222",company.getFirstBranchOffice().getNextOffice().getNextOffice().getNextOffice().getNextOffice().getId());	
	}
	
	@Test
	void testFindBranchOffice1() {
		setUpBranchOffices1();
		BranchOffice branchOffice = company.findBranchOffice("O2222");
		assertNull(branchOffice);
	}
	
	@Test
	void testFindBranchOffice2() {
		setUpBranchOffices2();
		BranchOffice branchOffice = company.findBranchOffice("O2222");
		assertNull(branchOffice);
	}
	
	@Test
	void testFindBranchOffice3() {
		setUpBranchOffices2();
		BranchOffice branchOffice = company.findBranchOffice("O1234");
		assertEquals("O1234",branchOffice.getId());
	}
	
	@Test
	void testFindBranchOffice4() {
		setUpBranchOffices3();
		BranchOffice branchOffice = company.findBranchOffice("O2222");
		assertNull(branchOffice);
	}
	
	@Test
	void testFindBranchOffice5() {
		setUpBranchOffices3();
		BranchOffice branchOffice = company.findBranchOffice("O2598");
		assertEquals("O2598",branchOffice.getId());
	}
	
	@Test
	void testFindBranchOffice6() {
		setUpBranchOffices3();
		BranchOffice branchOffice = company.findBranchOffice("O1234");
		assertEquals("O1234",branchOffice.getId());
	}
	
	@Test
	void testFindBranchOffice7() {
		setUpBranchOffices4();
		BranchOffice branchOffice = company.findBranchOffice("O2222");
		assertNull(branchOffice);
	}
	
	@Test
	void testFindBranchOffice8() {
		setUpBranchOffices4();
		BranchOffice branchOffice = company.findBranchOffice("O0000");
		assertEquals("O0000",branchOffice.getId());
	}
	
	@Test
	void testFindBranchOffice9() {
		setUpBranchOffices4();
		BranchOffice branchOffice = company.findBranchOffice("O1111");
		assertEquals("O1111",branchOffice.getId());
	}
	
	@Test
	void testFindBranchOffice10() {
		setUpBranchOffices4();
		BranchOffice branchOffice = company.findBranchOffice("O1234");
		assertEquals("O1234",branchOffice.getId());
	}
	
	@Test
	void testFindBranchOffice11() {
		setUpBranchOffices4();
		BranchOffice branchOffice = company.findBranchOffice("O2598");
		assertEquals("O2598",branchOffice.getId());
	}
	
	@Test
	void testRemoveBranchOffice1() {
		setUpBranchOffices1();
		try {
			company.removeBranchOffice("O2222");
			fail("Expected exception");
		} catch (BranchOfficeNotFoundException e) {
			
		}		
		assertNull(company.getFirstBranchOffice());
	}
	
	@Test
	void testRemoveBranchOffice2() {
		setUpBranchOffices2();
		try {
			company.removeBranchOffice("O2222");
			fail("Expected exception");
		} catch (BranchOfficeNotFoundException e) {
			
		}		
		assertEquals("O1234",company.getFirstBranchOffice().getId());
	}
	
	@Test
	void testBranchOffice3() {
		setUpBranchOffices2();
		try {
			company.removeBranchOffice("O1234");			
		} catch (BranchOfficeNotFoundException e) {
			fail("Unexpected exception");
		}		
		assertNull(company.getFirstBranchOffice());
	}
	
	@Test
	void testRemoveBranchOffices4() {
		setUpBranchOffices3();
		try {
			company.removeBranchOffice("O2222");
			fail("Expected exception");	
		} catch (BranchOfficeNotFoundException e) {
		
		}				
		assertEquals("O1234",company.getFirstBranchOffice().getId());
		assertEquals("O2598",company.getFirstBranchOffice().getNextOffice().getId());
	}
	
	@Test
	void testRemoveBranchOffices5() {
		setUpBranchOffices3();
		try {
			company.removeBranchOffice("O1234");				
		} catch (BranchOfficeNotFoundException e) {
			fail("Unexpected exception");
		}		
		assertEquals("O2598",company.getFirstBranchOffice().getId());
		assertNull(company.getFirstBranchOffice().getNextOffice());
	}
	
	@Test
	void testRemoveBranchOffices6() {
		setUpBranchOffices4();
		try {
			company.removeBranchOffice("O2222");	
			fail("Expected exception");
		} catch (BranchOfficeNotFoundException e) {
			
		}		
		assertEquals("O0000",company.getFirstBranchOffice().getId());			
		assertEquals("O1234",company.getFirstBranchOffice().getNextOffice().getId());
		assertEquals("O2598",company.getFirstBranchOffice().getNextOffice().getNextOffice().getId());	
		assertEquals("O1111",company.getFirstBranchOffice().getNextOffice().getNextOffice().getNextOffice().getId());	
		assertNull(company.getFirstBranchOffice().getNextOffice().getNextOffice().getNextOffice().getNextOffice());
	}
	
	@Test
	void testRemoveBranchOffice7() {
		setUpBranchOffices4();
		try {
			company.removeBranchOffice("O1111");				
		} catch (BranchOfficeNotFoundException e) {
			fail("Unexpected exception");
		}		
		assertEquals("O0000",company.getFirstBranchOffice().getId());	
		assertEquals("O1234",company.getFirstBranchOffice().getNextOffice().getId());
		assertEquals("O2598",company.getFirstBranchOffice().getNextOffice().getNextOffice().getId());	
		assertNull(company.getFirstBranchOffice().getNextOffice().getNextOffice().getNextOffice());
	}
	
	@Test
	void testRemoveBranchOffice8() {
		setUpBranchOffices4();
		try {
			company.removeBranchOffice("O1234");				
		} catch (BranchOfficeNotFoundException e) {
			fail("Unexpected exception");
		}		
		assertEquals("O0000",company.getFirstBranchOffice().getId());	
		assertEquals("O2598",company.getFirstBranchOffice().getNextOffice().getId());
		assertEquals("O1111",company.getFirstBranchOffice().getNextOffice().getNextOffice().getId());	
		assertNull(company.getFirstBranchOffice().getNextOffice().getNextOffice().getNextOffice());
	}
	
	@Test
	void testInsertionSortBranchOffices1() {
		setUpBranchOffices1();
		company.insertionSortBranchOffices();
		assertNull(company.getFirstBranchOffice());
	}
	
	@Test
	void testInsertionSortBranchOffices2() {
		setUpBranchOffices2();
		company.insertionSortBranchOffices();
		assertEquals("O1234",company.getFirstBranchOffice().getId());
	}
	
	@Test
	void testInsertionSortBranchOffices3() {
		setUpBranchOffices3();
		company.insertionSortBranchOffices();
		assertEquals("O1234",company.getFirstBranchOffice().getId());
		assertEquals("O2598",company.getFirstBranchOffice().getNextOffice().getId());
	}
	
	@Test
	void testInsertionSortBranchOffices4() {
		setUpBranchOffices5();
		company.insertionSortBranchOffices();
		assertEquals("O1234",company.getFirstBranchOffice().getId());
		assertEquals("O2598",company.getFirstBranchOffice().getNextOffice().getId());
	}
	
	@Test
	void testInsertionSortBranchOffices5() {
		setUpBranchOffices4();
		company.insertionSortBranchOffices();
		assertEquals("O0000",company.getFirstBranchOffice().getId());
		assertEquals("O1111",company.getFirstBranchOffice().getNextOffice().getId());
		assertEquals("O1234",company.getFirstBranchOffice().getNextOffice().getNextOffice().getId());
		assertEquals("O2598",company.getFirstBranchOffice().getNextOffice().getNextOffice().getNextOffice().getId());
	}
	
	@Test
	void testSelectionSortBranchOffices1() {
		setUpBranchOffices1();
		company.selectionSortBranchOffices();
		assertNull(company.getFirstBranchOffice());
	}
	
	@Test
	void testSelectionSortBranchOffices2() {
		setUpBranchOffices2();
		company.selectionSortBranchOffices();
		assertEquals("O1234",company.getFirstBranchOffice().getId());
	}
	
	@Test
	void testSelectionSortBranchOffices3() {
		setUpBranchOffices3();
		company.selectionSortBranchOffices();
		assertEquals("O1234",company.getFirstBranchOffice().getId());
		assertEquals("O2598",company.getFirstBranchOffice().getNextOffice().getId());
	}
	
	@Test
	void testSelectionSortBranchOffices4() {
		setUpBranchOffices5();		
		company.selectionSortBranchOffices();
		assertEquals("O1234",company.getFirstBranchOffice().getId());
		assertEquals("O2598",company.getFirstBranchOffice().getNextOffice().getId());
	}
	
	@Test
	void testSelectionSortBranchOffices5() {
		setUpBranchOffices4();
		company.selectionSortBranchOffices();
		assertEquals("O0000",company.getFirstBranchOffice().getId());
		assertEquals("O1111",company.getFirstBranchOffice().getNextOffice().getId());
		assertEquals("O1234",company.getFirstBranchOffice().getNextOffice().getNextOffice().getId());
		assertEquals("O2598",company.getFirstBranchOffice().getNextOffice().getNextOffice().getNextOffice().getId());
	}	
	
	@Test
	void testBubbleSortContracts1() {
		setUpContracts1();
		company.bubbleSortContracts();
		assertNull(company.getFirstContract());			
	}
	
	@Test
	void testBubbleSortContracts2() {		
		setUpContracts2();
		company.bubbleSortContracts();
		assertEquals("C1234", company.getFirstContract().getId());
	}
	
	@Test
	void testBubbleSortContracts3() {
		setUpContracts3();
		company.bubbleSortContracts();
		assertEquals("C1234", company.getFirstContract().getId());
		assertEquals("C2598", company.getFirstContract().getNextContract().getId());		
	}
	
	@Test
	void testBubbleSortContracts4() {
		setUpContracts4();
		company.bubbleSortContracts();
		assertEquals("C0000", company.getFirstContract().getId());
		assertEquals("C1111", company.getFirstContract().getNextContract().getId());
		assertEquals("C1234", company.getFirstContract().getNextContract().getNextContract().getId());
		assertEquals("C2598", company.getFirstContract().getNextContract().getNextContract().getNextContract().getId());	
	}
	
	@Test
	void testBubbleSortContracts5() {
		setUpContracts5();
		company.bubbleSortContracts();
		assertEquals("C1234", company.getFirstContract().getId());
		assertEquals("C2598", company.getFirstContract().getNextContract().getId());	
	}

}
