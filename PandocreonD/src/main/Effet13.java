package main;

import java.util.ArrayList;

public class Effet13 implements Effet{ // id = 49 Sacrifie tous les Croyants d'Origine N�ant d'une Divinit� ayant le Dogme Humain. Les capacit�s sp�ciales sont jou�es normalement.

	@Override
	public void utiliserEffet(Partie p, ArrayList<Joueur> listejoueur, int cible, ArrayList<Carte> table, Carte carte,
			int j, ArrayList<Carte> collection, ArrayList<Joueur> tourjoueur) {
		// TODO Auto-generated method stub
		
		boolean boucle = true;
		int n=0;
		while (boucle && n<listejoueur.size() ){
			
			if ((listejoueur.get(n).Divinite.natureCarte1==5) || (listejoueur.get(n).Divinite.natureCarte2==5) || (listejoueur.get(n).Divinite.natureCarte3==5)){
				if (listejoueur.get(n) != listejoueur.get(j)){
					for (int i=0; i<listejoueur.get(n).croyantPossede.size();i++){
						if (listejoueur.get(n).croyantPossede.get(i).origineCarte==2){
							//listejoueur.get(n).croyantPossede.get(i).utiliserEffet(); Gerer utiliser plus tard
						}
						boucle = false;
					}
				}
			}
			n++;
		}
		
	}

	@Override
	public void utiliserEffetDivinite(ArrayList<Joueur> listejoueur, int j, int id, ArrayList<Carte> collection,
			int croyant, int guide) {
		// TODO Auto-generated method stub
		
	}

}
