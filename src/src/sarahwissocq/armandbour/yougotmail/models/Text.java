package src.sarahwissocq.armandbour.yougotmail.models;

/**
 * @author Armand BOUR
 * @author Sarah WISSOCQ
 */
public class Text implements Content {

	/** Message that will be content in the letter */
	private String msg;

	public Text(String s) {
		this.msg = s;
	}

	/**
	 * Set the message.
	 * 
	 * @param s
	 *            the new message.
	 */
	public void setMessage(String s) {
		this.msg = s;
	}

	/**
	 * Return the message.
	 * 
	 * @return the message.
	 */
	public String getMessage() {
		return this.msg;
	}
}
