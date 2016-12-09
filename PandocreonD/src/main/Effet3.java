package main;

public class Effet3 extends Croyant { //Pioche deux cartes au hasard dans la main d'un autre joueur id = 8, 21, 34

	public void utiliserEffet(Carte carte, Joueur utilisateur, Joueur cible){
		for (int i=0; i<2; i++) {
			int nombreAleatoire = 1 + (int)(Math.random() * (cible.getMain().size() - 1));
			utilisateur.main.add(cible.main.get(nombreAleatoire));
			}
	}
}
