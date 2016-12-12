package main;

import java.util.ArrayList;

public class Effet2 implements Effet{ //Empeche une divinité n1 ou n2 de sacrifier ses cartes croyants durant ce tour
		int n1 , n2;


	@Override
	public void utiliserEffet(Partie p, ArrayList<Joueur> listejoueur, int cible, ArrayList<Carte> table, Carte carte,
			int j, ArrayList<Carte> collection,ArrayList<Joueur> tourjoueur) {
		
		int id = carte.identifiantCarte;
		
		if (id == 6 || id ==32){
			n1 = 1; // Nature
			n2 = 4; // Mystique
		}
		else if (id ==7 || id == 33){
			n1=2 ; // Chaos
			n2=4 ; // Mystique
		}
		else if (id == 19){
			n1 =5; // Humain
			n2 =4; // Mystique
		}
		else if (id ==20){
			n1=5; // Humain
			n2=3; // Symboles
		}
		
		//Empeche une divinité n1 ou n2 de sacrifier ses cartes croyants durant ce tour
			if ((listejoueur.get(cible).getDivinite().natureCarte1 == n1 || listejoueur.get(cible).getDivinite().natureCarte1 == n2) || (listejoueur.get(cible).getDivinite().natureCarte2 == n1 || listejoueur.get(cible).getDivinite().natureCarte2 == n2) || (listejoueur.get(cible).getDivinite().natureCarte3 == n1 || listejoueur.get(cible).getDivinite().natureCarte3 == n2)) {
				listejoueur.get(cible).stopSacrificeCroyant = true;
			}
		
	}


	@Override
	public void utiliserEffetDivinite(ArrayList<Joueur> listejoueur, int j, int id, ArrayList<Carte> collection,
			int croyant, int guide) {
		// TODO Auto-generated method stub
		
	}

}
