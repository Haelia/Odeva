package test.sarahwissocq.armandbour.yougotmail.models.mail;

import src.sarahwissocq.armandbour.yougotmail.models.City;
import src.sarahwissocq.armandbour.yougotmail.models.Inhabitant;
import src.sarahwissocq.armandbour.yougotmail.models.mail.Letter;
import src.sarahwissocq.armandbour.yougotmail.models.mail.SimpleLetter;
import src.sarahwissocq.armandbour.yougotmail.models.mail.Text;
import static org.junit.Assert.*;

public class SimpleLetterTest extends LetterTest<Text> {
	
	@Override
	protected Letter<Text> createLetter(Inhabitant sender, Inhabitant receiver) {
		Text t = new Text("test");
		return new SimpleLetter(sender, receiver, t);
	}

	@Override
	public void getCostTest() {
		City c = new City("test");
		Text t = new Text("test");
		Inhabitant send = new Inhabitant("send", c);
		Inhabitant rece = new Inhabitant("rece", c);
		Letter<Text> l = new SimpleLetter(send, rece, t);
		assertEquals(SimpleLetter.COST, l.getCost(), 0.1);
	}

}
