package src.sarahwissocq.armandbour.yougotmail.ui;

import src.sarahwissocq.armandbour.yougotmail.models.BankAccount;
import src.sarahwissocq.armandbour.yougotmail.models.Inhabitant;
import src.sarahwissocq.armandbour.yougotmail.models.mail.Mail;

/**
 * NoticeUI defines an interface to delegate the UI displays of information about the execution.
 * @author Armand BOUR
 * @author Sarah WISSOCQ
 *
 */
public interface UIListener {

	/**
	 * Method called when an {@link Inhabitant} posts a piece of {@link Mail}.
	 * @param mail The posted piece of mail.
	 */
	void onPostingMail(Mail<?> mail);
	
	/**
	 * Method called when an {@link Inhabitant} receives a piece of {@link Mail}.
	 * @param mail The received piece of mail.
	 */
	void onReceivingMail(Mail<?> mail);
	
	/**
	 * Method called when a {@link BankAccount} is being debited a certain amount.
	 * @param owner The owner of the account.
	 * @param account The account being debited.
	 * @param amount The debited amount.
	 */
	void onDebitingBankAccount(Inhabitant owner, BankAccount account, float amount);
	
	/**
	 * Method called when a {@link BankAccount} is being credited a certain amount.
	 * @param owner The owner of the account.
	 * @param amount The credited amount.
	 * @param account The account being credited.
	 */
	void onCreditingBankAccount(Inhabitant owner, BankAccount account, float amount);
}
