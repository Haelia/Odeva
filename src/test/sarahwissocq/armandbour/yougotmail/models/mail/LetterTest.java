package test.sarahwissocq.armandbour.yougotmail.models.mail;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import src.sarahwissocq.armandbour.yougotmail.models.City;
import src.sarahwissocq.armandbour.yougotmail.models.Inhabitant;
import src.sarahwissocq.armandbour.yougotmail.models.mail.Content;
import src.sarahwissocq.armandbour.yougotmail.models.mail.Letter;
import src.sarahwissocq.armandbour.yougotmail.models.mail.Mail;

public abstract class LetterTest<T extends Content> {

	protected class DummyInhabitant extends Inhabitant {

		public int numberOfLetterSent;
		
		public DummyInhabitant(String name, City city) {
			super(name, city);
			numberOfLetterSent = 0;
		}
		
		@Override
		public void postMail(Mail<?> mail) {
			super.postMail(mail);
			this.numberOfLetterSent++;
		}
	}
	
	protected Letter<T> letter;
	protected DummyInhabitant sender;
	protected DummyInhabitant receiver;

	protected abstract Letter<T> createLetter(Inhabitant sender, Inhabitant receiver);

	@Before
	public void init() {
		City c = new City("TestCity");
		sender = new DummyInhabitant("test", c);
		receiver = new DummyInhabitant("test2", c);
		letter = createLetter(sender, receiver);
	}

	@Test
	public void testLetter() {
		assertNotNull(letter);
	}

	@Test
	public void getSenderTest() {
		assertEquals(sender, letter.getSender());
	}

	@Test
	public void getReceiverTest() {
		assertEquals(receiver, letter.getReceiver());
	}

	@Test
	public abstract void getCostTest();
}
