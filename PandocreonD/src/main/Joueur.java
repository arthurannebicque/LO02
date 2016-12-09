package main;

import java.util.ArrayList;

public class Joueur implements Strategie {
	protected String nom;
	protected int nombreCroyantTotal, nombreGuide;
	// On cr�e un attribut pour les points d'action 1: jour , 2: nuit, 3: n�ant
	protected int[] nombrePointAction = new int [4];
	protected ArrayList<Carte> main; 
	protected ArrayList<Carte> guidePossede;
	protected ArrayList<Carte> croyantPossede;
	protected Carte Divinite;
	protected double resultatDes;
	
	protected boolean stopApocalypse = false; // Emp�che de poser une carte apocalypse
	boolean stopSacrificeGuide = false; //Emp�che de sacrifier une carte Guide
	boolean stopSacrificeCroyant = false;
	boolean sacrifierCroyant = false;
	boolean sacrifierGuide = false;
	boolean stopPointAction = false;
	
	// Constructeur par d�faut
	public Joueur(){
		nom = "Joueur";
		nombreCroyantTotal = 0; // Nombre de croyant total que poss�de un joueur
		nombreGuide = 0;
		nombrePointAction[1]=0;
		nombrePointAction[2]=0;
		nombrePointAction[3]=0;
		main = new ArrayList<Carte>();
		guidePossede = new ArrayList<Carte>();
		croyantPossede = new ArrayList<Carte>();
		
		
	}

// Methode defausser Carte
	public void defausserCarte( int indice , ArrayList<Carte> deck){ // On appelera avec joueur.defausser, et en argument on mettra p.getCollection...
		deck.add(this.getMain().get(indice)); //Rajoute la carte selectionn�e � la fin du deck 
		this.getMain().remove(indice);	// On enl�ve la carte  
		
		// on indique la carte qu'on veut defausser, �a enl�ve la carte de la main du joueur, et �a l'ajoute dans la collection de cartes
	}
	
// Methode lancer D�
	
