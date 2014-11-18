package test.sarahwissocq.armandbour.yougotmail.models.mail;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import src.sarahwissocq.armandbour.yougotmail.models.City;
import src.sarahwissocq.armandbour.yougotmail.models.Inhabitant;
import src.sarahwissocq.armandbour.yougotmail.models.mail.Content;
import src.sarahwissocq.armandbour.yougotmail.models.mail.Letter;


public abstract class LetterTest<T extends Content> {

	private Letter<T> l;
	private Inhabitant in;
	private Inhabitant ina;

	protected abstract Letter<T> createLetter(Inhabitant i,Inhabitant in);
	
	@Before
	public void init(){
	City c = new City("TestCity");
	in= new Inhabitant("test",c);
	ina= new Inhabitant("test2",c);
	l = createLetter(in,ina);
	}
	
	@Test
	public void testLetter(){
		assertNotNull(l);
	}
	
	@Test
	public void getSenderTest(){
		assertEquals(l.getSender(),in);
	}
	
	@Test
	public void getReceiverTest(){
		assertEquals(l.getSender(),ina);
	}	
}
