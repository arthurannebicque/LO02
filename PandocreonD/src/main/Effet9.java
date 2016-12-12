package main;

import java.util.ArrayList;
import java.util.Scanner;

public class Effet9 implements Effet{ // id =36 Imposez le sacrifice d'une carte de Croyants à autant de Divinités que vous le voulez. Chaque Divinité choisit la carte à sacrifier. Les capacités spéciales sont jouées.

	protected Scanner sc;

	@Override
	public void utiliserEffet(Partie p, ArrayList<Joueur> listejoueur, int cible, ArrayList<Carte> table, Carte carte,
			int j, ArrayList<Carte> collection,ArrayList<Joueur> tourjoueur) {
		
		if (listejoueur.get(j) == listejoueur.get(0)){
			// Demande combien de cible
			System.out.println("Sur combien de cible voulez-vous appliquer l'effet ?");
			int nbre = sc.nextInt();
				// for le nombre de cible
				for (int i=0; i<nbre;i++){
					// Demande quelle cible (ID du joueur)
					System.out.println("Quel joueur voulez-vous cibler ?");
					int idJoueur = sc.nextInt();
					listejoueur.get(idJoueur).forcerAction(idJoueur, listejoueur.get(idJoueur).doitSacrifierCroyant, listejoueur);
				}
		}
		else if ( listejoueur.get(j) != listejoueur.get(0)){
			int nombreAleatoire = 1 + (int)(Math.random() * (listejoueur.size()-1));
				for (int i=0;i<= nombreAleatoire ; i++){
					int idJoueurAleatoire = 1 + (int)(Math.random() * (listejoueur.size() -1));
					if (listejoueur.get(idJoueurAleatoire) != listejoueur.get(j)){
						listejoueur.get(idJoueurAleatoire).forcerAction(idJoueurAleatoire, listejoueur.get(idJoueurAleatoire).doitSacrifierCroyant, listejoueur);
					}
					else{
						idJoueurAleatoire += 1;
						listejoueur.get(idJoueurAleatoire).forcerAction(idJoueurAleatoire, listejoueur.get(idJoueurAleatoire).doitSacrifierCroyant, listejoueur);
				
					}
				}
		}
		
	}

	@Override
	public void utiliserEffetDivinite(ArrayList<Joueur> listejoueur, int j, int id, ArrayList<Carte> collection,
			int croyant, int guide) {
		// TODO Auto-generated method stub
		
	}

}
