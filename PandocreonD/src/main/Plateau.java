package main;

import java.util.ArrayList;



public class Plateau {
	private ArrayList<Carte> cartePlateau;
	
	public Plateau(){
		cartePlateau = new ArrayList<Carte>();
		
	}
	

	public ArrayList<Carte> getCartePlateau(){
		return cartePlateau;
	}
	
}
