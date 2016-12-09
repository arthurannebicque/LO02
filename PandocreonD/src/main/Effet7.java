package main;

import java.util.ArrayList;

public class Effet7 extends Croyant { // id =24 Defausse un guide spirituel d'un autre joueur posé sur la table, les croyants retournent au centre

	
	public void utiliserEffet( Joueur cible, ArrayList<Carte> cartePlateau, ArrayList<Carte> collectionCarte){
		for (int i = 0; i <= cible.guidePossede.get(0).croyantPossede.size(); i++) {
			cartePlateau.add(cible.guidePossede.get(0).croyantPossede.get(i));
			cible.guidePossede.get(0).croyantPossede.remove(i);

		}
		cible.defausserCarte(cible.guidePossede.get(0), collectionCarte);

	}
}
