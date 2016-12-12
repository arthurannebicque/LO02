package main;

import java.util.ArrayList;

public class Effet22 implements Effet {//id=65 Aucun autre joueur ne gagne de points d'Action durant ce tour.


	@Override
	public void utiliserEffet(Partie p, ArrayList<Joueur> listejoueur, int cible, ArrayList<Carte> table, Carte carte,
			int j, ArrayList<Carte> collection, ArrayList<Joueur> tourjoueur) {
		for(int n=0; n<listejoueur.size(); n++) {
			listejoueur.get(n).stopPointAction = true;
		}
		
	}

	@Override
	public void utiliserEffetDivinite(ArrayList<Joueur> listejoueur, int j, int id, ArrayList<Carte> collection,
			int croyant, int guide) {
		// TODO Auto-generated method stub
		
	}

}
