package main;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;



public class Partie{
	
	int nombre,nombre2, nombreJoueur;
	protected Divinite carteDivinite;
	protected Apocalypse carteApocalypse;
	protected DeusEx carteDeusEx;
	protected Croyant carteCroyant;
	protected Guide carteGuide;
	protected Joueur player;
	protected ArrayList<Carte> collectionCarte;
	protected ArrayList<Carte> collectionCarteDivinite;
	protected ArrayList<Joueur> listeJoueur;
	protected ArrayList<Joueur> tourJoueur;
	protected ArrayList<Carte> cartePlateau;
	
	protected Scanner sc;
	private boolean partieTermine = false;
	
	protected boolean doitSacrifierCarte = false; // Oblige à sacrifier une carte
	protected boolean doitSacrifierGuide = false; // Oblige à sacrifier un guide
	
	protected boolean doitPoserApocalypse = false; // Oblige à poser une carte apocalypse
	
	protected boolean stopSacrificeGuide = false; //Empêche de sacrifier une carte Guide
	protected boolean stopApocalypse = false; // Empêche de poser une carte apocalypse
	
	protected boolean interdiePointAction = false; //Autorise ou pas les points d'actions
	protected boolean effetDivinite = false; // Dit si un effet divinité a déjà été utilisé ou pas
	
	protected boolean choixJoueur = false;
	
	
	
	//Constructeur par défaut
	public Partie(){
		
	}
	
	public ArrayList<Carte> getCollectionCarte(){
		return collectionCarte;
	}
	
