/**
 * 
 */
package tester;

import java.util.ArrayList;
import java.util.Random;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import no.hvl.dat109.Blokk;
import no.hvl.dat109.Dyr;
import no.hvl.dat109.Kolonne;
import no.hvl.dat109.Spiller;
import no.hvl.dat109.Terning;
import no.hvl.dat109.Yatzoo;

/**
 * @author arnekvaleberg
 *
 */
public class mainTest {
	Random rand = new Random();
	ArrayList<Dyr> terninger = new ArrayList<Dyr>();
	Spiller spiller1 = new Spiller("Knut-Arild");
	Spiller spiller2 = new Spiller("Erna");
	Spiller[] spillere = new Spiller[2];
	Kolonne kolonne = new Kolonne(1);
	Blokk blokk;
	Yatzoo yatzoo = new Yatzoo();
	Terning terning = new Terning();
	Dyr love = new Dyr("løve", "Oransje", 1);
	Dyr slange = new Dyr("slange", "Grønn", 2);
	Dyr panda = new Dyr("panda", "Svart", 3);
	Dyr gris = new Dyr("gris", "Rosa", 4);
	Dyr elefant = new Dyr("elefant", "Grå", 5);
	Dyr hval = new Dyr("hval", "Blå", 6);
	final int runde6 = 6;
	final int runde7 = 7;
	final int runde8 = 8;
	final int runde9 = 9;
	final int runde10 = 10;
	final int runde11 = 11;
	final int runde12 = 12;
	
	@Before
	public void setup() {
		spillere[0] = spiller1;
		spillere[1] = spiller2;
		blokk = new Blokk(spillere);
	}
	
