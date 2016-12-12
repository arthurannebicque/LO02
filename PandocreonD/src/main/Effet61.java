package main;

import java.util.*;
public class Effet61 extends DeusEx{

	public void utiliserEffet(ArrayList<Joueur> listeJoueur , int cible){ // R�cupere un des guides spirituel pos� devant une divinit�
		// On regarde si le nombre de guide de la cible > 0 , si c'est le cas
		// On ajoute � notre liste de guide, le 1er guide de l'adversaire
		// On met � jour notre nombre de croyant
		if (listeJoueur.get(cible).guidePossede.size()>0){
			this.guidePossede.add(listeJoueur.get(cible).guidePossede.get(0));
			for(int i =0; i<listeJoueur.get(cible).guidePossede.get(0).croyantPossede.size();i++){
				this.guidePossede.get(this.guidePossede.size()-1).croyantPossede.add(listeJoueur.get(cible).guidePossede.get(0).croyantPossede.get(i));	
				listeJoueur.get(cible).guidePossede.get(0).croyantPossede.remove(i);	
			}
			listeJoueur.get(cible).guidePossede.remove(0);
			
			// On met � jour le nombre de croyant
			this.getNombreCroyantTotal();
			listeJoueur.get(cible).getNombreCroyantTotal();
			
		}
		else{
			System.out.println("Aucun guide � prendre");
		}
		
		
		
		
	}
}
