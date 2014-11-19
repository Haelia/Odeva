package src.sarahwissocq.armandbour.yougotmail.models.mail;

import src.sarahwissocq.armandbour.yougotmail.models.Inhabitant;

/**
 * Represent the acknowledgment of receipt. It is used when 
 * an inhabitant post a registered letter.
 * @author Armand BOUR
 * @author Sarah WISSOCQ
 */
public class AcknowledgmentOfReceipt extends Letter<Text>{

	public AcknowledgmentOfReceipt(Inhabitant sender, Inhabitant receiver) {
		super(sender, receiver, new Text("Letter received"));
	}
	
	@Override
	public float getCost() {
		return 0;
	}

	@Override
	public void action() {
		this.content.get();		
	}

}
