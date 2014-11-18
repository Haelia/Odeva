package test.sarahwissocq.armandbour.yougotmail.models;

import static org.junit.Assert.*;

import org.junit.Test;

import src.sarahwissocq.armandbour.yougotmail.models.BankAccount;

public class BankAccountTest {

	@Test
	public void TestBankAccount() {
		BankAccount ba = new BankAccount((float) 1500.50);
		assertNotNull(ba);
	}

	@Test
	public void getAmountTest() {
		BankAccount ba = new BankAccount((float) 1500.50);
		assertEquals(ba.getAmount(),1500.50,0.01);
	}

	@Test
	public void creditTest() {
		BankAccount ba = new BankAccount((float) 1500.50);
		ba.credit((float) 500.01);
		float f = (float) 2000.51;
		assertEquals(ba.getAmount(), f, 0.01);
	}

	@Test
	public void withdrawTest() {
		BankAccount ba = new BankAccount((float) 1500.50);
		ba.withdraw((float) 500.01);
		float f = (float) 1000.49;
		assertEquals(ba.getAmount(), f, 0.01);
	}
}
