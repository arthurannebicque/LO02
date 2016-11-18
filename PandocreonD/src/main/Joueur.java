package main;

import java.util.ArrayList;
import java.lang.*;

public class Joueur {
	protected String nom;
	protected int nombreCroyant, nombreGuide;
	// On crée un attribut pour les points d'action 1: jour , 2: nuit, 3: néant
	protected int[] nombrePointAction = new int [4];
	protected ArrayList<Carte> main; 
	protected ArrayList<Carte> guidePossede;
	protected ArrayList<Carte> croyantPossede;
	protected Carte Divinite;
	
	protected boolean stopApocalypse = false; // Empêche de poser une carte apocalypse
	boolean stopSacrificeGuide = false; //Empêche de sacrifier une carte Guide
	
	// Constructeur par défaut
	public Joueur(){
		nom = "Joueur";
		nombreCroyant = 0;
		nombreGuide = 0;
		nombrePointAction[1]=0;
		nombrePointAction[2]=0;
		nombrePointAction[3]=0;
		main = new ArrayList<Carte>();
		guidePossede = new ArrayList<Carte>();
		croyantPossede = new ArrayList<Carte>();
		
	}

// Methode poser Carte
// Methode defausser Carte
	public void defausserCarte( int indice , ArrayList<Carte> deck){ // On appelera avec joueur.defausser, et en argument on mettra p.getCollection...
		deck.add(this.getMain().get(indice)); //Rajoute la carte selectionnée à la fin du deck 
		this.getMain().remove(indice);	// On enlève la carte  
		
		// on indique la carte qu'on veut defausser, ça enlève la carte de la main du joueur, et ça l'ajoute dans la collection de cartes
	}
	
// Methode lancer Dé
	
	public void lancerDe( ArrayList <Joueur> listejoueur){ // On rentre un p.listejoueur
		double resultatDe = Math.random();
		int num = listejoueur.size();
		for (int i=0; i<num; i++){
			if ( resultatDe >= 0 && resultatDe <(1/3)){ // Dans ce cas, on est en face Jour
					if ( listejoueur.get(i).getDivinite().getOrigineCarte() == 1 ){ // Si le joueur a une Divinité d'origine jour
						listejoueur.get(i).setPointAction(1,2); //On donne 2 pts jour
					}
					if ( listejoueur.get(i).getDivinite().getOrigineCarte() == 4){
						listejoueur.get(i).setPointAction(1,1);
					}	
				}	
			else if ( resultatDe <=(1/3) && resultatDe <(2/3)){ // Dans ce cas, on est en face Nuit
					if (listejoueur.get(i).getDivinite().getOrigineCarte() == 3){
						listejoueur.get(i).setPointAction(2,2);
					}
					if (listejoueur.get(i).getDivinite().getOrigineCarte() == 5){
						listejoueur.get(i).setPointAction(2,1);
					}
			}
			else {
				listejoueur.get(i).setPointAction(3,1);
			}
			}
	}
		
		
	// Methode poser carte à terminer avec Deus Ex et Apocalypse
	public void poserCarte( int id , Plateau table){ // On entre joueur.main. et l'id de la main qu'on veut
		if ((this.main.get(id).identifiantCarte >=1) && (this.main.get(id).identifiantCarte <= 37)){// Si la carte selectionnée est un croyant , on le met sur le plateau
			table.getCartePlateau().add(this.main.get(id)); // On rajoute la carte croyant sur la table
			// On ajoute le nombre de croyant dispo à une variable qui les compte dans plateau
			this.main.remove(id); // On enlève la carte de nos mains
		}
		else if ((this.main.get(id).identifiantCarte >=38) && (this.main.get(id).identifiantCarte <=57 )){ // Si la carte selectionnée est un guide, on le met dans la liste du joueur
			this.guidePossede.add(this.main.get(id)); // On ajoute la carte de guide qu'on possède
		// Le guide va rechercher sur le tableau les cartes croyantes qu'il peut recup

			int i=0;
			while (i<this.guidePossede.get(this.guidePossede.size()-1).croyantPossede.size() && i<table.getCartePlateau().size()){ //On répète l'opération tant qu'on a pas le nombre max de croyant ou qu'on est pas à la fin de la liste
				if ((table.getCartePlateau().get(i).natureCarte1 == this.main.get(id).natureCarte2 ) || (table.getCartePlateau().get(i).natureCarte1 == this.main.get(id).natureCarte3)){ //On fait une recherche de cartes croyants qui sont dogme 1 ou dogme 2
					// Si le dogme 1 de la carte est égale à un des dogmes du guide
					this.guidePossede.get(this.guidePossede.size()-1).croyantPossede.add(table.getCartePlateau().get(i));//Si on en trouve on ajoute la carte au guide
					this.guidePossede.get(this.guidePossede.size()-1).nombreCroyant = this.guidePossede.get(this.guidePossede.size()-1).nombreCroyant + table.getCartePlateau().get(i).croyantPosable; //On ajoute le nombre de croyant de lié au guide
					table.getCartePlateau().remove(i); //On enlève la carte de la liste de la table
					i++;
					}
				else if ((table.getCartePlateau().get(i).natureCarte2 == this.main.get(id).natureCarte2 ) || (table.getCartePlateau().get(i).natureCarte2 == this.main.get(id).natureCarte3)){
					// Si le dogme 2 de la carte est égale à un des dogmes du guide
					this.guidePossede.get(this.guidePossede.size()-1).croyantPossede.add(table.getCartePlateau().get(i));
					this.guidePossede.get(this.guidePossede.size()-1).nombreCroyant = this.guidePossede.get(this.guidePossede.size()-1).nombreCroyant + table.getCartePlateau().get(i).croyantPosable;
					table.getCartePlateau().remove(i);
					i++;
					}
				else if ((table.getCartePlateau().get(i).natureCarte3 == this.main.get(id).natureCarte2 ) || (table.getCartePlateau().get(i).natureCarte3 == this.main.get(id).natureCarte3)){
					// Si le dogme 3 de la carte est égale à un des dogmes du guide
					this.guidePossede.get(this.guidePossede.size()-1).croyantPossede.add(table.getCartePlateau().get(i));
					this.guidePossede.get(this.guidePossede.size()-1).nombreCroyant = this.guidePossede.get(this.guidePossede.size()-1).nombreCroyant + table.getCartePlateau().get(i).croyantPosable;
					table.getCartePlateau().remove(i);
					i++;
				}
			}
		}
		else { // Si cest une carte Deus Ex 
			// Si c'est une carte apocalypse
		}
	}
	
	// Creation d'un setter pour nommer le Joueur (Joueur 1 , 2 , 3 ...)
	public String setNom(int i){
		return nom = nom + String.valueOf(i);
	}
	
// Création d'un setter pour donner une Divinite
	public void  setDivinite( Carte pDivinite){
		Divinite = pDivinite;
		//int IDivinite = pDivinite.getIdentifiantCarte();
	}
	
	public void setPointAction( int indice , int valeur){
		this.nombrePointAction[indice] = nombrePointAction[indice]+valeur;
	}
	
	public Carte getDivinite(){ // Type à revérifier
		return Divinite;
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
