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
	private String name;
	
	/** The list of inhabitants living in the city. */
	private final List<Inhabitant> inhabitants;
	
	/** The mailbox containing all mail ready to be sent at the next call of .*/
	private final List<Mail<?>> mailbox;
	
	public City(String name) {
		this.name = name;
		this.inhabitants = new ArrayList<Inhabitant>();
		this.mailbox = new ArrayList<Mail<?>>();
	}
}
