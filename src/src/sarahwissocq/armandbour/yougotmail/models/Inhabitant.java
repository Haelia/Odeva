package src.sarahwissocq.armandbour.yougotmail.models;

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
	private float bankAccount;
	
	/**
	 * Constructor for the class Inhabitant
	 * @param name the name of the inhabitant
	 * @param city the city of the inhabitant
	 * @param bankAccount the bank account of the inhabitant
	 */
	public Inhabitant(String name, City city, float bankAccount){
		this.name=name;
		this.city=city;
		this.bankAccount=bankAccount;
	}
	
	/**
	 * The inhabitant receive his letter
	 * @return the letter that the inhabitant have received
	 */
	public Mail receiveLetter(Mail l){
		
	}
	
	/**
	 * The inhabitant post his letter and pay the cost of a letter
	 * @param l the letter that the inhabitant want to post
	 */
	public void postLetter(Mail l){
		
	}
}
