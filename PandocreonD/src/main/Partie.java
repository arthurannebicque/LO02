package main;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;



public class Partie{
	
	int nombre,nombre2, nombreJoueur;
	private Carte carte;
	private Divinite carteDivinite;
	private Apocalypse carteApocalypse;
	private DeusEx carteDeusEx;
	private Croyant carteCroyant;
	private Guide carteGuide;
	private Joueur player;
	private ArrayList<Carte> collectionCarte;
	private ArrayList<Carte> collectionCarteDivinite;
	private ArrayList<Joueur> listeJoueur;
	
	private Scanner sc;
	
	boolean sacrifierCarte = false; // Oblige à sacrifier une carte
	boolean sacrifierGuide = false; // Oblige à sacrifier un guide
	
	boolean poserApocalypse = false; // Oblige à poser une carte apocalypse
	
	boolean stopSacrificeGuide = false; //Empêche de sacrifier une carte Guide
	boolean stopApocalypse = false; // Empêche de poser une carte apocalypse
	
	boolean PtsAction = false; //Autorise ou pas les points d'actions
	
	
	
	
	
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
		carte = new Carte();
		carteDivinite = new Divinite();
		carteApocalypse = new Apocalypse();
		carteDeusEx = new DeusEx();
		carteCroyant = new Croyant();
		carteGuide = new Guide();
		
		

		carteCroyant = new Croyant("Moines",1,1,4,1,5,1,0);
		collectionCarte.add(carteCroyant);
		
		carteCroyant = new Croyant("Moines",2,1,2,5,4,2,0);
		collectionCarte.add(carteCroyant);
		
		carteCroyant = new Croyant("Moines",3,1,2,4,3,2,0);
		collectionCarte.add(carteCroyant);
		
		carteCroyant = new Croyant("Moines",4,1,3,1,4,2,0);
		collectionCarte.add(carteCroyant);
		
		carteCroyant = new Croyant("Moines",5,1,2,1,4,2,0);
		collectionCarte.add(carteCroyant);
		
		carteCroyant = new Croyant("Travailleurs",6,1,2,5,3,2,0);
		collectionCarte.add(carteCroyant);
		
		carteCroyant = new Croyant("Travailleurs",7,1,3,1,5,2,0);
		collectionCarte.add(carteCroyant);
		
		carteCroyant = new Croyant("Travailleurs",8,1,2,5,4,2,0);
		collectionCarte.add(carteCroyant);
		
		carteCroyant = new Croyant("Ermite",9,1,2,5,4,1,0);
		collectionCarte.add(carteCroyant);
		
		carteCroyant = new Croyant("Ermite",10,1,3,1,4,1,0);
		collectionCarte.add(carteCroyant);
		
		carteCroyant = new Croyant("Integriste",11,1,2,1,5,1,0);
		collectionCarte.add(carteCroyant);
		
		carteCroyant = new Croyant("Guerriers Saints",12,1,3,1,5,4,0);
		collectionCarte.add(carteCroyant);
		
		carteCroyant = new Croyant("Diplomates",13,1,2,5,3,4,0);
		collectionCarte.add(carteCroyant);
		
		carteCroyant = new Croyant("Demons",14,3,4,1,5,2,0);
		collectionCarte.add(carteCroyant);
		
		carteCroyant = new Croyant("Demons",15,3,2,5,4,2,0);
		collectionCarte.add(carteCroyant);
		
		carteCroyant = new Croyant("Demons",16,3,2,4,3,2,0);
		collectionCarte.add(carteCroyant);
		
		carteCroyant = new Croyant("Demons",17,3,3,1,4,2,0);
		collectionCarte.add(carteCroyant);
		
		carteCroyant = new Croyant("Demons",18,3,2,1,4,2,0);
		collectionCarte.add(carteCroyant);
		
		carteCroyant = new Croyant("Alchimistes",19,3,2,1,3,2,0);
		collectionCarte.add(carteCroyant);
		
		carteCroyant = new Croyant("Alchimistes",20,3,2,1,4,2,0);
		collectionCarte.add(carteCroyant);
		
