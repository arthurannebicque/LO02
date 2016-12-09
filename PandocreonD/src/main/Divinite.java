package main;

import java.util.ArrayList;

public class Divinite extends Carte{

	public Divinite(){
		super();
		
	}
	
	public Divinite(String string, int i, int j, int k, int l, int m) {
		super ( string , i , j , k, l,m);
	}


		
	public void utiliserEffet(Carte carte, Joueur utilisateur, Joueur cible, ArrayList<Joueur> listeJoueur){
		int id = carte.identifiantCarte;
		switch (id) {
			case 81:
				//Empeche le joueur de jouer une carte apocalypse
				cible.stopApocalypse = true;
				break;
			case 82:
				//Empeche le sacrifice d'un guide spirituel de n'importe quelle joueur
				cible.stopSacrificeGuide = true;
				break;
			case 83:
				// Si une croyante d'origine nuit est sur le plateau, on l'enleve et on le met dans la pioche
				break;
			case 84:
				//Force un joueur à poser une carte apocalypse
				break;
			case 85:
				//Force un joueur à poser une carte apocalypse
				break;
			case 86:
				//Detruit toutes les cartes de croyants d'origine Jour au centre de la table
				break;
			case 87:
				//Donne autant de points d'action d'origine Néant que le nombre de guide spirituel que le joueur possede
				break;
			case 88: 
				//Force le sacrifice d'un guide spirituel avec dogme symboles ou nature
				break;
			case 89: 
				//Récupère les points d'actions d'un autre joueur en plus des siens, L'autre joueur ne reçoit aucun point d'action ce tour ci
				break;
			case 90:
				//Empeche un joueur de crée un guide spirituel
				break;

		
		
		
			}
	}
}

