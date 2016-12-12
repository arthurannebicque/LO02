package main;

import java.util.ArrayList;
import java.util.Scanner;

public class Joueur {
	protected String nom;
	protected int nombreCroyantTotal, nombreGuide, carteChoisie;
	// On crée un attribut pour les points d'action 1: jour , 2: nuit, 3: néant
	protected int[] nombrePointAction = new int [4];
	protected ArrayList<Carte> main; 
	protected ArrayList<Carte> guidePossede;
	protected ArrayList<Carte> croyantPossede;
	protected Carte Divinite;
	protected double resultatDes;
	protected Scanner sc;
	
	// Etats durant pendant un tour , à la fin du tour, on les remet à false
	protected boolean stopApocalypse = false; // Un joueur ne peut peut pas poser d'Apocalypse
	protected boolean stopSacrificeGuide = false; // Un joueur ne peut pas sacrifier de guide
	protected boolean stopSacrificeCroyant = false; // Un joueur ne peut pas sacrifier un croyant
	protected boolean stopPointAction = false; // Un joueur ne gagne pas les points d'action du tour
	
	// Etats pendant le moment où le joueur doit forcer une action 
	protected boolean doitSacrifierCroyant = false;
	protected boolean doitSacrifierGuide = false;
	protected boolean doitPoserApocalypse = false;
	
	// Etats activé après un effet, jusqu'à ce qu'une action les déclenche (ex: on empêche la prochaine carte apo , si quelqu'un la joue, l'effet s'active)
	protected boolean blocageApocalypse = false;
	protected boolean blocageSacrificeGuide = false;
	
	// Etats servant à dire ce qu'on a fait
	protected boolean poserCarte = false ;
	protected boolean sacrifierCroyant = false;
	protected boolean sacrifierGuide = false;
	protected boolean utiliserDivinite = false;
	protected boolean passerTour = false;
	
	
	
	
	
	
	// Instance de comportement
	protected Strategie strategie;
	
	// Constructeur par défaut
	public Joueur(){
		nom = "Joueur";
		nombreCroyantTotal = 0; // Nombre de croyant total que possède un joueur
		nombreGuide = 0;
		nombrePointAction[1]=0;
		nombrePointAction[2]=0;
		nombrePointAction[3]=0;
		main = new ArrayList<Carte>();
		guidePossede = new ArrayList<Carte>();
		croyantPossede = new ArrayList<Carte>();
	}

	// Constructeur avec paramètres
	public Joueur( Strategie strategie){
		this.strategie = strategie;
	}

	// Redéfinit le comportement
	public void setStrategie( Strategie strategie){
		this.strategie = strategie;
	}
	
// Methode defausser Carte
	public void defausserCarte( int indice , ArrayList<Carte> deck){ // On appelera avec joueur.defausser, et en argument on mettra p.getCollection...
		deck.add(this.getMain().get(indice)); //Rajoute la carte selectionnée à la fin du deck 
		this.getMain().remove(indice);	// On enlève la carte  
		
		// on indique la carte qu'on veut defausser, ça enlève la carte de la main du joueur, et ça l'ajoute dans la collection de cartes
	}
	
// Methode lancer Dé
	
	public void lancerDe( ArrayList <Joueur> listejoueur){ // On rentre un p.listejoueur
		double resultatDe = Math.round(Math.random()*3);
		this.resultatDes = resultatDe;
		for (int i=0; i<listejoueur.size(); i++){
			if ( resultatDe >= 0 && resultatDe <1){ // Dans ce cas, on est en face Jour
				
					if ( listejoueur.get(i).getDivinite().getOrigineCarte() == 1 ){ // Si le joueur a une Divinité d'origine jour
						listejoueur.get(i).setPointAction(1,2); //On donne 2 pts jour
					
					}
					if ( listejoueur.get(i).getDivinite().getOrigineCarte() == 4){
						listejoueur.get(i).setPointAction(1,1);
					}	
				}	
			else if ( resultatDe <=1 && resultatDe <2){ // Dans ce cas, on est en face Nuit
				
					if (listejoueur.get(i).getDivinite().getOrigineCarte() == 3){
						listejoueur.get(i).setPointAction(2,2);
					}
					if (listejoueur.get(i).getDivinite().getOrigineCarte() == 5){
						listejoueur.get(i).setPointAction(2,1);
					}
			}
			else {
				
				if ( listejoueur.get(i).getDivinite().getOrigineCarte()==4 || listejoueur.get(i).getDivinite().getOrigineCarte()==5){
				listejoueur.get(i).setPointAction(3,1);
				}
			}
			
			listejoueur.get(i).resultatDes = resultatDe;
			}
	}
	
