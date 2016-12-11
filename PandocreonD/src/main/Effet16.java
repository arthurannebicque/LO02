package main;

import java.util.ArrayList;

public class Effet16 extends Guide { //id = 52 Sacrifie 2 cartes Croyants d'une Divinité ayant le Dogme Humain ou Symboles. Les capacités spéciales sont jouées normalement.
	
	public void utiliserEffet(Joueur utilisateur, ArrayList<Joueur>listeJoueur) {
		
	boolean boucle = true;
	int n =0;
	while (boucle && n<listeJoueur.size()) {
	
		if ( (listeJoueur.get(n).getDivinite().natureCarte1 == 3 || listeJoueur.get(n).getDivinite().natureCarte1 == 5) || (listeJoueur.get(n).getDivinite().natureCarte2 == 3 || listeJoueur.get(n).getDivinite().natureCarte2 == 5) ||  (listeJoueur.get(n).getDivinite().natureCarte3 == 3 || listeJoueur.get(n).getDivinite().natureCarte3 == 5)) {
			if (listeJoueur.get(n) != utilisateur) {
				listeJoueur.get(n).croyantPossede.get(0).utiliserEffet(listeJoueur.get(n).croyantPossede.get(0));
				listeJoueur.get(n).croyantPossede.get(0).utiliserEffet(listeJoueur.get(n).croyantPossede.get(1));
				boucle = false;
			}
		}
		n++;
	}
	
}
}
