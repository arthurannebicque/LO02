package main;

import java.util.*;
public interface Effet {
	
	public void utiliserEffetDivinite( ArrayList<Joueur> listejoueur, int j, int id, ArrayList<Carte> collection, int croyant, int guide);
	
	public void utiliserEffet(Partie p , ArrayList<Joueur> listejoueur, int cible, ArrayList<Carte> table, Carte carte, int j , ArrayList<Carte> collection, ArrayList<Joueur> tourjoueur);
}
