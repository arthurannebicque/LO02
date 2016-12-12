package main;

import java.util.ArrayList;

public class Effet10 implements Effet{ // id = 37



	@Override
	public void utiliserEffet(Partie p, ArrayList<Joueur> listejoueur, int cible, ArrayList<Carte> table, Carte carte,
			int j, ArrayList<Carte> collection, ArrayList<Joueur> tourjoueur) {
		//Jusqu'à la fin du tour, plus aucune Divinité ne reçoit de points d'Action.
				//Rajouter une boucle for pour que l'effet dure un tour
		
		for (int i =0; i<listejoueur.size();i++){ // On interdit à chaque joueur de reçevoir des pts action pendant le prochain tour
			listejoueur.get(i).stopApocalypse=true;
		}
		
	}

	@Override
	public void utiliserEffetDivinite(ArrayList<Joueur> listejoueur, int j, int id, ArrayList<Carte> collection,
			int croyant, int guide) {
		// TODO Auto-generated method stub
		
	}

}