		carteCroyant = new Croyant("Alchimistes",21,3,2,1,3,2,0);
		collectionCarte.add(carteCroyant);
		
		carteCroyant = new Croyant("Vampire",22,3,3,1,5,1,0);
		collectionCarte.add(carteCroyant);
		
		carteCroyant = new Croyant("Vampire",23,3,2,5,4,1,0);
		collectionCarte.add(carteCroyant);
		
		carteCroyant = new Croyant("Lycanthropes",24,3,2,1,5,4,0);
		collectionCarte.add(carteCroyant);
		
		carteCroyant = new Croyant("Pillards",25,3,3,1,4,4,0);
		collectionCarte.add(carteCroyant);
		
		carteCroyant = new Croyant("Illusionnistes",26,3,2,5,3,4,0);
		collectionCarte.add(carteCroyant);
		
		carteCroyant = new Croyant("Esprits",27,2,4,1,5,2,0);
		collectionCarte.add(carteCroyant);
		
		carteCroyant = new Croyant("Esprits",28,2,2,5,4,2,0);
		collectionCarte.add(carteCroyant);
		
		carteCroyant = new Croyant("Esprits",29,2,2,4,3,2,0);
		collectionCarte.add(carteCroyant);
		
		carteCroyant = new Croyant("Esprits",30,2,3,1,4,2,0);
		collectionCarte.add(carteCroyant);
		
		carteCroyant = new Croyant("Esprits",31,2,2,1,4,2,0);
		collectionCarte.add(carteCroyant);
		
		carteCroyant = new Croyant("Alienes",32,2,2,5,3,2,0);
		collectionCarte.add(carteCroyant);
		
		carteCroyant = new Croyant("Alienes",33,2,3,1,5,2,0);
		collectionCarte.add(carteCroyant);
		
		carteCroyant = new Croyant("Alienes",34,2,2,5,4,2,0);
		collectionCarte.add(carteCroyant);
		
		carteCroyant = new Croyant("Revenant",35,2,4,1,5,1,0);
		collectionCarte.add(carteCroyant);
		
		carteCroyant = new Croyant("Revolutionnaires",36,2,2,5,3,2,0);
		collectionCarte.add(carteCroyant);
		
		carteCroyant = new Croyant("Nihillistes",37,2,2,4,3,4,0);
		collectionCarte.add(carteCroyant);
		
		carteGuide = new Guide("Martyr",38,1,0,5,1,0,2);
		collectionCarte.add(carteGuide);
		
		carteGuide = new Guide("Martyr",39,3,0,3,5,0,2);
		collectionCarte.add(carteGuide);
		
		carteGuide = new Guide("Martyr",40,2,0,2,1,0,2);
		collectionCarte.add(carteGuide);
		
		carteGuide = new Guide("Clerc",41,1,0,2,5,0,2);
		collectionCarte.add(carteGuide);
		
		carteGuide = new Guide("Clerc",42,3,0,3,1,0,2);
		collectionCarte.add(carteGuide);
		
		carteGuide = new Guide("Clerc",43,2,0,4,1,0,2);
		collectionCarte.add(carteGuide);
		
		carteGuide = new Guide("Clerc",44,1,0,2,1,0,2);
		collectionCarte.add(carteGuide);
		
		carteGuide = new Guide("Clerc",45,3,0,3,4,0,2);
		collectionCarte.add(carteGuide);
		
		carteGuide = new Guide("Clerc",46,2,0,4,3,0,2);
		collectionCarte.add(carteGuide);
		
		carteGuide = new Guide("Clerc",47,1,0,2,4,0,2);
		collectionCarte.add(carteGuide);
		
		carteGuide = new Guide("Clerc",48,3,0,5,1,0,2);
		collectionCarte.add(carteGuide);
		
		carteGuide = new Guide("Shaman",49,3,0,3,1,0,3);
		collectionCarte.add(carteGuide);
		
		carteGuide = new Guide("Anarchiste",50,2,0,2,5,0,3);
		collectionCarte.add(carteGuide);
		
		carteGuide = new Guide("Paladin",51,1,0,4,5,0,3);
		collectionCarte.add(carteGuide);
		
