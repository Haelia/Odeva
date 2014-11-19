package test.sarahwissocq.armandbour.yougotmail.models.mail;

import src.sarahwissocq.armandbour.yougotmail.models.Inhabitant;
import src.sarahwissocq.armandbour.yougotmail.models.mail.Letter;
import src.sarahwissocq.armandbour.yougotmail.models.mail.SimpleLetter;
import src.sarahwissocq.armandbour.yougotmail.models.mail.Text;

public class SimpleLetterTest extends LetterTest<Text>{

	@Override
	protected Letter<Text> createLetter(Inhabitant i, Inhabitant in) {
		Text t = new Text("test");
		return new SimpleLetter(i,in,t);
	}

}
