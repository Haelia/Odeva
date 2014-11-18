package src.sarahwissocq.armandbour.yougotmail.models;

import src.sarahwissocq.armandbour.yougotmail.models.mail.Mail;

/**
 * Represent the inhabitant in the city.
 * @author Armand BOUR
 * @author Sarah WISSOCQ
 */
public class Inhabitant {

	/* The name of the inhabitant */
	private String name;
	
	/* The city where the inhabitant leaves */
	private City city;
	
	/* the bank account of the inhabitant */
	private BankAccount bankAccount;
	
	/**
	 * Constructor for the class Inhabitant.
	 * @param name the name of the inhabitant.
	 * @param city the city of the inhabitant.
	 * @param bankAccount the bank account of the inhabitant.
	 */
	public Inhabitant(String name, City city){
		this.name=name;
		this.city=city;
		this.bankAccount=new BankAccount(0);
	}
	
	/**
	 * The inhabitant receive his letter l.
	 * Activate the action of the letter l.
	 * @param l letter the inhabitant received
	 */
	public void receiveLetter(Mail<Content> l){
		l.action();
	}
	
	/**
	 * The inhabitant post his letter and pay the cost of a letter.
	 * @param l the letter that the inhabitant want to post.
	 */
	public void postLetter(Mail<Content> l){
		this.bankAccount.withdraw(l.getCost());
		this.city.sendLetter(l);
	}
	
	/**
	 * Return the name of the inhabitant.
	 * @return the name of the inhabitant.
	 */
	public String getName(){
		return this.name;
	}
}
