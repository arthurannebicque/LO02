package main;

import java.util.*;

public class Yarstur extends Divinite { // Peut d�truire toutes les cartes au centre d'origine N�ant

public void utiliserEffetDivinite(ArrayList<Carte> table, ArrayList<Carte> collection){
	
	if (this.identifiantCarte == 3 ){
	for (int i=0; i<table.size();i++){
		if ( table.get(i).origineCarte==3){
			collection.add(table.get(i));
			table.remove(i);
		}
	}
	
}
else if ( this.identifiantCarte == 6){
	for (int i=0; i<table.size();i++){
		if (table.get(i).origineCarte == 1){
			collection.add(table.get(i));
			table.remove(i);
		}
	}
}
	
}
	
	
}

