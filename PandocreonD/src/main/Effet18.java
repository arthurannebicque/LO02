package main;

import java.util.ArrayList;

public class Effet18 extends Guide { //id = 54 Une Divinité d'Origine Nuit ou ayant les Dogmes Mystique ---->OU<--- (simplification de l'effet) Chaos reprend dans sa main l'un de ses Guides Spirituels. Les Croyants qui y étaient attachés sont défaussés.

	
	public void utiliserEffet(Joueur utilisateur, ArrayList<Joueur>listeJoueur, ArrayList<Carte>table) {
		
	boolean boucle = true;
	int n =0;
	while (boucle && n<listeJoueur.size()) {
	
		if ( (listeJoueur.get(n).getDivinite().natureCarte1 == 2 || listeJoueur.get(n).getDivinite().natureCarte1 == 4) || (listeJoueur.get(n).getDivinite().natureCarte2 == 2 || listeJoueur.get(n).getDivinite().natureCarte2 == 4) ||  (listeJoueur.get(n).getDivinite().natureCarte3 == 2 || listeJoueur.get(n).getDivinite().natureCarte3 == 4) || listeJoueur.get(n).getDivinite().origineCarte == 3) {
			if (listeJoueur.get(n) != utilisateur) {
				listeJoueur.get(n).main.add(listeJoueur.get(n).guidePossede.get(0));
				listeJoueur.get(n).guidePossede.remove(0);
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
