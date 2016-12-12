package main;

import java.util.ArrayList;

public class Effet3 implements Effet {



	@Override
	public void utiliserEffet(Partie p, ArrayList<Joueur> listejoueur, int cible, ArrayList<Carte> table, Carte carte,
			int j, ArrayList<Carte> collection,ArrayList<Joueur> tourjoueur) {
		//Pioche deux cartes au hasard dans la main d'un autre joueur id = 8, 21, 34
		
		int n = 1;
		for (int i =0; i<2; i++){
			int nombreAleatoire = 1 +(int)(Math.random()*(listejoueur.get(cible).main.size()-n));
			listejoueur.get(j).main.add(listejoueur.get(cible).main.get(nombreAleatoire));
			listejoueur.get(cible).main.remove(nombreAleatoire);
			n++;
		}

	}

	@Override
	public void utiliserEffetDivinite(ArrayList<Joueur> listejoueur, int j, int id, ArrayList<Carte> collection,
			int croyant, int guide) {
		// TODO Auto-generated method stub
		
	}

}
