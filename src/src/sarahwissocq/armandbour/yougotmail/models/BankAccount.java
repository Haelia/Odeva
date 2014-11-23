package src.sarahwissocq.armandbour.yougotmail.models;

import src.sarahwissocq.armandbour.yougotmail.ui.UIListener;


/**
 * The BankAccount class represent the bank account of an inhabitant.
 * 
 * @author Armand BOUR
 * @author Sarah WISSOCQ
 */
public class BankAccount {

	/** The current balance of the bank account */
	private float amount;

	/** The owner of the account. */
	private final Inhabitant owner;
	
	public BankAccount(float f, Inhabitant owner) {
		this.amount = f;
		this.owner = owner;
	}

	/**
	 * Adds the amount f to the bank account.
	 * @param f The amount
	 */
	public void credit(float f) {
		if(f > 0) {
			this.amount = this.amount + f;
			
			UIListener listener = this.owner.getCity().getListener();
			if(listener != null)
				listener.onCreditingBankAccount(this.owner, this, f);
		}
	}

	/**
	 * Removes the amount f from the bank account.
	 * @param f The amount
	 */
	public void withdraw(float f) {
		if(f > 0) {
			this.amount = this.amount - f;
			
			UIListener listener = this.owner.getCity().getListener();
			if(listener != null)
				listener.onDebitingBankAccount(this.owner, this, f);
		}
	}

	/**
	 * Returns the amount.
	 * @return the amount.
	 */
	public float getAmount() {
		return this.amount;
	}
	
	/**
	 * Gets the owner of the account.
	 * @return The owner of the account.
	 */
	public Inhabitant getOwner() {
		return owner;
	}
}
