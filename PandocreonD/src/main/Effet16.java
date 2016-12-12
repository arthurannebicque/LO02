package main;

import java.util.ArrayList;

public class Effet16 implements Effet{ //id = 52 Sacrifie 2 cartes Croyants d'une Divinité ayant le Dogme Humain ou Symboles. Les capacités spéciales sont jouées normalement.


	@Override
	public void utiliserEffet(Partie p, ArrayList<Joueur> listejoueur, int cible, ArrayList<Carte> table, Carte carte,
			int j, ArrayList<Carte> collection, ArrayList<Joueur> tourjoueur) {
		boolean boucle = true;
		int n =0;
		while (boucle && n<listejoueur.size()) {
		
			if ( (listejoueur.get(n).Divinite.natureCarte1 == 3 || listejoueur.get(n).Divinite.natureCarte1 == 5) || (listejoueur.get(n).Divinite.natureCarte2 == 3 || listejoueur.get(n).Divinite.natureCarte2 == 5) ||  (listejoueur.get(n).Divinite.natureCarte3 == 3 || listejoueur.get(n).Divinite.natureCarte3 == 5)) {
				if (listejoueur.get(n) != listejoueur.get(j)) {
					//listejoueur.get(n).croyantPossede.get(0).utiliserEffet(listejoueur.get(n).croyantPossede.get(0));
					//listejoueur.get(n).croyantPossede.get(0).utiliserEffet(listejoueur.get(n).croyantPossede.get(1));
					boucle = false;
				}
			}
			n++;
		}
		
	}

	@Override
	public void utiliserEffetDivinite(ArrayList<Joueur> listejoueur, int j, int id, ArrayList<Carte> collection,
			int croyant, int guide) {
		// TODO Auto-generated method stub
		
	}

}
