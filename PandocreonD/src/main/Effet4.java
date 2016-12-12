package main;

import java.util.ArrayList;

public class Effet4 implements Effet {



	@Override
	public void utiliserEffet(Partie p, ArrayList<Joueur> listejoueur, int cible, ArrayList<Carte> table, Carte carte,
			int j, ArrayList<Carte> collection,ArrayList<Joueur> tourjoueur) { // Forcer un sacrifice croyant
		int id = carte.identifiantCarte;
		if (id ==9 || id ==10 || id==22 || id==23){
		listejoueur.get(cible).forcerAction(cible,listejoueur.get(cible).doitSacrifierCroyant, listejoueur);
		}
		else if ( id==11){
			listejoueur.get(cible).forcerAction(cible, listejoueur.get(cible).doitSacrifierGuide, listejoueur);
		}
		
	}

	@Override
	public void utiliserEffetDivinite(ArrayList<Joueur> listejoueur, int j, int id, ArrayList<Carte> collection,
			int croyant, int guide) {
		// TODO Auto-generated method stub
		
	}

}
