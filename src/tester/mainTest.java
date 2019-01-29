/**
 * 
 */
package tester;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import no.hvl.dat109.Blokk;
import no.hvl.dat109.Dyr;
import no.hvl.dat109.Spiller;
import no.hvl.dat109.Terning;

/**
 * @author arnekvaleberg
 *
 */
public class mainTest {
	Spiller spiller1 = new Spiller("Are");
	Spiller spiller2 = new Spiller("Chris-Even");
	Spiller[] spillerliste = new Spiller[2];
	int test = 0;

	ArrayList<Dyr> terninger = new ArrayList<Dyr>();
	Terning terning = new Terning();
	Blokk blokk;
	

	Dyr love = new Dyr("Løve", "oransj", 1);
	Dyr slange = new Dyr("Slange", "grønn", 2);
	Dyr panda = new Dyr("Panda", "svart", 3);
	Dyr gris = new Dyr("Gris", "rosa", 4);
	Dyr elefant = new Dyr("elefant", "grå", 5);
	Dyr hval = new Dyr("Hval", "blå", 6);

	final int runde6 = 6;
	final int runde7 = 7;
	final int runde8 = 8;
	final int runde9 = 9;
	final int runde10 = 10;
	final int runde11 = 11;
	final int runde12 = 12;
	
	@Before
	public void setupInit() {
		spillerliste[0] = spiller1;
		spillerliste[1] = spiller2;
		blokk = new Blokk(spillerliste);
	}
	
	/**
	 * Tester at terningen triller og returnerer et dyr
	 */
	@Test
	public void terningTest() {
		Dyr dyr = terning.trillTerning();
		Assert.assertNotNull(dyr);

	}
    
	/**
	 * Skal teste om logikken i rundesjekken vår fungerer som den skal.
	 */
	@Test
	public void rundeTest() {
	Dyr dyr1 =  love;
	Dyr dyr2 = slange;
	Dyr dyr3 = panda;
	Dyr dyr4 = hval;
	Dyr dyr5 = hval;
	
	terninger.add(dyr1);
	terninger.add(dyr2);
	terninger.add(dyr3);
	terninger.add(dyr4);
	terninger.add(dyr5);
	int sjekk = blokk.getRad().rundeSjekk(runde6, terninger, spiller1);
	

	}

	
	/**
	 * Sjekker at hashMap for dyr fungerer ordentlig
	 */
	@Test
	public void mapTest() {
		
	}
	
	/**
	 * Sjekker at summer regner sammen poengene korrekt slik at den faktiske vinneren kåres
	 */
	@Test
	public void summerPoengTest() {
		
	}
	
	
	

}
