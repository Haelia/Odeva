package src.sarahwissocq.armandbour.yougotmail.models.mail;

/**
 * Content represents the content of a letter. When a class implements this interface,
 * it can be used as a content of a letter.
 * @author Armand BOUR
 * @author Sarah WISSOCQ
 *
 * @param <T> The type of the object contained in Content.
 */
public interface Content {

	/**
	 * Gets the object contained in the class.
	 * @return The object contained.
	 */
	public Object get();
	
}
