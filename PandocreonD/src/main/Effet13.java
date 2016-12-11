package main;

import java.util.ArrayList;

public class Effet13 extends Guide { // id = 49 Sacrifie tous les Croyants d'Origine Néant d'une Divinité ayant le Dogme Humain. Les capacités spéciales sont jouées normalement.

	public void utiliserEffet(ArrayList<Joueur>listeJoueur, Joueur utilisateur) {
		
		boolean boucle = true;
		int n =0;
		while (boucle && n<listeJoueur.size()) {
		
			if ( (listeJoueur.get(n).getDivinite().natureCarte1 == 5) || (listeJoueur.get(n).getDivinite().natureCarte2 == 5) ||  (listeJoueur.get(n).getDivinite().natureCarte3 == 5)) {
				if (listeJoueur.get(n) != utilisateur) {
					for (int i=0; i<listeJoueur.get(n).croyantPossede.size(); i++) {
					if (listeJoueur.get(n).croyantPossede.get(i).origineCarte == 2) {
						listeJoueur.get(n).croyantPossede.get(i).utiliserEffet(listeJoueur.get(n).croyantPossede.get(i));
					}
					boucle = false;
					}
				}
			}
			n++;
		}
		
	}
}
