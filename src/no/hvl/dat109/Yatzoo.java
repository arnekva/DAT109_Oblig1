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
	private Blokk blokk;
	public Spiller[] spillere;
	
	public Yatzoo(Spiller[] spillere) {
		runde = 1;
		terning = new Terning();
		terningsresultater = new ArrayList<Dyr>();
		blokk = new Blokk(spillere);
		this.spillere = spillere;
	}
	
	public Yatzoo() {
		
		runde = 0;
		terning = new Terning();
		terningsresultater = new ArrayList<Dyr>();
	}
	/**
	 * Hovedmetoden som kjører spillet gjennom alle 12 rundene.
	 */
	public void spill() {
		while (runde < 13) {
			spillRunde();
		}
		for (Spiller spiller : spillere) {
			summerPoeng(spiller);
		}
		finnVinner();
	}
	/**
	 * Kaster og printer terningresultatene. 
	 * @param antall - Antall terninger som skal kastes. 
	 */
	public void kastTerninger(int antall) {
		for(int i = 0; i<antall; i++) {
			Dyr dyr = terning.trillTerning();
			terningsresultater.add(dyr);
		}
		System.out.println();
	}
	/**
	 * Printer, lagrer og resetter terningkastresultatene
	 */
	public void spillRunde() {
		for (Spiller spiller : spillere) {
			System.out.println("\n" + spiller.getNavn() + " sin tur."
						+ "\n" + blokk.getRad().getRad()[runde-1].getBeskrivelse());
			kastTerninger();
			int resultat = blokk.getRad().rundeSjekk(runde, terningsresultater, spiller);
			spiller.getKolonne().oppdaterVerdi(runde, resultat);
			terningsresultater.clear();
		}
		runde++;
	}
	/**
	 * Kaster og spør spilleren hvilke terninger han vil ta vare på. Max 3 kast per spiller.
	 */
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
					try {
					midlertidig.add(terningsresultater.get(Integer.parseInt(inputTab[i]) - 1));
					}catch(Exception e) {
						System.out.println("Ingen terninger ble lagret. Triller alle på ny");
					}
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
	/**
	 * Summerer totalen gjennom kolonnen til spilleren, og setter poengscore.
	 * @param spiller - Spilleren som metoden skal summere poengene til
	 * Summerer poengene til en spiller
	 */
	public void summerPoeng(Spiller spiller) {
		int sum = 0;
		for (int i : spiller.getKolonne().getKolonne()) {
			sum += i;
		}
		spiller.setPoengscore(sum);
	}
	/**
	 * Sjekker resultatene opp mot hverandre og kårer en vinner. Printer ut resultatet uten å returnere.
	 */
	public void finnVinner() {
		boolean flereVinnere = false;

		Spiller vinner = spillere[0];
		
		ArrayList<Spiller> vinnere = new ArrayList<Spiller>();
		vinnere.add(vinner);
		
		for (int i = 1; i < spillere.length; i++) {
			if (spillere[i].getPoengscore() > vinner.getPoengscore()) {
				
				vinner = spillere[i];
				if (flereVinnere) {
					flereVinnere = false;
					vinnere.clear();
				}
			} else if (spillere[i].getPoengscore() == vinner.getPoengscore()) {
				flereVinnere = true;
				vinnere.add(spillere[i]);
			}
		}
		System.out.println("\n***** Resultatliste: ***** \n");
		for(Spiller a: spillere) {
			System.out.println(a.getNavn() + ": " +a.getPoengscore() + " p.");
		}
		
		if (flereVinnere) {
			System.out.print("\nDet er flere spillere med like stor poengsum som deler 1. plassen.\nGratulerer");
			for (Spiller spiller : vinnere) {
				System.out.print("  " + spiller.getNavn());
			}
			System.out.println("!");
		} else if (vinner != null){
			System.out.println("\nGratulerer " + vinner.getNavn() + "! Du har vunnet spillet!");
		} else {
			System.out.println("\nDet har oppstått et problem, og ingen vinner kan kåres. Spillet avsluttes.");
		}
	}

	
}
