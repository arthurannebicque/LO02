package main;

import java.util.ArrayList;
import java.util.Scanner;

public class Effet9 extends Croyant { // id =36 Imposez le sacrifice d'une carte de Croyants à autant de Divinités que vous le voulez. Chaque Divinité choisit la carte à sacrifier. Les capacités spéciales sont jouées.
	
	private Scanner sc;

	public void utiliserEffet(Joueur utilisateur, ArrayList<Joueur> listeJoueur){

		
		//Verifie si joueur physique ou virtuel avec ID à 0
		//Si joueur physique
		if (utilisateur == listeJoueur.get(0) ) {
			//Demande combien de cible
			System.out.println("Sur combien de cible voulez-vous appliquer l'effet?");
			int nbre = sc.nextInt();
				//for le nombre de cible
				for (int i = 0; i<= nbre; i++) {
					//Demande quel cible (ID du joueur)
					//joueur.get(id).forcerAction()
					System.out.println("Quel joueur voulez vous cibler ?");
					int idJoueur = sc.nextInt();
					listeJoueur.get(idJoueur).forcerAction();
				}
		}
		if (utilisateur != listeJoueur.get(0))	{
			int nombreAleatoire = 1 + (int)(Math.random() * (listeJoueur.size() - 1));
			for (int i =0; i<= nombreAleatoire; i++) {
				int idJoueurAleatoire = 1 + (int)(Math.random() * (listeJoueur.size() - 1));
				if (listeJoueur.get(idJoueurAleatoire) != utilisateur) {
					listeJoueur.get(idJoueurAleatoire).forcerAction();
				}
				else {
					idJoueurAleatoire  += 1;
					listeJoueur.get(idJoueurAleatoire).forcerAction();
						
					}	
			}
			
		}
	}	

}
