package test.sarahwissocq.armandbour.yougotmail.models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import src.sarahwissocq.armandbour.yougotmail.models.BankAccount;
import src.sarahwissocq.armandbour.yougotmail.models.City;
import src.sarahwissocq.armandbour.yougotmail.models.Inhabitant;

public class BankAccountTest {

	private BankAccount acc;
	
	@Before
	public void initialiseFields() {
		this.acc = new BankAccount((float) 1500.50, new Inhabitant("", new City("")));
	}
	
	@Test
	public void TestBankAccount() {
		assertNotNull(this.acc);
	}

	@Test
	public void getAmountTest() {
		assertEquals(this.acc.getAmount(),1500.50,0.01);
	}

	@Test
	public void creditTest() {
		this.acc.credit((float) 500.01);
		float f = (float) 2000.51;
		assertEquals(this.acc.getAmount(), f, 0.01);
	}

	@Test
	public void withdrawTest() {
		this.acc.withdraw((float) 500.01);
		float f = (float) 1000.49;
		assertEquals(this.acc.getAmount(), f, 0.01);
	}
}
