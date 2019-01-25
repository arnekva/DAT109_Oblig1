/**
 * 
 */
package no.hvl.dat109;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author arnekvaleberg
 *
 */
public class Yatzoo {
	public Terning terning;
	private int runde;
	public ArrayList<Dyr> terningsresultater;
	private Scanner reader = new Scanner(System.in);
	
	public Yatzoo() {
		
		runde = 0;
		terning = new Terning();
		terningsresultater = new ArrayList<Dyr>();
	}
	public void kastTerninger(int antall) {
		for(int i = 0; i<antall; i++) {
			Dyr dyr = terning.trillTerning();
			terningsresultater.add(dyr);
		}
		System.out.println();
	}
	public void kastTerninger() {
		boolean ferdig = false;
		int count = 0;
		int antall = 5;
		while (!ferdig && count != 3) {
			for (int i = 0; i < antall; i++) {
				Dyr dyr = terning.trillTerning();
				terningsresultater.add(dyr);
			}
			System.out.println("\nDine terningkast: ");
			for (int i = 1; i < 6; i++) {
				System.out.println(i + ".\t" + terningsresultater.get(i - 1));

			}
			if (count != 2) {
				System.out.println("Skriv inn tallene på terningene du vil ha");
				String input = reader.nextLine();
				String[] inputTab = input.split("\\s");
				ArrayList<Dyr> midlertidig = new ArrayList<Dyr>();
				for (int i = 0; i < inputTab.length; i++) {
					midlertidig.add(terningsresultater.get(Integer.parseInt(inputTab[i]) - 1));

				}
				terningsresultater = midlertidig;
			}
			antall = 5 - terningsresultater.size();
			if (antall == 0) {
				ferdig = true;
			}
				count++;

		}
	}
	public ArrayList<Dyr> getTerningsresultater() {
		return terningsresultater;
	}
	
}
