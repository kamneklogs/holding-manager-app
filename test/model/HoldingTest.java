package model;

import static org.junit.jupiter.api.Assertions.*;

//import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HoldingTest {

	private Holding theHolding;

	public void setUpCompanies1() throws Exception {
		theHolding = new Holding("Seros Group", 2212132, false);
	}

	public void setUpCompanies2() throws Exception {
		theHolding = new Holding("Seros Group", 2212132, false);
		theHolding.addCompany(new EducationCompany("Norma", "N1234", 0, 0, 0, 0));
	}

	public void setUpCompanies3() throws Exception {
		theHolding = new Holding("Seros Group", 2212132, false);
		theHolding.addCompany(new EducationCompany("Norma", "N1234", 0, 0, 0, 0));
		theHolding.addCompany(new TechnologyCompany("Carvajal", "N2598", 0, 0, 0, 0));
	}

	public void setUpCompanies4() throws Exception {
		theHolding = new Holding("Seros Group", 2212132, false);
		theHolding.addCompany(new EducationCompany("Norma", "N1234", 0, 0, 0, 0));
		theHolding.addCompany(new TechnologyCompany("Carvajal", "N2598", 0, 0, 0, 0));
		theHolding.addCompany(new FoodCompany("Bavaria", "N0000", 0, 0, 0, 0));
		theHolding.addCompany(new TechnologyCompany("Reprograf", "N1111", 0, 0, 0, 0));
	}

	@Test
	void testAddCompany1() throws Exception {
		setUpCompanies1();
		Company n1 = new FoodCompany("Scribe", "N2222", 0, 0, 0, 0);
		theHolding.addCompany(n1);
		assertEquals(n1, theHolding.getFirstCompany());
	}

	@Test
	void testAddCompany2() throws Exception {
		setUpCompanies2();
		Company n1 = new FoodCompany("Scribe", "N2222", 0, 0, 0, 0);
		theHolding.addCompany(n1);
		assertEquals(n1, theHolding.getFirstCompany().getRight());
	}

	@Test
	void testAddCompany3() throws Exception {
		setUpCompanies3();
		Company n1 = new FoodCompany("Scribe", "N2222", 0, 0, 0, 0);
		theHolding.addCompany(n1);
		assertEquals(n1, theHolding.getFirstCompany().getRight().getLeft());
	}

	@Test
	void testAddCompany4() throws Exception {
		setUpCompanies4();
		Company n1 = new FoodCompany("Scribe", "N2222", 0, 0, 0, 0);
		theHolding.addCompany(n1);
		assertEquals(n1, theHolding.getFirstCompany().getRight().getLeft());
	}

	@Test
	void testAddCompany5() throws Exception {
		setUpCompanies4();
		Company n1 = new FoodCompany("Camilo", "N1125", 0, 0, 0, 0);
		theHolding.addCompany(n1);
		assertEquals(n1, theHolding.getFirstCompany().getLeft().getRight().getRight());
	}

	@Test
	void testSellCompany1() throws Exception {
		setUpCompanies1();

		theHolding.sellCompany("N2222", 223);

		assertNull(theHolding.getFirstCompany());
	}

	@Test
	void testSellCompany2() throws Exception {
		setUpCompanies2();
		theHolding.sellCompany("N2222", 223);

		assertEquals("Norma", theHolding.getFirstCompany().getName());

	}

	@Test
	void testSellCompany3() throws Exception {
		setUpCompanies2();
		theHolding.sellCompany("N1234", 223);

		assertNull(theHolding.getFirstCompany());
	}

	@Test
	void testSellCompany4() throws Exception {
		setUpCompanies3();
		theHolding.sellCompany("N2222", 223);

		assertEquals("Norma", theHolding.getFirstCompany().getName());
	}

	@Test
	void testSellCompany5() throws Exception {
		setUpCompanies4();
		theHolding.sellCompany("N2222", 223);

		assertEquals("Norma", theHolding.getFirstCompany().getName());

	}

	@Test
	void testSellCompany6() throws Exception {
		setUpCompanies4();
		theHolding.sellCompany("N1234", 223);
		assertEquals("Norma", theHolding.getFirstCompany().getName());
		assertEquals("N1234", theHolding.getFirstCompany().getNit());

	}

	@Test
	void testSellCompany7() throws Exception {
		setUpCompanies4();
		theHolding.sellCompany("N1111", 223);

		assertNull(theHolding.getFirstCompany().getLeft().getRight());
	}

	@Test
	void testSellCompany8() throws Exception {
		setUpCompanies4();
		theHolding.sellCompany("N0000", 223);

		assertEquals("Reprograf", theHolding.getFirstCompany().getLeft().getName());
	}

	@Test
	void testSellCompany9() throws Exception {
		setUpCompanies4();

		double prevValue = theHolding.getValue();
		theHolding.sellCompany("N1111", 223);
		assertEquals(prevValue + 223, theHolding.getValue());

	}

}