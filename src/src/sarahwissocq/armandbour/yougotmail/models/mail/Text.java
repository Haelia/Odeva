package src.sarahwissocq.armandbour.yougotmail.models.mail;

/**
 * The Text class represents some text coming with a letter.
 * @author Armand BOUR
 * @author Sarah WISSOCQ
 *
 */
public class Text implements Content {

	/** The text contained. */
	private String text;

	public Text(String text) {
		this.text = text;
	}
	
	@Override
	public String get() {
		return this.text;
	}

	@Override
	public String toString() {
		return "a text content (" + this.text + ")";
	}
}
