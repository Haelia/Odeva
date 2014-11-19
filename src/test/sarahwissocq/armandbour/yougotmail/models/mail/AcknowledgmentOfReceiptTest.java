package test.sarahwissocq.armandbour.yougotmail.models.mail;

import static org.junit.Assert.assertEquals;
import src.sarahwissocq.armandbour.yougotmail.models.City;
import src.sarahwissocq.armandbour.yougotmail.models.Inhabitant;
import src.sarahwissocq.armandbour.yougotmail.models.mail.AcknowledgmentOfReceipt;
import src.sarahwissocq.armandbour.yougotmail.models.mail.Letter;
import src.sarahwissocq.armandbour.yougotmail.models.mail.Text;

public class AcknowledgmentOfReceiptTest extends LetterTest<Text> {

	@Override
	protected Letter<Text> createLetter(Inhabitant sender, Inhabitant receiver) {
		return new AcknowledgmentOfReceipt(sender, receiver);
	}

	@Override
	public void getCostTest() {
		City c = new City("test");
		Inhabitant send = new Inhabitant("send", c);
		Inhabitant rece = new Inhabitant("rece", c);
		Letter<Text> l = new AcknowledgmentOfReceipt(send, rece);
		assertEquals(0, l.getCost(), 0.1);

	}
}