	public void poserCarteIA(int id , ArrayList<Carte> table, ArrayList<Joueur> joueurs, ArrayList<Carte> collection){
		int joueurCible;
		
		
		
		
		// Pas besoin de faire de vérifications, on fait tout au moment de choisir la carte
		if (poserCarte ==true){
		if ((this.main.get(id).identifiantCarte >=1) && (this.main.get(id).identifiantCarte<=37)){
			table.add(this.main.get(id));
			System.out.println("Le joueur " +this.getNom()+ " a posé un croyant " +this.main.get(id).identifiantCarte);
			this.main.remove(id);
			
		}
		else if ((this.main.get(id).identifiantCarte>=38) && (this.main.get(id).identifiantCarte<=57)){
			this.guidePossede.add(this.main.get(id));
			int i =0;
			while ((i< (((Guide)this.guidePossede.get(this.guidePossede.size()-1)).getCroyantRecuperable())) && (i<table.size())){
				if ((table.get(i).natureCarte1 == this.main.get(id).natureCarte2) || (table.get(i).natureCarte1 == this.main.get(id).natureCarte3)){//On fait une recherche de cartes croyants qui sont dogme 1 ou dogme 2
					// Si le dogme 1 de la carte est égale à un des dogmes du guide
						this.guidePossede.get(this.guidePossede.size()-1).croyantPossede.add(table.get(i)); //Si on en trouve on ajoute la carte au guide
						int nbreCroyant;
						nbreCroyant = ((Guide)this.guidePossede.get(this.guidePossede.size()-1)).getNombreCroyant();//On ajoute le nombre de croyant de lié au guide
						nbreCroyant = nbreCroyant + ((Croyant)table.get(i)).getCroyantDisponible();
						((Guide)this.guidePossede.get(this.guidePossede.size()-1)).setNombreCroyant(nbreCroyant);
						table.remove(i);
						i++;
						
				}
				else if ((table.get(i).natureCarte2 == this.main.get(id).natureCarte2) || (table.get(i).natureCarte2 == this.main.get(id).natureCarte3)){
					// Si le dogme 2 de la carte est égale à un des dogmes du guide
					this.guidePossede.get(this.guidePossede.size()-1).croyantPossede.add(table.get(i)); //Si on en trouve on ajoute la carte au guide
					int nbreCroyant;
					nbreCroyant = ((Guide)this.guidePossede.get(this.guidePossede.size()-1)).getNombreCroyant();//On ajoute le nombre de croyant de lié au guide
					nbreCroyant = nbreCroyant + ((Croyant)table.get(i)).getCroyantDisponible();
					((Guide)this.guidePossede.get(this.guidePossede.size()-1)).setNombreCroyant(nbreCroyant);
					table.remove(i);
					i++;
					
				}
				else if ((table.get(i).natureCarte3 == this.main.get(id).natureCarte2) || (table.get(i).natureCarte3 == this.main.get(id).natureCarte3)){
					// Si le dogme 3 de la carte est égale à un des dogmes du guide
					this.guidePossede.get(this.guidePossede.size()-1).croyantPossede.add(table.get(i)); //Si on en trouve on ajoute la carte au guide
					int nbreCroyant;
					nbreCroyant = ((Guide)this.guidePossede.get(this.guidePossede.size()-1)).getNombreCroyant();//On ajoute le nombre de croyant de lié au guide
					nbreCroyant = nbreCroyant + ((Croyant)table.get(i)).getCroyantDisponible();
					((Guide)this.guidePossede.get(this.guidePossede.size()-1)).setNombreCroyant(nbreCroyant);
					table.remove(i);
					i++;
					
				}	
				else{
			// blabla
				}
		}
			System.out.println("Le joueur " +this.getNom()+ " a posé un guide "+this.main.get(id).identifiantCarte);
			this.defausserCarte(id, collection);
	}
		else if ((this.main.get(id).identifiantCarte>=58) && (this.main.get(id).identifiantCarte<=75)){
			System.out.println("Le joueur "+this.getNom()+ " a posé un Deus ex " +this.main.get(id).identifiantCarte);
			
			// Etape pour choisir une cible si il le faut
						int min = this.nombreCroyantTotal-2;
							for (int a=0; a<joueurs.size();a++){
								if (min> joueurs.get(a).nombreCroyantTotal){
									min = joueurs.get(a).nombreCroyantTotal;
									joueurCible =a ;
							}
								
						}
			
			//this.main.get(id).utiliserEffet(joueurs, joueurCible);
			this.defausserCarte(id, collection);
		}
		else{ // alors il pose une apocalypse
			System.out.println("Le joueur "+this.getNom()+ " a posé une carte apocalypse " +this.main.get(id).identifiantCarte);
			//this.main.get(id).utiliserEffet();
			this.defausserCarte(id, collection);
		}
		
		
		this.poserCarte= false;
	}
		
	if ( this.sacrifierCroyant==true || this.sacrifierGuide == true){ // Si l'IA a choisi de sacrifier une carte
		
		// Etape pour choisir une cible si il le faut
			int min = this.nombreCroyantTotal-2;
				for (int a=0; a<joueurs.size();a++){
					if (min> joueurs.get(a).nombreCroyantTotal){
						min = joueurs.get(a).nombreCroyantTotal;
						joueurCible =a ;
				}
					
			}
		
		// On regarde quelle carte guide ou croyant il veut sacrifier 
		if (this.sacrifierCroyant==true){ // S'il veut sacrifier  un croyant

			// Etape pour choisir le croyant qu'il veut 
			for (int b=0; b<this.guidePossede.size();b++){
				if(this.guidePossede.get(b).croyantPossede.size() > 1){
				// this.guidePossede.get(b).croyantPossede.get(0).sacrifierCarte( joueurCible);
					System.out.println("Le joueur " +this.getNom()+ " a sacrifié un Croyant" +this.main.get(id).identifiantCarte);
				break; //On arrête de chercher à sacrifier, on quitte la boucle for
				
				}
			}
		this.sacrifierCroyant=false;	
		}
		
		if (this.sacrifierGuide == true){ // S'il veut sacrifier un guide
			// Etape pour choisir le guide qu'il veut
			//this.guidePossede.get(id).sacrifierCarte(joueurCible);
			System.out.println("Le joueur " +this.getNom()+ " a sacrifié un Guide " +this.main.get(id).identifiantCarte);
			this.sacrifierGuide = false;
			}
		}
	
	if (this.utiliserDivinite == true && id==100){
		//this.utiliserEffetDivinite();
		System.out.println("Le joueur " +this.getNom()+ " a utilisé effet Divinité");
	}
	
	if (this.passerTour == true && id==99){
		// Ne rien faire de son tour
		System.out.println("Le joueur " +this.getNom()+ " a passé son tour");
		this.passerTour = false;
	}
	
}
	
	
	public void poserCarte( int id, ArrayList<Carte> table , ArrayList<Carte> collection ){
	{//l'id de la main correspondant à la carte qu'on veut poser , partie on rentre collectionCarte
		if (( this.main.get(id).identifiantCarte >=1) && (this.main.get(id).identifiantCarte <=37)){// Si la carte selectionnée est un croyant , on le met sur le plateau
			table.add(this.main.get(id)); // On rajoute la carte croyant sur la table
			// On peut ajouter le nombre de croyant dispo à une variable qui les compte sur le plateau
			this.main.remove(id);// On enlève la carte de nos mains
			System.out.println("On a enlevé la carte");
			/////////// On enlève les points d'actions correspondants 
		}
		else if (( this.main.get(id).identifiantCarte >=38) && (this.main.get(id).identifiantCarte <=57)){// Si la carte selectionnée est un guide, on le met dans la liste du joueur
			this.guidePossede.add(this.main.get(id));// On ajoute la carte de guide qu'on possède
			// Le guide va rechercher sur le tableau les cartes croyantes qu'il peut recup
			int i =0;
			while ((i < (((Guide)this.guidePossede.get(this.guidePossede.size()-1)).getCroyantRecuperable())) && (i<table.size())){
				if ((table.get(i).natureCarte1 == this.main.get(id).natureCarte2) || (table.get(i).natureCarte1 == this.main.get(id).natureCarte3)){//On fait une recherche de cartes croyants qui sont dogme 1 ou dogme 2
				// Si le dogme 1 de la carte est égale à un des dogmes du guide
					this.guidePossede.get(this.guidePossede.size()-1).croyantPossede.add(table.get(i)); //Si on en trouve on ajoute la carte au guide
					int nbreCroyant;
					nbreCroyant = ((Guide)this.guidePossede.get(this.guidePossede.size()-1)).getNombreCroyant();//On ajoute le nombre de croyant de lié au guide
					nbreCroyant = nbreCroyant + ((Croyant)table.get(i)).getCroyantDisponible();
					((Guide)this.guidePossede.get(this.guidePossede.size()-1)).setNombreCroyant(nbreCroyant);
					table.remove(i);
					i++;
					
					
					//((Guide)this.guidePossede.get(this.guidePossede.size()-1)).getNombreCroyant() = ((Guide)this.guidePossede.get(this.guidePossede.size()-1)).getNombreCroyant() + ((Croyant)table.getCartePlateau().get(i)).getCroyantDisponible();
					//((Guide)this.guidePossede.get(1)).getNombreCroyant() = 1;
				}
				else if ((table.get(i).natureCarte2 == this.main.get(id).natureCarte2) || (table.get(i).natureCarte2 == this.main.get(id).natureCarte3)){
					// Si le dogme 2 de la carte est égale à un des dogmes du guide
					this.guidePossede.get(this.guidePossede.size()-1).croyantPossede.add(table.get(i)); //Si on en trouve on ajoute la carte au guide
					int nbreCroyant;
					nbreCroyant = ((Guide)this.guidePossede.get(this.guidePossede.size()-1)).getNombreCroyant();//On ajoute le nombre de croyant de lié au guide
					nbreCroyant = nbreCroyant + ((Croyant)table.get(i)).getCroyantDisponible();
					((Guide)this.guidePossede.get(this.guidePossede.size()-1)).setNombreCroyant(nbreCroyant);
					table.remove(i);
					i++;
				}
				else if ((table.get(i).natureCarte3 == this.main.get(id).natureCarte2) || (table.get(i).natureCarte3 == this.main.get(id).natureCarte3)){
					// Si le dogme 3 de la carte est égale à un des dogmes du guide
					this.guidePossede.get(this.guidePossede.size()-1).croyantPossede.add(table.get(i)); //Si on en trouve on ajoute la carte au guide
					int nbreCroyant;
					nbreCroyant = ((Guide)this.guidePossede.get(this.guidePossede.size()-1)).getNombreCroyant();//On ajoute le nombre de croyant de lié au guide
					nbreCroyant = nbreCroyant + ((Croyant)table.get(i)).getCroyantDisponible();
					((Guide)this.guidePossede.get(this.guidePossede.size()-1)).setNombreCroyant(nbreCroyant);
					table.remove(i);
					i++;
				}
				else{
					System.out.println("Il n'y a pas de croyants compatibles");
					// Dans ce cas, il n'y a pas de cartes croyants compatibles
				}
					//On répète l'opération tant qu'on a pas le nombre max de croyant ou qu'on est pas à la fin de la liste
			}
			// On enlève le guide de notre main
			this.defausserCarte(id, collection);
		}
		else if ((this.main.get(id).identifiantCarte >=58) && (this.main.get(id).identifiantCarte<=75)){ // Si la carte selectionnée est une Deus Ex
				/*	On utilise l'effet de la carte, selon son id
				 *  On retire la carte de la main
				 *  On place la carte au fond de la pile de carte
				 */
			//this.main.get(id).utiliserEffet(id); On utilise l'effet de la carte
			this.defausserCarte(id, collection); // On defausse la carte
		}
		else if ((this.main.get(id).identifiantCarte >=76) && (this.main.get(id).identifiantCarte<=80)){ // Si on veut poser une carte Apocalypse
			/* On utilise l'effet de la carte selon son id
			 * S'il ne s'est rien passé, on défausse la carte
			 * 
			 */
		//this.main.get(id).utiliserEffet(); On utilise l'effet
		// Si l'effet ne nous a pas fait stopper le jeu, la carte sera défausser dans son effet ou ici ( a voir)
		}
		else{
			// On ne veut pas poser de carte, on exit la méthode
		}
	}
	}
	
