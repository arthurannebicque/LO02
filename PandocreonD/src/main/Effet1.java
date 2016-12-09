package main;


public class Effet1 extends Croyant { //Donner point d'action
	
	public void utiliserEffet(Carte carte, Joueur utilisateur){
		int id = carte.identifiantCarte;
		if (id == 1 || id == 2 || id == 3 || id == 4 || id ==5) utilisateur.setPointAction(1, 1); //Donne un point d'action Jour
		if (id == 14 || id == 15 || id == 16 || id == 17 || id == 18) utilisateur.setPointAction(2, 1); //Donne un point d'action Nuit
		if (id == 27 || id == 28 || id == 29 || id == 30 || id == 31) utilisateur.setPointAction(3, 1); //Donne un point d'action Néant

	}
}
