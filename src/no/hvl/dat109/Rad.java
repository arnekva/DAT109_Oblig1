package no.hvl.dat109;

/**
 * @author arnekvaleberg
 *
 */
public class Rad {
	public Runde[] rad;
	private Runde runde1 = new Runde(1, "Du skal trille etter løver");
	private Runde runde2= new Runde(2, "Du skal trille etter slanger");
	private Runde runde3 = new Runde(3, "Du skal trille etter Pandaer");
	private Runde runde4 = new Runde(4, "Du skal trille etter Griser");
	private Runde runde5 = new Runde(5, "Du skal trille etter Elefanter");
	private Runde runde6 = new Runde(6, "Du skal trille etter Hvaler");
	private Runde runde7 = new Runde(7, "Du skal få 3 like");
	private Runde runde8 = new Runde(8, "Du skal få 4 like");
	private Runde runde9 = new Runde(9, "Du skal få 2 par");
	private Runde runde10 = new Runde(10, "Du skal få hus (2 + 3)");
	private Runde runde11 = new Runde(11, "Du skal få alle ulike");
	private Runde runde12 = new Runde(12, "Du skal få alle like");
	
	/**
	 * Konstruktør
	 */
	public Rad() {
		rad = new Runde[12];
		rad[0] = runde1;
		rad[1] = runde2;
		rad[2] = runde3;
		rad[3] = runde4;
		rad[4] = runde5;
		rad[5] = runde6;
		rad[6] = runde7;
		rad[7] = runde8;
		rad[8] = runde9;
		rad[9] = runde10;
		rad[10] = runde11;
		rad[11] = runde12;
	
		
	}
	
//	public rundeSjekk() {
//		
//	}

}
