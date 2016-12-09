package main;

public class Effet8 extends Croyant { // id = 26 utilise l'effet d'une carte croyant d'un autre joueur, la carte reste en jeu

	public void utiliserEffet(Joueur cible){

		//utilise l'effet d'une carte croyant d'un autre joueur, la carte reste en jeu
		int carteAleatoire = 1 + (int)(Math.random() * (cible.getMain().size() - 1));
		utiliserEffet(cible.main.get(carteAleatoire));
	}
}