	/**
	 * Denne metoden teste om sjekkene for hver runde er korrekte.
	 */
	@Test
	public void rundeTest() {
		//Runde 1-6 kan sjekkes i én sjekk, da de stiller samme krav.
		Dyr dyr1 = hval;
		Dyr dyr2 = hval;
		Dyr dyr3 = hval;
		Dyr dyr4 = hval;
		Dyr dyr5 = hval;
		terninger.add(dyr1);
		terninger.add(dyr2);
		terninger.add(dyr3);
		terninger.add(dyr4);
		terninger.add(dyr5);
		int sjekk = blokk.getRad().rundeSjekk(runde6, terninger, spiller1);
		int sjekk1 = blokk.getRad().rundeSjekk(runde6, terninger, spiller2);
		Assert.assertEquals(5, sjekk);
		terninger = new ArrayList<Dyr>();
		
		//Sjekker runde 7. 3 like
		dyr1 = love;
		dyr2 = hval;
		dyr3 = gris;
		dyr4 = hval;
		dyr5 = hval;
		terninger.add(dyr1);
		terninger.add(dyr2);
		terninger.add(dyr3);
		terninger.add(dyr4);
		terninger.add(dyr5);
		sjekk = blokk.getRad().rundeSjekk(runde7, terninger, spiller1);
		Assert.assertEquals(3, sjekk);
		terninger = new ArrayList<Dyr>();
	
		//runde 7 null rette
		dyr1 = love;
		dyr2 = slange;
		dyr3 = gris;
		dyr4 = hval;
		dyr5 = hval;
		terninger.add(dyr1);
		terninger.add(dyr2);
		terninger.add(dyr3);
		terninger.add(dyr4);
		terninger.add(dyr5);
		sjekk = blokk.getRad().rundeSjekk(runde7, terninger, spiller2);
		Assert.assertEquals(0, sjekk);
		terninger = new ArrayList<Dyr>();
				
		//Sjekker runde 8. 4 like
		dyr1 = gris;
		dyr2 = gris;
		dyr3 = hval;
		dyr4 = gris;
		dyr5 = gris;
		terninger.add(dyr1);
		terninger.add(dyr2);
		terninger.add(dyr3);
		terninger.add(dyr4);
		terninger.add(dyr5);
		sjekk = blokk.getRad().rundeSjekk(runde8, terninger, spiller1);
		Assert.assertEquals(4, sjekk);
		terninger = new ArrayList<Dyr>();
			
		//runde 8 ingen rette
		dyr1 = love;
		dyr2 = slange;
		dyr3 = gris;
		dyr4 = hval;
		dyr5 = hval;
		terninger.add(dyr1);
		terninger.add(dyr2);
		terninger.add(dyr3);
		terninger.add(dyr4);
		terninger.add(dyr5);
		sjekk = blokk.getRad().rundeSjekk(runde8, terninger, spiller2);
		Assert.assertEquals(0, sjekk);
		terninger = new ArrayList<Dyr>();
				
		//Sjekker runde 9. 2 par
		dyr1 = slange;
		dyr2 = slange;
		dyr3 = gris;
		dyr4 = hval;
		dyr5 = hval;
		terninger.add(dyr1);
		terninger.add(dyr2);
		terninger.add(dyr3);
		terninger.add(dyr4);
		terninger.add(dyr5);
		sjekk = blokk.getRad().rundeSjekk(runde9, terninger, spiller1);
		Assert.assertEquals(4, sjekk);
		terninger = new ArrayList<Dyr>();
			
		//runde 9 bare ett par
		dyr1 = love;
		dyr2 = slange;
		dyr3 = gris;
		dyr4 = hval;
		dyr5 = hval;
		terninger.add(dyr1);
		terninger.add(dyr2);
		terninger.add(dyr3);
		terninger.add(dyr4);
		terninger.add(dyr5);
		sjekk = blokk.getRad().rundeSjekk(runde9, terninger, spiller2);
		Assert.assertEquals(0, sjekk);
		terninger = new ArrayList<Dyr>();
				
		//Sjekker runde 10. Fullt hus
		dyr1 = love;
		dyr2 = love;
		dyr3 = love;
		dyr4 = hval;
		dyr5 = hval;
		terninger.add(dyr1);
		terninger.add(dyr2);
		terninger.add(dyr3);
		terninger.add(dyr4);
		terninger.add(dyr5);
		sjekk = blokk.getRad().rundeSjekk(runde10, terninger, spiller1);
		Assert.assertEquals(5, sjekk);
		terninger = new ArrayList<Dyr>();
			
		//runde 10 ingen hus
		dyr1 = love;
		dyr2 = slange;
		dyr3 = gris;
		dyr4 = hval;
		dyr5 = hval;
		terninger.add(dyr1);
		terninger.add(dyr2);
		terninger.add(dyr3);
		terninger.add(dyr4);
		terninger.add(dyr5);
		sjekk = blokk.getRad().rundeSjekk(runde10, terninger, spiller2);
		Assert.assertEquals(0, sjekk);
		terninger = new ArrayList<Dyr>();
				
		//Sjekker runde 11. Alle ulike
		dyr1 = love;
		dyr2 = slange;
		dyr3 = gris;
		dyr4 = elefant;
		dyr5 = hval;
		terninger.add(dyr1);
		terninger.add(dyr2);
		terninger.add(dyr3);
		terninger.add(dyr4);
		terninger.add(dyr5);
		sjekk = blokk.getRad().rundeSjekk(runde11, terninger, spiller1);
		Assert.assertEquals(5, sjekk);
		terninger = new ArrayList<Dyr>();
			
		//RUnde 11 flere like
		dyr1 = love;
		dyr2 = slange;
		dyr3 = gris;
		dyr4 = hval;
		dyr5 = hval;
		terninger.add(dyr1);
		terninger.add(dyr2);
		terninger.add(dyr3);
		terninger.add(dyr4);
		terninger.add(dyr5);
		sjekk = blokk.getRad().rundeSjekk(runde11, terninger, spiller2);
		Assert.assertEquals(0, sjekk);
		terninger = new ArrayList<Dyr>();
				
		//Sjekker runde 12. Alle like
		dyr1 = slange;
		dyr2 = slange;
		dyr3 = slange;
		dyr4 = slange;
		dyr5 = slange;
		terninger.add(dyr1);
		terninger.add(dyr2);
		terninger.add(dyr3);
		terninger.add(dyr4);
		terninger.add(dyr5);
		sjekk = blokk.getRad().rundeSjekk(runde12, terninger, spiller1);
		Assert.assertEquals(10, sjekk);
		terninger = new ArrayList<Dyr>();
				
		//Sjekker runde 12. En ulik
				dyr1 = slange;
				dyr2 = slange;
				dyr3 = slange;
				dyr4 = love;
				dyr5 = slange;
				terninger.add(dyr1);
				terninger.add(dyr2);
				terninger.add(dyr3);
				terninger.add(dyr4);
				terninger.add(dyr5);
				sjekk = blokk.getRad().rundeSjekk(runde12, terninger, spiller2);
				Assert.assertEquals(0, sjekk);
				terninger = new ArrayList<Dyr>();
				
	}
	
	/**
	 * Tester om trillTerning() returnerer et dyr.
	 */
	@Test
	public void terningTest() {
		Dyr dyr = terning.trillTerning();
		Assert.assertNotNull(dyr);
	}
	
	/**
	 * Tester om mapAntall() gir en korrekt mapping av dyr og forekomsten av det dyret.
	 */
	@Test
	public void mapTest() {
		
	}
	
	/**
	 * Tester om summerpoeng() angir riktig poengsum til spilleren.
	 */
	@Test
	public void summerPoengTest() {
		int maxScore = 61;
		spiller1.setKolonne(kolonne);

		for(int i = 1; i<13;i++) {
			if(i < 7 || i == 10 || i == 11) {
				spiller1.getKolonne().oppdaterVerdi(i, 5);
			} else if(i == 7) {
				spiller1.getKolonne().oppdaterVerdi(i, 3);
			} else if(i == 8 || i == 9) {
				spiller1.getKolonne().oppdaterVerdi(i, 4);
			} else {
				spiller1.getKolonne().oppdaterVerdi(i, 10);
			}
			
		}
		int sum = 0;
		for (int i : spiller1.getKolonne().getKolonne()) {
			sum += i;
		}
		spiller1.setPoengscore(sum);
		
		Assert.assertEquals(maxScore, spiller1.getPoengscore());
		System.out.println("\n\n" +spiller1.getNavn() + " har scoret full pott! Han fikk " + spiller1.getPoengscore() + "/"+ blokk.getRad().getMaxSum() + " poeng!");
		
	}

}
