package main;

import java.util.Scanner;

public class Effet19 extends Guide{ //id=55 Echangez l'un de vos Guides Spirituels avec un d'une autre Divinité. Vous choisissez les deux guides Spirituels en question. Les Croyants restent attachés aux mêmes cartes.

	private Scanner sc;

	public void utiliserEffet(Joueur utilisateur, Joueur cible) {
		System.out.println("Choisissez votre Guide à echanger");
		int id = sc.nextInt();
		System.out.println("Choisissez le Guide à echanger de votre cible");
		int id2 = sc.nextInt();
		
		cible.guidePossede.add(utilisateur.guidePossede.get(id));
		/* Est-nécessaire pour que les croyants suivent les guides ?
		for (int i = 0; i <= utilisateur.guidePossede.get(id).croyantPossede.size(); i++) {
			cible.guidePossede.get(cible.guidePossede.size()-1).add(utilisateur.guidePossede.get(id).croyantPossede.get(i));
			utilisateur.guidePossede.get(id).croyantPossede.remove(i);
		}
		*/
		utilisateur.guidePossede.remove(id);
		
		utilisateur.guidePossede.add(cible.guidePossede.get(id2));
		/*
		for (int i = 0; i <= cible.guidePossede.get(id2).croyantPossede.size(); i++) {
			utilisateur.guidePossede.get(utilisateur.guidePossede.size()-1).add(cible.guidePossede.get(id2).croyantPossede.get(i));
			cible.guidePossede.get(id2).croyantPossede.remove(i);
		}
		*/
		cible.guidePossede.remove(id2);
		
	}
}
