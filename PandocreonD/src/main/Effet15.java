package main;

import java.util.ArrayList;

public class Effet15 implements Effet{



	@Override
	public void utiliserEffet(Partie p, ArrayList<Joueur> listejoueur, int cible, ArrayList<Carte> table, Carte carte,
			int j, ArrayList<Carte> collection, ArrayList<Joueur> tourjoueur) {
		//id = 51 Tous les Croyants, d'Origine Nuit ou Néant et ayant le Dogme Nature, actuellement sur la table sont défaussés. Les capacités spéciales ne sont pas jouées.
		
		for (int i=0; i<table.size();i++) {
			 if (  ((table.get(i).natureCarte1 == 1 ) || (table.get(i).natureCarte2 == 1)) && ((table.get(i).origineCarte == 2) || (table.get(i).origineCarte == 3))) {//On fait une recherche de cartes croyants qui sont dogme 1 ou dogme 2
				 collection.add(table.get(i));
				 table.remove(i);
			 }
			}
			 
			for ( int n=0; n<listejoueur.size();n++){
				for (int c = 0; c<listejoueur.get(n).croyantPossede.size(); c++ ) {
					if (  ((listejoueur.get(n).croyantPossede.get(c).natureCarte1 == 1 ) || (listejoueur.get(n).croyantPossede.get(c).natureCarte2 == 1)) && ((listejoueur.get(n).croyantPossede.get(c).origineCarte == 2) || (listejoueur.get(n).croyantPossede.get(c).origineCarte == 3))) {//On fait une recherche de cartes croyants qui sont dogme 1 ou dogme 2
						 collection.add(listejoueur.get(n).croyantPossede.get(c));
						 listejoueur.get(n).croyantPossede.remove(c);	
					}
				}
			} 
		
	}

	@Override
	public void utiliserEffetDivinite(ArrayList<Joueur> listejoueur, int j, int id, ArrayList<Carte> collection,
			int croyant, int guide) {
		// TODO Auto-generated method stub
		
	}

}
