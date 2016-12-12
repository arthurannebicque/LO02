package main;

import java.util.*;
public class Effet58 extends DeusEx {

	public void utiliserEffet(Partie p , int cible, ArrayList<Carte> table){ // Détruit des guides spirituels, et remet les croyants au centre
		if (this.identifiantCarte==58){
			// On regarde les guides possédés du joueur cible
			// Si un guide est d'origine Nuit
			// On remet tous ses croyants sur la table
			// On remove la carte guide
			int fois = 1;
			for (int i=0; i<p.listeJoueur.get(cible).guidePossede.size();i++){
				if (p.listeJoueur.get(cible).guidePossede.get(i).origineCarte==3 || p.listeJoueur.get(cible).guidePossede.get(i).origineCarte==2 && fois==1){
					for ( int j=0; j<p.listeJoueur.get(cible).guidePossede.get(i).croyantPossede.size() && fois==1;j++){
						table.add(p.listeJoueur.get(cible).guidePossede.get(i).croyantPossede.get(j));
						p.listeJoueur.get(cible).guidePossede.get(i).croyantPossede.remove(j);
						
						// On met à jour son nombre de croyants du joueur
						p.listeJoueur.get(cible).getNombreCroyantTotal();
						fois++;
					}
				}
			}
		}
		else if (this.identifiantCarte ==59){
			// On regarde les guides possédés du joueur cible
			// Si un guide est d'origine Nuit
			// On remet tous ses croyants sur la table
			// On remove la carte guide
			int fois = 1;
			for (int i=0; i<p.listeJoueur.get(cible).guidePossede.size();i++){
				if (p.listeJoueur.get(cible).guidePossede.get(i).origineCarte==3 || p.listeJoueur.get(cible).guidePossede.get(i).origineCarte==1 && fois==1){
					for ( int j=0; j<p.listeJoueur.get(cible).guidePossede.get(i).croyantPossede.size() && fois==1;j++){
						table.add(p.listeJoueur.get(cible).guidePossede.get(i).croyantPossede.get(j));
						p.listeJoueur.get(cible).guidePossede.get(i).croyantPossede.remove(j);
						
						// On met à jour son nombre de croyants du joueur
						p.listeJoueur.get(cible).getNombreCroyantTotal();
						fois++;
					}
				}
			}
		}
		

	}
	
}
