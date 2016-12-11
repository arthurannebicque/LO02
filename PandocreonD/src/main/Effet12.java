package main;

import java.util.Scanner;

public class Effet12 extends Guide { // id = 41, 42, 43, 44, 45, 46 , 47, 48 Fait gagner un nombre de points d'Action égal au nombre de cartes de Croyants rattachées. L'Origine des points d'Action est au choix du joueur.
	
	private Scanner sc;

	
	public void utiliserEffet(Carte carte, Joueur utilisateur){
		int nb = carte.croyantPossede.size();
		System.out.println("Quelle Origine pour les points d'actions ? 1: jour , 2: nuit, 3: neant");
		int indice = sc.nextInt();
		utilisateur.setPointAction(indice, nb);
		
	}


}