	public void sacrifierCarte(int id, ArrayList<Carte> collection, int reponse2, int reponse1, Joueur j ){
		///////// On code ici les étapes selon si c'est un croyant ou un guide
		// Si on veut sacrifier un guide
		
		if ( this.sacrifierGuide == true){   // Si le joueur veut sacrifier un guide, on a pris ce qu'il voulait
			for (int i=0; i<this.guidePossede.get(reponse1).croyantPossede.size();i++){
			// On defausse tous les croyants du guide choisi
				collection.add(this.guidePossede.get(reponse1).croyantPossede.get(i));
				this.guidePossede.get(reponse1).croyantPossede.remove(i);
				}
			// On remet à jour son nombre total de Croyants
			this.getNombreCroyantTotal();
			// Une fois sans ses croyants, on sacrifie le guide
			
			this.guidePossede.get(reponse1).utiliserEffet();
			collection.add(this.guidePossede.get(reponse1));
			this.guidePossede.remove(reponse1);
			
			this.sacrifierGuide = false;
		}
		else{ // Si on veut sacrifier un croyant
			this.guidePossede.get(reponse1).croyantPossede.get(reponse2).utiliserEffet();
			collection.add(this.guidePossede.get(reponse1).croyantPossede.get(reponse2));
			this.guidePossede.get(reponse1).croyantPossede.remove(reponse1);
			
			// On remet à jour le nombre de croyant du joueur
			this.getNombreCroyantTotal();
			
			this.sacrifierCroyant = false;
		}

	}
	// Creation d'un setter pour nommer le Joueur (Joueur 1 , 2 , 3 ...)
	
