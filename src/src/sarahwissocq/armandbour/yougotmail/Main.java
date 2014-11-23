package src.sarahwissocq.armandbour.yougotmail;

import java.io.PrintWriter;
import java.util.Random;

import src.sarahwissocq.armandbour.yougotmail.models.City;
import src.sarahwissocq.armandbour.yougotmail.models.Inhabitant;
import src.sarahwissocq.armandbour.yougotmail.models.mail.Letter;
import src.sarahwissocq.armandbour.yougotmail.models.mail.Mail;
import src.sarahwissocq.armandbour.yougotmail.models.mail.Money;
import src.sarahwissocq.armandbour.yougotmail.models.mail.PromissoryNote;
import src.sarahwissocq.armandbour.yougotmail.models.mail.RegisteredLetter;
import src.sarahwissocq.armandbour.yougotmail.models.mail.SimpleLetter;
import src.sarahwissocq.armandbour.yougotmail.models.mail.Text;
import src.sarahwissocq.armandbour.yougotmail.models.mail.UrgentLetter;
import src.sarahwissocq.armandbour.yougotmail.ui.UIConsole;

public class Main {

	private static Random random;
	private static PrintWriter printer;
	
	static {
		random = new Random();
		printer = new PrintWriter(System.out);
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
			value = String.valueOf(i);
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
	
	public static Letter<?> generateRandomLetter(Inhabitant sender, Inhabitant receiver) {
		Letter<?> mail = null;
		switch(random.nextInt(8)) {
			case 0: case 1: case 2:
				mail = new SimpleLetter(sender, receiver, new Text("blah blah blah mr. freeman"));
				break;
			case 3: case 4: case 5:
				mail = new PromissoryNote(sender, receiver, new Money(random.nextFloat() * 50));
				break;
			case 6:
				mail = new RegisteredLetter(generateRandomLetter(sender, receiver));
				break;
			case 7:
				mail = new UrgentLetter(generateRandomLetter(sender, receiver));
				break;
		}
		return mail;
	}

	public static void simulateOneDay(int day, City city) {
		printer.printf("************************ Day %d ************************\n", day);
		
		// Distribute and receive mail
		city.distributeMail();
		
		// Send a random number of letters
		final int numberOfMails = random.nextInt(10) + 1; // at least one letter a day, and max 10
		for(int i = 0; i < numberOfMails; i++) {
			// Generate a random type of mail, and random sender and receiver
			Mail<?> mail = null;
			Inhabitant sender = getRandomInhabitant(city),
					   receiver = getRandomInhabitant(city);
			
			mail = generateRandomLetter(sender, receiver);
			
			// Send the letter
			sender.postMail(mail);
		}
		
		printer.println("*******************************************************");
		printer.println();
		printer.flush();
	}

	public static void main(String [] args) {
		try {
			int nbDays = 6;
			if(args.length > 0) {
				try {
					nbDays = Integer.parseInt(args[0]);
				}
				catch(NumberFormatException nfExc) {
					new PrintWriter(System.err)
						.printf("Invalid integer passed as argument, using default value (%d) as number of days...",
								nbDays);
				}
			}
			
			// Create city and add inhabitants
			City city = new City("ChocoLicorneCity", new UIConsole(printer));
			printer.println("Creating " + city.getName());
			city.addInhabitant(createInhabitants(100, city));
			printer.println("Creating 100 inhabitants\n");
			
			// Launch simulation for nbDays days
			for (int i = 1; i <= nbDays; i++) {
				simulateOneDay(i, city);
			}
		}
		finally {
			// Flush and close the printer
			printer.close();
		}
	}
}
