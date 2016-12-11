package main;

public class Effet24 extends DeusEx { //id = 67, 68, 69, 70, 71 annule la capacité spéciale
	
	public void utiliserEffet(Carte carte, Carte cible) {
		
		int id = carte.identifiantCarte;
		
		if(  ((id == 67) && (cible.origineCarte == 2 || cible.origineCarte == 3)) || ((id == 68) && (cible.origineCarte == 1 || cible.origineCarte == 2)) || ((id == 69) && (cible.origineCarte == 1 || cible.origineCarte == 3)) || (id == 70 || id == 71)) cible.CapaciteSpe = false;
	}
		
}

