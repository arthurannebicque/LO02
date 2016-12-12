package main;

import java.util.*;

public class Romtec extends Divinite { // On empeche un joueur de poser sa carte Guide

	public void utiliserEffetDivinite( Partie p, ArrayList<Joueur> listejoueur, int cible, int carteChoisie){ // Peut emêcher un joueur de créer un guide spirituel
		if (listejoueur.get(cible).stopSacrificeGuide==false){
			listejoueur.get(cible).stopSacrificeGuide=true;	
		}
		else{
			//On prends la carte guide qu'il veut poser, on la remove
			p.collectionCarte.add(listejoueur.get(cible).main.get(carteChoisie));
			listejoueur.get(cible).main.remove(carteChoisie);
			
		}
		
	}
}
