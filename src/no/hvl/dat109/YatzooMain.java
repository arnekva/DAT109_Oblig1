package no.hvl.dat109;

import java.util.Scanner;

public class YatzooMain {
	static Scanner reader = new Scanner(System.in);

	public static void main(String[] args) {

		Rad rad = new Rad();
		Yatzoo yatzoo = new Yatzoo();
		Terning terning = new Terning();
		yatzoo.kastTerninger(5);

		System.out.println("Hvor mange spillere ønsker å spille?");
		String input = reader.nextLine();
		System.out.println("Vennligst skriv inn navnet på de " + input + " deltakerene.");
		System.out.println();
		int antallspillere = Integer.parseInt(input);

		Spiller[] spillerliste = new Spiller[antallspillere];
		for (int i = 0; i < antallspillere; i++) {
			Spiller spiller = new Spiller(reader.nextLine());

			spillerliste[i] = spiller;
		}

		System.out.println("\nSpillere spiller i følgende rekkefølge: ");
		for (int i = 0; i < antallspillere; i++) {
			System.out.println(spillerliste[i].getNavn());
		}
		
		int counter = 0;
		while(counter != 12) {
			yatzoo.kastTerninger(5);
			System.out.println("\n***********Runde " + rad.rad[counter].getRundeid() + ": " + rad.rad[counter].getBeskrivelse());
			
			
			yatzoo.kastTerninger();
			
			
			rad.rundeSjekk(counter, yatzoo.getTerningsresultater());
			
			
			counter++;
		}
		
		
		
	}
}
