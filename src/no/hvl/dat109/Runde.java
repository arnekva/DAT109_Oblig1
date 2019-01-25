/**
 * 
 */
package no.hvl.dat109;

/**
 * @author arnekvaleberg
 *
 */
public class Runde {

	
	private int rundeid;
	private String beskrivelse;
	
	public Runde(int id, String beskrivelse) {
		this.rundeid = id;
		this.beskrivelse = beskrivelse;
	}

	public int getRundeid() {
		return rundeid;
	}

	public String getBeskrivelse() {
		return beskrivelse;
	}
	
}
