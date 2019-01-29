package no.hvl.dat109;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author arnekvaleberg
 *
 */
public class Rad {
	public Runde[] rad;
	private Runde runde1 = new Runde(1, "Du skal trille etter løver");
	private Runde runde2 = new Runde(2, "Du skal trille etter slanger");
	private Runde runde3 = new Runde(3, "Du skal trille etter Pandaer");
	private Runde runde4 = new Runde(4, "Du skal trille etter Griser");
	private Runde runde5 = new Runde(5, "Du skal trille etter Elefanter");
	private Runde runde6 = new Runde(6, "Du skal trille etter Hvaler");
	private Runde runde7 = new Runde(7, "Du skal få 3 like");
	private Runde runde8 = new Runde(8, "Du skal få 4 like");
	private Runde runde9 = new Runde(9, "Du skal få 2 par");
	private Runde runde10 = new Runde(10, "Du skal få hus (2 + 3)");
	private Runde runde11 = new Runde(11, "Du skal få alle ulike");
	private Runde runde12 = new Runde(12, "Du skal få alle like");

	/**
	 * Konstruktør
	 */
	public Rad() {
		rad = new Runde[12];
		rad[0] = runde1;
		rad[1] = runde2;
		rad[2] = runde3;
		rad[3] = runde4;
		rad[4] = runde5;
		rad[5] = runde6;
		rad[6] = runde7;
		rad[7] = runde8;
		rad[8] = runde9;
		rad[9] = runde10;
		rad[10] = runde11;
		rad[11] = runde12;

	}

	public Runde[] getRad() {
		return rad;
	}

	public void setRad(Runde[] rad) {
		this.rad = rad;
	}

	/**
	 * Sjekker terningkastene opp mot kravet for runden.
	 * 
	 * @param rundenr  - Hvilken runde spillet er på akkurat nå
	 * @param terningkast - Liste med terningresultatet spiller fikk
	 * @param spiller - Nåværende spiller
	 * @return resultatet til spilleren denne runden
	 */
	public int rundeSjekk(int rundenr, ArrayList<Dyr> terningkast, Spiller spiller) {
		int resultat = 0;
		Map<Dyr, Integer> antallKart = mapAntall(terningkast);
		if (rundenr < 7) {
			// Her skal brukeren bare få like dyr som runden sier.
			// 1 = løve, 2=slange, 3=Panda,4=gris,5=elefant,6=hval

			for (Dyr dyr : terningkast) {
				if (dyr.getId() == rundenr) {
					resultat++;
				}
			}

		} else if (rundenr == 7) {
			// tre like
			for (Dyr dyr : antallKart.keySet()) {
				int forekomst = antallKart.get(dyr);
				if (forekomst >= 3) {
					resultat = 3;
				}
			}
		} else if (rundenr == 8) {
			//fire like 
			for (Dyr key : antallKart.keySet()) {
				int forekomst = antallKart.get(key);
				if (forekomst >= 4) {
					resultat = 4;
				}
			}
		} else if (rundenr == 9) {
			boolean ettpar = false;
			boolean topar = false;
			
			for (Dyr key : antallKart.keySet()) {
				int forekomst = antallKart.get(key);
				if(forekomst >= 4) {
					resultat = 4;
				}else if(forekomst>=2){
					if(ettpar) {
						topar = true;
					} else { ettpar = true;}
				}
				
			}
			if(ettpar && topar){
				resultat = 4;
			}

		} else if (rundenr == 10) {
			//Sivert sin metode tar ikke høyde for 5 like gir riktig?
			boolean ettpar = false;
			boolean trelike = false;
			
			for (Dyr key : antallKart.keySet()) {
				int forekomst = antallKart.get(key);
				if(forekomst >= 5) {
					resultat = 5;
				}else if(forekomst==2){
					ettpar = true;
				} else if(forekomst==3) {
					trelike = true;
				}
				
			}
			if(ettpar && trelike) {
				resultat = 5;
			}
		} else if (rundenr == 11) {
			boolean alleulike = true;
			for(Dyr key : antallKart.keySet()) {
				int forekomst = antallKart.get(key);
				if(forekomst >= 2) {
					alleulike = false;
				} 
			}
			if(alleulike) {
				resultat = 5;
			}

		} else if (rundenr == 12) {
			for(Dyr key : antallKart.keySet()) {
				int forekomst = antallKart.get(key);
				if(forekomst == 5) {
					resultat = 10;
				} 
			}
			


		}
		System.out.println("\n" + spiller.getNavn() + " fikk " + resultat + "/" + ((rundenr < 12) ? "5" : "10") + " poeng denne runden.");
		
		return resultat;
	}

	/**
	 * Hashmap brukes for å kunne koble antall dyr til resultatscoren
	 * 
	 * @param terningkast - Liste av terningkastresultat
	 * @return
	 */
	public Map<Dyr, Integer> mapAntall(ArrayList<Dyr> terningkast) {
		Map<Dyr, Integer> map = new HashMap<>();
		for (Dyr key : terningkast) {
			if (map.containsKey(key)) {
				int forekomst = map.get(key);
				forekomst++;
				map.put(key, forekomst);
			} else {
				map.put(key, 1);
			}
		}
		return map;
	}

}
