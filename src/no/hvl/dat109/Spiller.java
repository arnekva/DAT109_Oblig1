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
}
