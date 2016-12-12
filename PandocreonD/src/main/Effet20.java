package main;

import java.util.ArrayList;

public class Effet20 implements Effet{


	@Override
	public void utiliserEffet(Partie p, ArrayList<Joueur> listejoueur, int cible, ArrayList<Carte> table, Carte carte,
			int j, ArrayList<Carte> collection, ArrayList<Joueur> tourjoueur) {
		for (int i=0; i<table.size();i++) {
			if (table.get(i).natureCarte1==4 || table.get(i).natureCarte2==4 || table.get(i).natureCarte3==4) {
				collection.add(table.get(i));
				table.remove(i);
			}	
		}
		
	}

	@Override
	public void utiliserEffetDivinite(ArrayList<Joueur> listejoueur, int j, int id, ArrayList<Carte> collection,
			int croyant, int guide) {
		// TODO Auto-generated method stub
		
	}

}
