package main;

import java.util.Scanner;

public class Effet23 extends DeusEx { //id=66 Permet de bénéficier de la capacité spéciale de l'un de vos Croyants ou Guides Spirituels sans sacrifier la carte.
	private Scanner sc;

	public void utiliserEffet(Joueur utilisateur) {
		
		System.out.println("Voulez-vous utiliser l'effet d'un croyant (1) ou d'un guide (2) ?");
		int rep = sc.nextInt();
		if ( rep == 1){
			// On affiche la liste des guides et leur croyants
			System.out.println("Selectionnez le guide du croyant");
			rep = sc.nextInt();
			// On affiche les croyants suivi par le guide (rep)
			System.out.println("Selectionnez le croyant");
			int rep2 = sc.nextInt();
			utilisateur.guidePossede.get(rep).croyantPossede.get(rep2).utiliserEffet(utilisateur.guidePossede.get(rep).croyantPossede.get(rep2));
		}
		else if( rep == 2){
			// On affiche la liste des guides et leurs croyants
			System.out.println("Selectionnez le guide");
			rep = sc.nextInt();
			utilisateur.guidePossede.get(rep).utiliserEffet(utilisateur.guidePossede.get(rep));
			}
	}
}