	// Méthode pour remplir le deck des cartes action et divinités
	public void creerDeck(){
		
		// On crée une liste de carte, qui sera la pioche des cartes actions
		collectionCarte = new ArrayList<Carte>();
		// On crée une liste de carte, qui sera la pioche des cartes divinités
		collectionCarteDivinite = new ArrayList<Carte>();
		//System.out.println("La méthode a été lancée");
		carteDivinite = new Divinite();
		carteApocalypse = new Apocalypse();
		carteDeusEx = new DeusEx();
		carteCroyant = new Croyant();
		carteGuide = new Guide();
		
		
		

		carteCroyant = new Croyant("Moines",1,1,4,1,5,1);
		Effet effet1 = new Effet1();
		carteCroyant.setEffet(effet1);
		collectionCarte.add(carteCroyant);
		
		carteCroyant = new Croyant("Moines",2,1,2,5,4,2);
		carteCroyant.setEffet(effet1);
		collectionCarte.add(carteCroyant);
		
		carteCroyant = new Croyant("Moines",3,1,2,4,3,2);
		carteCroyant.setEffet(effet1);
		collectionCarte.add(carteCroyant);
		
		carteCroyant = new Croyant("Moines",4,1,3,1,4,2);
		carteCroyant.setEffet(effet1);
		collectionCarte.add(carteCroyant);
		
		carteCroyant = new Croyant("Moines",5,1,2,1,4,2);
		carteCroyant.setEffet(effet1);
		collectionCarte.add(carteCroyant);
		
		carteCroyant = new Croyant("Travailleurs",6,1,2,5,3,2);
		Effet effet2 = new Effet2();
		carteCroyant.setEffet(effet2);
		collectionCarte.add(carteCroyant);
		
		carteCroyant = new Croyant("Travailleurs",7,1,3,1,5,2);
		carteCroyant.setEffet(effet2);
		collectionCarte.add(carteCroyant);
		
		carteCroyant = new Croyant("Travailleurs",8,1,2,5,4,2);
		Effet effet3 = new Effet3();
		carteCroyant.setEffet(effet3);
		collectionCarte.add(carteCroyant);
		
		carteCroyant = new Croyant("Ermite",9,1,2,5,4,1);
		Effet effet4 = new Effet4();
		carteCroyant.setEffet(effet4);
		collectionCarte.add(carteCroyant);
		
		carteCroyant = new Croyant("Ermite",10,1,3,1,4,1);
		carteCroyant.setEffet(effet4);
		collectionCarte.add(carteCroyant);
		
		carteCroyant = new Croyant("Integriste",11,1,2,1,5,1);
		carteCroyant.setEffet(effet4);
		collectionCarte.add(carteCroyant);
		
		carteCroyant = new Croyant("Guerriers Saints",12,1,3,1,5,4);
		Effet effet5 = new Effet5();
		carteCroyant.setEffet(effet5);
		collectionCarte.add(carteCroyant);
		
		carteCroyant = new Croyant("Diplomates",13,1,2,5,3,4);
		Effet effet6 = new Effet6();
		carteCroyant.setEffet(effet6);
		collectionCarte.add(carteCroyant);
		
		carteCroyant = new Croyant("Demons",14,3,4,1,5,2);
		carteCroyant.setEffet(effet1);
		collectionCarte.add(carteCroyant);
		
		carteCroyant = new Croyant("Demons",15,3,2,5,4,2);
		carteCroyant.setEffet(effet1);
		collectionCarte.add(carteCroyant);
		
		carteCroyant = new Croyant("Demons",16,3,2,4,3,2);
		carteCroyant.setEffet(effet1);
		collectionCarte.add(carteCroyant);
		
		carteCroyant = new Croyant("Demons",17,3,3,1,4,2);
		carteCroyant.setEffet(effet1);
		collectionCarte.add(carteCroyant);
		
		carteCroyant = new Croyant("Demons",18,3,2,1,4,2);
		carteCroyant.setEffet(effet1);
		collectionCarte.add(carteCroyant);
		
		carteCroyant = new Croyant("Alchimistes",19,3,2,1,3,2);
		carteCroyant.setEffet(effet2);
		collectionCarte.add(carteCroyant);
		
		carteCroyant = new Croyant("Alchimistes",20,3,2,1,4,2);
		carteCroyant.setEffet(effet2);
		collectionCarte.add(carteCroyant);
		
		carteCroyant = new Croyant("Alchimistes",21,3,2,1,3,2);
		carteCroyant.setEffet(effet3);
		collectionCarte.add(carteCroyant);
		
		carteCroyant = new Croyant("Vampire",22,3,3,1,5,1);
		carteCroyant.setEffet(effet4);
		collectionCarte.add(carteCroyant);
		
		carteCroyant = new Croyant("Vampire",23,3,2,5,4,1);
		carteCroyant.setEffet(effet4);
		collectionCarte.add(carteCroyant);
		
		carteCroyant = new Croyant("Lycanthropes",24,3,2,1,5,4);
		Effet effet7 = new Effet7();
		carteCroyant.setEffet(effet7);
		collectionCarte.add(carteCroyant);
		
		carteCroyant = new Croyant("Pillards",25,3,3,1,4,4);
		Effet effet11 = new Effet11();
		carteCroyant.setEffet(effet11);
		collectionCarte.add(carteCroyant);
		
		carteCroyant = new Croyant("Illusionnistes",26,3,2,5,3,4);
		Effet effet8 = new Effet8();
		carteCroyant.setEffet(effet8);
		collectionCarte.add(carteCroyant);
		
		carteCroyant = new Croyant("Esprits",27,2,4,1,5,2);
		carteCroyant.setEffet(effet1);
		collectionCarte.add(carteCroyant);
		
		carteCroyant = new Croyant("Esprits",28,2,2,5,4,2);
		carteCroyant.setEffet(effet1);
		collectionCarte.add(carteCroyant);
		
		carteCroyant = new Croyant("Esprits",29,2,2,4,3,2);
		carteCroyant.setEffet(effet1);
		collectionCarte.add(carteCroyant);
		
		carteCroyant = new Croyant("Esprits",30,2,3,1,4,2);
		carteCroyant.setEffet(effet1);
		collectionCarte.add(carteCroyant);
		
		carteCroyant = new Croyant("Esprits",31,2,2,1,4,2);
		carteCroyant.setEffet(effet1);
		collectionCarte.add(carteCroyant);
		
		carteCroyant = new Croyant("Alienes",32,2,2,5,3,2);
		carteCroyant.setEffet(effet2);
		collectionCarte.add(carteCroyant);
		
		carteCroyant = new Croyant("Alienes",33,2,3,1,5,2);
		carteCroyant.setEffet(effet2);
		collectionCarte.add(carteCroyant);
		
		carteCroyant = new Croyant("Alienes",34,2,2,5,4,2);
		carteCroyant.setEffet(effet3);
		collectionCarte.add(carteCroyant);
		
		carteCroyant = new Croyant("Revenant",35,2,4,1,5,1);
		carteCroyant.setEffet(effet6);
		collectionCarte.add(carteCroyant);
		
		carteCroyant = new Croyant("Revolutionnaires",36,2,2,5,3,2);
		Effet effet9 = new Effet9();
		carteCroyant.setEffet(effet9);
		collectionCarte.add(carteCroyant);
		
		carteCroyant = new Croyant("Nihillistes",37,2,2,4,3,4);
		Effet effet10 = new Effet10();
		carteCroyant.setEffet(effet10);
		collectionCarte.add(carteCroyant);
		
		carteGuide = new Guide("Martyr",38,1,0,5,1,2);
		Effet apocalypse = new EffetApocalypse();
		carteGuide.setEffet(apocalypse);
		collectionCarte.add(carteGuide);
		
		carteGuide = new Guide("Martyr",39,3,0,3,5,2);
		carteGuide.setEffet(apocalypse);
		collectionCarte.add(carteGuide);
		
		carteGuide = new Guide("Martyr",40,2,0,2,1,2);
		carteGuide.setEffet(apocalypse);
		collectionCarte.add(carteGuide);
		
		carteGuide = new Guide("Clerc",41,1,0,2,5,2);
		Effet effet12 = new Effet12();
		carteGuide.setEffet(effet12);
		collectionCarte.add(carteGuide);
		
		carteGuide = new Guide("Clerc",42,3,0,3,1,2);
		carteGuide.setEffet(effet12);
		collectionCarte.add(carteGuide);
		
		carteGuide = new Guide("Clerc",43,2,0,4,1,2);
		carteGuide.setEffet(effet12);
		collectionCarte.add(carteGuide);
		
		carteGuide = new Guide("Clerc",44,1,0,2,1,2);
		carteGuide.setEffet(effet12);
		collectionCarte.add(carteGuide);
		
		carteGuide = new Guide("Clerc",45,3,0,3,4,2);
		carteGuide.setEffet(effet12);
		collectionCarte.add(carteGuide);
		
		carteGuide = new Guide("Clerc",46,2,0,4,3,2);
		carteGuide.setEffet(effet12);
		collectionCarte.add(carteGuide);
		
		carteGuide = new Guide("Clerc",47,1,0,2,4,2);
		carteGuide.setEffet(effet12);
		collectionCarte.add(carteGuide);
		
		carteGuide = new Guide("Clerc",48,3,0,5,1,2);
		carteGuide.setEffet(effet12);
		collectionCarte.add(carteGuide);
		
		carteGuide = new Guide("Shaman",49,3,0,3,1,3);
		Effet effet13 = new Effet13();
		carteGuide.setEffet(effet13);
		collectionCarte.add(carteGuide);
		
		carteGuide = new Guide("Anarchiste",50,2,0,2,5,3);
		Effet effet14 = new Effet14();
		carteGuide.setEffet(effet14);
		collectionCarte.add(carteGuide);
		
		carteGuide = new Guide("Paladin",51,1,0,4,5,3);
		Effet effet15 = new Effet15();
		carteGuide.setEffet(effet15);
		collectionCarte.add(carteGuide);
		
		carteGuide = new Guide("Ascete",52,3,0,3,5,1);
		Effet effet16 = new Effet16();
		carteGuide.setEffet(effet16);
		collectionCarte.add(carteGuide);
		
		carteGuide = new Guide("Devin",53,2,0,4,1,1);
		Effet effet17 = new Effet17();
		carteGuide.setEffet(effet17);
		collectionCarte.add(carteGuide);
		
		carteGuide = new Guide("Exorciste",54,1,0,2,4,1);
		Effet effet18 = new Effet18();
		carteGuide.setEffet(effet18);
		collectionCarte.add(carteGuide);
		
		carteGuide = new Guide("Sorcier",55,3,0,3,4,3);
		collectionCarte.add(carteGuide);
		
		carteGuide = new Guide("Tyran",56,2,0,2,3,3);
		Effet effet20 = new Effet20();
		carteGuide.setEffet(effet20);
		collectionCarte.add(carteGuide);
		
		carteGuide = new Guide("Messie",57,1,0,4,5,3);
		collectionCarte.add(carteGuide);
		
		carteDeusEx = new DeusEx("Colere Divine",58,1,0,0,0);
		collectionCarte.add(carteDeusEx);
		
		carteDeusEx = new DeusEx("Colere Divinie",59,3,0,0,0);
		collectionCarte.add(carteDeusEx);
		
		carteDeusEx = new DeusEx("Stase",60,1,0,0,0);
		collectionCarte.add(carteDeusEx);
		
		carteDeusEx = new DeusEx("Ordre Celeste",61,1,0,0,0);
		collectionCarte.add(carteDeusEx);
		
		carteDeusEx = new DeusEx("Fourberie",62,3,0,0,0);
		collectionCarte.add(carteDeusEx);
		
		carteDeusEx = new DeusEx("Diversion",63,3,0,0,0);
		collectionCarte.add(carteDeusEx);
		
		carteDeusEx = new DeusEx("Concentration",64,2,0,0,0);
		collectionCarte.add(carteDeusEx);
		
		carteDeusEx = new DeusEx("Trou Noir",65,2,0,0,0);
		Effet effet22 = new Effet22();
		carteDeusEx.setEffet(effet22);
		collectionCarte.add(carteDeusEx);
		
		carteDeusEx = new DeusEx("Phoenix",66,2,0,0,0);
		collectionCarte.add(carteDeusEx);
		
		carteDeusEx = new DeusEx("Influence Jour",67,0,0,0,0);
		collectionCarte.add(carteDeusEx);
		
		carteDeusEx = new DeusEx("Influence Nuit",68,0,0,0,0);
		collectionCarte.add(carteDeusEx);
		
		carteDeusEx = new DeusEx("Influence Neant",69,0,0,0,0);
		collectionCarte.add(carteDeusEx);
		
		carteDeusEx = new DeusEx("Influence Nulle",70,0,0,0,0);
		collectionCarte.add(carteDeusEx);
		
		carteDeusEx= new DeusEx("Influence Nulle",71,0,0,0,0);
		collectionCarte.add(carteDeusEx);
		
		carteDeusEx = new DeusEx("Transe",72,0,0,0,0);
		collectionCarte.add(carteDeusEx);
		
		carteDeusEx = new DeusEx("Miroir",73,0,0,0,0);
		collectionCarte.add(carteDeusEx);
		
		carteDeusEx = new DeusEx("Bouleversement",74,0,0,0,0);
		collectionCarte.add(carteDeusEx);
		
		carteDeusEx = new DeusEx("Inquisition",75,0,0,0,0);
		collectionCarte.add(carteDeusEx);
		
		carteApocalypse = new Apocalypse("Apocalypse",76,1,0,0,0);
		carteApocalypse.setEffet(apocalypse);
		collectionCarte.add(carteApocalypse);
		
		carteApocalypse = new Apocalypse("Apocalypse",77,3,0,0,0);
		carteApocalypse.setEffet(apocalypse);
		collectionCarte.add(carteApocalypse);
		
		carteApocalypse = new Apocalypse("Apocalypse",78,2,0,0,0);
		carteApocalypse.setEffet(apocalypse);
		collectionCarte.add(carteApocalypse);
		
		carteApocalypse = new Apocalypse("Apocalypse",79,0,0,0,0);
		carteApocalypse.setEffet(apocalypse);
		collectionCarte.add(carteApocalypse);
		
		carteApocalypse = new Apocalypse("Apocalypse",80,0,0,0,0);
		carteApocalypse.setEffet(apocalypse);
		collectionCarte.add(carteApocalypse);
		
		
		// Création d'une carte avec ses attributs et son effet
		carteDivinite = new Divinite ("Brenvalen",81,1,1,5,4);
		Effet effet = new Brenvalen();
		carteDivinite.setEffet(effet);
		collectionCarteDivinite.add(carteDivinite);
		
		carteDivinite = new Divinite("Drinded",82,1,1,5,3);
		Effet drinded = new Drinded();
		carteDivinite.setEffet(drinded);
		collectionCarteDivinite.add(carteDivinite);
		
		carteDivinite = new Divinite("Yarstur",83,1,2,3,4);
		collectionCarteDivinite.add(carteDivinite);
		
		carteDivinite = new Divinite("Killinstred",84,3,1,4,2);
		collectionCarteDivinite.add(carteDivinite);
		
		carteDivinite = new Divinite("Llenvella",85,3,1,4,2);
		collectionCarteDivinite.add(carteDivinite);
		
		carteDivinite = new Divinite("Pui-Tara",86,3,1,4,3);
		collectionCarteDivinite.add(carteDivinite);
		
		carteDivinite = new Divinite("Gnvenghelen",87,4,5,4,3);
		collectionCarteDivinite.add(carteDivinite);
		
		carteDivinite = new Divinite("Shingva",88,4,5,4,2);
		collectionCarteDivinite.add(carteDivinite);
		
		carteDivinite = new Divinite("Gorpa",89,5,5,3,2);
		collectionCarteDivinite.add(carteDivinite);
		
		carteDivinite = new Divinite("Romtec",90,5,1,5,2);
		collectionCarteDivinite.add(carteDivinite);
		
	}

	
	public void demarrerPartie(){
		
		System.out.println(" Pandocreon Divinae \n Combien de joueur ?");
		sc = new Scanner(System.in);
		String reponse = sc.nextLine();
		int rep = Integer.parseInt(reponse); // On transforme la réponse en int
		System.out.println("Initialisation de la partie\n\n");
		
		
		this.creerDeck();
		this.melangerDeck();
		this.creerListeJoueur(rep);
		this.distribuerDivinite();
		cartePlateau = new ArrayList<Carte>();
		
				
		System.out.println("Vous etes le joueur " +this.listeJoueur.get(0).getString());
		System.out.println("Vous avez eu la carte divinité: \n" +this.listeJoueur.get(0).getInfosDivinite());
		System.out.println("Aide :");
		System.out.println("Origines : 1 = Jour, 2 = Néant, 3 = Nuit, 4 = Aube, 5 = Crépuscule");
		System.out.println("Dogmes : 1 = Nature, 2 = Chaos, 3 = Symboles, 4 = Mystique, 5 = Humain");
		 System.out.println("Types de Carte : 1 - 37 = Croyants, 38 - 57 = Guide Spirituel, 58 - 75 = Deus Ex, 76 - 80 = Apocalypse\n");
		int nbreTour=1;
		
		
		/***************************************************************************************************
		****************************************************************************************************
		************************************ PARTIE COMMENCE ICI *******************************************
		****************************************************************************************************
		****************************************************************************************************/
		
		while ( partieTermine == false){
		
		choixJoueur = false;	
		
		this.distribuerCarte();		
		System.out.println("Vous avez les cartes:\n ");
		
		for (int i=0; i<7 ; i++){
		System.out.printf("\nPosition dans votre main : "+(i)+ " - Identifiant de la carte : " +this.listeJoueur.get(0).main.get(i).getIdentifiantCarte()+ "\n");
		System.out.println(this.listeJoueur.get(0).main.get(i).getInfosCarte());
		}
		
		// Rajouter une boucle pour chaque joueur
		System.out.println("\n Combien de carte voulez vous defausser ? (entre 1 et 7 dans l'ordre)");
		int nbre = sc.nextInt();
		int i=0;
		int c = 0, temp=7;
		while (i < nbre){
			System.out.println("Quelle carte ?");
			int crte = sc.nextInt();
				if (crte > temp){
					c++;
					this.listeJoueur.get(0).defausserCarte(crte-c, this.getCollectionCarte());	
					temp = crte;
					}
				else{
					this.listeJoueur.get(0).defausserCarte(crte-c, this.getCollectionCarte());
					temp = crte;
					}
			this.distribuerCarte();
			i++;
		}
		
		System.out.println("Vous avez les cartes:\n ");
	
		for (int j=0; j<this.listeJoueur.get(0).main.size() ; j++){
			System.out.printf("\nPosition dans votre main : "+(j)+ " - Identifiant de la carte : " +this.listeJoueur.get(0).main.get(j).getIdentifiantCarte()+ "\n");
			System.out.println(this.listeJoueur.get(0).main.get(j).getInfosCarte());
		}		
		
		// Le premier à jouer lance le dé
		this.tourJoueur.get(0).lancerDe(this.listeJoueur);
		System.out.println("\n/// Tour : " +nbreTour+ " ///");
		System.out.println("/// Infos: "+this.tourJoueur.get(0).getNom()+ " lance le dé ///\n");
		if (this.listeJoueur.get(0).resultatDes>=0 && this.listeJoueur.get(0).resultatDes<1){
			System.out.println("\n Influence: Jour ! \n Les divinités d'origine Jour gagnent 2 points action  Jour (1)! \n Les divinités d'origine Aube gagnent 1 point d'action Jour (1)!");
		}
		else if (this.listeJoueur.get(0).resultatDes<=1 && this.listeJoueur.get(0).resultatDes<2){
			System.out.println("\n Influence: Nuit ! \n Les divinités d'origine Nuit gagnent 2 points action Nuit (2) ! \n Les divinités d'origine Crépuscule gagnent 1 point d'action Nuit (2)  !");
		}
		else{
			System.out.println("\n Influence: Néant ! \n Les divinités d'origine Aube gagnent 1 point action Neant (3)! \n Les divinités d'origine Crépuscule gagnent 1 point d'action Néant");
		}
		
		System.out.println("/// Sur le plateau, il y a " +this.cartePlateau.size()+ " cartes croyants : ");
		 for (i=0; i<this.cartePlateau.size(); i++){
		 System.out.println("\nPosition : "+(i)+ " - Identifiant de la carte : " +this.cartePlateau.get(i).getIdentifiantCarte());
		 System.out.println(this.cartePlateau.get(i).getInfosCarte());
		 }
		
		// On indique combien chaque joueur a de guide et de croyants
		for ( int n=0; n<listeJoueur.size();n++){
			System.out.println("/// Le "+this.listeJoueur.get(n).getNom()+ " a "+this.listeJoueur.get(n).getNombreCroyantTotal()+ " croyants et " +this.listeJoueur.get(n).getNombreGuide()+ " guides///");
			for ( i=0; i<listeJoueur.get(n).guidePossede.size(); i++){
				 System.out.println("\n Guide : Position : "+(i)+ " - Identifiant de la carte : " +this.listeJoueur.get(n).guidePossede.get(i).getIdentifiantCarte()+ "\n");
				  System.out.println(this.listeJoueur.get(n).guidePossede.get(i).getInfosCarte());
				 for (int j=0;j<listeJoueur.get(n).guidePossede.get(i).croyantPossede.size();j++){
				 		System.out.println("\n Croyant: Position : "+(j)+ " - Identifiant de la carte : " +this.listeJoueur.get(n).guidePossede.get(i).croyantPossede.get(j).getIdentifiantCarte()+ "\n");
				 		System.out.println(this.listeJoueur.get(n).guidePossede.get(i).croyantPossede.get(j).getInfosCarte());
				 	}
				 
				
				 }
		}
		
		System.out.println(this.listeJoueur.get(0).getPointsAction());
		
		////////////////////////////////////////////////////////////////////////////////////////////
		// On fait jouer chaque joueur
		///////////////////////////////////////////////////////////////////////////////////////////
		
		
		
		for (int j=0; j<tourJoueur.size();j++){
			if (this.tourJoueur.get(j)== this.listeJoueur.get(0)){
				System.out.println("\n\n A votre tour !");
				while ( choixJoueur == false){
				System.out.println("\n Que voulez-vous faire ?\n - Jouer une carte (1)\n - Sacrifier une carte (2)\n - Utiliser effet divinité (3)\n - Passer mon tour (4)");
				nbre = sc.nextInt();
				
				switch (nbre){
				case 1:  // Si on choisi 1, on veut jouer une carte
					if (doitSacrifierCarte==false && doitSacrifierGuide==false){ // On peut le faire si: on est pas obligé de sacrifier, ni de sacrifier un guide
						System.out.println("Quelle carte voulez-vous jouer ?");
						rep = sc.nextInt();
						if ((this.listeJoueur.get(0).main.get(rep).getIdentifiantCarte()>=1 && this.listeJoueur.get(0).main.get(rep).getIdentifiantCarte()<=37) && doitPoserApocalypse==false){ // Si on est pas obligé de poser une apocalypse, et on a 1 pts d'action d'origine que la carte
							if (this.listeJoueur.get(0).nombrePointAction[this.listeJoueur.get(0).main.get(rep).origineCarte] !=0){ // Si on a des points correspondants à l'origine de la carte, on peut la jouer
								this.listeJoueur.get(0).setPointAction(this.listeJoueur.get(0).main.get(rep).origineCarte,-1);
								this.listeJoueur.get(0).poserCarte(rep, this.cartePlateau, this.getCollectionCarte());
								choixJoueur = true;
							
							}
							else if(this.listeJoueur.get(0).main.get(rep).origineCarte ==3){ // Si on a une carte d'origine Néant
								if(this.listeJoueur.get(0).nombrePointAction[1]>=2){ // On regarde si on a assez de point d'action Jour
									this.listeJoueur.get(0).setPointAction(1, -2); // Si c'est le cas, on en retire 2
									this.listeJoueur.get(0).poserCarte(rep,this.cartePlateau, this.getCollectionCarte()); // On pose la carte
									choixJoueur = true;
								}
								else if ( this.listeJoueur.get(0).nombrePointAction[2]>=2){ // On regarde si on a assez de point d'action Nuit
									this.listeJoueur.get(0).setPointAction(2, -2); // Si c'est le cas, on en retire 2
									this.listeJoueur.get(0).poserCarte(rep, this.cartePlateau, this.getCollectionCarte()); // On pose la carte
									choixJoueur = true;
								}
								else{
									System.out.println("Vous n'avez pas assez de point d'actions");
									// Pas assez de points d'action, on refait un choix
								}
							}
							else{
								System.out.println("Vous n'avez pas assez de point d'action");
								// On a pas assez de points d'actions, on revient au choix
							}
						}
						else if ((this.listeJoueur.get(0).main.get(rep).getIdentifiantCarte()>=38 && this.listeJoueur.get(0).main.get(rep).getIdentifiantCarte()<=57) && doitPoserApocalypse==false){ // Si on est pas obligé de poser une apocalypse, et on a 1 pts d'action d'origine que la carte
							if (this.listeJoueur.get(0).nombrePointAction[this.listeJoueur.get(0).main.get(rep).origineCarte] !=0){ // Si on a des points correspondants à l'origine de la carte, on peut la jouer
								this.listeJoueur.get(0).setPointAction(this.listeJoueur.get(0).main.get(rep).origineCarte,-1);
								this.listeJoueur.get(0).poserCarte(rep, this.cartePlateau, this.getCollectionCarte());
								choixJoueur = true;
							
							}
							else if(this.listeJoueur.get(0).main.get(rep).origineCarte ==3){ // Si on a une carte d'origine Néant
								if(this.listeJoueur.get(0).nombrePointAction[1]>=2){ // On regarde si on a assez de point d'action Jour
									this.listeJoueur.get(0).setPointAction(1, -2); // Si c'est le cas, on en retire 2
									this.listeJoueur.get(0).poserCarte(rep,this.cartePlateau, this.getCollectionCarte()); // On pose la carte
									choixJoueur = true;
								}
								else if ( this.listeJoueur.get(0).nombrePointAction[2]>=2){ // On regarde si on a assez de point d'action Nuit
									this.listeJoueur.get(0).setPointAction(2, -2); // Si c'est le cas, on en retire 2
									this.listeJoueur.get(0).poserCarte(rep, this.cartePlateau, this.getCollectionCarte()); // On pose la carte
									choixJoueur = true;
								}
								else{
									System.out.println("Vous n'avez pas assez de points d'action");
									// Pas assez de points d'action, on refait un choix
								}
							}
							else{
								System.out.println("Vous n'avez pas assez de points d'action");
								// On a pas assez de points d'actions, on revient au choix
							}
						}
						else if((this.listeJoueur.get(0).main.get(rep).getIdentifiantCarte()>=58 && this.listeJoueur.get(0).main.get(rep).getIdentifiantCarte()<=75) && doitPoserApocalypse==false){ // Si c'est une carte Deus Ex et on est pas obligé de poser une apocalypse
							if (this.listeJoueur.get(0).main.get(rep).origineCarte ==0){
								this.listeJoueur.get(0).poserCarte(rep, this.cartePlateau, this.getCollectionCarte());
								choixJoueur = true;
							}
							else if (this.listeJoueur.get(0).nombrePointAction[this.listeJoueur.get(0).main.get(rep).origineCarte] !=0){ // Si on a des points correspondants à l'origine de la carte, on peut la jouer
								this.listeJoueur.get(0).setPointAction(this.listeJoueur.get(0).main.get(rep).origineCarte,-1);
								this.listeJoueur.get(0).poserCarte(rep, this.cartePlateau, this.getCollectionCarte());
								choixJoueur = true;
							
							}
							else if(this.listeJoueur.get(0).main.get(rep).origineCarte ==3){ // Si on a une carte d'origine Néant
								if(this.listeJoueur.get(0).nombrePointAction[1]>=2){ // On regarde si on a assez de point d'action Jour
									this.listeJoueur.get(0).setPointAction(1, -2); // Si c'est le cas, on en retire 2
									this.listeJoueur.get(0).poserCarte(rep,this.cartePlateau, this.getCollectionCarte()); // On pose la carte
									choixJoueur = true;
								}
								else if ( this.listeJoueur.get(0).nombrePointAction[2]>=2){ // On regarde si on a assez de point d'action Nuit
									this.listeJoueur.get(0).setPointAction(2, -2); // Si c'est le cas, on en retire 2
									this.listeJoueur.get(0).poserCarte(rep, this.cartePlateau, this.getCollectionCarte()); // On pose la carte
									choixJoueur = true;
								}
								else{
									// Pas assez de points d'action, on refait un choix
								}
							
						}
							else{
								// Pas assez de points d'action, on refait un choix
							}
					}
						else{
							// Pas assez de points d'action, on refait un choix
						}
					}
					break;
				case 2: // Si on choisi 2, on veut sacrifier une carte
					if (doitPoserApocalypse == false){ // Si on est pas obligé de poser une carte apocalypse, /!\ PAS OBLIGER D'UTILISER EFFET DIVINITE /!\
						System.out.println("Voulez-vous sacrifier un croyant (1) ou un guide (2) ?");
						rep = sc.nextInt();
						if ( rep == 1){
							// On affiche la liste des guides et leur croyants
							for ( i=0; i<listeJoueur.get(0).guidePossede.size(); i++){
							System.out.println("\nPosition : "+(i)+ " - Identifiant de la carte : " +this.listeJoueur.get(0).guidePossede.get(i).getIdentifiantCarte()+ "\n");
							System.out.println(this.listeJoueur.get(0).guidePossede.get(i).getInfosCarte());
							}
						
							System.out.println("Selectionnez le guide du croyant");
							rep = sc.nextInt();
							// On affiche les croyants suivi par le guide (rep)
							System.out.println("Selectionnez le croyant");
							int rep2=100;
							rep2 = sc.nextInt();
							this.listeJoueur.get(0).sacrifierGuide=true;
							this.listeJoueur.get(0).sacrifierCarte(this.listeJoueur.get(0).guidePossede.get(rep).croyantPossede.get(rep2).identifiantCarte, this.collectionCarte, rep2, rep, this.listeJoueur.get(0));
							choixJoueur = true;
						}
						else if( rep == 2){
							// On affiche la liste des guides et leurs croyants
							for ( i=0; i<listeJoueur.get(0).guidePossede.size(); i++){
							System.out.println("\nPosition : "+(i)+ " - Identifiant de la carte : " +this.listeJoueur.get(0).guidePossede.get(i).getIdentifiantCarte()+ "\n");
							System.out.println(this.listeJoueur.get(0).guidePossede.get(i).getInfosCarte());
															
							for ( j=0; j<listeJoueur.get(0).guidePossede.get(i).croyantPossede.size(); j++){
							System.out.println("\n    Position : "+(j)+ " - Identifiant de la carte : " +this.listeJoueur.get(0).guidePossede.get(rep).croyantPossede.get(j).getIdentifiantCarte()+ "\n");
							System.out.println("    " +this.listeJoueur.get(0).guidePossede.get(rep).croyantPossede.get(j).getInfosCarte());
							}
							System.out.println("____");
							}
							
							
							System.out.println("Selectionnez le guide");
							rep = sc.nextInt();
							//this.listeJoueur.get(0).guidePossede.get(rep).utiliserEffet();
							choixJoueur = true;
							}
						else{
							// On ne sacrifie pas
						}
					}
				else{
						// Retour aux choix
					}
					break;
				case 3: // Si on choisi 3, on veut utiliser l'effet divinité
					if ( doitSacrifierCarte == false && doitPoserApocalypse ==false && doitSacrifierGuide == false && effetDivinite ==false){
						//this.listeJoueur.get(0).Divinite.utiliserEffet();
						choixJoueur=true;
						effetDivinite = true;
					}
					else{
						// On ne fait rien, on revient aux choix
					}
					
					break;
				case 4: // On décide de sauter son tour
					System.out.println("Vous passez votre tour");
					choixJoueur = true;
					break;
					
				
				default: 
					System.out.println("Faites un choix");
				
				}
				} // Fin du While
				//choixJoueur = true;
			} // Fin du if pour le Joueur 0
			else{
					
				// On dit à un joueur de jouer selon sa strategie
				/////// Faire attention à ne pas confondre liste des joueurs (pour cibler) et tourjoueur pour choisir à qui c'est le tour
				System.out.println("Le joueur " +tourJoueur.get(j).getNom()+ " va jouer");
				int choix = this.tourJoueur.get(j).strategie.choisirCarte(this.tourJoueur, j,this.collectionCarte, this.cartePlateau);
				this.tourJoueur.get(j).poserCarteIA(choix, this.cartePlateau,this.listeJoueur, this.collectionCarte);
				// On fait jouer les autres joueurs avec leur stratégie
			}
			
			
		}	// Fin de la boucle for
		
		this.tourJoueur.add(this.tourJoueur.get(0));
		this.tourJoueur.remove(0);
		nbreTour++;
		
		}
		
	}
	
	
	
	
	// Méthode pour mélanger les cartes action et divinités
	public void melangerDeck(){
	Collections.shuffle(collectionCarte); // On mélange la liste des cartes action du deck
	Collections.shuffle(collectionCarteDivinite); // On mélange la liste des cartes divinités du deck
	}
	
