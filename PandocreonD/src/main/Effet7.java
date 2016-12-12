package main;

import java.util.ArrayList;

public class Effet7 implements Effet{ // id =24 Defausse un guide spirituel d'un autre joueur posé sur la table, les croyants retournent au centre



	@Override
	public void utiliserEffet(Partie p, ArrayList<Joueur> listejoueur, int cible, ArrayList<Carte> table, Carte carte,
			int j, ArrayList<Carte> collection,ArrayList<Joueur> tourjoueur) {
		for (int i=0; i<listejoueur.get(cible).guidePossede.get(0).croyantPossede.size();i++){
			table.add(listejoueur.get(cible).guidePossede.get(0).croyantPossede.get(i));
			listejoueur.get(cible).guidePossede.get(0).croyantPossede.remove(i);
		}
		
	collection.add(listejoueur.get(cible).guidePossede.get(0));
	listejoueur.get(cible).guidePossede.remove(0);
		
			
		
	}

	@Override
	public void utiliserEffetDivinite(ArrayList<Joueur> listejoueur, int j, int id, ArrayList<Carte> collection,
			int croyant, int guide) {
		// TODO Auto-generated method stub
		
	}

	
}
