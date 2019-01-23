/**
 * 
 */
package no.hvl.dat109;

import java.util.ArrayList;

/**
 * @author arnekvaleberg
 *
 */
public class Yatzoo {
	public Terning terning;
	private int runde;
	public ArrayList<Dyr> terningkast;
	
	public Yatzoo() {
		
		runde = 0;
		terning = new Terning();
		terningkast = new ArrayList<Dyr>();
	}
	public void kastTerninger(int antall) {
		for(int i = 0; i<antall; i++) {
			Dyr dyr = terning.trillTerning();
			terningkast.add(dyr);
		}
		System.out.println();
	}
	
//	public void beholdTerninger() {
//		for(int i = 0; i<)
//		System.out.println("Ønsker du å beholde noen terninger?");
//	}
}
