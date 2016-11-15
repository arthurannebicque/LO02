package main;

public class Carte extends Joueur{
	private int identifiantCarte;
	private int origineCarte;
	private int natureCarte1, natureCarte2, natureCarte3;
	private int croyantPosable , croyantRecuperable;
	private String nom;
	
	// 0:aucun, 1:nature , 2: chaos , 3: symboles , 4: mystique, 5: humain
	// 0: aucune, 1: jour , 2: néant, 3: nuit 4: aube 5: crépuscule 
	
	// Constructeur par défaut
	public Carte(){
		identifiantCarte=0;
		origineCarte=0;
		natureCarte1=0;
		natureCarte2=0;
		natureCarte3=0;
		croyantPosable=0;
		croyantRecuperable=0;
		nom="";
		
		
	}

	// Constructeur de la classe Carte
	public Carte(String pnom, int pid, int porigine, int pdogme1 , int pdogme2, int pdogme3, int pcroyantPosable, int pcroyantRecuperable){
		this.nom = pnom;
		this.identifiantCarte = pid;
		this.origineCarte = porigine;
		this.natureCarte1 = pdogme1;
		this.natureCarte2 = pdogme2;
		this.natureCarte3 = pdogme3;
		this.croyantPosable=pcroyantPosable;
		this.croyantRecuperable=pcroyantRecuperable;
	}
	
	public String decrisToi(){
		
		return "\n Origine : " +this.origineCarte+ " \n Dogme 1 : " +this.natureCarte1+ "\n Dogme 2 :  " +this.natureCarte2+ "\n Dogme 3 : " +this.natureCarte3;
	}
	
	//Creation d'un getter pour récuperer l'identifiant
	public int getIdentifiantCarte() {
		return identifiantCarte;
	}

	// Création d'un setter pour changer l'identifiant
	public void setIdentifiantCarte(int id){
			identifiantCarte = id;
	}
	
	public int getNatureCarte1(){ 
		return natureCarte1;
	}
	public int getNatureCarte2(){ 
		return natureCarte2;
	}
	public int getNatureCarte3(){ 
		return natureCarte3;
	}
	// Création d'un setter pour changer les infos de la carte
	public void setNatureCarte1( int valeur){
			natureCarte1=valeur;
	}
	
	public void setNatureCarte2( int valeur){
		natureCarte2=valeur;
}
	
	public void setNatureCarte3( int valeur){
		natureCarte3=valeur;
}
	
	public int getOrigineCarte(){
		return origineCarte;
	}
	
	public void setOrigineCarte (int id){
			origineCarte=id;
	}
	
	
}
