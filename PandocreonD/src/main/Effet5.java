package main;

import java.util.ArrayList;

public class Effet5 implements Effet{


	@Override
	public void utiliserEffet(Partie p, ArrayList<Joueur> listejoueur, int cible, ArrayList<Carte> table, Carte carte,
			int j, ArrayList<Carte> collection,ArrayList<Joueur> tourjoueur) { // id = 12 Le joueur recupère dans sa main un de ses guides spirituels posés sur la table, les croyants retournent au centre de la table
		//Le joueur recupère dans sa main un de ses guides spirituels posés sur la table, les croyants retournent au centre de la table
		for (int i=0; i<listejoueur.get(j).guidePossede.get(0).croyantPossede.size();i++){
			table.add(listejoueur.get(j).guidePossede.get(0).croyantPossede.get(i));
			listejoueur.get(j).guidePossede.get(0).croyantPossede.remove(i);
		}
		
		listejoueur.get(j).main.add(listejoueur.get(j).guidePossede.get(0));
		listejoueur.get(j).guidePossede.remove(0);
		
		
	}

	@Override
	public void utiliserEffetDivinite(ArrayList<Joueur> listejoueur, int j, int id, ArrayList<Carte> collection,
			int croyant, int guide) {
		// TODO Auto-generated method stub
		
	}

	
}