	public void utiliserEffetDivinite(){
		this.getDivinite().utiliserEffet();
	}
	
	
	public String setNom(int i){
		return nom = nom + String.valueOf(i);
	}
	
	public String getNom(){
		return nom;
	}
// Création d'un setter pour donner une Divinite
	public void  setDivinite( Carte pDivinite){
		Divinite = pDivinite;
		//int IDivinite = pDivinite.getIdentifiantCarte();
	}
	
	public void setPointAction( int indice , int valeur){
		this.nombrePointAction[indice] = this.nombrePointAction[indice] +valeur;
	}
	
	public int getNombreCroyantTotal(){
		int nombreCroyantTotal =0;
		for (int i=0; i< this.guidePossede.size();i++){
			for (int j=0; j<this.guidePossede.get(i).croyantPossede.size();j++){
				nombreCroyantTotal = nombreCroyantTotal + ((Croyant)this.guidePossede.get(i).croyantPossede.get(j)).croyantDisponible;
			}
		}
		return nombreCroyantTotal;
	}
	
	public int getNombreGuide(){
		int nombreGuide = this.guidePossede.size();
		return nombreGuide;
	}
	
	public Carte getDivinite(){
		return Divinite;
	}
	
	public String getPointsAction(){
		return "\n Vous avez "+this.nombrePointAction[1]+ " points Jour (1) \n Vous avez "+this.nombrePointAction[2]+ " points Nuit (2)\n Vous avez "+this.nombrePointAction[3]+ " points Néant (3)";
	}
	
