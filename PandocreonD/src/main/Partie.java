package main;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.ArrayList;
import java.util.Collections;



public class Partie{
	
	private int resultatDe;
	int nombre,nombre2, nombreJoueur;
	private Carte carte;
	private Joueur player;
	private ArrayList<Carte> collectionCarte;
	private ArrayList<Carte> collectionCarteDivinite;
	private ArrayList<Joueur> listeJoueur;
	
	
	
	
	
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
		
		carte = new Carte(1,1,4,1,5,1,0);
		collectionCarte.add(carte);
		
		carte = new Carte(2,1,2,5,4,2,0);
		collectionCarte.add(carte);
		
		carte = new Carte(3,1,2,4,3,2,0);
		collectionCarte.add(carte);
		
		carte = new Carte(4,1,3,1,4,2,0);
		collectionCarte.add(carte);
		
		carte = new Carte(5,1,2,1,4,2,0);
		collectionCarte.add(carte);
		
		carte = new Carte(6,1,2,5,3,2,0);
		collectionCarte.add(carte);
		
		carte = new Carte(7,1,3,1,5,2,0);
		collectionCarte.add(carte);
		
		carte = new Carte(8,1,2,5,4,2,0);
		collectionCarte.add(carte);
		
		carte = new Carte(9,1,2,5,4,1,0);
		collectionCarte.add(carte);
		
		carte = new Carte(10,1,3,1,4,1,0);
		collectionCarte.add(carte);
		
		carte = new Carte(11,1,2,1,5,1,0);
		collectionCarte.add(carte);
		
		carte = new Carte(12,1,3,1,5,4,0);
		collectionCarte.add(carte);
		
		carte = new Carte(13,1,2,5,3,4,0);
		collectionCarte.add(carte);
		
		carte = new Carte(14,3,4,1,5,2,0);
		collectionCarte.add(carte);
		
		carte = new Carte(15,3,2,5,4,2,0);
		collectionCarte.add(carte);
		
		carte = new Carte(16,3,2,4,3,2,0);
		collectionCarte.add(carte);
		
		carte = new Carte(17,3,3,1,4,2,0);
		collectionCarte.add(carte);
		
		carte = new Carte(18,3,2,1,4,2,0);
		collectionCarte.add(carte);
		
		carte = new Carte(19,3,2,1,3,2,0);
		collectionCarte.add(carte);
		
		carte = new Carte(20,3,2,1,4,2,0);
		collectionCarte.add(carte);
		
		carte = new Carte(21,3,2,1,3,2,0);
		collectionCarte.add(carte);
		
		carte = new Carte(22,3,3,1,5,1,0);
		collectionCarte.add(carte);
		
		carte = new Carte(23,3,2,5,4,1,0);
		collectionCarte.add(carte);
		
		carte = new Carte(24,3,2,1,5,4,0);
		collectionCarte.add(carte);
		
		carte = new Carte(25,3,3,1,4,4,0);
		collectionCarte.add(carte);
		
		carte = new Carte(26,3,2,5,3,4,0);
		collectionCarte.add(carte);
		
		carte = new Carte(27,2,4,1,5,2,0);
		collectionCarte.add(carte);
		
		carte = new Carte(28,2,2,5,4,2,0);
		collectionCarte.add(carte);
		
		carte = new Carte(29,2,2,4,3,2,0);
		collectionCarte.add(carte);
		
		carte = new Carte(30,2,3,1,4,2,0);
		collectionCarte.add(carte);
		
		carte = new Carte(31,2,2,1,4,2,0);
		collectionCarte.add(carte);
		
		carte = new Carte(32,2,2,5,3,2,0);
		collectionCarte.add(carte);
		
		carte = new Carte(33,2,3,1,5,2,0);
		collectionCarte.add(carte);
		
		carte = new Carte(34,2,2,5,4,2,0);
		collectionCarte.add(carte);
		
		carte = new Carte(35,2,4,1,5,1,0);
		collectionCarte.add(carte);
		
		carte = new Carte(36,2,2,5,3,2,0);
		collectionCarte.add(carte);
		
		carte = new Carte(37,2,2,4,3,4,0);
		collectionCarte.add(carte);
		
		carte = new Carte(38,1,0,5,1,0,2);
		collectionCarte.add(carte);
		
		carte = new Carte(39,3,0,3,5,0,2);
		collectionCarte.add(carte);
		
		carte = new Carte(40,2,0,2,1,0,2);
		collectionCarte.add(carte);
		
		carte = new Carte(41,1,0,2,5,0,2);
		collectionCarte.add(carte);
		
		carte = new Carte(42,3,0,3,1,0,2);
		collectionCarte.add(carte);
		
		carte = new Carte(43,2,0,4,1,0,2);
		collectionCarte.add(carte);
		
		carte = new Carte(44,1,0,2,1,0,2);
		collectionCarte.add(carte);
		
		carte = new Carte(45,3,0,3,4,0,2);
		collectionCarte.add(carte);
		
