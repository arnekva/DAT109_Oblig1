package no.hvl.dat109;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author arnekvaleberg
 *
 */
public class Observator {
	/**
	 * Kjører spillet
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner tastatur = new Scanner(System.in);
		int antall = 0;
		Spiller[] spillere;
		
		System.out.println("Hvor mange spillere skal spille? Det er maks 5 deltakere.");
		
		boolean fortsett = false;
		while (!fortsett) {

			try {
				antall = tastatur.nextInt();
				if(antall<6) {
				fortsett = true;
				} else {
					System.out.println("For høyt tall. Spillet har maks 5 deltakere!");
				}
				tastatur.nextLine();
			} catch (InputMismatchException e) {
				System.out.println("Du har ikke tastet inn et gyldig tall! Prøv på ny!");
				fortsett = false;
				tastatur.nextLine();
			}
		}
		
		
		
		
		if(antall>0 && antall<6) {
		System.out.println("Skriv inn navnet på deltakerene en etter en. Trykk enter mellom hvert navn:");
		
		spillere = new Spiller[antall];
		
		for(int i = 0; i<antall;i++) {
			
			spillere[i] = new Spiller(tastatur.nextLine());
		
		}
	
		Yatzoo yatzoo = new Yatzoo(spillere);
		try {
			
		yatzoo.spill();
		tastatur.close();
		} catch (Exception e) {
			System.out.println("Det har oppstått et problem ved kjøring av spillet! Errorkode:");
			e.printStackTrace();
			System.out.println("Spillet avsluttes.");
			
		
		}
		}else {
			System.out.println("Minst 1 og maks 5 deltakere! Spillet avsluttes.");
		}
	}
}
