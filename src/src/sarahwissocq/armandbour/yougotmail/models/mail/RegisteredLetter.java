package src.sarahwissocq.armandbour.yougotmail.models.mail;

/**
 * When you send a registered letter, you'll receive an acknowledgment of
 * receipt. A registered letter cost the price of the letter + 15.
 * 
 * @author Armand BOUR
 * @author Sarah WISSOCQ
 */
public class RegisteredLetter extends DecorativeLetter {

	public RegisteredLetter(Letter<?> letter) {
		super(letter);
	}

	@Override
	public void action() {
		this.receiver.postMail(new AcknowledgmentOfReceipt(this.receiver,
				this.sender));
	}

	@Override
	public float getCost() {
		return (this.content.getCost() + 15);
	}
	
	@Override
	public String toString() {
		return "a registered letter whose content is " + this.content.toString();
	}
}
