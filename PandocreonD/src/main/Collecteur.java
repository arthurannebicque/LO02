package main;
import java.util.*;

public class Collecteur implements Strategie{
	
	protected int carteChoisie;
	
	public int choisirCarte(ArrayList<Joueur> joueur, int j, ArrayList<Carte> collectionCarte, ArrayList<Carte> table){
		/*
		( Faire un boolean sur une carte croyant qui fait que quand on la pose, on peut pas la récuperer directe, 
				et quand on la récupère, on ne peut pas la sacrifier directe, même chose avec un guide qu'on pose)
				* - Je défausse toutes les cartes Deus Ex que j'ai, je garde les autres
				* - Si il y a des croyants possible de récuperer, je pose les guides pour les récuperer. 
				* - Sinon , je pose mes croyants sur la table en esperant que personne n'y touche
				* - Si je suis celui qui a le plus de croyant , et que j'ai une carte apocalypse, je l'utilise
				* - Sinon j'utilise une carte Deus Ex au hasard, pour m'en débarasser
				* - Si mes points d'action sont bas, je passe mon tour
		
		*/
		
		this.carteChoisie=99;
		
		System.out.println("Le joueur " +joueur.get(j).getNom()+ " est un Collecteur ");
		
		for ( int k=0; k <joueur.get(j).getMain().size();k++ ){ // On regarde dans notre main, si on a des cartes Deux Ex, on les défausse
			if ( joueur.get(j).getMain().get(k).getIdentifiantCarte() >=58 && joueur.get(j).getMain().get(k).getIdentifiantCarte()<=75){
				System.out.println("Le joueur " +joueur.get(j).getNom()+ " a défaussé la carte : " +joueur.get(j).getMain().get(k).identifiantCarte);
				joueur.get(j).defausserCarte(j, collectionCarte);
				
			}
		}

		// Si il y a des croyants possible de récupérer, je pose les guides
		if (this.carteChoisie==99){
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
						}
					else {
					}
						// Il n'y a pas de cartes compatible
					}
					
				}	
			}
		}
		
		if (this.carteChoisie==99){
		// Si il n'y a pas de croyants à récuperer, on pose des croyants
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
				
			}
		}
		}
		
		
		if (this.carteChoisie ==99){
		// Si je suis celui qui a le plus de croyants, et que j'ai une carte apocalypse, je l'utilise
		for ( int k=0; k<joueur.get(j).getMain().size();k++){
			if ( joueur.get(j).getMain().get(k).identifiantCarte >= 76 && joueur.get(j).getMain().get(k).identifiantCarte <=80){
				// On fait un for pour repérer celui qui a le plus de croyants
				int max = joueur.get(j).getNombreCroyantTotal();
				for (int a=0; a<joueur.size(); a++){
					if ( max < joueur.get(a).getNombreCroyantTotal()){
						max = joueur.get(a).getNombreCroyantTotal();
					}
				}
				
				if ( max == joueur.get(j).getNombreCroyantTotal()){ // On va vouloir poser la carte apocalypse car on en a le plus
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
			else{
				// On a pas de carte Apocalypse
			}
			
		}
		}
		
		if (this.carteChoisie==99){
		// Si je peux rien faire en haut, je regarde si j'ai des carte Deus Ex, et je les utilise 
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
		

		if (this.carteChoisie == 99 && joueur.get(j).getUtiliserDivinite()==false){
			
			double nombreAleatoire = Math.round(Math.random()*5);
			if ( nombreAleatoire>=0 && nombreAleatoire<=(1/5)){
				joueur.get(j).setUtiliserDivinite(0);
			this.carteChoisie=100;
			// On utilis l'effet Divinité 
			}
		}
		
		System.out.println(+this.carteChoisie);
		if (this.carteChoisie==99){
			joueur.get(j).setPasserTour(0); 
			// On va décider de sauter son tour
		}	
		
		
		return this.carteChoisie;
}
	
}
