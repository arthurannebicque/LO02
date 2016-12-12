package main;

import java.util.ArrayList;

public class Effet17 implements Effet { //id=53 Oblige une Divinité ayant leDogme Nature ou Mystiqueà sacrifier l'un de ses GuidesSpirituels.


	@Override
	public void utiliserEffet(Partie p, ArrayList<Joueur> listejoueur, int cible, ArrayList<Carte> table, Carte carte,
			int j, ArrayList<Carte> collection, ArrayList<Joueur> tourjoueur) {
		boolean boucle = true;
		int n =0;
		while (boucle && n<listejoueur.size()) {
		
			if ( (listejoueur.get(n).Divinite.natureCarte1 == 1 || listejoueur.get(n).Divinite.natureCarte1 == 4) || (listejoueur.get(n).Divinite.natureCarte2 == 1 || listejoueur.get(n).Divinite.natureCarte2 == 4) ||  (listejoueur.get(n).Divinite.natureCarte3 == 1 || listejoueur.get(n).Divinite.natureCarte3 == 4)) {
				if (listejoueur.get(n) != listejoueur.get(j)) {
					//listejoueur.get(n).guidePossede.get(0).utiliserEffet(listejoueur.get(n).guidePossede.get(0));
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
