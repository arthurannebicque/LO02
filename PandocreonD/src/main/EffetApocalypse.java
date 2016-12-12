package main;

import java.util.*;

public class EffetApocalypse implements Effet {

	
public void utiliserEffet( Partie p, ArrayList<Joueur> listeJoueur, int cible, ArrayList<Carte> table, Carte carte, int j, ArrayList<Carte> collection, ArrayList<Joueur> tourJoueur ){
	/*
	 *  On regarde qui a le moins de croyant
	 * 
	 *  On ajoute les nombre de croyant de joueurs dans un tableau
	 *  On regarde une première fois, on stock dans min1
	 *  On enlève le joueur qui a moins de croyant
	 *  On regarde une deuxième fois, on stock dans min2
	 *  On compare si le min1 et le min2 est pareil
	 *   Si c'est pareil, la carte ne fait rien
	 *   Si min2 > min1 on élimine le min 1
	 *  
	 */
	
	int tabCroyants[] = new int[listeJoueur.size()-1];
	for (int i=0; i<listeJoueur.size();i++){
		tabCroyants[i]= listeJoueur.get(i).nombreCroyantTotal;
	}
	
	int min = 99;
	int min2 = 99;
	int joueur = 99;
	
	for ( int a =0; a<listeJoueur.size();a++){
		if ( tabCroyants[a]<= min){
			min = tabCroyants[a];
			joueur = a;
		}
	}
	
	tabCroyants[joueur]=99;
	
	for ( int b = 0; b<listeJoueur.size();b++){
		if (tabCroyants[b]<= min2){
			min2 = tabCroyants[b];
			
		}
	}
	
	if (min == min2){
		// Il n'y a pas de dernier, la carte n'a pas d'effet
	}
	else{ // min est donc vraiment le plus petit
		// On élimine le joueur qui a le moins de croyant 
	for (int c=0; c<listeJoueur.size();c++){ // On l'élimine de la liste des tours des joueurs
		if (listeJoueur.get(joueur).Divinite == tourJoueur.get(c).Divinite){ // En passant par les divinités, on est sûr d'éliminer le bon (car ils sont dans le désordre)
			tourJoueur.remove(c);
		}
	}
	
	listeJoueur.remove(joueur); // Puis on l'élimine dans la liste des joueurs
		
	
	}
	
	
	
	
	
	
	
}

@Override
public void utiliserEffetDivinite(ArrayList<Joueur> listejoueur, int j, int id, ArrayList<Carte> collection,
		int croyant, int guide) {
	// TODO Auto-generated method stub
	
}

	
	
	
	
	
	
	
	
	
	
}
