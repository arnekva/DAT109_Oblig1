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
	private int max;
	
	

	public Runde(int id, String beskrivelse, int max) {
		this.rundeid = id;
		this.beskrivelse = beskrivelse;
		this.max = max;
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

	public int getRundeid() {
		return rundeid;
	}

	public int getMax() {
		return max;
	}

	
}
