package main;
import java.util.*;

public class Main {

	private static Scanner sc;

	public static void main(String[] args) {
		
		int nombreJoueur;
		
		// TODO Auto-generated method stub
		System.out.println(" Pandocreon Divinae \n Combien de joueur ?");
		sc = new Scanner(System.in);
		String reponse = sc.nextLine();
		int rep = Integer.parseInt(reponse); // On transforme la réponse en int
		System.out.println("Initialisation de la partie\n\n");
		
		Partie p = new Partie();
		p.creerDeck();
		p.melangerDeck();
		p.creerListeJoueur(rep);
		p.distribuerDivinite();
		p.distribuerCarte();
		System.out.println("Vous êtes le joeur " +p.getListeJoueur().get(0).getString() );
		System.out.println("Vous avez eu la carte divinité: " +p.getListeJoueur().get(0).getDivinite().getIdentifiantCarte());
		System.out.println("Vous avez reçu les cartes:\n ");
		
		for (int i=0; i<7 ; i++){
		System.out.printf(" "+(i)+ " - " +p.getListeJoueur().get(0).getMain().get(i).getIdentifiantCarte()+ " | ");
		System.out.println("" +p.getListeJoueur().get(0).getMain().get(i).decrisToi());
		}
		
		// Rajouter une boucle pour chaque joueur
		System.out.println("\n Combien de carte voulez vous defausser ? (entre 1 et 7 dans l'ordre)");
		int nbre = sc.nextInt();
		int i=0;
		int c = 0, temp=7;
		while (i < nbre){
			System.out.println("Quelle carte ?" +p.getListeJoueur().get(0).getMain().size());
			int crte = sc.nextInt();
			if (crte > temp){
				c++;
				p.getListeJoueur().get(0).defausserCarte(crte-c, p.getCollectionCarte());	
				temp = crte;
			}
			else{
				p.getListeJoueur().get(0).defausserCarte(crte-c, p.getCollectionCarte());
				temp = crte;
			}
			p.distribuerCarte();
			i++;
		}
		
System.out.println("Vous avez les cartes:\n ");
		
	// Modifier DefausserCarte, 
		for (int k=0; k<7 ; k++){
		System.out.printf(" "+(k)+ " - " +p.getListeJoueur().get(0).getMain().get(k).getIdentifiantCarte()+ " | ");
		}
		
		for (int j=0; j<7 ; j++){
		System.out.printf(" "+(j)+ " - " +p.getListeJoueur().get(0).getMain().get(j).getIdentifiantCarte()+ " | ");
		System.out.println("" +p.getListeJoueur().get(0).getMain().get(j).decrisToi());
		}
		
p.getListeJoueur().get(0).lancerDe(p.getListeJoueur());
System.out.println("Vous êtes de Divinité : " +p.getListeJoueur().get(0).getDivinite().getOrigineCarte());
	}

	}
