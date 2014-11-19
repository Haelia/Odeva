package test.sarahwissocq.armandbour.yougotmail.models.mail;

import src.sarahwissocq.armandbour.yougotmail.models.City;
import src.sarahwissocq.armandbour.yougotmail.models.Inhabitant;
import src.sarahwissocq.armandbour.yougotmail.models.mail.Letter;
import src.sarahwissocq.armandbour.yougotmail.models.mail.Money;
import src.sarahwissocq.armandbour.yougotmail.models.mail.PromissoryNote;
import static org.junit.Assert.*;

public class PromissoryNoteTest extends LetterTest<Money> {

	@Override
	protected Letter<Money> createLetter(Inhabitant i, Inhabitant in) {
		Money m =new Money((float) 100);
		return new PromissoryNote(i,in,m);
	}

	@Override
	public void getCostTest() {
		City c = new City("test");
		Inhabitant send = new Inhabitant("send", c);
		Inhabitant rece = new Inhabitant("rece", c);
		Money m =new Money((float) 100);
		Letter<Money> l = new PromissoryNote(send,rece,m);
		assertEquals( 2,l.getCost(),0.1);
	}
	
	

}
