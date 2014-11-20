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
public interface NoticeUI {

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
	 * @param amount The debited amount.
	 * @param account The account being debited.
	 */
	void onDebitingBankAccount(int amount, BankAccount account);
	
	/**
	 * Method called when a {@link BankAccount} is being credited a certain amount.
	 * @param amount The credited amount.
	 * @param account The account being credited.
	 */
	void onCreditingBankAccount(int amount, BankAccount account);
}
