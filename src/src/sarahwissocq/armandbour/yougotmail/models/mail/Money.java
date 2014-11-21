package src.sarahwissocq.armandbour.yougotmail.models.mail;

/**
 * The Money class represents money sent through mail.
 * @author Armand BOUR
 * @author Sarah WISSOCQ
 *
 */
public class Money implements Content {

	/** The amount of money contained. */
	private float amount;
	
	public Money(float amount) {
		this.amount = amount;
	}
	
	@Override
	public Float get() {
		return this.amount;
	}

	@Override
	public String toString() {
		return "a money content (" + String.valueOf(this.amount) + ")";
	}
}
