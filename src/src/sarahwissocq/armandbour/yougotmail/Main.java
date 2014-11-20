package src.sarahwissocq.armandbour.yougotmail;

import java.io.PrintWriter;
import java.util.Random;

import src.sarahwissocq.armandbour.yougotmail.models.City;
import src.sarahwissocq.armandbour.yougotmail.models.Inhabitant;
import src.sarahwissocq.armandbour.yougotmail.models.mail.Mail;
import src.sarahwissocq.armandbour.yougotmail.models.mail.Money;
import src.sarahwissocq.armandbour.yougotmail.models.mail.PromissoryNote;
import src.sarahwissocq.armandbour.yougotmail.models.mail.RegisteredLetter;
import src.sarahwissocq.armandbour.yougotmail.models.mail.SimpleLetter;
import src.sarahwissocq.armandbour.yougotmail.models.mail.Text;
import src.sarahwissocq.armandbour.yougotmail.models.mail.UrgentLetter;

public class Main {

	private static Random random;
	
	static {
		random = new Random();
	}
	
	/**
	 * Creates the specified number of inhabitants in an array.
	 * @param number The number of inhabitants to create.
	 * @param city The {@link City} which the inhabitants are from.
	 * @return An array containing the specified number of inhabitants.
	 */
	public static Inhabitant[] createInhabitants(int number, City city) {
		Inhabitant[] inhabitants = new Inhabitant[number];
		String value;
		
		for (int i = 0; i < inhabitants.length; i++) {
			value = String.valueOf(number);
			// Generate a name under the form "Inhabitant-022"
			inhabitants[i] = new Inhabitant("Inhabitant-" +
					("0000" + value).substring(value.length()), city);
		}
		
		return inhabitants;
	}
	
	public static Inhabitant getRandomInhabitant(City city) {
		int nbInhabitants = city.getNumberOfInhabitants();
		return city.getInhabitant(random.nextInt(nbInhabitants));
	}
	
	public static void simulateOneDay(int day, City city) {
		PrintWriter print = new PrintWriter(System.out);
		print.printf("******************** Day %d************************\n", day);
		
		// Send a random number of letters
		final int numberOfMails = random.nextInt(10) + 1; // at least one letter a day, and max 10
		final Text content= new Text("blah blah blah mr. freeman");
		for(int i = 0; i < numberOfMails; i++) {
			// Generate a random type of mail, and random sender and receiver
			Mail<?> mail = null;
			Inhabitant sender = getRandomInhabitant(city),
					   receiver = getRandomInhabitant(city);
			
			switch(random.nextInt(4)) {
				case 0:
					mail = new SimpleLetter(sender, receiver, content);
					break;
				case 1:
					mail = new PromissoryNote(sender, receiver, new Money(random.nextFloat() * 50));
					break;
				case 2:
					mail = new RegisteredLetter(new SimpleLetter(sender, receiver, content));
					break;
				case 3:
					mail = new UrgentLetter(new SimpleLetter(sender, receiver, content));
					break;
			}
			
			// Send the letter
			sender.postMail(mail);
		}
	}
	
	public static void main(String [] args) {
		// Create city and add inhabitants
		City city = new City("ChocoLicorneCity");
		city.addInhabitant(createInhabitants(100, city));
	}
}
