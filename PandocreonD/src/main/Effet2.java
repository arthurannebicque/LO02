package main;

import java.util.ArrayList;

public class Effet2 extends Croyant { //Empeche une divinité n1 ou n2 de sacrifier ses cartes croyants durant ce tour
	
	int n1;
	int n2;
	
	public void utiliserEffet(Carte carte, Joueur utilisateur, ArrayList<Joueur> listeJoueur){
		int id = carte.identifiantCarte;
		
		
		if (id == 6 || id == 32) {
			n1 = 1; //Nature
			n2 = 4; //Mystique
		}
		
		else if (id == 7 || id == 33) {
			n1 = 2; //Chaos
			n2 = 4; //Mystique
		}
		
		else if (id == 19) {
			n1 = 5; //Humain
			n2 = 4;	//Mystique
		}
		
		else if (id == 20) {
			n1 = 5; //Humain
			n2 = 3; //Symboles
		}
		
		
			//Empeche une divinité n1 ou n2 de sacrifier ses cartes croyants durant ce tour
			for (int i=0; i<listeJoueur.size();i++){
				if ((listeJoueur.get(i).getDivinite().natureCarte1 == n1 | listeJoueur.get(i).getDivinite().natureCarte1 == n2) | (listeJoueur.get(i).getDivinite().natureCarte2 == n1 | listeJoueur.get(i).getDivinite().natureCarte2 == n2) | (listeJoueur.get(i).getDivinite().natureCarte3 == n1 | listeJoueur.get(i).getDivinite().natureCarte3 == n2)) {
					listeJoueur.get(i).stopSacrificeCroyant = true;
				}
			}
		}
	
}
