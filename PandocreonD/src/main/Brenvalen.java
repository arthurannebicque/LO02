package main;

import java.util.*;
public class Brenvalen implements Effet {

@Override
public void utiliserEffet(Partie p, ArrayList<Joueur> listejoueur, int cible, ArrayList<Carte> table, Carte carte,
		int j, ArrayList<Carte> collection, ArrayList<Joueur> tourjoueur) {
	// TODO Auto-generated method stub
	
}


@Override
public void utiliserEffetDivinite(ArrayList<Joueur> listejoueur, int j, int id, ArrayList<Carte> collection,
		int croyant, int guide) {
	 // Peut empêcher l'utilisation d'une carte Apocalypse
		// On active une boolean en arrière plan, lors qu'on pose une carte, si l'effet est activé on réappelle l'effet pour qu'il annule l'apocalypse
		/*if ( p.blocageApocalypse == false){
		/p.blocageApocalypse =true;
		}
		else{
			joueur.get(j).defausserCarte(id, collection);
			p.blocageApocalypse = false;	
		}
		
		
		 */
	
}
	
}