	public void lancerDe( ArrayList <Joueur> listejoueur){ // On rentre un p.listejoueur
		double resultatDe = Math.round(Math.random()*3);
		resultatDes = resultatDe;
		for (int i=0; i<listejoueur.size(); i++){
			if ( resultatDe >= 0 && resultatDe <1){ // Dans ce cas, on est en face Jour
				
					if ( listejoueur.get(i).getDivinite().getOrigineCarte() == 1 ){ // Si le joueur a une Divinit� d'origine jour
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
		
	public void poserCarte( int id, ArrayList<Carte> table , ArrayList<Carte> collection ){
	{//l'id de la main correspondant � la carte qu'on veut poser , partie on rentre collectionCarte
		if (( this.main.get(id).identifiantCarte >=1) && (this.main.get(id).identifiantCarte <=37)){// Si la carte selectionn�e est un croyant , on le met sur le plateau
			table.add(this.main.get(id)); // On rajoute la carte croyant sur la table
			// On peut ajouter le nombre de croyant dispo � une variable qui les compte sur le plateau
			this.main.remove(id);// On enl�ve la carte de nos mains
			System.out.println("On a enlev� la carte");
			/////////// On enl�ve les points d'actions correspondants 
		}
		else if (( this.main.get(id).identifiantCarte >=38) && (this.main.get(id).identifiantCarte <=57)){// Si la carte selectionn�e est un guide, on le met dans la liste du joueur
			this.guidePossede.add(this.main.get(id));// On ajoute la carte de guide qu'on poss�de
			// Le guide va rechercher sur le tableau les cartes croyantes qu'il peut recup
			int i =0;
			while ((i < (((Guide)this.guidePossede.get(this.guidePossede.size()-1)).getCroyantRecuperable())) && (i<table.size())){
				if ((table.get(i).natureCarte1 == this.main.get(id).natureCarte2) || (table.get(i).natureCarte1 == this.main.get(id).natureCarte3)){//On fait une recherche de cartes croyants qui sont dogme 1 ou dogme 2
				// Si le dogme 1 de la carte est �gale � un des dogmes du guide
					this.guidePossede.get(this.guidePossede.size()-1).croyantPossede.add(table.get(i)); //Si on en trouve on ajoute la carte au guide
					int nbreCroyant;
					nbreCroyant = ((Guide)this.guidePossede.get(this.guidePossede.size()-1)).getNombreCroyant();//On ajoute le nombre de croyant de li� au guide
					nbreCroyant = nbreCroyant + ((Croyant)table.get(i)).getCroyantDisponible();
					((Guide)this.guidePossede.get(this.guidePossede.size()-1)).setNombreCroyant(nbreCroyant);
					table.remove(i);
					i++;
					
					
					//((Guide)this.guidePossede.get(this.guidePossede.size()-1)).getNombreCroyant() = ((Guide)this.guidePossede.get(this.guidePossede.size()-1)).getNombreCroyant() + ((Croyant)table.getCartePlateau().get(i)).getCroyantDisponible();
					//((Guide)this.guidePossede.get(1)).getNombreCroyant() = 1;
				}
				else if ((table.get(i).natureCarte2 == this.main.get(id).natureCarte2) || (table.get(i).natureCarte2 == this.main.get(id).natureCarte3)){
					// Si le dogme 2 de la carte est �gale � un des dogmes du guide
					this.guidePossede.get(this.guidePossede.size()-1).croyantPossede.add(table.get(i)); //Si on en trouve on ajoute la carte au guide
					int nbreCroyant;
					nbreCroyant = ((Guide)this.guidePossede.get(this.guidePossede.size()-1)).getNombreCroyant();//On ajoute le nombre de croyant de li� au guide
					nbreCroyant = nbreCroyant + ((Croyant)table.get(i)).getCroyantDisponible();
					((Guide)this.guidePossede.get(this.guidePossede.size()-1)).setNombreCroyant(nbreCroyant);
					table.remove(i);
					i++;
				}
				else if ((table.get(i).natureCarte3 == this.main.get(id).natureCarte2) || (table.get(i).natureCarte3 == this.main.get(id).natureCarte3)){
					// Si le dogme 3 de la carte est �gale � un des dogmes du guide
					this.guidePossede.get(this.guidePossede.size()-1).croyantPossede.add(table.get(i)); //Si on en trouve on ajoute la carte au guide
					int nbreCroyant;
					nbreCroyant = ((Guide)this.guidePossede.get(this.guidePossede.size()-1)).getNombreCroyant();//On ajoute le nombre de croyant de li� au guide
					nbreCroyant = nbreCroyant + ((Croyant)table.get(i)).getCroyantDisponible();
					((Guide)this.guidePossede.get(this.guidePossede.size()-1)).setNombreCroyant(nbreCroyant);
					table.remove(i);
					i++;
				}
				else{
					System.out.println("Il n'y a pas de croyants compatibles");
					// Dans ce cas, il n'y a pas de cartes croyants compatibles
				}
					//On r�p�te l'op�ration tant qu'on a pas le nombre max de croyant ou qu'on est pas � la fin de la liste
			}
		}
		else if ((this.main.get(id).identifiantCarte >=58) && (this.main.get(id).identifiantCarte<=75)){ // Si la carte selectionn�e est une Deus Ex
				/*	On utilise l'effet de la carte, selon son id
				 *  On retire la carte de la main
				 *  On place la carte au fond de la pile de carte
				 */
			//this.main.get(id).utiliserEffet(id); On utilise l'effet de la carte
			this.defausserCarte(id, collection); // On defausse la carte
		}
		else if ((this.main.get(id).identifiantCarte >=76) && (this.main.get(id).identifiantCarte<=80)){ // Si on veut poser une carte Apocalypse
			/* On utilise l'effet de la carte selon son id
			 * S'il ne s'est rien pass�, on d�fausse la carte
			 * 
			 */
		//this.main.get(id).utiliserEffet(); On utilise l'effet
		// Si l'effet ne nous a pas fait stopper le jeu, la carte sera d�fausser dans son effet ou ici ( a voir)
		}
		else{
			// On ne veut pas poser de carte, on exit la m�thode
		}
	}
	}
	
	public void sacrifierCarte(int id, Partie p){
		this.main.get(id).utiliserEffet();
		this.defausserCarte(id, p.getcollectionCarte());
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
// Cr�ation d'un setter pour donner une Divinite
	public void  setDivinite( Carte pDivinite){
		Divinite = pDivinite;
		//int IDivinite = pDivinite.getIdentifiantCarte();
	}
	
	public void setPointAction( int indice , int valeur){
		if (stopPointAction == false) {
		this.nombrePointAction[indice] = this.nombrePointAction[indice] +valeur;
		}
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
		return "\n Vous avez "+this.nombrePointAction[1]+ " points Jour (1) \n Vous avez "+this.nombrePointAction[2]+ " points Nuit (2)\n Vous avez "+this.nombrePointAction[3]+ " points N�ant (3)";
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
	
	public void forcerAction() {
		//Si ID du joueur cible est 0 -> Joueur physique
	
			//premièreboucle pour regarder s'il a un croyant => boolean true
				//Si oui demandez quelle croyant
				//Le joueur choisi  sa carte qu'il veut sacrifier
				//utiliserEffet() avec l'ID de cette carte
		//SI ID =! de 0 -> Joueur virtuel
			//premièreboucle pour regarder s'il a un croyant => boolean true
			//utiliserEffet() avec la première carte croyant
		
		
	}
	
	/*
	 public String getPointsAction( ArrayList<Joueur> a){
		for (int i =1; i <=3; i++){
			String 
			return "Jour " +a.get(0).nombrePointAction[i];
		}
		
	}
	*/



}
// Setter nombre de Guide
// Setter nombre de Croyants