		carteGuide = new Guide("Ascete",52,3,0,3,5,0,1);
		collectionCarte.add(carteGuide);
		
		carteGuide = new Guide("Devin",53,2,0,4,1,0,1);
		collectionCarte.add(carteGuide);
		
		carteGuide = new Guide("Exorciste",54,1,0,2,4,0,1);
		collectionCarte.add(carteGuide);
		
		carteGuide = new Guide("Sorcier",55,3,0,3,4,0,3);
		collectionCarte.add(carteGuide);
		
		carteGuide = new Guide("Tyran",56,2,0,2,3,0,3);
		collectionCarte.add(carteGuide);
		
		carteGuide = new Guide("Messie",57,1,0,4,5,0,3);
		collectionCarte.add(carteGuide);
		
		carteDeusEx = new DeusEx("Colere Divine",58,1,0,0,0,0,0);
		collectionCarte.add(carteDeusEx);
		
		carteDeusEx = new DeusEx("Colere Divinie",59,3,0,0,0,0,0);
		collectionCarte.add(carteDeusEx);
		
		carteDeusEx = new DeusEx("Stase",60,1,0,0,0,0,0);
		collectionCarte.add(carteDeusEx);
		
		carteDeusEx = new DeusEx("Ordre Celeste",61,1,0,0,0,0,0);
		collectionCarte.add(carteDeusEx);
		
		carteDeusEx = new DeusEx("Fourberie",62,3,0,0,0,0,0);
		collectionCarte.add(carteDeusEx);
		
		carteDeusEx = new DeusEx("Diversion",63,3,0,0,0,0,0);
		collectionCarte.add(carteDeusEx);
		
		carteDeusEx = new DeusEx("Concentration",64,2,0,0,0,0,0);
		collectionCarte.add(carteDeusEx);
		
		carteDeusEx = new DeusEx("Trou Noir",65,2,0,0,0,0,0);
		collectionCarte.add(carteDeusEx);
		
		carteDeusEx = new DeusEx("Phoenix",66,2,0,0,0,0,0);
		collectionCarte.add(carteDeusEx);
		
		carteDeusEx = new DeusEx("Influence Jour",67,0,0,0,0,0,0);
		collectionCarte.add(carteDeusEx);
		
		carteDeusEx = new DeusEx("Influence Nuit",68,0,0,0,0,0,0);
		collectionCarte.add(carteDeusEx);
		
		carteDeusEx = new DeusEx("Influence Neant",69,0,0,0,0,0,0);
		collectionCarte.add(carteDeusEx);
		
		carteDeusEx = new DeusEx("Influence Nulle",70,0,0,0,0,0,0);
		collectionCarte.add(carteDeusEx);
		
		carteDeusEx= new DeusEx("Influence Nulle",71,0,0,0,0,0,0);
		collectionCarte.add(carteDeusEx);
		
		carteDeusEx = new DeusEx("Transe",72,0,0,0,0,0,0);
		collectionCarte.add(carteDeusEx);
		
		carteDeusEx = new DeusEx("Miroir",73,0,0,0,0,0,0);
		collectionCarte.add(carteDeusEx);
		
		carteDeusEx = new DeusEx("Bouleversement",74,0,0,0,0,0,0);
		collectionCarte.add(carteDeusEx);
		
		carteDeusEx = new DeusEx("Inquisition",75,0,0,0,0,0,0);
		collectionCarte.add(carteDeusEx);
		
		carteApocalypse = new Apocalypse("Apocalypse",76,1,0,0,0,0,0);
		collectionCarte.add(carteApocalypse);
		
		carteApocalypse = new Apocalypse("Apocalypse",77,3,0,0,0,0,0);
		collectionCarte.add(carteApocalypse);
		
		carteApocalypse = new Apocalypse("Apocalypse",78,2,0,0,0,0,0);
		collectionCarte.add(carteApocalypse);
		
		carteApocalypse = new Apocalypse("Apocalypse",79,0,0,0,0,0,0);
		collectionCarte.add(carteApocalypse);
		
