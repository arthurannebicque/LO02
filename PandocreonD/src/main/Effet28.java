package main;

import java.util.ArrayList;
import java.util.Scanner;

public class Effet28 extends DeusEx { //id = 75
	
	private Scanner sc;

	public void utiliserEffet(Joueur utilisateur, Joueur cible, ArrayList<Carte>table) {
		
		System.out.println("Choisissez un de vos Guides");
		int rep = sc.nextInt();

		System.out.println("Choisissez un des Guides de votre cible");
		int rep2 = sc.nextInt();

		
		
		double resultatDe = Math.round(Math.random()*3);
		resultatDes = resultatDe;
		if ( resultatDe >= 0 && resultatDe <1){ // Dans ce cas, on est en face Jour
				
			cible.guidePossede.get(rep2).utiliserEffet(cible.guidePossede.get(rep2));
			for (int i = 0; i <= cible.guidePossede.get(rep2).croyantPossede.size(); i++) {
				table.add(cible.guidePossede.get(rep2).croyantPossede.get(i));
				cible.guidePossede.get(rep2).croyantPossede.remove(i);
			}
		}	
		else if ( resultatDe <=1 && resultatDe <2){ // Dans ce cas, on est en face Nuit
			utilisateur.guidePossede.get(rep).utiliserEffet(utilisateur.guidePossede.get(rep));
			for (int i = 0; i <= utilisateur.guidePossede.get(rep).croyantPossede.size(); i++) {
				table.add(utilisateur.guidePossede.get(rep).croyantPossede.get(i));
				utilisateur.guidePossede.get(rep).croyantPossede.remove(i);
			}

		}

			
	}
	

}
