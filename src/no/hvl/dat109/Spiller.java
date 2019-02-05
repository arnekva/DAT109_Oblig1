/**
 * 
 */
package no.hvl.dat109;

/**
 * @author arnekvaleberg
 *
 */
public class Spiller {
	private String navn;
	public Kolonne kolonne;
	private int poengscore;
	
	
	/**
	 * Konstruktør for spiller
	 * @param navn - Navnet på spilleren
	 */
	public Spiller(String navn) {
		this.navn = navn;
		this.poengscore = 0;
	}
	
	public int getPoengscore() {
		return poengscore;
	}
	public void setPoengscore(int poengscore) {
		this.poengscore = poengscore;
	}
	public String getNavn() {
		return navn;
	}
	public void setNavn(String navn) {
		this.navn = navn;
	}
	public Kolonne getKolonne() {
		return kolonne;
	}
	public void setKolonne(Kolonne kolonne) {
		this.kolonne = kolonne;
	}
	/**
	 * Summerer totalen gjennom kolonnen til spilleren, og setter poengscore.
	 * @param spiller - Spilleren som metoden skal summere poengene til
	 */
	public void summerPoeng(Spiller spiller) {
		int sum = 0;
		for (int i : spiller.getKolonne().getKolonne()) {
			sum += i;
		}
		spiller.setPoengscore(sum);
	}
}
