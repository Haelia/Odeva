package src.sarahwissocq.armandbour.yougotmail.models.mail;

import src.sarahwissocq.armandbour.yougotmail.models.Inhabitant;
import src.sarahwissocq.armandbour.yougotmail.models.Money;
import src.sarahwissocq.armandbour.yougotmail.models.Text;

/**
 * When the sender send a promissory note, he send an amount that is withdraw
 * of his bank account, he have to pay 1+1% of the amount he want to give.
 * Then the receiver send a simple letter to thanks the sender.
 * @author Armand BOUR
 * @author Sarah WISSOCQ
 */
public class PromissoryNote extends Letter<Money> {

	public PromissoryNote(Inhabitant sender, Inhabitant receiver, Money content) {
		super(sender, receiver, content);
	}

	@Override
	public float getCost() {
		return 1 + (this.content.getAmount() / 100);
	}

	@Override
	public void action() {
		this.sender.getBankAccount().withdraw(this.getContent().getAmount());
		this.receiver.getBankAccount().credit(this.getContent().getAmount());
		Text msg = new Text("Thank You !");
		SimpleLetter l = new SimpleLetter(this.receiver, this.sender, msg);
		this.receiver.postMail(l);
	}

}
