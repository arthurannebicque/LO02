package main;

import java.util.ArrayList;

public class Effet10 extends Croyant { // id =37

	public void utiliserEffet(Joueur utilisateur, ArrayList<Joueur> listeJoueur){
		//Jusqu'à la fin du tour, plus aucune Divinité ne reçoit de points d'Action.
		//Rajouter une boucle for pour que l'effet dure un tour
		stopPointAction = true;
	}
}
