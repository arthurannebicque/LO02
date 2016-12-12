package main;

import java.util.ArrayList;

public class Effet1 implements Effet {




	public void utiliserEffet(Partie p, ArrayList<Joueur> listejoueur, int cible, ArrayList<Carte> table, Carte carte, int j , ArrayList<Carte> collection, ArrayList<Joueur> tourjoueur) {
		// On code ici 
		int id = carte.identifiantCarte;
		if (id==1 || id==2 || id==3 || id==4 || id==5 )
			listejoueur.get(j).setPointAction(1,1); // Donne un point d'action jour
		if( id==14 || id ==15 || id == 16 || id ==17 || id ==18);
			listejoueur.get(j).setPointAction(2,1); // Donne un point d'action Nuit
		if (id==27 || id==28 || id==29 || id==30 || id==31); // Donne un point d'action néant
			listejoueur.get(j).setPointAction(3,1);
		
	}

	@Override
	public void utiliserEffetDivinite(ArrayList<Joueur> listejoueur, int j, int id, ArrayList<Carte> collection,
			int croyant, int guide) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
