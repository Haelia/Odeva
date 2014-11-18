package src.sarahwissocq.armandbour.yougotmail.models;

/**
 * @author Armand BOUR
 * @author Sarah WISSOCQ
 */
public class Money implements Content{

	/** Money that will be send in the letter*/
	private float amount;
	
	public Money(float f){
		this.setAmount(f);
	}

	/**
	 * Return the amount.
	 * @return the amount.
	 */
	public float getAmount() {
		return amount;
	}

	/**
	 * Set the amount.
	 * @param amount the new amount.
	 */
	public void setAmount(float amount) {
		this.amount = amount;
	}
	
	
}
