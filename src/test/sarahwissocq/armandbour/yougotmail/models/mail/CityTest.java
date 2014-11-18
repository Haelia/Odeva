package test.sarahwissocq.armandbour.yougotmail.models.mail;

import org.junit.Before;
import org.junit.Test;

import src.sarahwissocq.armandbour.yougotmail.models.City;
import src.sarahwissocq.armandbour.yougotmail.models.Inhabitant;
import src.sarahwissocq.armandbour.yougotmail.models.mail.Letter;
import src.sarahwissocq.armandbour.yougotmail.models.mail.Money;

public class CityTest {
	
	/**
	 * Dummy letter to credit money to the receive.
	 * @author Armand BOUR
	 * @author Sarah WISSOCQ
	 *
	 */
	private class EasyMoneyLetter extends Letter<Money>{

		public EasyMoneyLetter(Inhabitant sender, Inhabitant receiver) {
			super(sender, receiver, null);
		}

		@Override
		public float getCost() {
			return 10;
		}

		@Override
		public void action() {
			this.receiver.getBankAccount().credit(1000);
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
		this.city.post(new EasyMoneyLetter(this.city.getInhabitant(0),
				this.city.getInhabitant(1)));
		
	}
}
