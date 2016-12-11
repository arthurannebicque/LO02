package main;

public class Effet4 extends Croyant { //forcer sacrifice croyant
	
	
	public void utiliserEffet(Carte carte, Joueur cible){
		int id = carte.identifiantCarte;
		if (id == 9 || id == 10 || id == 22 || id == 23 ) cible.forcerAction(); //a modifier pour faire comparaison entre croyant et guide spirituel
		else if (id == 11 ) cible.forcerAction(); //a modifier

	}

}
