package main;

import java.util.ArrayList;

public class Effet5 extends Croyant {	// id = 12 Le joueur recupère dans sa main un de ses guides spirituels posés sur la table, les croyants retournent au centre de la table

	
	public void utiliserEffet(Carte carte, Joueur utilisateur, ArrayList<Joueur> listeJoueur, ArrayList<Carte> cartePlateau){

		//Le joueur recupère dans sa main un de ses guides spirituels posés sur la table, les croyants retournent au centre de la table
		for (int i = 0; i <= utilisateur.guidePossede.get(0).croyantPossede.size(); i++) {
			cartePlateau.add(utilisateur.guidePossede.get(0).croyantPossede.get(i));
			utilisateur.guidePossede.get(0).croyantPossede.remove(i);
		}
		utilisateur.main.add(utilisateur.guidePossede.get(0));
		utilisateur.guidePossede.remove(utilisateur.guidePossede.get(0));
	}
}
