package main;

import java.util.ArrayList;

public class Drinded implements Effet {

public void utiliserEffetDivinite( ArrayList<Joueur> listejoueur, int j, int id, ArrayList<Carte> collection, int croyant, int guide ){ // Peut empêcher le sacrifice d'un guide à n'importe quel joueur
	// On active une boolean en arrière plan, lorsque quelqu'un veut sacrifier un guide, si l'effet de la carte est activé, on rappelle l'effet pour qu'il annule le sacrifice
	if (listejoueur.get(0).blocageSacrificeGuide == false){
		for (int i=0;i<=listejoueur.size();i++){
			listejoueur.get(i).blocageSacrificeGuide=true;
		}
	}
	else{
		// On enlève le guide qu'il veut sacrifier, et remet ses croyants dans le deck
		// D'abord on enlève tous ses croyants
		for (int c=0; c<listejoueur.get(j).guidePossede.get(guide).croyantPossede.size();c++){
		collection.add(listejoueur.get(j).guidePossede.get(croyant).croyantPossede.get(c));
		listejoueur.get(j).guidePossede.get(croyant).croyantPossede.remove(c);
		}
		
		// On remet à jour son nombre total de croyant
		listejoueur.get(j).getNombreCroyantTotal();
		// Une fois sans ses croyants, on enlève le guide
		
		collection.add(listejoueur.get(j).guidePossede.get(croyant));
		listejoueur.get(j).guidePossede.remove(croyant);
		listejoueur.get(j).blocageSacrificeGuide = false;
		
	}





}

@Override
public void utiliserEffet(Partie p, ArrayList<Joueur> listejoueur, int cible, ArrayList<Carte> table, Carte carte,
		int j, ArrayList<Carte> collection, ArrayList<Joueur> tourjoueur) {
	// TODO Auto-generated method stub
	
}
	
}
