package main;

import java.util.ArrayList;

public class Effet11 implements Effet { // Id = 25
	//Récupérez les points d'Action d'une Divinité n'ayant pas encore joué durant ce tour. Les points d'Action gardent leur Origine. La Divinité perd ses points.


	@Override
	public void utiliserEffet(Partie p, ArrayList<Joueur> listejoueur, int cible, ArrayList<Carte> table, Carte carte,
			int j, ArrayList<Carte> collection,ArrayList<Joueur> tourjoueur) {
	for (int i=0;i<tourjoueur.size();i++){
		if ( listejoueur.get(j)== listejoueur.get(i)){
			int pointDepart = i;
		}
	}
	// Flemme , plus tard
		
		
	}

	@Override
	public void utiliserEffetDivinite(ArrayList<Joueur> listejoueur, int j, int id, ArrayList<Carte> collection,
			int croyant, int guide) {
		// TODO Auto-generated method stub
		
	}

}
