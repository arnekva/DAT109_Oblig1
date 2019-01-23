/**
 * 
 */
package no.hvl.dat109;

import java.util.Random;

/**
 * @author arnekvaleberg
 *
 */
public class Terning {
	Random random = new Random();
	public Dyr[] terning;

	private Dyr love = new Dyr("Løve", "oransj", 1);
	private Dyr slange = new Dyr("Slange", "grønn", 2);
	private Dyr panda = new Dyr("Panda", "svart", 3);
	private Dyr gris = new Dyr("Gris", "rosa", 4);
	private Dyr elefant = new Dyr("elefant", "grå", 5);
	private Dyr hval = new Dyr("Hval", "blå", 6);

	/**
	 * Konstruktør: Oppretter et terningobjekt
	 */
	public Terning() {

		terning = new Dyr[6];
		terning[0] = love;
		terning[1] = slange;
		terning[2] = panda;
		terning[3] = gris;
		terning[4] = elefant;
		terning[5] = hval;
	}

	/**
	 * Triller terningen og returnerer et dyr-objekt
	 * @return
	 */
	public Dyr trillTerning() {

		int resultat = random.nextInt(6);

		return terning[resultat];
	}
}
