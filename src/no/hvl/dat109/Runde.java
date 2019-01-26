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

	public int getRundeId() {
		return rundeid;
	}

	public void setRundeId(int rundeId) {
		this.rundeid = rundeId;
	}

	public String getBeskrivelse() {
		return beskrivelse;
	}

	public void setBeskrivelse(String beskrivelse) {
		this.beskrivelse = beskrivelse;
	}
	
}
