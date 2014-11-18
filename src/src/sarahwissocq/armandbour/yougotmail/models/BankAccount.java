package src.sarahwissocq.armandbour.yougotmail.models;

/**
 * The BankAccount class represent the bank account of an inhabitant.
 * 
 * @author Armand BOUR
 * @author Sarah WISSOCQ
 */
public class BankAccount {

	/** The current balance of the bank account */
	private float amount;

	public BankAccount(float f) {
		this.amount = f;
	}

	/**
	 * Adds the amount f to the bank account.
	 * 
	 * @param f The amount
	 */
	public void credit(float f) {
		this.amount = this.amount + f;
	}

	/**
	 * Removes the amount f from the bank account.
	 * 
	 * @param f The amount
	 */
	public void withdraw(float f) {
		this.amount = this.amount - f;
	}

	/**
	 * Returns the amount.
	 * 
	 * @return the amount.
	 */
	public float getAmount() {
		return this.amount;
	}
}
