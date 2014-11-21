package src.sarahwissocq.armandbour.yougotmail.models.mail;

import src.sarahwissocq.armandbour.yougotmail.models.Inhabitant;

/**
 * @author Armand BOUR
 * @author Sarah WISSOCQ
 */
public class SimpleLetter extends Letter<Text> {

	/** Price of a simple letter */
	public static final float COST = 1;

	public SimpleLetter(Inhabitant sender, Inhabitant receiver, Text content) {
		super(sender, receiver, content);
	}

	@Override
	public float getCost() {
		return SimpleLetter.COST;
	}

	@Override
	public void action() {
		this.content.get();
	}

	@Override
	public String toString() {
		return "a simple letter whose content is " + this.content.toString();
	}
}
