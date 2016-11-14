package main;

import java.util.ArrayList;
import java.lang.*;

public class Joueur {
	private String nom;
	private int nombreCroyant, nombreGuide;
	// On crée un attribut pour les points d'action 1: jour , 2: nuit, 3: néant
	private int[] nombrePointAction = new int [4];
	private ArrayList<Carte> main; 
	private Carte Divinite;
	
	// Constructeur par défaut
	public Joueur(){
		nom = "Joueur";
		nombreCroyant = 0;
		nombreGuide = 0;
		nombrePointAction[1]=0;
		nombrePointAction[2]=0;
		nombrePointAction[3]=0;
		main = new ArrayList<Carte>();
		
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

	public ArrayList<Carte> getMain(){
		return main;
	}
	
	public String getString(){
		return "" +this.nom ;}
	
	
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
