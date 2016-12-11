package main;

import java.util.ArrayList;

public class Effet17 extends Guide { //id=53 Oblige une Divinité ayant leDogme Nature ou Mystiqueà sacrifier l'un de ses GuidesSpirituels.

	public void utiliserEffet(Joueur utilisateur, ArrayList<Joueur>listeJoueur, ArrayList<Carte>table) {
		
	boolean boucle = true;
	int n =0;
	while (boucle && n<listeJoueur.size()) {
	
		if ( (listeJoueur.get(n).getDivinite().natureCarte1 == 1 || listeJoueur.get(n).getDivinite().natureCarte1 == 4) || (listeJoueur.get(n).getDivinite().natureCarte2 == 1 || listeJoueur.get(n).getDivinite().natureCarte2 == 4) ||  (listeJoueur.get(n).getDivinite().natureCarte3 == 1 || listeJoueur.get(n).getDivinite().natureCarte3 == 4)) {
			if (listeJoueur.get(n) != utilisateur) {
				listeJoueur.get(n).guidePossede.get(0).utiliserEffet(listeJoueur.get(n).guidePossede.get(0));
				for (int i = 0; i <= listeJoueur.get(n).guidePossede.get(0).croyantPossede.size(); i++) {
					table.add(listeJoueur.get(n).guidePossede.get(0).croyantPossede.get(i));
					listeJoueur.get(n).guidePossede.get(0).croyantPossede.remove(i);
				}
				boucle = false;
			}
		}
		n++;
	}
	
}
}
