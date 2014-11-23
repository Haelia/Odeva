package src.sarahwissocq.armandbour.yougotmail.models.mail;

import src.sarahwissocq.armandbour.yougotmail.models.Inhabitant;

public class ThanksLetter extends SimpleLetter {

	public ThanksLetter(Inhabitant sender, Inhabitant receiver, Letter<?> letter) {
		super(sender, receiver, new Text("Thanks for " + letter.toString()));
	}

	@Override
	public String toString() {
		return "a thanks letter which is " + super.toString();
	}
}
