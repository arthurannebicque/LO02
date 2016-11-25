package main;


public class Divinite extends Carte{

	public Divinite(){
		super();
		
	}
	
	public Divinite(String string, int i, int j, int k, int l, int m) {
		super ( string , i , j , k, l,m);
	}

	// On code l'effet utiliserEffet() qui est un polymorphe
	public void utiliserEffet( Carte carteSelectionnee, Joueur joueurChoisi){ // On donne p.joueur.divinite 
		int idEffet = carteSelectionnee.identifiantCarte; // on attribut � idEffet l'id de la carte, selon sa valeur, l'effet sera different
		if ( idEffet == 81 ){ // Si on a la divinit� 81 
			// On choisi la personne qu'on cible , on recup�re son id ( joueur 0 1 2 3...)
			joueurChoisi.stopApocalypse = true; // On l'emp�che d'utiliser une carte apocalypse
		}
		else if ( idEffet == 82){ // Si on a la divinit� 82
			// On choisi la personne qu'on cible, on recup�re son id
			joueurChoisi.stopSacrificeGuide = true; // On l'emp�che de sacrifier un guide
		}
		else if (idEffet == 83){
			// Si une croyante d'origine nuit est sur le plateau, on l'enl�ve et on le met dans la pioche

		}
		
		
		
	}

}

