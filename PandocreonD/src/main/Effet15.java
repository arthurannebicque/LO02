package main;

import java.util.ArrayList;

public class Effet15 extends Guide { //id = 51 Tous les Croyants, d'Origine Nuit ou Néant et ayant le Dogme Nature, actuellement sur la table sont défaussés. Les capacités spéciales ne sont pas jouées.

	public void utiliserEffet(ArrayList<Joueur>listeJoueur, ArrayList<Carte>table, ArrayList<Carte> deck) {
		
		for (int i=0; i<table.size();i++) {
		 if (  ((table.get(i).natureCarte1 == 1 ) || (table.get(i).natureCarte2 == 1)) && ((table.get(i).origineCarte == 2) || (table.get(i).origineCarte == 3))) {//On fait une recherche de cartes croyants qui sont dogme 1 ou dogme 2
			 deck.add(table.get(i));
			 table.remove(i);
		 }
		}
		 
		for ( int n=0; n<listeJoueur.size();n++){
			for (int j = 0; j<listeJoueur.get(n).croyantPossede.size(); j++ ) {
				if (  ((listeJoueur.get(n).croyantPossede.get(j).natureCarte1 == 1 ) || (listeJoueur.get(n).croyantPossede.get(j).natureCarte2 == 1)) && ((listeJoueur.get(n).croyantPossede.get(j).origineCarte == 2) || (listeJoueur.get(n).croyantPossede.get(j).origineCarte == 3))) {//On fait une recherche de cartes croyants qui sont dogme 1 ou dogme 2
					 deck.add(listeJoueur.get(n).croyantPossede.get(j));
					 listeJoueur.get(n).croyantPossede.remove(j);	
				}
			}
		} 
	}
}
