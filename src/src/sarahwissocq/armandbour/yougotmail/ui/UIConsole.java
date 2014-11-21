package src.sarahwissocq.armandbour.yougotmail.ui;

import java.io.PrintWriter;

import src.sarahwissocq.armandbour.yougotmail.models.BankAccount;
import src.sarahwissocq.armandbour.yougotmail.models.Inhabitant;
import src.sarahwissocq.armandbour.yougotmail.models.mail.Mail;

public class UIConsole implements UIListener {

	private PrintWriter printer;
	
	public UIConsole(PrintWriter printer) {
		this.printer = printer;
	}
	
	protected String formatPrice(float amount, boolean credit) {
		String action = credit
				      ? "credited"
				      : "debited";
		
		// Return a string under the format "2 euros are debited"
		return ( amount == 1
			 ? "euro is "
			 : "euros are ")
			 + action;
	}
	
	@Override
	public void onPostingMail(Mail<?> mail) {
		this.printer.printf("-> %s posts %s to %s for a cost of %4.2f euro.%n",
				mail.getSender(), mail, mail.getReceiver(), mail.getCost());
	}

	@Override
	public void onReceivingMail(Mail<?> mail) {
		this.printer.printf("<- %s receives %s from %s.%n",
				mail.getSender(), mail, mail.getReceiver());
	}

	@Override
	public void onDebitingBankAccount(Inhabitant owner, BankAccount account,
			float amount) {
		this.printer.printf("\t- %4.2f %s from %s's account whose balance is now %4.2f euros.%n",
				amount, formatPrice(amount, false), owner, account.getAmount());
	}

	@Override
	public void onCreditingBankAccount(Inhabitant owner, BankAccount account,
			float amount) {
		this.printer.printf("\t+ %4.2f %s from %s's account whose balance is now %4.2f euros.%n",
				amount, formatPrice(amount, true), owner, account.getAmount());
	}

}
