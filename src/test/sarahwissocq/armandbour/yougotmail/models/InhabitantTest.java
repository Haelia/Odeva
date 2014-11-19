package test.sarahwissocq.armandbour.yougotmail.models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import src.sarahwissocq.armandbour.yougotmail.models.City;
import src.sarahwissocq.armandbour.yougotmail.models.Inhabitant;
import src.sarahwissocq.armandbour.yougotmail.models.mail.Letter;
import src.sarahwissocq.armandbour.yougotmail.models.mail.Money;
import src.sarahwissocq.armandbour.yougotmail.models.mail.PromissoryNote;
import src.sarahwissocq.armandbour.yougotmail.models.mail.SimpleLetter;
import src.sarahwissocq.armandbour.yougotmail.models.mail.Text;

public class InhabitantTest {
	
	private Letter<Money> promissoryNote;
	private Letter<Text> simpleLetter;
	private Inhabitant sender;
	private Inhabitant receiver;
	
	@Before
	public void init(){
		City c = new City("TestCity");
		this.sender= new Inhabitant("Sender",c);
		this.receiver= new Inhabitant("Receiver",c);
		Text t =new Text("Ceci est un test");
		this.simpleLetter=new SimpleLetter(sender, receiver, t);
		Money m =new Money(100);
		this.promissoryNote=new PromissoryNote(sender, receiver, m);
	}
	
	@Test
	public void testInhabitant(){
		assertNotNull(this.sender);
		assertNotNull(this.receiver);
	}

	@Test
	public void postMail(){
		this.sender.postMail(this.simpleLetter);
		assertEquals(999,this.sender.getBankAccount().getAmount(),0.1);
		assertEquals(1,this.sender.getCity().getNumberOfLettersInMailbox());
	}
	
	@Test
	public void receiveMail(){
		this.sender.postMail(this.promissoryNote);
		this.sender.getCity().distributeMail();
		assertEquals(1099,this.receiver.getBankAccount().getAmount(),0.1);
		assertEquals(1,this.receiver.getCity().getNumberOfLettersInMailbox());
	}
}
