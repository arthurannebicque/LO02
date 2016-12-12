package main;

import java.util.ArrayList;
import java.util.*;

public class Chaos implements Strategie{

	protected int carteChoisie;
	
	public int choisirCarte(ArrayList<Joueur> joueur, int j, ArrayList<Carte> collectionCarte, ArrayList<Carte> table){
		/*
		 - Si j'ai plus d'une carte apocalypse, j'en défause n-1 ( on veut une carte pour finir les autres, puis le reste pour jouer)
		 - Si il y a des croyants possible de récuperer, je pose les guides pour les récuperer
		 - Sinon je pose les croyants en espérant que personne n'y touche
		 - Si je suis celui qui a le plus de croyant, et que j'ai une carte apocalypse, je l'utilise
		 - Si je suis celui qui a le plus de croyants sans apocalypse, ou celui qui n'en a pas le moins, je regarde mes croyants et j'en sacrifie jusqu'à ce que mon nombre 
		  de croyant tombe à celui d'un peu plus que l'avant dernier.
		 - Si un guide n'a qu'un croyant, je le sacrifie, pour les effets, je sélectionne celui qui a le plus de croyants
		 - Si je suis celui qui a le moins de croyant, j'utilise les cartes Deus Ex sur celui qui en a le moins avant moi
		 - Si mes points d'action sont bas, je passe mon tour
		*/
		this.carteChoisie=99;
		
		System.out.println("Le joueur " +joueur.get(j).getNom()+ " est un Chaos ");
		
		// Si j'ai plus d'une carte apocalypse, j'en défause n-1 (on veut une carte pour finir les autres, puis le reste pour jouer)
		int i =0;
		for ( int k=0; k<joueur.get(j).getMain().size();k++){
			if (joueur.get(j).getMain().get(k).getIdentifiantCarte()>=76 && joueur.get(j).getMain().get(k).getIdentifiantCarte()<=80 ){
				i++;
			}
		}
		
			for ( int k=0; k<joueur.get(j).getMain().size();k++){
				if (joueur.get(j).getMain().get(k).getIdentifiantCarte()>=76 && joueur.get(j).getMain().get(k).getIdentifiantCarte()<=80 && i>1){
					System.out.println("Le joueur " +joueur.get(j).getNom()+ " a défaussé la carte : " +joueur.get(j).getMain().get(k).identifiantCarte);
					joueur.get(j).defausserCarte(j,collectionCarte);
					i--;
					
				}
			}
			
			System.out.println("avant un choix "+this.carteChoisie);
		
		// Si il y a des croyants possible de récuperer, je pose les guides
			if (this.carteChoisie ==99){
			for ( int k=0; k<table.size();k++){ // On regarde tous les croyants qu'il y a sur la table
				// On regarde pour chaque guide qu'on a
				for ( int a=0; a<joueur.get(j).getMain().size();a++){
					if ( joueur.get(j).getMain().get(a).getIdentifiantCarte() >=38 && joueur.get(j).getMain().get(a).getIdentifiantCarte() <=57 ){
						if (joueur.get(j).getMain().get(a).natureCarte2 == table.get(k).natureCarte1 || joueur.get(j).getMain().get(a).natureCarte3 == table.get(k).natureCarte1){
							if (joueur.get(j).nombrePointAction[joueur.get(j).getMain().get(a).origineCarte] !=0){ // On regarde si on a assez de points d'action de l'origine de la carte
								joueur.get(j).poserCarte = true;
								this.carteChoisie = a;
								
							}
							else if (joueur.get(j).getMain().get(a).origineCarte ==3){
								if ( joueur.get(j).nombrePointAction[1]>=2){
									joueur.get(j).poserCarte = true;
									this.carteChoisie = a;
								}
								else if (joueur.get(j).nombrePointAction[2]>=2){
									joueur.get(j).poserCarte = true;
									this.carteChoisie = a;
								}
								else{
									// Pas de points action
								}
							}
							else{
								// La carteChoisie va rester à 99
							}
							
							
						}
						else if (joueur.get(j).getMain().get(a).natureCarte2 == table.get(k).natureCarte2 || joueur.get(j).getMain().get(a).natureCarte3 == table.get(k).natureCarte2){
							if (joueur.get(j).nombrePointAction[joueur.get(j).getMain().get(a).origineCarte] !=0){ // On regarde si on a assez de points d'action de l'origine de la carte
								joueur.get(j).poserCarte = true;
								this.carteChoisie = a;
								}
								else if (joueur.get(j).getMain().get(a).origineCarte ==3){
									if ( joueur.get(j).nombrePointAction[1]>=2){
										joueur.get(j).poserCarte = true;
										this.carteChoisie = a;
									}
									else if (joueur.get(j).nombrePointAction[2]>=2){
										joueur.get(j).poserCarte = true;
										this.carteChoisie = a;
									}
									else{
										// Pas de points action
									}
								}
								else{
									// La carteChoisie va rester à 99
								}
							}
						else if (joueur.get(j).getMain().get(a).natureCarte2 == table.get(k).natureCarte3 || joueur.get(j).getMain().get(a).natureCarte3 == table.get(k).natureCarte3){
							if (joueur.get(j).nombrePointAction[joueur.get(j).getMain().get(a).origineCarte] !=0){ // On regarde si on a assez de points d'action de l'origine de la carte
								joueur.get(j).poserCarte = true;
								this.carteChoisie = a;
								}
								else if (joueur.get(j).getMain().get(a).origineCarte ==3){
									if ( joueur.get(j).nombrePointAction[1]>=2){
										joueur.get(j).poserCarte = true;
										this.carteChoisie = a;
									}
									else if (joueur.get(j).nombrePointAction[2]>=2){
										joueur.get(j).poserCarte = true;
										this.carteChoisie = a;
									}
									else{
										// Pas de points action
									}
								}
								else{
									// La carteChoisie va rester à 99
								}
							}
						else {
						}
							// Il n'y a pas de cartes compatible
						}
						
					}	
				}
			}
			
			System.out.println("après poser un guide "+this.carteChoisie);
		
		//Sinon je pose les croyants en espérant que personne n'y touche
			if (this.carteChoisie==99){
			for (int k=0; k<joueur.get(j).getMain().size() ; k++){
				if ( joueur.get(j).getMain().get(k).identifiantCarte >=1 && joueur.get(j).getMain().get(k).identifiantCarte <=37){
					if (joueur.get(j).nombrePointAction[joueur.get(j).getMain().get(k).origineCarte] != 0){ // Si on a des points correspondants à l'origine
						joueur.get(j).poserCarte = true;
						this.carteChoisie = k;
					}
					else if (joueur.get(j).getMain().get(k).origineCarte ==3){
						if ( joueur.get(j).nombrePointAction[1]>=2){
							joueur.get(j).poserCarte = true;
							this.carteChoisie = k;
						}
						else if (joueur.get(j).nombrePointAction[2]>=2){
							joueur.get(j).poserCarte = true;
							this.carteChoisie = k;
						}
						else{
							// Pas de points action
						}
					}
					else{
						// La carte reste à 99
					}
					
				}  
			}
		
			}
			
			System.out.println("après poser un croyant "+this.carteChoisie);
			
		// Si je suis celui qui n'a pas le moins de croyants avec apocalypse, je l'utilise
		if (this.carteChoisie==99){
			for (int k=0; k<joueur.get(j).getMain().size();k++){
			if ( joueur.get(j).getMain().get(k).identifiantCarte >=76 && joueur.get(j).getMain().get(k).identifiantCarte <=80 ){
				// On fait un for pour repérer celui qui a le moins de croyants
				int min = joueur.get(j).getNombreCroyantTotal();
				for (int a=0; a<joueur.size();a++){
					if (min > joueur.get(a).getNombreCroyantTotal()){
						min = joueur.get(a).getNombreCroyantTotal();
					}
				}
				
				if ( min != joueur.get(j).getNombreCroyantTotal()){ // On regarde si on est pas dernier 
					if ( joueur.get(j).getMain().get(k).origineCarte==0){
						joueur.get(j).poserCarte = true;
						this.carteChoisie = k;
					}
					else if ( joueur.get(j).nombrePointAction[joueur.get(j).getMain().get(k).origineCarte] !=0){
						joueur.get(j).poserCarte = true;
						this.carteChoisie = k;
					}
					else if ( joueur.get(j).nombrePointAction[joueur.get(j).getMain().get(k).origineCarte] ==3){
							if ( joueur.get(j).nombrePointAction[1]>=2){
								joueur.get(j).poserCarte = true;
								this.carteChoisie = k;
							}
							else if (joueur.get(j).nombrePointAction[2]>=2){
								joueur.get(j).poserCarte = true;
								this.carteChoisie = k;
							}
							else{
								// Pas de points action
							    }
					}
					else{
							// La carteChoisie reste à 99
					}
				
						}
			
					}
			}
		}
		
		System.out.println("après utiliser apocalypse "+this.carteChoisie);
		///////////////////// Mettre un boolen au cas où il veut sacrifier ou utiliser
		// Sinon, si j'en ai pas, je regarde un de mes croyants que je sacrifie (jusqu'à ce qu'il m'en reste 1, puis je sacrifie le guide) si le sacrifice me permet toujours d'être avant dernier
		// On regarde si son nombre de croyant n'est pas nul
		// On regarde si le sacrifice d'un croyant ( disons 2) , me permet de rester dans la course
		
		if (this.carteChoisie ==99){
		if (joueur.get(j).getNombreCroyantTotal() != 0){
			int min = joueur.get(j).getNombreCroyantTotal()-2;
				for (int a=0; a<joueur.size(); a++){
					if (min > joueur.get(a).getNombreCroyantTotal()){
						min = joueur.get(a).getNombreCroyantTotal();
					}
				}
		
				if ( min != joueur.get(j).getNombreCroyantTotal()){ // On ne sera pas dernier si on perd 2 croyants
				// On va regarder la taille des croyants possédés du guide 1 , si elle est à 1 on sacrifie le guide, si >1 , on sacrifie un croyant
				for(int b=0; b<joueur.get(j).guidePossede.size();b++){
					if (joueur.get(j).guidePossede.get(b).croyantPossede.size() == 1){
						joueur.get(j).sacrifierGuide = true;
						this.carteChoisie = b;				
						// Boolean qui indique qu'on veut sacrifier un guide
					}
					else if (joueur.get(j).guidePossede.get(b).croyantPossede.size() >1){
						joueur.get(j).sacrifierCroyant = true;
						this.carteChoisie = 0;
						// Boolean qui indique qu'on veut sacrifier un croyant
					}
					else{
						// 
					}	
				}
			}
		
	}
		
		}
		System.out.println("après sacrifice " +this.carteChoisie);
		
		// Pour cibler quelqu'un, si je suis dernier je cible l'avant dernier, sinon je cible le premier ( A faire dans poserCarteIA)
		
		// Si je suis le dernier, j'utilise les cartes Deus Ex sur celui qui a un nombre supérieur avant moi
		if (this.carteChoisie ==99){
		int min = joueur.get(j).getNombreCroyantTotal();
		for (int a=0; a<joueur.size();a++){
			if (min > joueur.get(a).getNombreCroyantTotal()){
				min = joueur.get(a).getNombreCroyantTotal();
			}
		}
		
		/////// On code la cible dans poserCarte
		if (min == joueur.get(j).getNombreCroyantTotal()){
			for ( int k=0 ; k<joueur.get(j).getMain().size();k++){
				if ( joueur.get(j).getMain().get(k).identifiantCarte >=58 && joueur.get(j).getMain().get(k).identifiantCarte <=75){
					if ( joueur.get(j).getMain().get(k).origineCarte==0){
						joueur.get(j).poserCarte = true;
						this.carteChoisie = k;
						}
						else if ( joueur.get(j).nombrePointAction[joueur.get(j).getMain().get(k).origineCarte] !=0){
						joueur.get(j).poserCarte = true;
						this.carteChoisie = k;
						}
						else if ( joueur.get(j).nombrePointAction[joueur.get(j).getMain().get(k).origineCarte] ==3){
							if ( joueur.get(j).nombrePointAction[1]>=2){
								joueur.get(j).poserCarte = true;
								this.carteChoisie = k;
							}
							else if (joueur.get(j).nombrePointAction[2]>=2){
								joueur.get(j).poserCarte = true;
								this.carteChoisie = k;
							}
							else{
								// Pas de points action
							}
						}
					}
				}
		}
		}
		
		System.out.println("après deus ex " +this.carteChoisie);
		
		if (this.carteChoisie ==99 && joueur.get(j).getUtiliserDivinite()==false){
			double nombreAleatoire = Math.round(Math.random()*5);
			if ( nombreAleatoire>=0 && nombreAleatoire<=(1/5)){
				joueur.get(j).setUtiliserDivinite(0);
			this.carteChoisie=100;
			// On utilis l'effet Divinité 
			}
			// On va décider d'utiliser l'effet Divinité
		// Faire un random, avec une faible proba d'utiliser l'effet Divinité
		// Avec un boolean qui indique qu'il veut être utilisé

		}
		
		System.out.println("après divinité "+this.carteChoisie);
		if (this.carteChoisie ==99){
			joueur.get(j).setPasserTour(0); 
			
			// On va décider de sauter son tour
		}
		
		System.out.println("après passer tour "+this.carteChoisie);
		return this.carteChoisie;
		}
}