	// Méthode pour créer la liste des joueurs
	public void creerListeJoueur( int nombreJoueur){
		listeJoueur = new ArrayList<Joueur>();
		tourJoueur = new ArrayList<Joueur>();
		
		Strategie collecteur = new Collecteur();
		Strategie chaos = new Chaos();
		
		////// Instancier une strategie et la donner à un joueur
		for (int i=0; i<nombreJoueur; i++)
		{
		player = new Joueur(); // On crée le joueur numéro i
		// On donne les strategies selon les probas	
		if ( i!=0){
			double nb = Math.round(Math.random()*2);
			if ( nb>=0 && nb<1 ){
				player.setStrategie(collecteur);
			}
			else{
				player.setStrategie(chaos);
			}

		}
			
		player.setNom(i); // On le nomme "Joueur i "
		listeJoueur.add(player); // On le rajoute dans la liste des joueurs
		tourJoueur.add(player); // On le rajoute dans la liste des tours du joueur
		}
	}


	// Methode pour distribuer carte Divinité
	public void distribuerDivinite(){
		 for (int i=0; i<listeJoueur.size();i++){
			 listeJoueur.get(i).setDivinite(collectionCarteDivinite.get(0)); // On attribut au joueur sa carte divinité
			 collectionCarteDivinite.remove(0); // On enlève alors cette carte de la liste des cartes Divinités
		}	
	}
	
	// Methode pour distribuer cartes
	public void distribuerCarte(){
		for (int i=0; i<listeJoueur.size(); i++){ // On répète l'opération pour plusieurs chaque joueur de la liste
			int nombre = listeJoueur.get(i).getMain().size();
			//int nombre = listeJoueur.get(i).getMain().size(); // On met dans une variable le nombre de carte que possède le joueur i 
			while(nombre < 7){ // Tant que le joueur n'a pas 7 cartes, on répète l'opération
				
				
				listeJoueur.get(i).getMain().add(this.collectionCarte.get(0)); // On donne cette carte au joueur i
				collectionCarte.remove(0); // On enlève cette carte de la liste
				nombre++;	
			}
			// Pour chaque joueur, on prend la carte 1 de la collection, on la stock dans carte 0, et on ajoute la carte 0 dans la collection main , on répète ça tant que la taille de collection main <=7 fois 
		}
	}
	
	// Getter pour obtenir la collection de carte
	public ArrayList<Carte> getcollectionCarte(){
		return collectionCarte;
	}

	public ArrayList<Joueur> getListeJoueur(){
		return listeJoueur;
	}
	
	public ArrayList<Joueur> getTourJoueur(){
		return tourJoueur;
	}
	
	}
