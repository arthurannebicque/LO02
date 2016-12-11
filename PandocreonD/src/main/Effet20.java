package main;

import java.util.ArrayList;

public class Effet20 extends Guide { //id=56 Défausse tous les Croyants ayant le Dogme Mystique actuellement au centre de la table.

	public void utiliserEffet(ArrayList<Joueur>listeJoueur, ArrayList<Carte>table, ArrayList<Carte> deck) {
	
		for (int i=0; i<table.size();i++) {
			if (table.get(i).natureCarte1==4 || table.get(i).natureCarte2==4 || table.get(i).natureCarte3==4) {
				deck.add(table.get(i));
				table.remove(i);
			}	
		}
		
		
		/*  au centre de la table veut dire table plus joueurs ou pas ?
		for (int n=0; n<listeJoueur.size(); n++) {
			for (int j=0; j<listeJoueur.get(n).croyantPossede.size(); j++) {
				if (listeJoueur.get(n).croyantPossede.get(j).natureCarte1==4 || listeJoueur.get(n).croyantPossede.get(j).natureCarte2==4 || listeJoueur.get(n).croyantPossede.get(j).natureCarte3==4) {
					deck.add(listeJoueur.get(n).croyantPossede.get(j));
					listeJoueur.get(n).croyantPossede.remove(j);
				}
			}
		}
		*/
		
		
	}

}