		carte = new Carte(46,2,0,4,3,0,2);
		collectionCarte.add(carte);
		
		carte = new Carte(47,1,0,2,4,0,2);
		collectionCarte.add(carte);
		
		carte = new Carte(48,3,0,5,1,0,2);
		collectionCarte.add(carte);
		
		carte = new Carte(49,3,0,3,1,0,3);
		collectionCarte.add(carte);
		
		carte = new Carte(50,2,0,2,5,0,3);
		collectionCarte.add(carte);
		
		carte = new Carte(51,1,0,4,5,0,3);
		collectionCarte.add(carte);
		
		carte = new Carte(52,3,0,3,5,0,1);
		collectionCarte.add(carte);
		
		carte = new Carte(53,2,0,4,1,0,1);
		collectionCarte.add(carte);
		
		carte = new Carte(54,1,0,2,4,0,1);
		collectionCarte.add(carte);
		
		carte = new Carte(55,3,0,3,4,0,3);
		collectionCarte.add(carte);
		
		carte = new Carte(56,2,0,2,3,0,3);
		collectionCarte.add(carte);
		
		carte = new Carte(57,1,0,4,5,0,3);
		collectionCarte.add(carte);
		
		carte = new Carte(58,1,0,0,0,0,0);
		collectionCarte.add(carte);
		
		carte = new Carte(59,3,0,0,0,0,0);
		collectionCarte.add(carte);
		
		carte = new Carte(60,1,0,0,0,0,0);
		collectionCarte.add(carte);
		
		carte = new Carte(61,1,0,0,0,0,0);
		collectionCarte.add(carte);
		
		carte = new Carte(62,3,0,0,0,0,0);
		collectionCarte.add(carte);
		
		carte = new Carte(63,3,0,0,0,0,0);
		collectionCarte.add(carte);
		
		carte = new Carte(64,2,0,0,0,0,0);
		collectionCarte.add(carte);
		
		carte = new Carte(65,2,0,0,0,0,0);
		collectionCarte.add(carte);
		
		carte = new Carte(66,2,0,0,0,0,0);
		collectionCarte.add(carte);
		
		carte = new Carte(67,0,0,0,0,0,0);
		collectionCarte.add(carte);
		
		carte = new Carte(68,0,0,0,0,0,0);
		collectionCarte.add(carte);
		
		carte = new Carte(69,0,0,0,0,0,0);
		collectionCarte.add(carte);
		
		carte = new Carte(70,0,0,0,0,0,0);
		collectionCarte.add(carte);
		
		carte= new Carte(71,0,0,0,0,0,0);
		collectionCarte.add(carte);
		
		carte = new Carte(72,0,0,0,0,0,0);
		collectionCarte.add(carte);
		
		carte = new Carte(73,0,0,0,0,0,0);
		collectionCarte.add(carte);
		
		carte = new Carte(74,0,0,0,0,0,0);
		collectionCarte.add(carte);
		
		carte = new Carte(75,0,0,0,0,0,0);
		collectionCarte.add(carte);
		
		carte = new Carte(76,1,0,0,0,0,0);
		collectionCarte.add(carte);
		
		carte = new Carte(77,3,0,0,0,0,0);
		collectionCarte.add(carte);
		
		carte = new Carte(78,2,0,0,0,0,0);
		collectionCarte.add(carte);
		
		carte = new Carte(79,0,0,0,0,0,0);
		collectionCarte.add(carte);
		
		carte = new Carte(80,0,0,0,0,0,0);
		collectionCarte.add(carte);
		
		carte = new Carte(81,1,1,5,4,0,0);
		collectionCarteDivinite.add(carte);
		
		carte = new Carte(82,1,1,5,3,0,0);
		collectionCarteDivinite.add(carte);
		
		carte = new Carte(83,1,2,3,4,0,0);
		collectionCarteDivinite.add(carte);
		
		carte = new Carte(84,3,1,4,2,0,0);
		collectionCarteDivinite.add(carte);
		
		carte = new Carte(85,3,1,4,2,0,0);
		collectionCarteDivinite.add(carte);
		
		carte = new Carte(86,3,1,4,3,0,0);
		collectionCarteDivinite.add(carte);
		
		carte = new Carte(87,4,5,4,3,0,0);
		collectionCarteDivinite.add(carte);
		
		carte = new Carte(88,4,5,4,2,0,0);
		collectionCarteDivinite.add(carte);
		
		carte = new Carte(89,5,5,3,2,0,0);
		collectionCarteDivinite.add(carte);
		
		carte = new Carte(90,5,1,5,2,0,0);
		collectionCarteDivinite.add(carte);
		

		nombre = collectionCarte.size();
		nombre2 = collectionCarteDivinite.size();
		
		//System.out.println("il y a" +nombre+ "cartes d'actions et "+nombre2+ "cartes Divinités");
		/*

		
		
		System.out.println(" carte" +c[1].getOrigineCarte());
		*/
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
