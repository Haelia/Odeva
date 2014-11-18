package src.sarahwissocq.armandbour.yougotmail.models;

import src.sarahwissocq.armandbour.yougotmail.models.mail.Mail;

/**
 * Represent the inhabitant in the city.
 * @author Armand BOUR
 * @author Sarah WISSOCQ
 */
public class Inhabitant {

	/** The name of the inhabitant. */
	private String name;
	
	/** The city where the inhabitant lives. */
	private City city;
	
	/** The bank account of the inhabitant */
	private BankAccount bankAccount;
	
	/**
	 * Constructor for the class Inhabitant.
	 * @param name The name of the inhabitant.
	 * @param city The city of the inhabitant.
	 * @param bankAccount The bank account of the inhabitant.
	 */
	public Inhabitant(String name, City city){
		this.name = name;
		this.city = city;
		this.bankAccount = new BankAccount(0);
	}
	
	/**
	 * The inhabitant receives his specified letter.
	 * Activates the action of the specified letter.
	 * @param l letter the inhabitant received
	 */
	public void receiveMail(Mail<?> l){
		l.action();
	}
	
	/**
	 * The inhabitant posts his letter and pays the cost of a letter.
	 * @param l the letter that the inhabitant wants to post.
	 */
	public void postMail(Mail<?> l){
		this.bankAccount.withdraw(l.getCost());
		this.city.post(l);
	}
	
	/**
	 * Returns the name of the inhabitant.
	 * @return the name of the inhabitant.
	 */
	public String getName(){
		return this.name;
	}
	/**
	 * Gets the inhabitant's bank account.
	 * @return The inhabitant's bank account.
	 */
	public BankAccount getBankAccount() {
		return bankAccount;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Inhabitant other = (Inhabitant) obj;
		if (bankAccount == null) {
			if (other.bankAccount != null)
				return false;
		} else if (!bankAccount.equals(other.bankAccount))
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
}