	public boolean getUtiliserDivinite(){
		return utiliserDivinite;
	}
	
	public void setUtiliserDivinite(int i){
		if (i==0){
			this.utiliserDivinite=true;
		}
		else{
			this.utiliserDivinite=false;
	
		}
	}
	
	public boolean getPasserTour(){
		return this.passerTour;
	}
	
	public void setPasserTour(int i){
		if (i==0){
			this.passerTour=true;
		}
		else{
			this.utiliserDivinite=false;
		}
	}
	
	
	
	
	public Double getResultatDe(){
		return resultatDes;
	}
	
	public ArrayList<Carte> getGuidePossede(){
		return guidePossede;
	}

	public ArrayList<Carte> getCroyantPossede(){
		return croyantPossede;
	}
	
	public ArrayList<Carte> getMain(){
		return main;
	}
	
	public String getString(){
		return "" +this.nom ;}
	
	public String getInfosDivinite(){
		return "\n\n Nom: " +this.getDivinite().nom+ " \n Origine: "+this.getDivinite().origineCarte+ " \n Dogme1: "+ this.getDivinite().natureCarte1+ "\n Dogme2: "+this.getDivinite().natureCarte2+ "\n Dogme3: " +this.getDivinite().natureCarte3+ "\n";
	}
	
	public void forcerAction(int cible, boolean action, ArrayList<Joueur> listeJoueur){ // On rentre la boolean de l'action qu'on veut forcer
		int compteur = 0;
		if ( cible ==0){ // On s'attaque au joueur physique
			if (action == this.doitPoserApocalypse){ // Si il est forcé de poser une carte apocalypse
				for(int i=0; i<listeJoueur.get(cible).main.size();i++){
					if ( listeJoueur.get(cible).main.get(i).origineCarte>=76 && listeJoueur.get(cible).main.get(i).origineCarte<=80){
						compteur++;
					}
				}
			
			if (compteur != 0){
				System.out.println("Vous êtes forcé d'utiliser une carte apocalypse maintenant\n Posez là");
				sc = new Scanner(System.in);
				int rep = sc.nextInt();
				if (listeJoueur.get(cible).main.get(rep).origineCarte>=76 && listeJoueur.get(cible).main.get(rep).origineCarte<=80){
					//////////// Attribuer à chaque carte apocalypse, un effet de classe de son effet
					//listeJoueur.get(cible).main.get(rep).utiliserEffet(this.listeJoueur, this.tourJoueur); Pour utiliser l'effet
					}
			}
			else{
				System.out.println("Pas de carte apocalypse à sacrifier");
			}
		}
			
			
		}
		else{ // On s'attaque à un joueur virtuel
			if (action == this.doitPoserApocalypse){
				for (int i=0; i<listeJoueur.get(cible).main.size();i++){
					if (listeJoueur.get(cible).main.get(i).origineCarte >=76 && listeJoueur.get(cible).main.get(i).origineCarte<=80){
						listeJoueur.get(cible).carteChoisie = i;
					}
				}
				
				//listeJoueur.get(cible).main.get(listeJoueur.get(cible).carteChoisie).utiliserEffet(); L'effet est joué 
				
			}
		}
	}
	
	
}
