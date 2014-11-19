package test.sarahwissocq.armandbour.yougotmail.models.mail;

import static org.junit.Assert.*;

import org.junit.Test;

import src.sarahwissocq.armandbour.yougotmail.models.Inhabitant;
import src.sarahwissocq.armandbour.yougotmail.models.mail.Letter;
import src.sarahwissocq.armandbour.yougotmail.models.mail.RegisteredLetter;
import src.sarahwissocq.armandbour.yougotmail.models.mail.SimpleLetter;
import src.sarahwissocq.armandbour.yougotmail.models.mail.Text;

public class RegisteredLetterTest extends LetterTest<Letter<?>>{

	@Override
	protected Letter<Letter<?>> createLetter(Inhabitant sender, Inhabitant receiver) {
		return new RegisteredLetter(
				new SimpleLetter(sender, receiver, new Text("Sincères salutations.")));
	}
	
	@Override
	public void getCostTest() {
		assertEquals(15 + SimpleLetter.COST, this.letter.getCost(), 0.009);
	}

	
	@Test
	public void receiverSendsAcknowledgment() throws Exception {
		assertEquals(0, this.receiver.numberOfLetterSent);
		this.letter.action();
		assertEquals(1, this.receiver.numberOfLetterSent);
	}
}
