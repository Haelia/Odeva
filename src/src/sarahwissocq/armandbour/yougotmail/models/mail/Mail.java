package src.sarahwissocq.armandbour.yougotmail.models.mail;

import src.sarahwissocq.armandbour.yougotmail.models.Content;
import src.sarahwissocq.armandbour.yougotmail.models.Inhabitant;

/**
 * The Mail interface lists all the methods necessary for a class to act like
 * something sent by mail.
 * 
 * @author Armand BOUR
 * @author Sarah WISSOCQ
 *
 * @param <T> The Content of the mail.
 */
public interface Mail<T extends Content> {
	
	/**
	 * Gets the mailing cost of the item.
	 * @return The mailing cost.
	 */
	public float getCost();
	
	/**
	 * Gets the sender of the mail.
	 * @return The sender of the mail.
	 */
	public Inhabitant getSender();
	
	/**
	 * Gets the receiver of the mail.
	 * @return The receiver of the mail.
	 */
	public Inhabitant getReceiver();
	
	/**
	 * Gets the content of the mail.
	 * @return The content of the mail.
	 */
	public T getContent();
	
	/**
	 * Executes a certain action to be done upon receiving the mail.
	 */
	public void action();
}
