package main;

import java.util.ArrayList;

public class Effet22 extends DeusEx{ //id=65 Aucun autre joueur ne gagne de points d'Action durant ce tour.
	
	public void utiliserEffet(ArrayList<Joueur>listeJoueur) {
		for(int n=0; n<listeJoueur.size(); n++) {
			listeJoueur.get(n).stopPointAction = true;
		}
	}
}
