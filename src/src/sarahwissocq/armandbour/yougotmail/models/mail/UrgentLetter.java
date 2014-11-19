package src.sarahwissocq.armandbour.yougotmail.models.mail;

/**
 * The UrgentLetter class describes a letter with a doubled cost.
 * @author Armand BOUR
 * @author Sarah WISSOCQ
 *
 */
public class UrgentLetter extends DecorativeLetter {

	public UrgentLetter(Letter<?> letter) {
		super(letter);
	}

	@Override
	public float getCost() {
		return super.getCost() * 2;
	}
}
