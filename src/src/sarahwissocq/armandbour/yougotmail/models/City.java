package src.sarahwissocq.armandbour.yougotmail.models;

import java.util.ArrayList;
import java.util.List;

import src.sarahwissocq.armandbour.yougotmail.models.mail.Mail;
import src.sarahwissocq.armandbour.yougotmail.ui.UIListener;

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
	
	private final UIListener listener;
	
	public City(String name) {
		this(name, null);
	}
	
	public City(String name, UIListener listener) {
		this.name = name;
		this.inhabitants = new ArrayList<Inhabitant>();
		this.mailbox = new ArrayList<Mail<?>>();
		this.listener = listener;
	}
	
	/**
	 * Adds some {@link Mail} to the mailbox of the city.
	 * @param mail The mail to add.
	 */
	protected void post(Mail<?> mail) {
		this.mailbox.add(mail);
	}
	
	/**
	 * Sends all the mail contained in the mailbox to all receivers.
	 */
	public void distributeMail() {
		// Empty mailbox into postman's bag
		List<Mail<?>> postmanBag = new ArrayList<Mail<?>>(this.mailbox);
		this.mailbox.clear();
		
		// Post all letters to each inhabitants
		for(Mail<?> m : postmanBag) {
			m.getReceiver().receiveMail(m);
		}
	}
	
	/**
	 * Adds inhabitants to the city.
	 * @param inhabitants The inhabitants to add.
	 */
	public void addInhabitant(Inhabitant ... inhabitants) {
		for(Inhabitant inh : inhabitants) {
			if(!this.inhabitants.contains(inh))
				this.inhabitants.add(inh);
		}
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
	
	/**
	 * Gets the inhabitant at the specified index.
	 * @param index The index used to get the inhabitant in the list.
	 * @return The inhabitant at the specified index.
	 */
	public Inhabitant getInhabitant(int index) {
		return this.inhabitants.get(index);
	}
	
	/**
	 * Gets the letter at the specified index.
	 * @param index The index of the letter to get.
	 * @return The letter at the specified index.
	 */
	public Mail<?> getMail(int index) {
		return this.mailbox.get(index);
	}
	
	/**
	 * Gets the number of letters contained in the public mailbox.
	 * @return The number of letters.
	 */
	public int getNumberOfLettersInMailbox() {
		return this.mailbox.size();
	}
	
	/**
	 * Gets the number of inhabitants in the city.
	 * @return The number of inhabitants in the city
	 */
	public int getNumberOfInhabitants() {
		return this.inhabitants.size();
	}
	
	/**
	 * Gets the name of the city.
	 * @return The name of the city.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Gets the event listener associated with the City.
	 * @return The event listener associated.
	 */
	public UIListener getListener() {
		return listener;
	}
}
