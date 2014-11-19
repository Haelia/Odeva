package src.sarahwissocq.armandbour.yougotmail.models.mail;

import src.sarahwissocq.armandbour.yougotmail.models.Inhabitant;

/**
 * @author Armand BOUR
 * @author Sarah WISSOCQ
 *
 * @param <T> The Content of the Letter.
 */
public abstract class Letter<T extends Content> implements Mail<T> {

	/** Content of the letter */
	protected T content;

	/** The inhabitant who send the letter */
	protected Inhabitant sender;

	/** The inhabitant who will receive the letter */
	protected Inhabitant receiver;

	public Letter(Inhabitant sender, Inhabitant receiver, T content) {
		this.sender = sender;
		this.receiver = receiver;
		this.content = content;
	}

	/**
	 * Return the sender of the letter.
	 */
	public Inhabitant getSender() {
		return this.sender;
	}

	/**
	 * Return the receiver of the letter.
	 */
	public Inhabitant getReceiver() {
		return this.receiver;
	}

	/**
	 * Return the price of the letter.
	 */
	public abstract float getCost();

	/**
	 * Do the action of the letter.
	 */
	public abstract void action();

	/**
	 * Return the content.
	 */
	public T getContent() {
		return this.content;
	}
}
