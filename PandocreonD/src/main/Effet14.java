package main;

import java.util.ArrayList;

public class Effet14 extends Guide { //id = 50 Sacrifie un Guide Spirituel, si lui ou sa Divinité ne croit pas au Dogme Chaos. Les capacités spéciales sont jouées normalement.

	public void utiliserEffet(ArrayList<Joueur>listeJoueur, Joueur utilisateur, ArrayList<Carte>table) {
		
		boolean boucle = true;
		int n =0;
		int i = 0;
		while (boucle && n<listeJoueur.size()) {
			
			if (listeJoueur.get(n) != utilisateur) {
				
			while (boucle && i<listeJoueur.get(n).guidePossede.size()) {
				if ((listeJoueur.get(n).getDivinite().natureCarte1 != 2 || listeJoueur.get(n).getDivinite().natureCarte2 != 2 || listeJoueur.get(n).getDivinite().natureCarte3 != 2) || (listeJoueur.get(n).guidePossede.get(i).natureCarte1 != 2 || listeJoueur.get(n).guidePossede.get(i).natureCarte2 != 2 || listeJoueur.get(n).guidePossede.get(i).natureCarte3 != 2)) {
					listeJoueur.get(n).guidePossede.get(i).utiliserEffet(listeJoueur.get(n).guidePossede.get(i));
					for (int j = 0; j <= listeJoueur.get(n).guidePossede.get(0).croyantPossede.size(); j++) {
						table.add(listeJoueur.get(n).guidePossede.get(0).croyantPossede.get(i));
						listeJoueur.get(n).guidePossede.get(0).croyantPossede.remove(i);
					}
					boucle=false;
				}
			
				i++;
			}
	
			n++;
			}
		}
		
	}
}
