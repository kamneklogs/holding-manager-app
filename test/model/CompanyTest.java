package model;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

import customExceptions.ContractAlreadyExistException;

class CompanyTest {

private Company company;
	
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
