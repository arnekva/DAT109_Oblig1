/**
 * 
 */
package no.hvl.dat109;

/**
 * @author arnekvaleberg
 *
 */
public class Dyr {
	private String navn;
	private String farge;
	private int id;

	/**
	 * Konsturktør for dyrene på terningene
	 * @param navn - Navn på dyret
	 * @param farge - Farge på siden til terningen
	 * @param id - Unik ID for å kunne identifisere resultatet
	 */
	public Dyr(String navn, String farge, int id) {
		
		this.navn = navn;
		this.farge = farge;
		this.id = id;
	}

	public String getNavn() {
		return navn;
	}

	public String getFarge() {
		return farge;
	}

	public int getId() {
		return id;
	}
	@Override
	public String toString() {
		return farge + " " + navn;
	}
}
