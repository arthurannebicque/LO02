package main;

import java.util.ArrayList;

public class Effet8 implements Effet{// id = 26 utilise l'effet d'une carte croyant d'un autre joueur, la carte reste en jeu



	@Override
	public void utiliserEffet(Partie p, ArrayList<Joueur> listejoueur, int cible, ArrayList<Carte> table, Carte carte,
			int j, ArrayList<Carte> collection,ArrayList<Joueur> tourjoueur) {
		//utilise l'effet d'une carte croyant d'un autre joueur, la carte reste en jeu
		
		int carteAleatoire = 1 + (int)(Math.random() * (listejoueur.get(cible).main.size()-1));
		//listejoueur.get(j).main.get(carteAleatoire).utiliserEffet(); Remplir les effets après
		
		
		
		
		
		
	}

	@Override
	public void utiliserEffetDivinite(ArrayList<Joueur> listejoueur, int j, int id, ArrayList<Carte> collection,
			int croyant, int guide) {
		// TODO Auto-generated method stub
		
	}

}
