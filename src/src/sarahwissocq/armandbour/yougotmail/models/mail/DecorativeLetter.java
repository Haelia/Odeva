package src.sarahwissocq.armandbour.yougotmail.models.mail;

/**
 * The DecorativeLetter class uses the Decorator pattern to decorate a letter with
 * an extra effect.
 * @author Armand BOUR
 * @author Sarah WISSOCQ
 *
 */
public abstract class DecorativeLetter extends Letter<Letter<?>> {

	public DecorativeLetter(Letter<?> letter) {
		super(letter.sender, letter.receiver, letter);
	}
	
	@Override
	public void action() {
		this.content.action();
	}
	
	@Override
	public float getCost() {
		return this.content.getCost();
	}
}
