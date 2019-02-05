package no.hvl.dat109;

/**
 * @author arnekvaleberg
 *
 */
public class Kolonne {
	private int kolonneId;
	public int[] kolonne;
	
	/**
	 * Oppretteren en kolonne som kan tildeles til en spiller. 12 rader (plasser i tabellen) opprettes automatisk.
	 * @param id - Unik ID for kolonnen.
	 */
	public Kolonne(int id) {
		kolonneId = id;
		kolonne = new int[12];
	}
	
	/**
	 * Oppdaterer scoren til spilleren i den gitte runden med score. 
	 * @param runde - Rundenummer
	 * @param verdi - Scoren som skal settes
	 */
	public void oppdaterVerdi(int runde, int verdi) {
		kolonne[runde-1] = verdi;
	}

	public int getKolonneId() {
		return kolonneId;
	}

	public void setKolonneId(int kolonneId) {
		this.kolonneId = kolonneId;
	}

	public int[] getKolonne() {
		return kolonne;
	}

	public void setKolonne(int[] kolonne) {
		this.kolonne = kolonne;
	}
	
}