package src.sarahwissocq.armandbour.yougotmail.models;

import java.util.ArrayList;
import java.util.List;

import src.sarahwissocq.armandbour.yougotmail.models.mail.Mail;

/**
 * The City class represents a city containing several {@link Inhabitant}s, and managing
 * mails between them.
 * @author Armand BOUR
 * @author Sarah WISSOCQ
 *
 */
public class City {

	/** The name of the city. */
	private final String name;
	
	/** The list of inhabitants living in the city. */
	private final List<Inhabitant> inhabitants;
	
	/** The mailbox containing all mail ready to be sent at the next call of .*/
	private final List<Mail<?>> mailbox;
	
	public City(String name) {
		this.name = name;
		this.inhabitants = new ArrayList<Inhabitant>();
		this.mailbox = new ArrayList<Mail<?>>();
	}
	
	/**
	 * Adds some {@link Mail} to the mailbox of the city.
	 * @param mail The mail to add.
	 */
	public void post(Mail<?> mail) {
		this.mailbox.add(mail);
	}
	
	/**
	 * Sends all the mail contained in the mailbox to all receivers.
	 */
	public void distributeMail() {
		// Empty mailbox into postman's bag
		List<Mail<?>> postmanBag = new ArrayList<Mail<?>>(this.mailbox);
		this.mailbox.removeAll(null);
		
		// Post all letters to each inhabitants
		for(Mail<?> m : postmanBag) {
			m.getReceiver().receiveMail(m);
		}
	}
	
	/**
	 * Adds a inhabitant to the city.
	 * @param inhabitant The inhabitant to add.
	 */
	public void addInhabitant(Inhabitant inhabitant) {
		if(!this.inhabitants.contains(inhabitant))
			this.inhabitants.add(inhabitant);
	}
	
	/**
	 * Removes a inhabitant from the city. 
	 * @param inhabitant The inhabitant to remove.
	 * @return <code>true</code> if the inhabitant was successfully removed ; <br>
	 * 			<code>false</code> if it does not exist in the city.
	 */
	public boolean removeInhabitant(Inhabitant inhabitant) {
		return this.inhabitants.remove(inhabitant);
	}
	
	/**
	 * Gets a list containing all the inhabitants.
	 * @return A new list containing all the inhabitants.
	 */
	public List<Inhabitant> getAllInhabitants() {
		return new ArrayList<Inhabitant>(this.inhabitants);
	}
	
	public Inhabitant getInhabitant(int index) {
		return this.inhabitants.get(index);
	}
	
	/**
	 * Gets the name of the city.
	 * @return The name of the city.
	 */
	public String getName() {
		return name;
	}
}
