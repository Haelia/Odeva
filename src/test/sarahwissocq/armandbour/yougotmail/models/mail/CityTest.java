package test.sarahwissocq.armandbour.yougotmail.models.mail;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import src.sarahwissocq.armandbour.yougotmail.models.City;
import src.sarahwissocq.armandbour.yougotmail.models.Inhabitant;
import src.sarahwissocq.armandbour.yougotmail.models.mail.Letter;
import src.sarahwissocq.armandbour.yougotmail.models.mail.Money;

public class CityTest {
	
	/**
	 * Dummy letter to credit money to the receiver.
	 * @author Armand BOUR
	 * @author Sarah WISSOCQ
	 *
	 */
	private class EasyMoneyLetter extends Letter<Money>{

		public EasyMoneyLetter(Inhabitant sender, Inhabitant receiver) {
			super(sender, receiver, new Money(1000));
		}

		@Override
		public float getCost() {
			return 10;
		}

		@Override
		public void action() {
			this.receiver.getBankAccount().credit(content.get());
		}
		
	}
	
	private City city;
	
	@Before
	public void initialiseFields() {
		this.city = new City("ChocoLicorneCity");
		
		this.city.addInhabitant(new Inhabitant("Armand Bour", city));
		this.city.addInhabitant(new Inhabitant("Sarah Wissocq", city));
	}
	
	@Test
	public void testDistributeMail() {
		// Credit money to Armand
		Inhabitant armand = this.city.getInhabitant(0);
		Inhabitant sarah = this.city.getInhabitant(1);
		armand.postMail(new EasyMoneyLetter(armand, sarah));
		
		this.city.distributeMail();
		
		assertEquals(1000, sarah.getBankAccount().getAmount(), 0.009);
		assertEquals(-10, armand.getBankAccount().getAmount(), 0.009);
	}
}
