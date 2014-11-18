package src.sarahwissocq.armandbour.yougotmail.models;

/**
 * The BankAccount class represent the bank account of an inhabitant.
 * 
 * @author Armand BOUR
 * @author Sarah WISSOCQ
 */
public class BankAccount {

	/** the amount of the bank account */
	private float amount;

	public BankAccount(float f) {
		this.amount = f;
	}

	/**
	 * Add the amount f on the bank account.
	 * 
	 * @param f
	 *            the amount
	 */
	public void credit(float f) {
		this.amount = this.amount + f;
	}

	/**
	 * Remove the amount f on the bank account.
	 * 
	 * @param f
	 *            the amount
	 */
	public void withdraw(float f) {
		this.amount = this.amount - f;
	}

	/**
	 * Return the amount.
	 * 
	 * @return the amount.
	 */
	public float getAmount() {
		return this.amount;
	}
}
