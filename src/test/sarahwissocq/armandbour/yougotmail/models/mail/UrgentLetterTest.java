package test.sarahwissocq.armandbour.yougotmail.models.mail;

import static org.junit.Assert.assertEquals;
import src.sarahwissocq.armandbour.yougotmail.models.Inhabitant;
import src.sarahwissocq.armandbour.yougotmail.models.mail.Letter;
import src.sarahwissocq.armandbour.yougotmail.models.mail.SimpleLetter;
import src.sarahwissocq.armandbour.yougotmail.models.mail.Text;
import src.sarahwissocq.armandbour.yougotmail.models.mail.UrgentLetter;

public class UrgentLetterTest extends LetterTest<Letter<?>> {

	@Override
	protected Letter<Letter<?>> createLetter(Inhabitant sender, Inhabitant receiver) {
		return new UrgentLetter(new SimpleLetter(sender, receiver, new Text(
				"Salutations.")));
	}

	@Override
	public void getCostTest() {
		assertEquals(2* SimpleLetter.COST, this.letter.getCost(), 0.009);
	}

}
