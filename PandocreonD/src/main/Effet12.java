package main;

import java.util.ArrayList;
import java.util.Scanner;


public class Effet12 implements Effet{
	// id = 41, 42, 43, 44, 45, 46 , 47, 48 Fait gagner un nombre de points d'Action égal au nombre de cartes de Croyants rattachées. L'Origine des points d'Action est au choix du joueur.
	
	protected Scanner sc;


	@Override
	public void utiliserEffet(Partie p, ArrayList<Joueur> listejoueur, int cible, ArrayList<Carte> table, Carte carte,
			int j, ArrayList<Carte> collection, ArrayList<Joueur> tourjoueur) {
		if (listejoueur.get(j)==listejoueur.get(0)){ // Si le joueur est humain
			int nb = carte.croyantPossede.size();
			System.out.println("Quelle origine pour les points d'action ? 1: jour , 2: nuit , 3: neant");
			int indice = sc.nextInt();
			listejoueur.get(j).setPointAction(indice, nb);
		}
		else if (listejoueur.get(j)!= listejoueur.get(0)){ // Si c'est l'ordi
			int nb = carte.croyantPossede.size();
			int indice = listejoueur.get(j).Divinite.origineCarte;
			listejoueur.get(j).setPointAction(indice, nb);
			
		}
		
	}


	@Override
	public void utiliserEffetDivinite(ArrayList<Joueur> listejoueur, int j, int id, ArrayList<Carte> collection,
			int croyant, int guide) {
		// TODO Auto-generated method stub
		
	}

}