		carteApocalypse = new Apocalypse("Apocalypse",80,0,0,0,0,0,0);
		collectionCarte.add(carteApocalypse);
		
		carteDivinite = new Divinite ("Brenvalen",81,1,1,5,4,0,0);
		collectionCarteDivinite.add(carteDivinite);
		
		carteDivinite = new Divinite("Drinded",82,1,1,5,3,0,0);
		collectionCarteDivinite.add(carteDivinite);
		
		carteDivinite = new Divinite("Yarstur",83,1,2,3,4,0,0);
		collectionCarteDivinite.add(carteDivinite);
		
		carteDivinite = new Divinite("Killinstred",84,3,1,4,2,0,0);
		collectionCarteDivinite.add(carteDivinite);
		
		carteDivinite = new Divinite("Llenvella",85,3,1,4,2,0,0);
		collectionCarteDivinite.add(carteDivinite);
		
		carteDivinite = new Divinite("Pui-Tara",86,3,1,4,3,0,0);
		collectionCarteDivinite.add(carteDivinite);
		
		carteDivinite = new Divinite("Gnvenghelen",87,4,5,4,3,0,0);
		collectionCarteDivinite.add(carteDivinite);
		
		carteDivinite = new Divinite("Shingva",88,4,5,4,2,0,0);
		collectionCarteDivinite.add(carteDivinite);
		
		carteDivinite = new Divinite("Gorpa",89,5,5,3,2,0,0);
		collectionCarteDivinite.add(carteDivinite);
		
		carteDivinite = new Divinite("Romtec",90,5,1,5,2,0,0);
		collectionCarteDivinite.add(carteDivinite);
		

		nombre = collectionCarte.size();
		nombre2 = collectionCarteDivinite.size();
		
		//System.out.println("il y a" +nnnombre+ "cartes d'actions et "+nombre2+ "cartes Divinités");
		/*

		
		
		System.out.println(" carte" +c[1].getOrigineCarte());
		*/
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
		this.distribuerCarte();
		System.out.println("Vous êtes le joueur " +this.getListeJoueur().get(0).getString());
		System.out.println("Vous avez eu la carte divinité: \n" +this.getListeJoueur().get(0).getInfosDivinite());
		System.out.println("Vous avez reçu les cartes:\n ");
		
		for (int i=0; i<7 ; i++){
		System.out.printf("\n "+(i)+ " - " +this.getListeJoueur().get(0).getMain().get(i).getIdentifiantCarte()+ "\n");
		System.out.println(this.getListeJoueur().get(0).getMain().get(i).getInfosCarte());
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
					this.getListeJoueur().get(0).defausserCarte(crte-c, this.getCollectionCarte());	
					temp = crte;
					}
				else{
					this.getListeJoueur().get(0).defausserCarte(crte-c, this.getCollectionCarte());
					temp = crte;
					}
			this.distribuerCarte();
			i++;
		}
		
		System.out.println("Vous avez les cartes:\n ");
	
		for (int j=0; j<this.getListeJoueur().get(0).main.size() ; j++){
			System.out.printf("\n "+(j)+ " - " +this.getListeJoueur().get(0).getMain().get(j).getIdentifiantCarte()+ " | ");
			System.out.println("\n" +this.getListeJoueur().get(0).getMain().get(j).getInfosCarte());
		}
		
		// On lance le dé
		this.getListeJoueur().get(0).lancerDe(this.getListeJoueur());
		
	}
	
	// Méthode pour mélanger les cartes action et divinités
	public void melangerDeck(){
	Collections.shuffle(collectionCarte); // On mélange la liste des cartes action du deck
	Collections.shuffle(collectionCarteDivinite); // On mélange la liste des cartes divinités du deck
	}
	
	// Méthode pour créer la liste des joueurs
	public void creerListeJoueur( int nombreJoueur){
		listeJoueur = new ArrayList<Joueur>();
		for (int i=0; i<nombreJoueur; i++)
		{
		player = new Joueur(); // On crée le joueur numéro i
		player.setNom(i); // On le nomme "Joueur i "
		listeJoueur.add(player); // On le rajoute dans la liste des joueurs
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
	
	}
