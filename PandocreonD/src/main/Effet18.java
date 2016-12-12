package main;

import java.util.ArrayList;

public class Effet18 implements Effet{



	@Override
	public void utiliserEffet(Partie p, ArrayList<Joueur> listejoueur, int cible, ArrayList<Carte> table, Carte carte,
			int j, ArrayList<Carte> collection, ArrayList<Joueur> tourjoueur) { //id = 54 Une Divinité d'Origine Nuit ou ayant les Dogmes Mystique ---->OU<--- (simplification de l'effet) Chaos reprend dans sa main l'un de ses Guides Spirituels. Les Croyants qui y étaient attachés sont défaussés.
		boolean boucle = true;
		int n =0;
		while (boucle && n<listejoueur.size()) {
		
			if ( (listejoueur.get(n).getDivinite().natureCarte1 == 2 || listejoueur.get(n).getDivinite().natureCarte1 == 4) || (listejoueur.get(n).getDivinite().natureCarte2 == 2 || listejoueur.get(n).getDivinite().natureCarte2 == 4) ||  (listejoueur.get(n).getDivinite().natureCarte3 == 2 || listejoueur.get(n).getDivinite().natureCarte3 == 4) || listejoueur.get(n).getDivinite().origineCarte == 3) {
				if (listejoueur.get(n) != listejoueur.get(j)) {
					listejoueur.get(n).main.add(listejoueur.get(n).guidePossede.get(0));
					listejoueur.get(n).guidePossede.remove(0);
					for (int i = 0; i <= listejoueur.get(n).guidePossede.get(0).croyantPossede.size(); i++) {
						table.add(listejoueur.get(n).guidePossede.get(0).croyantPossede.get(i));
						listejoueur.get(n).guidePossede.get(0).croyantPossede.remove(i);
					}
					boucle = false;
				}
			}
			n++;
		}
		
	}

	@Override
	public void utiliserEffetDivinite(ArrayList<Joueur> listejoueur, int j, int id, ArrayList<Carte> collection,
			int croyant, int guide) {
		// TODO Auto-generated method stub
		
	}

}
